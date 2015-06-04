<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent sortDrag" selector="h1" layoutH="42"
	id="woStatistics">
	<div class="panel collapse" minH="100" defH="200">
		<h1>
			--代办事项--
		</h1>
		<table class="list"  width="100%">
			<thead>
				<tr>
					<th width="80">
						客服专员
					</th>
					<th width="100">
						工单编号
					</th>
					<th width="80">
						工单状态
					</th>

					<th width="80">
						工单类型
					</th>
					<th width="80">
						工单来源
					</th>

					<th width="80">
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
</div>