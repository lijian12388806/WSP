<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listCrmWo.action?tmp_code=${tmp_code}">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="listCrmWo.action?tmp_code=${tmp_code}" method="post"
		name="listCrmWo">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<c:forEach var="it" items="${crmwo_init_query}">
						<c:set var="format" value="${it.defColFormat}" />
						<c:set var="col" value="${it.defCol}" />
						<td>
							<c:if
								test="${it.defColType == 'input' || it.defColType == 'textarea'}">
								${it.defColTitle}：<input name="${col}" type="text" size="15"
									value="" />
							</c:if>
							<c:if test="${it.defColType == 'select'}">
								<select name="${col}" class="combox">
									<option value="">
										${it.defColTitle}
									</option>
									<c:forEach items="${applicationScope.dictpara[format]}"
										var="activeState">
										<c:choose>
											<c:when test="${col == activeState.code}">
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
							<c:if test="${it.defColType == 'date'}">
								${it.defColTitle}：
								<input name="${col}" value=""
									type="text" size="20" class="date" format="${format}" />
								<span>-</span>
								<input name="${col}" value=""
									type="text" size="20" class="date" format="${format}" />
							</c:if>
						</td>
					</c:forEach>
				</tr>
			</table>
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
						var url = "${applicationScope.rootpath}download.action?loadflag=commonexcel&fileName=wo_list.xls"
								+ "&title="
								+ str1
								+ "&sessionname=wo_excel_data";
						$("#wo_excel").attr("href", url);
					});

	//-->
</script>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
<!--			<li>-->
<!--				<a class="add"-->
<!--					href="${applicationScope.rootpath}addCallsWo.action?callmode=inbound&tmp_code=wo_inbound&caller=9113"-->
<!--					rel="addCallsCardNav" target="navTab" reloadFlag=1><span>添加</span>-->
<!--				</a>-->
<!--			</li>-->
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addCallsWo.action?callmode=manual&tmp_code=${tmp_code}&actFrom=add"
					rel="addCallsCardNav" target="navTab" reloadFlag=1><span>添加</span>
				</a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}delCrmWo.action?navTabId=crmwoLiNav"
					class="delete"><span>批量删除</span> </a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}editCrmWo.action?crmWoKey={slt_uid}&tmp_code=${tmp_code}&actFrom=edit"
					rel="workorderCardNav" target="navTab" reloadFlag=1><span>编辑</span>
				</a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}editCrmWo.action?crmWoKey={slt_uid}&tmp_code=${tmp_code}&actFrom=details"
					rel="workorderCardNav" target="navTab" reloadFlag=1><span>查看</span>
				</a>
			</li>
			<!-- <li>
				<a class="icon"
					href="${applicationScope.rootpath}download.action?loadflag=wo&fileName=wo_info.xls&sessionname=allOrderList"
					target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?" id="wo_excel"><span>导出EXCEL</span>
				</a>
			</li> -->
		</ul>
	</div>
	<table class="table" layoutH="139" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="20">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<c:forEach var="item" items="${crmwo_init_list}">
					<th width="100" title="${item.defColTitle}">
						${item.defColTitle}
					</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${crmwo_list}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<c:forEach var="it" items="${crmwo_init_list}">
						<c:choose>
							<c:when test="${it.defColType == 'select'}">
								<td>
									<c:set value="${it.defColFormat}" var="dictt" />
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
