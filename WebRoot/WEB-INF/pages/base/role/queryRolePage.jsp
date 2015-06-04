<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListRole.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
<!-- 查询条件 -->
	<input type="hidden" value="${queryrolename}" id="queryrolename"
		name="queryrolename">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ListRole.action"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						<s:text name="role.rolename"/>：
						<input name="queryrolename" type="text" id="queryrolename"
							size="15" style="WIDTH: 94px" value="${queryrolename}"
							onkeydown="" />
					</td>
					<td>
						<div class="subBar">
							<ul>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">
												<s:text name="common.search"/>
											</button>
										</div>
									</div>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="button" onclick="getValue(document.forms['ListRole']);">
												<s:text name="common.clean"/>
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
				<a class="add" href="${applicationScope.rootpath}addRole.action"
					rel="addroleCardNav" target="navTab" reloadFlag=1 width="853" height="476"><span><s:text name="role.add"/></span>
				</a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo" rel="selectIDS"
					postType="string"
					href="${applicationScope.rootpath}deleteRole.action?navTabId=roleLiNav"
					class="delete"><span> <s:text name="common.batchdel"/></span> </a>
			</li>
			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%" asc="asc" desc="desc"> 
		<thead>
			<tr>
				<th width="1%">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					<s:text name="role.rolename"/>
				</th>
				<th width="250" >
					<s:text name="role.description"/>
				</th>
				<th width="10">
					<s:text name="common.operate"/>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.roleList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.rolename}
					</td>
					<td>
						${item.description}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteRole.action?selectIDS=${item.id}&navTabId=roleLiNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text name="common.delete"/></span> </a>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editRole.action?roleKey=${item.id}"
							target="navTab" rel="roleCardNav" reloadFlag=1 title="<s:text name="role.edit"/>"><span><s:text name="role.edit"/></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
