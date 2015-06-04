<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListWorkorder.action?pageCode=${pageCode}&clearPara=Y">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
	<!-- 查询条件 -->
	<input type="hidden" value="${querycustomername}" id="querycustomername" name="querycustomername">
	<input type="hidden" value="${querycustlinkman}" id="querycustlinkman" name="querycustlinkman">
	<input type="hidden" value="${querygeneratemode}" id="querygeneratemode" name="querygeneratemode">
	<input type="hidden" value="${starttime1}" id="starttime1" name="starttime1">
	<input type="hidden" value="${stoptime1}" id="stoptime1" name="stoptime1">
	<input type="hidden" value="${querycallerno}" id="querycallerno" name="querycallerno">
	<input type="hidden" value="${queryordertype}" id="queryordertype" name="queryordertype">
	<input type="hidden" value="${sessionScope.orderCode}" id="orderCode" name="orderCode">
	<input type="hidden" value="${queryworkorderno}" id="queryworkorderno" name="queryworkorderno">
	<input type="hidden" value="${querywostatus}" id="querywostatus" name="querywostatus">
	<input type="hidden" value="${querycompleteperson}" id="querycompleteperson" name="querycompleteperson">
	<input type="hidden" value="${starttime2}" id="starttime2" name="starttime2">
	<input type="hidden" value="${stoptime2}" id="stoptime2" name="stoptime2">
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListWorkorder.action?search=true&pageCode=${pageCode}&clearPara=Y&orderCode=${orderCode}"
		method="post" name="${pageCode}">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						工单编号 :
						<input name="queryworkorderno" type="text" id="queryworkorderno"
							size="15" style="WIDTH: 94px" value="${queryworkorderno}"
							onkeydown="" />
					</td>
					<td>
						工单状态 :
						<select name="querywostatus">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach
								items="${applicationScope.dictpara['WorkOrderStatus']}"
								var="activeState">
								<c:choose>
									<c:when test="${querywostatus == activeState.code}">
										<option value="${activeState.code}" selected>
											${activeState.title}
										</option>
									</c:when>
									<c:otherwise>
										<option value="${activeState.code}">
											${activeState.title}
										</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>

						</select>
					</td>
					<td>
						工单类型 :
						<select name="queryordertype">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['OrderType']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryordertype == activeState.code}">
										<option value="${activeState.code}" selected>
											${activeState.title}
										</option>
									</c:when>
									<c:otherwise>
										<option value="${activeState.code}">
											${activeState.title}
										</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>

						</select>
					</td>
					<td>
						客户名称 :
						<input name="querycustlinkman" type="text" id="querycustlinkman"
							size="15" style="WIDTH: 94px" value="${querycustlinkman}"
							onkeydown="" />
					</td>
					<td>
						<div class="subBar">
							<ul>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">
												检索
											</button>
										</div>
									</div>
								</li>
								<li>
									<a class="button"
										href="${applicationScope.rootpath}searchJspPage.action?changeUrl=Y"
										target="dialog" mask="true" title="高级检索"
										rel="searchOrderinfoCardNav" width="855" height="150"><span>高级检索</span>
									</a>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="button"
												onclick="getValue(document.forms['${pageCode}']);">
												清除
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
			<c:if test="${sessionScope.orderCode == 'wcl'}">
				<li>
					<a class="add"
						href="${applicationScope.rootpath}addWorkOrder.action?ordersource=manual"
						rel="workorderCardNav" target="navTab" reloadFlag=1><span>生成工单</span>
					</a>
				</li>
			</c:if>
			<c:if test="${sessionScope.orderCode == 'hahaha'}">
				<li>
					<a title="<s:text name="common.askdel"/>" target="selectedTodo"
						rel="selectIDS" postType="string"
						href="${applicationScope.rootpath}deleteWorkOrder.action?navTabId=workorder${pageCode}LiNav"
						class="delete"><span>批量删除</span> </a>
				</li>
			</c:if>
			<c:if test="${sessionScope.orderCode == 'all'}">
				<li>
					<a class="icon"
						href="${applicationScope.rootpath}download.action?loadflag=wo&fileName=wo_info.xls&sessionname=allOrderList"
						target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span>
					</a>
				</li>
			</c:if>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<c:if test="${sessionScope.orderCode == 'hahaha'}">
					<th width="22">
						<input type="checkbox" group="selectIDS" class="checkboxCtrl">
					</th>
				</c:if>
				<th width="100">
					工单编号
				</th>
				<th width="80">
					工单状态
				</th>
				<th width="80">
					工单类型
				</th>
				<th width="120">
					客户名称
				</th>
				<th width="80">
					客服专员
				</th>
				<th width="80">
					实际接单人
				</th>
				<th width="80">
					生成类型
				</th>
				<th width="120">
					创建时间
				</th>
				<th width="120">
					处理时间
				</th>
				<th width="120">
					结单时间
				</th>
				<th width="70">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.workorderList}">
				<tr target="slt_uid" rel="${item.id}">
					<c:if test="${sessionScope.orderCode == 'hahaha'}">
						<td>
							<input name="selectIDS" value="${item.id}" type="checkbox">
						</td>
					</c:if>
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
						<c:if
							test="${item.wostatus == 'wcl' && sessionScope.orderCode != 'all'}">
							<%--<a class="btnDel"
									href="${applicationScope.rootpath}deleteWorkOrder.action?selectIDS=${item.id}&navTabId=workorderLiNav"
									target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
											name="common.delete" /> </span> </a>--%>
							<a class="btnEdit"
								href="${applicationScope.rootpath}editWorkOrder.action?workOrderKey=${item.id}"
								target="navTab" rel="workorderCardNav" reloadFlag=1 title="修改工单"><span>修改工单</span>
							</a>
						</c:if>
						<c:if test="${sessionScope.orderCode == 'dhxcl'}">
							<a class="btnEdit"
								href="${applicationScope.rootpath}editWorkOrderdealinfo.action?workOrderKey=${item.id}"
								target="navTab" rel="workorderCardNav" reloadFlag=1 title="工单处理"><span>工单处理</span>
							</a>
						</c:if>
						<c:if test="${sessionScope.orderCode == 'ywc'}">
							<a class="btnEdit"
								href="${applicationScope.rootpath}editYwcWorkOrderdealinfo.action?workOrderKey=${item.id}&orderCode=ywc"
								target="navTab" rel="workorderCardNav" reloadFlag=1 title="工单结单"><span>工单结单
							</span> </a>
						</c:if>
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
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>
</div>
