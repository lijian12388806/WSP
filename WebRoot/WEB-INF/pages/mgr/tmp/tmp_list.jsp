<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listMgrTemplet.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addMgrTemplet.action"
					rel="addMgrTempletCardNav" target="dialog" reloadFlag=1 mask="true"><span>添加模板</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}editMgrTemplet.action?mgrTempletKey={slt_uid}"
					rel="addMgrTempletCardNav" target="dialog" reloadFlag=1 mask="true"><span>修改模板</span>
				</a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}delMgrTemplet.action?navTabId=mgrtempletLiNav"
					class="delete"><span>删除模板</span> </a>
			</li>
			<li class="line">
				line
			</li>
			<li class="line">
				line
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}listMgrWoDefine.action?mgrTempletKey={slt_uid}&coltype=add"
					rel="addMgrWoDefineCardNav" target="navTab" reloadFlag=1 mask="true"><span>新增页面</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}listMgrWoDefine.action?mgrTempletKey={slt_uid}&coltype=edit"
					rel="addMgrWoDefineCardNav" target="navTab" reloadFlag=1 mask="true"><span>编辑页面</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}listMgrWoDefine.action?mgrTempletKey={slt_uid}&coltype=list"
					rel="addMgrWoDefineCardNav" target="navTab" reloadFlag=1 mask="true"><span>列表页面</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}listMgrWoDefine.action?mgrTempletKey={slt_uid}&coltype=query"
					rel="addMgrWoDefineCardNav" target="navTab" reloadFlag=1 mask="true"><span>查询条件</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}listMgrWoDefine.action?mgrTempletKey={slt_uid}&coltype=details"
					rel="addMgrWoDefineCardNav" target="navTab" reloadFlag=1 mask="true"><span>详情页面</span>
				</a>
			</li>
		</ul>
	</div>
	<table class="table" layoutH="80" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="2%">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="10%">
					模板编号
				</th>
				<th width="10%">
					模板名称
				</th>
				<th width="22%">
					列表数据显示
				</th>
				<th width="6%">
					模板类型
				</th>
				<th width="6%">
					模板状态
				</th>
				<th width="36%">
					按钮定义
				</th>
				<th width="8%">
					关联工单/客户
				</th>
				<th width="6%">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${mgr_templet_list}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.tmpCode}
					</td>
					<td>
						${item.tmpName}
						<a class=""
					href="${applicationScope.rootpath}getMgrTempletUrl.action?tmpType=${item.tmpType}&tmpCode=${item.tmpCode}"
					rel="urlMgrTempletCardNav" target="dialog" reloadFlag=1 mask="true"><span style="color:blue;">[Url]</span>
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['WO_BUTTON']}"
							var="activeState">
							<c:if test="${fn:contains(item.tmpListdata,activeState.code)}">
								${activeState.title}
							</c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['MGR_TYPE']}"
							var="activeState">
							<c:if test="${item.tmpType == activeState.code}">
								${activeState.title}
							</c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['UserStatus']}"
							var="activeState">
							<c:if test="${item.tmpStatus == activeState.code}">
								${activeState.title}
							</c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['WO_BUTTON']}"
							var="activeState">
							<c:if test="${fn:contains(item.tmpBtn,activeState.code)}">
								${activeState.title}
							</c:if>
						</c:forEach>
					</td>
					<td>
						${item.tmpRelated}
					</td>
					<td>
						<a class=""
							href="${applicationScope.rootpath}addcloneMgrTemplet.action?mgrTempletKey=${item.id}&navTabId=mgrtempletLiNav"
							target="ajaxTodo" title="<s:text name="是否复制该模板新增页面?"/>"><span style="color:blue;">复制页面</span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>
</div>
