<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}lookUpWorkstation.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>

<div class="pageHeader">
	<form onsubmit="return dwzSearch(this, 'dialog');"
		action="lookUpWorkstation.action?search=true" method="post" name="lookListWorkstation">
		<div class="searchBar">
			<table class="searchContent">
				<tr>

					<td>
						<s:text name="工厂名称" />
						:
						<input name="queryfactorynamecn" type="text"
							id="queryfactorynamecn" size="15" style="WIDTH: 94px"
							value="${queryfactorynamecn}" onkeydown="" />
					</td>
					<td>
						<s:text name="工厂英文名称" />
						:
						<input name="queryfactorynameen" type="text"
							id="queryfactorynameen" size="15" style="WIDTH: 94px"
							value="${queryfactorynameen}" onkeydown="" />
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
											<button type="button" onclick="getValue(document.forms['lookListWorkstation']);">
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
	<table class="table" layoutH="116" nowrapTD="false" width="100%" style="table-layout: fixed">
		<thead>
			<tr>

				<th width="100">
					工厂名称
				</th>
				<th width="100">
					工厂英文名称
				</th>
				<th width="100">
					工厂联系电话
				</th>
				<th width="100">
					联系人
				</th>
				<th width="100">
					联系人邮箱
				</th>
				<th width="70">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.workstationList}">
				<tr target="slt_uid" rel="${item.id}">

					<td>
						${item.factorynamecn}
					</td>
					<td>
						${item.factorynameen}
					</td>
					<td>
						${item.phoneno}
					</td>
					<td>
						${item.wslinkman}
					</td>
					<td>
						${item.wsemail}
					</td>
					<td>
						<a class=""
							href="javascript:$.bringBack({temp1:'${item.id}', factory:'${item.factorynamecn}',salesorg:'${item.factorynamecn}'})"
							title="查找带回"><span style="color:blue">选择</span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/dialogBar.jsp"></c:import>

</div>
