<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListUserinfo">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
<!-- 查询条件 -->
	<input type="hidden" value="${queryusername}" id="queryusername"
		name="queryusername">
	<input type="hidden" value="${queryextno}" id="queryextno"
		name="queryextno">
	<input type="hidden" value="${queryagentname}" id="queryagentname"
		name="queryagentname">
	<input type="hidden" value="${queryfactory}" id="queryfactory"
		name="queryfactory">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListUserinfo.action?search=true" method="post"
		name="ListUserinfo">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						坐席账号:
						<input name="queryusername" type="text" id="queryusername"
							size="15" style="WIDTH: 94px" value="${queryusername}"
							onkeydown="" />
					</td>
					<td>
						坐席分机号:
						<input name="queryextno" type="text" id="queryextno" size="15"
							style="WIDTH: 94px" value="${queryextno}" onkeydown="" />
					</td>
					<td>
						坐席员姓名:
						<input name="queryagentname" type="text" id="queryagentname"
							size="15" style="WIDTH: 94px" value="${queryagentname}"
							onkeydown="" />
					</td>
					<td>
						工厂名称:
						<input name="queryfactory" type="text" id="queryfactory" size="15"
							style="WIDTH: 94px" value="${queryfactory}" onkeydown="" />
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
												onclick="getValue(document.forms['ListUserinfo']);">
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
				<a class="add" href="${applicationScope.rootpath}addUserinfo.action"
					rel="adduserinfoCardNav" target="navTab" reloadFlag=1><span><s:text
							name="userinfo.add" /> </span> </a>
			</li>

			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteUserinfo.action?navTabId=userinfoLiNav"
					class="delete"><span><s:text name="userinfo.delete" />
				</span> </a>
			</li>
			<li class="line">
				line
			</li>
			<li class="line">
				line
			</li>
			<li>
				<a class="add" href="${applicationScope.rootpath}exceldialog.action"
					rel="excelCardNav" target="dialog" reloadFlag=1><span><s:text
							name="userinfo.import" /> </span> </a>
			</li>

			<li>
				<a class="add"
					href="${applicationScope.rootpath}download.action?fileName=UserinfoTemplate.xlsx&loadflag=excel"
					target="_black"><span><s:text name="userinfo.download" />
				</span> </a>
			</li>
			<li class="line">
				line
			</li>
			<li class="line">
				line
			</li>
			<span style="width: 55%"></span>

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%" >
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					坐席员姓名
				</th>

				<th width="100">
					坐席分机号
				</th>
				<th width="100">
					坐席账号
				</th>
				<th width="100">
					坐席类型
				</th>
				<!-- <th width="100">
					是否值班
				</th> -->
				<th width="100">
					电话
				</th>
				<th width="100">
					电子邮箱
				</th>
				<th width="100">
					CTI登录号
				</th>
				<th width="100">
					用户状态
				</th>
				<th width="100">
					最近登录时间
				</th>
				<th width="100">
					授权方式
				</th>
				<th width="150">
					操作
				</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.userinfoList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<c:if test="${sessionScope.userinfo.isadmin == 'true' and item.userstatus == 'Y'}">
							<input name="selectIDS" value="${item.id}" type="checkbox">
						</c:if>
					</td>
					<td>
						${item.agentname}
					</td>
					<td>
						${item.extno}
					</td>
					<td>
						${item.username}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['AgentType']}"
							var="activeState">
							<c:if test="${item.agenttype == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<!-- <td>
						<c:forEach items="${applicationScope.syspara['yesornotPara']}"
							var="activeState">
							<c:if test="${item.temp3 == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td> -->
					<td>
						${item.phoneno}
					</td>
					<td>
						${item.agentemail}
					</td>
					<td>
						${item.agentno}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['UserStatus']}"
							var="activeState">
							<c:if test="${item.userstatus == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>
					<td>
						${item.lastlogintime}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['AuthorizeType']}"
							var="activeState">
							<c:if test="${item.authtype == activeState.code}">
							${activeState.title}
						</c:if>
						</c:forEach>
					</td>

					<td>
						<c:if test="${sessionScope.userinfo.isadmin == 'true' and item.userstatus == 'Y'}">
							<a class="btnDel"
								href="${applicationScope.rootpath}deleteUserinfo.action?selectIDS=${item.id}&navTabId=userinfoLiNav"
								target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
										name="common.delete" /> </span> </a>
						</c:if>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editUserinfo.action?userinfoKey=${item.id}"
							target="navTab" rel="userinfoCardNav" reloadFlag=1
							title="<s:text name="userinfo.edituser"/>"><span><s:text
									name="userinfo.edituser" /> </span> </a>
						<c:if test="${sessionScope.userinfo.isadmin == 'true'}">
							<a class="btnAssign"
								href="${applicationScope.rootpath}dispatchRole.action?userinfoKey=${item.id}"
								target="dialog" rel="dispatchCardNav" reloadFlag=1 mask="true"
								title="<s:text name="role.dispatch"/>"><span><s:text
										name="role.dispatch" /> </span> </a>
							<!--<c:if test="${item.temp3 == 'false' || empty item.temp3}">
							<a class="btnSelect"
								href="${applicationScope.rootpath}onduty.action?userinfoKey=${item.id}&navTabId=userinfoLiNav"
								target="ajaxTodo"
								title="是否安排值班?">值班 </a>
								</c:if>-->
						</c:if>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
