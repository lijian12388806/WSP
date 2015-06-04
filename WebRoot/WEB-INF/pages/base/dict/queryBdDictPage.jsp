<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="${applicationScope.rootpath}ListBdDict.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
</form>

<!-- 查询条件 -->
	<input type="hidden" value="${queryDictTitle}" id="queryDictTitle"
		name="queryDictTitle">
	<input type="hidden" value="${queryDictCode}" id="queryDictCode"
		name="queryDictCode">
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListBdDict.action?search=true" method="post" name="ListBdDict">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						<s:text name="dict.dictname"/>：
						<input name="queryDictTitle" type="text" id="queryDictTitle"
							size="15" style="WIDTH: 94px" value="${queryDictTitle}"
							onkeydown="" />
					</td>
					<td>
						<s:text name="dict.dictcode"/>：
						<input name="queryDictCode" type="text" autocomplete="off"
							query="Y" id="queryDictCode" size="15" style="WIDTH: 94px"
							value="${queryDictCode}" onkeydown="" />
					</td><td>
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
											<button type="button" onclick="getValue(document.forms['ListBdDict']);">
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
				<a class="add" href="${applicationScope.rootpath}addBdDict.action" rel="adddictCardNav" target="navTab"  reloadFlag=1><span><s:text name="common.add"/></span>
				</a>
			</li>
			<li><a title="" target="selectedTodo" rel="selectIDS" postType="string" href="${applicationScope.rootpath}deleteBdDict.action?navTabId=dictLiNav" class="delete"><span><s:text name="common.batchdel"/></span></a></li>
			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="selectIDS" class="checkboxCtrl"></th>
				<th width="100" orderField="DICTTITLE" class="${param.orderField eq 'DICTTITLE' ? param.orderDirection : ''}"><s:text name="dict.dictname"/></th>
				<th width="100" orderField="DICTCODE" class="${param.orderField eq 'DICTCODE' ? param.orderDirection : ''}"><s:text name="dict.dictcode"/></th>
				<th width="80" orderField="ISVALID" class="${param.orderField eq 'ISVALID' ? param.orderDirection : ''}"><s:text name="common.validornot"/></th>
				<th width="70"><s:text name="common.operate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.bdDictList}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="selectIDS" value="${item.id}" type="checkbox"></td>
				<td>${item.dicttitle}</td>
				<td>${item.dictcode}</td>
				<td>${item.isvalid}</td>
				<td>
					<a class="btnDel" href="${applicationScope.rootpath}deleteBdDict.action?selectIDS=${item.id}&navTabId=dictLiNav"
					target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text name="common.delete"/></span> </a>
					<a class="btnEdit" href="${applicationScope.rootpath}editBdDict.action?bdDictKey=${item.id}"
					target="navTab" rel="dictCardNav"  reloadFlag=1 title="<s:text name="dict.edit"/>"><span><s:text name="dict.edit"/></span> </a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
		<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>


</div>
