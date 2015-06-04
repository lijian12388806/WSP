<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListJobmsg.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
<!-- 查询条件 -->
	<input type="hidden" value="${queryjobname}" id="queryjobname"
		name="queryjobname">
	<input type="hidden" value="${queryjobstate}" id="queryjobstate"
		name="queryjobstate">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListJobmsg.action?search=true" method="post" name="ListJobmsg">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						任务名称
						:
						<input name="queryjobname" type="text" id="queryjobname"
							size="15" style="WIDTH: 94px" value="${queryjobname}"
							onkeydown="" />
					</td>
					<td>
						状态
						：
						<select name="queryjobstate">
							<option value="">
								<s:text name="common.listbox"/>
							</option>
							<c:forEach items="${applicationScope.syspara['jobStatusPara']}"
								var="activeState">
								<c:choose>
									<c:when test="${queryjobstate == activeState.code}">
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
											<button type="button" onclick="getValue(document.forms['ListJobmsg']);">
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
				<a class="add" href="${applicationScope.rootpath}addJobmsg.action"
					rel="adduserinfoCardNav" target="dialog" reloadFlag=1 mask="true" width="610" height="579"><span>添加
				</span> </a>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo" rel="selectIDS"
					postType="string"
					href="${applicationScope.rootpath}deleteJobmsg.action?navTabId=jobmsgLiNav"
					class="delete"><span>批量删除</span> </a>
				<a class="add" href="${applicationScope.rootpath}rule.action"
					rel="adduserinfoCardNav" target="navTab" reloadFlag=1 mask="true" width="610" height="579"><span>规则
				</span> </a>
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		asc="asc" desc="desc" style="table-layout: fixed">
		<thead>
			<tr>
				<th width="1%">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="150">
					任务名称
				</th>
				<th width="30" orderField="Extension">
					任务状态
				</th>
				<th width="100">
					创建时间
				</th>
				<th width="100">
					执行时间
				</th>
				<th width="150">
					备注
				</th>
				<th width="15">
					删除
				</th>
				<th width="15">
					编辑
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.userinfoList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.jobName}
					</td>
					<td>
						<c:forEach items="${applicationScope.syspara['jobStatusPara']}"
							var="activeState">
							<c:if test="${item.jobState == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<td>
						${item.createTime}
					</td>
					<td>
						${item.cronExpression}
					</td>
					<td>
						${item.remark}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteJobmsg.action?selectIDS=${item.id}&navTabId=jobmsgLiNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>" ><span><s:text
									name="common.delete" />
						</span> </a>
						</td><td>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editJobmsg.action?jobmsgKey=${item.id}"
							target="dialog" rel="jobmsgCardNav" reloadFlag=1 width="610" height="579"
							title="<s:text name="userinfo.edituser"/>"><span><s:text
									name="userinfo.edituser" />
						</span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
