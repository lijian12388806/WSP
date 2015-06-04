<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addOrderdealinfo.action?workOrderKey=${workOrderKey}"
					rel="addDhxclOrderdealinfoCardNav" target="navTab" reloadFlag=1><span>处理工单
				</span> </a>
			</li>

			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteOrderdealinfo.action?navTabId=workorderCardNav"
					class="delete"><span>批量删除</span> </a>
			</li>

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="350" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					工单编号
				</th>
				<th width="100">
					问题部门
				</th>
				<th width="100">
					问题部门处理人
				</th>
				<th width="100">
					问题责任人
				</th>
				<th width="100">
					问题描述
				</th>
				<th width="100">
					问题原因
				</th>
				<th width="100">
					处理情况
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
			<c:forEach var="item" items="${sessionScope.orderdealList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.workorderno}
					</td>
					<td>
						${item.prodepartment}
					</td>
					<td>
						${item.depdealman}
					</td>
					<td>
						${item.assignperson}
					</td>
					<td>
						${item.prodesc}
					</td>
					<td>
						${item.proreason}
					</td>
					<td>
						${item.prosituation}
					</td>
					<td>
						${item.remark}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteOrderdealinfo.action?selectIDS=${item.id}&navTabId=workorderCardNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
									name="common.delete" /> </span> </a>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editOrderdealinfo.action?orderdealinfoKey=${item.id}&workOrderKey=${workOrderKey}"
							target="navTab" rel="editOrderdealinfoCardNav" reloadFlag=1
							title="处理信息"><span>修改工单 </span> </a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>