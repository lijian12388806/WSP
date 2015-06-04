<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listCrmCust.action?tmp_code=${tmp_code}">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="listCrmCust.action?tmp_code=${tmp_code}"
		method="post" name="listCrmCust">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<c:forEach var="it" items="${crmCust_init_query}">
						<c:set var="selectParam" value="Cust-${it.defCol}"/>
						<td>
							${it.defColTitle}:
							<c:if test="${it.defColType == 'input'}">
								<input name="query" type="text" size="15"
									value="" />
							</c:if>
							<c:if test="${it.defColType == 'select'}">
								<select name="query">
									<option value="">
										<s:text name="common.listbox" />
									</option>
									<c:forEach items="${applicationScope.dictpara[selectParam]}"
										var="activeState">
										<c:choose>
											<c:when test="${query == activeState.code}">
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
							</c:if>
						</td>
					</c:forEach>
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
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var str1 = getThValueByTable();
						str1 = encodeURI(str1);
						str1 = encodeURI(str1);
						var url = "${applicationScope.rootpath}download.action?loadflag=commonexcel&fileName=Cust_list.xls"
								+ "&title="
								+ str1
								+ "&sessionname=Cust_excel_data";
						$("#Cust_excel").attr("href", url);
					});

	//-->
</script>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addCrmCust.action?tmp_code=${tmp_code}"
					rel="addCallsCardNav" target="navTab" reloadFlag=1><span>添加</span>
				</a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}delCrmCust.action?navTabId=crmCustLiNav"
					class="delete"><span>批量删除</span> </a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}editCrmCust.action?crmCustKey={slt_uid}&tmp_code=${tmp_code}&actFrom=edit"
					rel="CustrkorderCardNav" target="navTab" reloadFlag=1><span>编辑</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}editCrmCust.action?crmCustKey={slt_uid}&tmp_code=${tmp_code}&actFrom=details"
					rel="CustrkorderCardNav" target="navTab" reloadFlag=1><span>查看</span>
				</a>
			</li>
			<!-- <li>
				<a class="icon"
					href="${applicationScope.rootpath}download.action?loadflag=Cust&fileName=Cust_info.xls&sessionname=allOrderList"
					target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?" id="Cust_excel"><span>导出EXCEL</span>
				</a>
			</li> -->
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="20">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<c:forEach var="item" items="${crmCust_init_list}">
					<th width="100" title="${item.defColTitle}">
						${item.defColTitle}
					</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${crmCust_list}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<c:forEach var="it" items="${crmCust_init_list}">
					<c:choose>
						<c:when test="${it.defColType == 'select'}">
						<td>
							<c:set value="${it.defColFormat}" var="dictt"/>
							<c:forEach items="${applicationScope.dictpara[dictt]}"
							var="activeState">
							<c:if test="${item[it.defCol] == activeState.code}">
							${activeState.title}
							</c:if>
						</c:forEach>
						</td>
						</c:when>
						<c:otherwise>
							<td>
							${item[it.defCol]}
							</td>
						</c:otherwise>
					</c:choose>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>
</div>
