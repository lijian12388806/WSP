<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post"
	onsubmit="return divSearch(this, 'jbsxBox_order');"
	action="${applicationScope.rootpath}listworkoder_his.action?his_N='${order_hisN}'">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
</form>
<div class="lcp_div_left" style="margin-top: 10px; width: 100%;">
	<table class="list" nowrapTD="false" width="99%"
		style="table-layout: fixed;">
		<thead>
			<tr>
				<th width="20">
					<i class="icon-comment"></i> 历史工单
				</th>
			</tr>
		</thead>
	</table>
	<table class="table" layoutH="350" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="5">
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
					客户名称
				</th>
				<th width="100">
					客服专员
				</th>
				<th width="100">
					实际接单人
				</th>
				<th width="100">
					生成类型
				</th>
				<th width="100">
					创建时间
				</th>
				<th width="100">
					处理时间
				</th>
				<th width="100">
					结单时间
				</th>
				<th width="70">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${workorderList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
					</td>
					<td>
						${item.workorderno}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['WorkOrderStatus']}"
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
						${item.pkCustomerinfo.custlinkman}
					</td>
					<td>
						${item.pkUserinfo.username}
					</td>
					<td>
						${item.actusername}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['GenerateMode']}"
							var="activeState">
							<c:if test="${item.generatemode == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<td>
						<fmt:formatDate value="${item.calltime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>
						<fmt:formatDate value="${item.dealtime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>
						<fmt:formatDate value="${item.completetime}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>
						<c:if test="${sessionScope.orderCode == 'all'}">
							<a class="btnEdit"
								href="${applicationScope.rootpath}searchAllWorkOrderdealinfo.action?workOrderKey=${item.id}&orderCode=all"
								target="navTab" rel="searchAllorderdealinfoCardNav" reloadFlag=1
								title="工单查看"><span>工单查看 </span> </a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
	<div class="pages">
		<!-- <span>显示:</span> -->
		<span><s:text name="common.perpage"/></span>
		<select name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox_order')">
			<c:forEach begin="10" end="40" step="10" varStatus="s">
				<option value="${s.index}" ${numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
		<!-- <span>条，共: ${totalCount}条</span> -->
		<span><s:text name="common.tiao"/>，<s:text name="common.total"/>: ${totalCount}<s:text name="common.tiao"/></span>
	</div>
	
	<div class="pagination" targetType="navTab" rel="jbsxBox_order" totalCount="${totalCount}" numPerPage="${numPerPage}" pageNumShown="10" currentPage="${param.pageNum}"></div>
</div>
</div>