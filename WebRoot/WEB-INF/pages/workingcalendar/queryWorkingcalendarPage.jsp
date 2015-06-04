<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listWorkingcalendar.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />

	<!-- 查询条件 -->
	<input type="hidden" value="${queryworkingdate}" id="queryworkingdate"
		name="queryworkingdate">
	<input type="hidden" value="${queryisvacation}" id="queryisvacation"
		name="queryisvacation">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="listWorkingcalendar.action?search=true" method="post"
		name="ListWorkingcalendar">
		<div class="searchBar">
			<table class="searchContent">
				<tr>

					<td>
						日期 :
						<input name="queryworkingdate" id="queryworkingdate"
							value="${queryworkingdate}" type="text" size="20" class="date"
							format="yyyy-MM-dd" />
					</td>
					<td>
						是否节假日:
						<select name="queryisvacation" >
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach
								items="${applicationScope.dictpara['WorkingCalendar']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryisvacation == activeState.code}">
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
						<div class="subBar">
							<ul>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">
												<s:text name="common.search" />
											</button>
										</div>
									</div>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="button"
												onclick="getValue(document.forms['ListWorkingcalendar']);">
												<s:text name="common.clean" />
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
				<a class="add"
					href="${applicationScope.rootpath}addWorkingcalendar.action"
					rel="addworkingcalendarCardNav" target="dialog" reloadFlag=1
					mask="true" width="911" height="262"><span><s:text
							name="节假日" /> </span> </a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteWorkingcalendar?navTabId=workingcalendarLiNav"
					class="delete"><span><s:text name="批量删除" /> </span> </a>
			</li>

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					日期
				</th>
				<th width="100">
					是否节假日
				</th>
				<th width="100">
					值班人
				</th>
				<th width="100">
					值班电话
				</th>
				<th width="100">
					备注
				</th>
				<th width="70">
					<s:text name="common.operate" />
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.workingcalendarList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.workingdate}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['WorkingCalendar']}"
							var="activeState">
							<c:if test="${item.isvacation == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<td>
						${item.n2}
					</td>
					<td>
						${item.n1}
					</td>
					<td>
						${item.reamrk}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteWorkingcalendar.action?selectIDS=${item.id}&navTabId=workingcalendarLiNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
									name="common.delete" /> </span> </a>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editWorkingcalendar.action?workingcalendarKey=${item.id}"
							target="dialog" rel="editWorkingcalendarCardNav" reloadFlag=1
							mask="true" width="911" height="262" title="修改日历信息"><span>修改日历信息</span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
