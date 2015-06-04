<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addMgrWoDefine.action?coltype=${coltype}&mgrTempletKey=${mgrTempletKey}"
					rel="addMgrWoDefineCardNav" target="dialog" reloadFlag=1
					width="804" height="336" mask="true"><span>添加</span> </a>
			</li>
			<li>
				<a class="delete" title="<s:text name="common.askdel"/>"
					target="selectedTodo" rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}delMgrWoDefine.action?navTabId=addMgrWoDefineCardNav"><span>删除</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}editMgrWoDefine.action?mgrWoDefineKey={slt_uid}&coltype=${coltype}&mgrTempletKey=${mgrTempletKey}"
					rel="addMgrWoDefineCardNav" target="dialog" reloadFlag=1
					width="804" height="336" mask="true"><span>修改</span>
				</a>
			</li>
			<c:if test="${coltype == 'add'}">
				<li class="line">
					line
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="delete" title="确定要复制到编辑页面吗?" target="selectedTodo"
						rel="selectIDS" postType="string"
						href="${applicationScope.rootpath}cloneMgrWoDefine.action?navTabId=addMgrWoDefineCardNav&copyTo=edit"><span>复制>编辑页面</span>
					</a>
				</li>
				<li>
					<a class="delete" title="确定要复制到列表页面吗?" target="selectedTodo"
						rel="selectIDS" postType="string"
						href="${applicationScope.rootpath}cloneMgrWoDefine.action?navTabId=addMgrWoDefineCardNav&copyTo=list"><span>复制>列表页面</span>
					</a>
				</li>
				<li>
					<a class="delete" title="确定要复制到查询条件吗?" target="selectedTodo"
						rel="selectIDS" postType="string"
						href="${applicationScope.rootpath}cloneMgrWoDefine.action?navTabId=addMgrWoDefineCardNav&copyTo=query"><span>复制>查询条件</span>
					</a>
				</li>
				<li>
					<a class="delete" title="确定要复制到详情页面吗?" target="selectedTodo"
						rel="selectIDS" postType="string"
						href="${applicationScope.rootpath}cloneMgrWoDefine.action?navTabId=addMgrWoDefineCardNav&copyTo=details"><span>复制>详情页面</span>
					</a>
				</li>
			</c:if>
		</ul>
	</div>
	<table class="table" layoutH="80" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="2%">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<c:if
					test="${coltype == 'list'||coltype == 'query'||coltype == 'details'}">
					<th width="40%">
						字段名称
					</th>
					<th width="40%">
						显示名称
					</th>
					<th width="18%">
						编辑框类型
					</th>
				</c:if>
				<c:if test="${coltype == 'add'||coltype == 'edit'}">
					<th width="15%">
						字段名称
					</th>
					<th width="15%">
						显示名称
					</th>
					<th width="5%">
						编辑框类型
					</th>
					<th width="5%">
						最小长度
					</th>
					<th width="5%">
						最大长度
					</th>
					<th width="15%">
						样式(class)
					</th>
					<th width="5%">
						必填
					</th>
					<th width="5%">
						可编辑
					</th>
					<th width="5%">
						区域划分
					</th>
				</c:if>
				<th width="4%">
					排序
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${mgr_wodefine_need}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<c:if
						test="${coltype == 'list'||coltype == 'query'||coltype == 'details'}">
						<td>
							${item.defCol}
						</td>
						<td>
							${item.defColTitle}
						</td>
						<td>
							${item.defColType}
						</td>
					</c:if>
					<c:if test="${coltype == 'add'||coltype == 'edit'}">
						<td>
							${item.defCol}
						</td>
						<td>
							${item.defColTitle}
						</td>
						<td>
							${item.defColType}
						</td>
						<td>
							${item.defColLmin}
						</td>
						<td>
							${item.defColLmax}
						</td>
						<td>
							${item.defColClass}
						</td>
						<td>
							${item.defColRequired}
						</td>
						<td>
							${item.defCanedit}
						</td>
						<td>
							<c:forEach items="${applicationScope.dictpara['MGR_WO_REGION']}"
								var="activeState">
								<c:if test="${item.defColRegion == activeState.code}">
								${activeState.title}
							</c:if>
							</c:forEach>
						</td>
					</c:if>
					<td>
						${item.defColOrder}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
