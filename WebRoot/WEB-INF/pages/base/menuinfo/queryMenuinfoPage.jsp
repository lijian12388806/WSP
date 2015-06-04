<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post"
	onsubmit="return divSearch(this, 'jbsxBox');"
	action="${applicationScope.rootpath}ListMenuinfo.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />

<!-- 查询条件 -->
	<input type="hidden" value="${querymenuname}" id="querymenuname"
		name="querymenuname">
	<input type="hidden" value="${queryaddress}" id="queryaddress"
		name="queryaddress">
</form>

<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js">
</script>
<div class="pageHeader">
	<form onsubmit="return divSearch(this, 'jbsxBox');" action="ListMenuinfo.action"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						<s:text name="menuinfo.menuname"/>：
						<input name="querymenuname" type="text" id="querymenuname"
							size="15" style="WIDTH: 94px" value="${querymenuname}"
							onkeydown="" />
					</td>
<td>
						<s:text name="menuinfo.linkaddress"/>：
						<input name="queryaddress" type="text" id="queryaddress"
							size="30" style="WIDTH: 94px" value="${queryaddress}"
							onkeydown="" />
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
											<button type="button" onclick="getValue(document.forms['ListMenuinfo']);">
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
				<a class="add" href="${applicationScope.rootpath}addMenuinfo.action"
					rel="addmenuinfoCardNav" target="navTab" reloadFlag=1><span><s:text name="menuinfo.add"/></span>
				</a>
			</li>
			<!-- <li>
				<a class="add" href="${applicationScope.rootpath}addMenuinfo.action"
					rel="batchmenuinfoCardNav" target="navTab" reloadFlag=1><span>批量添加</span>
				</a>
			</li>-->
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo" rel="selectIDS"
					postType="string"
					href="${applicationScope.rootpath}deleteMenuinfo.action?navTabId=menuinfoLiNav"
					class="delete"><span><s:text name="common.batchdel"/></span> </a>
			</li>
			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="155" nowrapTD="false" width="100%" style="table-layout: fixed">
		<thead>
			<tr>
				<th width="2%">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="10%">
					<s:text name="menuinfo.menuname"/>
				</th>
				<th width="10%">
					<s:text name="menuinfo.listSuper"/>
				</th>
				<th width="50%">
					<s:text name="menuinfo.linkaddress"/>
				</th>
				<th width="10%">
					rel
				</th>
				<th width="3%">
					状态
				</th>
				<th width="3%">
					删除
				</th>
				<th width="3%">
					编辑
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.menuinfoList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.menuname}
					</td>
					<td>
						<c:if test="${item.supermenu==0}">
									     Root
									  </c:if>
						<c:forEach items="${supermenumap[item.supermenu]}" var="item1"> 
									${item1}
								</c:forEach>
					</td>
					<td>
						${item.linkaddress}
					</td>
					<td>
						${item.temp1}
					</td>
					<td>
						${item.isavailable}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteMenuinfo.action?selectIDS=${item.id}&navTabId=menuinfoLiNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text name="common.delete"/></span> </a>
							</td>
							<td>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editMenuinfo.action?pkMenuKey=${item.id}"
							target="navTab" rel="menuinfoCardNav" reloadFlag=1 title="<s:text name="menuinfo.edit"/>"><span><s:text name="menuinfo.edit"/></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBarBox.jsp"></c:import>

</div>
