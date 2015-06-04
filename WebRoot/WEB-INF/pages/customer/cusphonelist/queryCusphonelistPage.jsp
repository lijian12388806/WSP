<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListCusphonelist.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
<!-- 查询条件 -->
	<input type="hidden" value="${querylinkman}" id="querylinkman"
		name="queryani">
	<input type="hidden" value="${querynostatus}" id="querynostatus"
		name="queryagentid">
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListCusphonelist.action?search=true" method="post" name="ListCusphonelist">
		<div class="searchBar" >
			<table class="searchContent">
				<tr>

					<!-- <td>
						客户名称
						:
						<input name="querycusphonename" type="text" id="querycusphonename"
							size="15" style="WIDTH: 94px" value="${querycusphonename}"
							onkeydown="" />
					</td> -->
					<td>
						联系人 :
						<input name="querylinkman" type="text" id="querylinkman" size="15"
							style="WIDTH: 94px" value="${querylinkman}" onkeydown="" />
					</td>
					<td>
						同步状态 :
						<select name="querynostatus">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['SynStatus']}"
								var="activeState">
								<c:choose>
									<c:when test="${querynostatus == activeState.code}">
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
											<button type="button" onclick="getValue(document.forms['ListCusphonelist']);">
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
					href="${applicationScope.rootpath}addCusphonelist.action"
					rel="addCusphonelistCardNav" target="navTab" reloadFlag=1><span>添加</span> </a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteCusphonelist.action?navTabId=cusphonelistLiNav"
					class="delete"><span><s:text name="批量删除" /> </span> </a>
			</li>

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		asc="asc" desc="desc">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					客户名称
				</th>
				<th width="100">
					联系人
				</th>

				<th width="100">
					电话号码
				</th>
				<th width="100">
					同步状态
				</th>
				<th width="100">
					备注
				</th>
				<th width="70">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.cusphoneList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>

					</td>
					<td>
						${item.custlinkname}
					</td>
					<td>
						${item.phoneno}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['SynStatus']}"
							var="activeState">
							<c:if test="${item.synstatus == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<td>
						${item.remark}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteCusphonelist.action?selectIDS=${item.id}&navTabId=cusphonelistLiNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
									name="common.delete" /> </span> </a>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editCusphonelist.action?cusphonelistKey=${item.id}"
							target="navTab" rel="cusphonelistCardNav" reloadFlag=1
							title="<s:text name="电话信息修改"/>"><span><s:text
									name="电话信息修改" /> </span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
