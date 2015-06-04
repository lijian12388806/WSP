<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ include file="/include.inc.jsp"%>
	<div class="panel collapse" width="90%" >
		<h1>
			--未处理工单统计--
		</h1>
		<table class="table" layoutH="300" nowrapTD="false" width="80%">
			<thead>
				<tr>
					<th width="100">
						客服专员
					</th>
					<th width="100">
						工单编号
					</th>
					<th width="100">
						工单状态
					</th>

					<th width="100">
						工单类型
					</th>
					<th width="100">
						工单来源
					</th>

					<th width="70">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${sessionScope.workorderIndexList}">
					<tr target="slt_uid" rel="${item.id}">
						<td>
							${item.pkUserinfo.username}
						</td>
						<td>
							${item.workorderno}
						</td>
						<td>
							<c:forEach
								items="${applicationScope.dictpara['WorkOrderStatus']}"
								var="activeState">
								<c:if test="${item.wostatus == activeState.code}">
							${activeState.title}
						</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${applicationScope.dictpara['OrderType']}"
								var="activeState">
								<c:if test="${item.ordertype == activeState.code}">
							${activeState.title}
						</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${applicationScope.dictpara['SourceOrder']}"
								var="activeState">
								<c:if test="${item.ordersource == activeState.code}">
							${activeState.title}
						</c:if>
							</c:forEach>
						</td>

						<td>
							<a class="btnEdit"
								href="${applicationScope.rootpath}indexYwcWorkOrderdealinfo.action?workOrderKey=${item.id}"
								target="navTab" rel="indexorderdealinfoCardNav" reloadFlag=1
								title="工单处理"><span>工单处理</span> </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
