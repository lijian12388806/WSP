<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListCustomerinfo.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />

<!-- 查询条件 -->
	<input type="hidden" value="${querycustlinkman}" id="querycustlinkman"
		name="querycustlinkman">
	<input type="hidden" value="${querycustomername}" id="querycustomername"
		name="querycustomername">
	<input type="hidden" value="${queryinfosource}" id="queryinfosource"
		name="queryinfosource">
	<input type="hidden" value="${querycustphoneno}" id="querycustphoneno"
		name="querycustphoneno">
	<input type="hidden" value="${querytemp1}"
		id="querytemp1" name="querytemp1">

	<input type="hidden" value="${queryemailaddr}" id="queryemailaddr"
		name="queryemailaddr">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ListCustomerinfo.action?search=true"
		method="post" name="ListCustomerinfo">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
<td>
						客户名称:
						<input name="querycustlinkman" type="text" id="querycustlinkman"
							size="15" style="WIDTH: 94px" value="${querycustlinkman}"
							onkeydown="" />
					</td>
					<td>
						公司名称:
						<input name="querycustomername" type="text" id="querycustomername"
							size="15" style="WIDTH: 94px" value="${querycustomername}"
							onkeydown="" />
					</td>
					<td>
						性别:
				<select name="queryinfosource" class=""
					lookupGroup="newworkOrderForm">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.dictpara['Gender']}"
						var="activeState">
						<c:choose>
							<c:when test="${queryinfosource == activeState.code}">
								<option value="${activeState.code}" selected>
									${activeState.title}
								</option>
							</c:when>
							<c:otherwise>
								<option value="${activeState.code}">
									${activeState.title}
								</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
					</td>
					<td>
						联系电话:
						<input name="querycustphoneno" type="text" id="querycustphoneno"
							size="15" style="WIDTH: 94px" value="${querycustphoneno}"
							onkeydown="" />
					</td>
					<td>
						QQ号码:
						<input name="querytemp1" type="text" id="querytemp1"
							size="15" style="WIDTH: 94px" value="${querytemp1}"
							onkeydown="" />
					</td>
					<td>
						邮箱地址:
						<input name="queryemailaddr" type="text" id="queryemailaddr"
							size="15" style="WIDTH: 94px" value="${queryemailaddr}"
							onkeydown="" />
					</td>
					<td>
						<div class="subBar">
							<ul>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">
												<s:text name="common.search" />
											</button>
										</div>
									</div>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="button" onclick="getValue(document.forms['ListCustomerinfo']);">
												<s:text name="common.clean" />
											</button>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addCustomerinfo.action"
					rel="addCustomerCardNav" target="navTab" reloadFlag=1><span>新客户</span> </a>
			</li>

			<!-- <li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteCustomerinfo?navTabId=workorderLiNav"
					class="delete"><span><s:text name="批量删除" /> </span> </a>
			</li> -->

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%">
		<thead>
			<tr>
				<th width="10%">
					公司名称
				</th>
				<th width="5%">
					联系人
				</th>
				<th width="3%">
					性别
				</th>	
				<th width="20%">
					联系电话
				</th>
				<th width="8%">
					QQ号码
				</th>
				<th width="8%">
					邮箱地址
				</th>
				<th width="8%">
					所属城市
				</th>
				<th width="20%">
					客户地址
				</th>
				<th width="10%">
					更新时间
				</th>
				<th width="5%">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.customerinfoList}">
				<tr target="slt_uid" rel="${item.id}">
						<td>
						${item.customername}
					</td>
					<td>
						${item.custlinkman}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['Gender']}"
							var="activeState">
							<c:if test="${item.temp2 == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<td>
						${item.custphoneno}
					</td>
					<td>
						${item.temp1}
					</td>
					<td>
						${item.emailaddr}
					</td>
					<td>
						${item.netherlands}
					</td>
					<td>
						${item.custaddr}
					</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.updatetime}" />
					</td>
					<td>
						<!-- <a class="btnDel"
								href="${applicationScope.rootpath}deleteCustomerinfo?selectIDS=${item.id}&navTabId=customerLiNav"
								target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
										name="common.delete" /> </span> </a> -->
						<a class="btnEdit"
							href="${applicationScope.rootpath}editCustomerinfo?customerKey=${item.id}"
							target="navTab" rel="editCustomerCardNav" reloadFlag=1
							title="修改客户信息"><span>修改客户信息</span> </a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>
</div>
