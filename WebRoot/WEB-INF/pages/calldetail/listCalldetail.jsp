<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListCalldetail.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
<!-- 查询条件 -->
	<input type="hidden" value="${queryani}" id="queryani"
		name="queryani">
	<input type="hidden" value="${queryagentid}" id="queryagentid"
		name="queryagentid">
	<input type="hidden" value="${starttime2}" id="starttime2"
		name="starttime2">
	<input type="hidden" value="${stoptime2}" id="stoptime2"
		name="stoptime2">
	<input type="hidden" value="${querycreatetype}"
		id="querycreatetype" name="querycreatetype">

	<input type="hidden" value="${starttime1}" id="starttime1"
		name="starttime1">
	<input type="hidden" value="${stoptime1}" id="stoptime1"
		name="stoptime1">
	<input type="hidden" value="${querylslost}"
		id="querylslost" name="querylslost">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListCalldetail.action?search=true" method="post"
		name="ListCalldetail">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						来电号码：
						<input type="text" name="queryani" value="${queryani}"
							maxlength="20" size="15" />
						<!-- 来电号码区域：
						<input type="text" name="queryaniarea" value="${queryaniarea}"
							maxlength="20" size="15"/>
						来电号归属地：
						<input type="text" name="queryanicity" value="${queryanicity}"
							maxlength="20" size="15"/> -->
					</td>
					<td>
						坐席工号：
						<input type="text" name="queryagentid" value="${queryagentid}"
							maxlength="20" size="15" />
					</td>
					<td>
						呼损/留言/转出时间:
						<input name="starttime2" id="starttime2" value="${starttime2}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span>到</span>
						<input name="stoptime2" id="stoptime2" value="${stoptime2}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<td>
						创建类型：
						<select name="querycreatetype">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['CallCreateType']}"
								var="activeState">
								<c:choose>
									<c:when test="${querycreatetype == activeState.code}">
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
						是否呼损：
						<select name="querylslost">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['ISLost']}"
								var="activeState">
								<c:choose>
									<c:when test="${querylslost == activeState.code}">
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
						来电时间 ：
						<input name="starttime1" id="starttime1" value="${starttime1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span>到</span>
						<input name="stoptime1" id="stoptime1" value="${stoptime1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
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
												onclick="getValue(document.forms['ListCalldetail']);">
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
					来电号码
				</th>
				<th width="100">
					坐席工号
				</th>


				<!-- <th width="100">
					来电号码区域
				</th>
				<th width="100">
					来电号码归属地
				</th>
				<th width="100">
					来电受理情况
				</th> -->
				<th width="100">
					来电时间
				</th>
				<!-- <th width="100">
					按键菜单
				</th> -->
				<th width="100">
					创建类型
				</th>
				<th width="100">
					呼损/留言/转出时间
				</th>
				<th width="100">
					是否呼损
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.calldetailList}">
				<tr target="slt_uid" rel="">
					<td>
						${item.ani}
					</td>
					<td>
						${item.agentid}
					</td>

					<!-- <td>
						${item.aniarea}
					</td>
					<td>
						${item.anicity}
					</td>

					<td>
						${item.svrresult}
					</td> -->
					<td>
						${item.callintime}
					</td>
					<!-- <td>
						${item.busitype}
					</td> -->
					<td>
						<c:forEach items="${applicationScope.dictpara['CallCreateType']}"
							var="activeState">
							<c:if test="${item.createtype == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<td>
						${item.leavetime}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['ISLost']}"
							var="activeState">
							<c:if test="${item.islost == activeState.code}">
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
