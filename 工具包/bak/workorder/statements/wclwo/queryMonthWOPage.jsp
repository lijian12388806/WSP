<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listMonthWclwo.action">
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
		action="listMonthWclwo.action" method="post" name="listMonthWclwo">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						统计时间:
						<input name="querywomonth" id="querywomonth"
							value="${querywomonth}" type="text" size="20" class="date"
							format="yyyy-MM" yearstart="0" yearend="100" />
					</td>
					<td>
						未处理工单数:
						<select name="querywclcompare">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${querywclcompare == activeState.code}">
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
						<input name="querywclnumber" id="querywclnumber"
							value="${querywclnumber}" type="text" size="5" />
					</td>
					<td>
						待处理工单数:
						<select name="querydhxclcompare">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${querydhxclcompare == activeState.code}">
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
						<input name="querydhxclnumber" id="querydhxclnumber"
							value="${querydhxclnumber}" type="text" size="5" />
					</td>
				</tr>
				<tr>
					<td>
						客服专员:
						<input name="queryagentname" id="queryagentname"
							value="${queryagentname}" type="text" size="20" />
					</td>
					<td>
						已完成工单数:
						<select name="queryywccompare">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['Compare']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryywccompare == activeState.code}">
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
						<input name="queryywcnumber" id="queryywcnumber"
							value="${queryywcnumber}" type="text" size="5" />
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
												onclick="getValue(document.forms['listMonthWclwo']);">
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
				<th width="100">
					统计时间
				</th>
				<th width="100">
					客服专员
				</th>
				<th width="100">
					未处理工单
				</th>
				<th width="100">
					待处理工单
				</th>
				<th width="100">
					已完成工单
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.liststfmonth}">
				<tr>
					<td>
						${item.subdate}
					</td>
					<td>
						${item.womaker}
					</td>
					<td>
						${item.wclwo}
					</td>
					<td>
						${item.dhxclwo}
					</td>
					<td>
						${item.ywcwo}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
