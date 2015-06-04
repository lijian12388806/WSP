<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post">
	action="${applicationScope.rootpath}listCrmWo.action?tmp_code=${tmp_code}&his_wo=${his_wo}&caller=${caller}&callucid=${callucid}>
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<div class="pageHeader">
	<form onsubmit="return dwzSearch(this, 'dialog');"
		action="listCrmWo.action?tmp_code=${tmp_code}&his_wo=${his_wo}&caller=${caller}&callucid=${callucid}"
		method="post" name="listCrmWo">
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
<div class="pageContent">
	<table class="table" layoutH="98" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
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
					<c:forEach var="it" items="${crmwo_init_list}">
						<td>
							${item[it.defCol]}
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/pages/common/dialogBar.jsp"></c:import>
</div>
