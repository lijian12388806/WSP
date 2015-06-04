<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}lookUpCustomer.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
<input name="querycustlinkman" type="hidden" id="querycustlinkman"
							 value="${querycustlinkman}" />
<input name="querycustphoneno" type="hidden" id="querycustphoneno"
							 value="${querycustphoneno}" />
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>

<div class="pageHeader">
	<form onsubmit="return dwzSearch(this, 'dialog');"
		action="lookUpCustomer.action?search=true" method="post"
		name="lookListCustomerinfo">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						客户名称:
						<input name="querycustlinkman" type="text" id="querycustlinkman"
							size="15" value="${querycustlinkman}" onkeydown="" />
					</td>
					<td>
						电话号码:
						<input name="querycustphoneno" type="text" id="querycustphoneno"
							size="15" value="${querycustphoneno}" onkeydown="" />
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
											<button type="button"
												onclick="getValue(document.forms['lookListCustomerinfo']);">
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
	<table class="table" layoutH="138" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="10%">
					公司名称
				</th>
				<th width="10%">
					客户名称
				</th>
				<th width="10%">
					性别
				</th>	
				<th width="10%">
					联系电话
				</th>
				<th width="10%">
					QQ号码
				</th>
				<th width="10%">
					邮箱地址
				</th>
				<th width="10%">
					所属城市
				</th>
				<th width="10%">
					客户地址
				</th>
				<th width="70">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.customerinfoList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<a class=""
							href="javascript:$.bringBack({isnew:'false',customerid:'${item.id}',customername:'${item.customername}', custlinkman:'${item.custlinkman}', infosource:'${item.infosource}', custphoneno:'${item.custphoneno}',temp1:'${item.temp1}',emailaddr:'${item.emailaddr}',netherlands:'${item.netherlands}',custaddr:'${item.custaddr}'})"
							title="查找带回"><span style="color:blue">${item.customername}</span></a>
					</td>
					<td>
						${item.custlinkman}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['Gender']}"
							var="activeState">
							<c:if test="${item.infosource == activeState.code}">
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
						<a class=""
							href="javascript:$.bringBack({isnew:'false',customerid:'${item.id}',customername:'${item.customername}', custlinkman:'${item.custlinkman}', infosource:'${item.infosource}', custphoneno:'${item.custphoneno}',temp1:'${item.temp1}',emailaddr:'${item.emailaddr}',netherlands:'${item.netherlands}',custaddr:'${item.custaddr}'})"
							title="查找带回"><span style="color:blue">选择</span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/dialogBar.jsp"></c:import>

</div>
