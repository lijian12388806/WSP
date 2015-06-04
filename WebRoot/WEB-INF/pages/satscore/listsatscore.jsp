<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListSatscore.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
	<!-- 查询条件 -->
	<input type="hidden" value="${querycallerno}" id="querycallerno"
		name="querycallerno">
	<input type="hidden" value="${starttime1}" id="starttime1"
		name="starttime1">
	<input type="hidden" value="${stoptime1}" id="stoptime1"
		name="stoptime1">
	<input type="hidden" value="${queryagentid}" id="queryagentid"
		name="queryagentid">
	<input type="hidden" value="${queryextno}" id="queryextno"
		name="queryextno">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListSatscore.action?search=true" method="post"
		name="ListSatscore">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						主叫号码：
						<input type="text" name="querycallerno" value="${querycallerno}"
							maxlength="20" />
					</td>

					<td>
						满意度调查服务时间 ：
						<input name="starttime1" id="starttime1" value="${starttime1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span>到</span>
						<input name="stoptime1" id="stoptime1" value="${stoptime1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<td>
						坐席工号：
						<input type="text" name="queryagentid" value="${queryagentid}"
							maxlength="20" />
					</td>
					<td>
						登陆分机号：
						<input type="text" name="queryextno" value="${queryextno}"
							maxlength="20" />
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
												onclick="getValue(document.forms['ListSatscore']);">
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
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		asc="asc" desc="desc" style="table-layout: fixed">
		<thead>
			<tr>
				<th width="100">
					主叫号码
				</th>
				<th width="100">
					坐席工号
				</th>

				<th width="100">
					登陆的分机号码
				</th>
				<th width="100">
					满意度调查服务时间
				</th>
				<th width="100">
					满意度
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.satscoreList}">
				<tr target="slt_uid" rel="">
					<td>
						${item.callerno}
					</td>
					<td>
						${item.agentid}
					</td>
					<td>
						${item.extno}
					</td>
					<td>
						${item.svctime}
					</td>

					<td>
						<c:forEach items="${applicationScope.dictpara['StaCode']}"
							var="activeState">
							<c:if test="${item.svcpoint == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>
</div>
