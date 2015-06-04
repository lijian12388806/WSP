<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListLogmsg">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />

<!-- 查询条件 -->
	<input type="hidden" value="${queryusername}" id="queryusername"
		name="queryusername">
	<input type="hidden" value="${querylogtype}" id="querylogtype"
		name="querylogtype">
	<input type="hidden" value="${queryip}" id="queryip"
		name="queryip">
	<input type="hidden" value="${starttime}" id="starttime"
		name="starttime">
	<input type="hidden" value="${stoptime}"
		id="stoptime" name="stoptime">
</form>
<script type="text/javascript">
			function showcontent(entityName,entityPk,i){
				var id=entityName+entityPk;
				if(i==1){
					document.getElementById(id).style.display="block";
					return false;
				}else{
					document.getElementById(id).style.display="none";
					return false;
				}
			}
		</script>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListLogmsg.action?search=true" method="post" name="ListLogmsg">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						<s:text name="syslog.username" />
						：
						<input name="queryusername" type="text" id="queryusername"
							size="15" style="WIDTH: 94px" value="${queryusername}"
							onkeydown="" />
					</td>
					<td>
						<s:text name="syslog.logtype" />
						：
						<select name="querylogtype">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['LOGTYPE']}"
								var="activeState">
								<c:choose>
									<c:when test="${querylogtype == activeState.code}">
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
						<s:text name="syslog.ip" />
						：
						<input name="queryip" type="text" id="queryip" size="20"
							style="WIDTH: 94px" value="${queryip}" onkeydown="" />
					</td>
					<td>
						<s:text name="syslog.starttime" />
						：
						<input name="starttime" id="starttime" value="${starttime}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span><s:text name="syslog.dao" /> </span>
						<input name="stoptime" id="stoptime" value="${stoptime}"
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
												onclick="getValue(document.forms['ListLogmsg']);">
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
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteLogmsg?navTabId=logmsgLiNav"
					class="delete"><span><s:text name="common.batchdel" />
				</span> </a>
			</li>
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
				<th width="50">
					<s:text name="syslog.username" />
				</th>
				<th width="50">
					<s:text name="syslog.logtype" />
				</th>
				<th width="100">
					<s:text name="syslog.ip" />
				</th>
				<th width="100">
					<s:text name="syslog.starttime" />
				</th>
				<th width="50">
					<s:text name="syslog.entityname" />
				</th>
				<th width="300">
					<s:text name="syslog.logcontext" />
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.logmsgList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.username}
					</td>
					<td>
						<c:forEach items="${applicationScope.dictpara['LOGTYPE']}"
							var="activeState">
							<c:if test="${item.logtype == activeState.code}">
									${activeState.title}</c:if>
						</c:forEach>
					</td>
					<td>
						${item.ip}
					</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.createtime}" />
					</td>
					<td>
						${item.entityname}
					</td>
					<td>
						<c:set var="str" value="${item.logcontent}" />
						<c:choose>
							<c:when test="${fn:length(str) > 100}">
							内容太长，请点<a href="#"
									onclick="showcontent('content','${item.id}',1);return false;" style="color:blue">[查看]</a>
								<div id="content${item.id}" style="display: none;">
									<span><a href="#"
										onclick="showcontent('content','${item.id}');return false;" style="color:blue">[关闭]</a>
									</span>${item.logcontent}
								</div>
							</c:when>
							<c:otherwise>														
									${item.logcontent}												
							</c:otherwise>
						</c:choose>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
