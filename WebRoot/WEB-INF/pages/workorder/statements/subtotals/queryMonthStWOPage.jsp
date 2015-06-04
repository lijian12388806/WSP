<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listMonthStwo.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="listMonthStwo.action" method="post" name="listMonthStwo">
		<div class="searchBar">
			<table class="searchContent">
				<tr>

					<td>
						统计时间:
						<input name="querystwomonth" id="querystwomonth"
							value="${querystwomonth}" type="text" size="20" class="date"
							format="yyyy-MM" yearstart="0" yearend="100" />
					</td>
					<td>
						客服专员:
						<input name="queryagentname" id="queryagentname"
							value="${queryagentname}" type="text" size="20" />
					</td>
					<td>
						小样依赖:
						<select name="queryOSampledependc">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryOSampledependc == activeState.code}">
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
						<input name="queryOSampledependn" id="queryOSampledependn"
							value="${queryOSampledependn}" type="text" size="5"
							class="digits" />
					</td>
					<td>
						样板依赖:
						<select name="queryOAmodeldependc">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryOAmodeldependc == activeState.code}">
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
						<input name="queryOAmodeldependn" id="queryOAmodeldependn"
							value="${queryOAmodeldependn}" type="text" size="5"
							class="digits" />
					</td>
					<td>
						样板需求:
						<select name="queryOSampleReqc">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryOSampleReqc == activeState.code}">
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
						<input name="queryOSampleReqn" id="queryOSampleReqn"
							value="${queryOSampleReqn}" type="text" size="5" class="digits" />
					</td>
				</tr>
				<tr>
					<td>
						订单交货:
						<select name="queryOOrderDeliveryc">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryOOrderDeliveryc == activeState.code}">
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
						<input name="queryOOrderDeliveryn" id="queryOOrderDeliveryn"
							value="${queryOOrderDeliveryn}" type="text" size="5"
							class="digits" />
					</td>
					<td>
						现场服务:
						<select name="queryOOnsiteservicec">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryOOnsiteservicec == activeState.code}">
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
						<input name="queryOOnsiteservicen" id="queryOOnsiteservicen"
							value="${queryOOnsiteservicen}" type="text" size="5"
							class="digits" />
					</td>
					<td>
						投诉受理:
						<select name="queryOComplainthandc">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryOComplainthandc == activeState.code}">
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
						<input name="queryOComplainthandn" id="queryOComplainthandn"
							value="${queryOComplainthandn}" type="text" size="5"
							class="digits" />
					</td>
					<td>
						退货申请:
						<select name="queryOReturnReqc">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryOReturnReqc == activeState.code}">
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
						<input name="queryOReturnReqn" id="queryOReturnReqn"
							value="${queryOReturnReqn}" type="text" size="5" class="digits" />
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
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="button"
												onclick="getValue(document.forms['listMonthStwo']);">
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
			<li><a class="icon" href="${applicationScope.rootpath}download.action?loadflag=wo&fileName=${fileName}" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%">
		<thead>
			<tr>
				<th width="70">
					统计时间
				</th>
				<th width="70">
					客服专员
				</th>
				<th width="70">
					小样依赖
				</th>
				<th width="70">
					样板依赖
				</th>
				<th width="70">
					样板需求
				</th>
				<th width="70">
					订单交货
				</th>
				<th width="70">
					现场服务
				</th>
				<th width="70">
					投诉受理
				</th>
				<th width="70">
					退货申请
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.liststfstmonth}">
				<tr>
					<td>
						${item.subdate}
					</td>
					<td>
						${item.womaker}
					</td>
					<td>
						${item.OSampledepend}
					</td>
					<td>
						${item.OAmodeldepend}
					</td>
					<td>
						${item.OSampleReq}
					</td>
					<td>
						${item.OOrderDelivery}
					</td>
					<td>
						${item.OOnsiteservice}
					</td>
					<td>
						${item.OComplainthand}
					</td>
					<td>
						${item.OReturnReq}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
