<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListAdminUserinfo">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	<!-- 查询条件 -->
	<input type="hidden" value="${queryusername}" id="queryusername"
		name="queryusername">
</form>

<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js">
</script>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ListAdminUserinfo"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						<s:text name="userinfo.username" />
						：
						<input name="queryusername" type="text" id="queryusername"
							size="15" style="WIDTH: 94px" value="${queryusername}"
							onkeydown="" />
						<input type="hidden" value="Y" id="isadmin" name="isadmin">
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
											<button type="button" onclick="getValue(document.forms[1]);">
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
					href="${applicationScope.rootpath}addAdminUserinfo.action"
					rel="addAdminuserinfoCardNav" target="navTab" reloadFlag=1><span><s:text
							name="common.add" /> </span> </a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteAdminUserinfo?navTabId=adminLiNav"
					class="delete"><span><s:text name="common.batchdel" />
				</span> </a>
			</li>
			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					<s:text name="userinfo.username" />
				</th>
				<th width="100">
					<s:text name="userinfo.isadmin" />
				</th>				
				<th width="100">
					<s:text name="userinfo.remark" />
				</th>
				<th width="70">
					<s:text name="common.operate" />
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.userinfoList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<c:if test="${item.username != 'admin'}">
							<input name="selectIDS" value="${item.id}" type="checkbox">
						</c:if>
					</td>
					<td>
						${item.username}
					</td>
					<td>
						${item.isadmin}
					</td>
					<td>
						${item.remark}
					</td>
					<td>

						<c:if test="${item.username != 'admin'}">
							<a class="btnDel"
								href="${applicationScope.rootpath}deleteAdminUserinfo?selectIDS=${item.id}&navTabId=adminLiNav"
								target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
										name="common.delete" /> </span> </a>
						</c:if>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editAdminUserinfo?adminKey=${item.id}"
							target="navTab" rel="adminCardNav" reloadFlag=1
							title="<s:text name="userinfo.edituserinfo"/>"><span><s:text
									name="userinfo.edituser" /> </span> </a>
						<c:if test="${sessionScope.userinfo.isadmin == 'true'}">
							<a class="btnAssign"
								href="${applicationScope.rootpath}dispatchRole?userinfoKey=${item.id}"
								target="dialog" rel="dispatchCardNav" reloadFlag=1
								title="<s:text name="role.dispatch"/>"><span><s:text
										name="role.dispatch" /> </span> </a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
