<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListWorkorder.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />

<!-- 查询条件 -->
	<input type="hidden" value="${querycustlinkman}" id="querycustlinkman"
		name="querycustlinkman">
	<input type="hidden" value="${querygeneratemode}" id="querygeneratemode"
		name="querygeneratemode">
	<input type="hidden" value="${starttime1}" id="starttime1"
		name="starttime1">
	<input type="hidden" value="${stoptime1}" id="stoptime1"
		name="stoptime1">
	<input type="hidden" value="${querycallerno}" id="querycallerno"
		name="querycallerno">
	<input type="hidden" value="${queryordertype}"
		id="queryordertype" name="queryordertype">
	<input type="hidden" value="${sessionScope.orderCode}" id="orderCode"
						name="orderCode">



	<input type="hidden" value="${queryworkorderno}" id="queryworkorderno"
		name="queryworkorderno">
	<input type="hidden" value="${querywostatus}" id="querywostatus"
		name="querywostatus">
	<input type="hidden" value="${querycompleteperson}" id="querycompleteperson"
		name="querycompleteperson">
	<input type="hidden" value="${starttime2}" id="starttime2"
		name="starttime2">
	<input type="hidden" value="${stoptime2}" id="stoptime2"
		name="stoptime2">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListWorkorder.action?search=true&orderCode=${orderCode}" method="post"
		name="gListWorkorder">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						客户名称 :
						<input name="querycustlinkman" type="text" id="querycustlinkman"
							size="15" style="WIDTH: 94px" value="${querycustlinkman}"
							onkeydown="" />
					</td>

					<td>
						生成类型 :
						<select name="querygeneratemode">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['GenerateMode']}"
								var="activeState">
								<c:choose>
									<c:when test="${querygeneratemode == activeState.code}">
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
						来电时间 :
						<input name="starttime1" id="starttime1" value="${starttime1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span>到</span>
						<input name="stoptime1" id="stoptime1" value="${stoptime1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
					</td>

				</tr>
				<tr>
					<td>
						来电号码 :
						<input name="querycallerno" type="text" id="querycallerno"
							size="20" value="${querycallerno}" onkeydown="" />
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
						结单时间 :
						<input name="starttime2" id="starttime2" value="${starttime2}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span>到</span>
						<input name="stoptime2" id="stoptime2" value="${stoptime2}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
					</td>

				</tr>
				<tr>
					<td>
						工单编号 :
						<input name="queryworkorderno" type="text" id="queryworkorderno"
							size="20" value="${queryworkorderno}" onkeydown="" />
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
						结 单 人:
						<input name="querycompleteperson" type="text"
							id="querycompleteperson" size="20" value="${querycompleteperson}"
							onkeydown="" />
					</td>
				</tr>
			</table>
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
									onclick="getValue(document.forms['gListWorkorder']);">
									<s:text name="common.clean" />
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>
