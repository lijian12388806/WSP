<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	onsubmit="return divSearch(this,'jbsxBox_klp');"
	action="${applicationScope.rootpath}listKbmsKlpSee.action?query=true">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
	<!-- 查询条件 -->
	<input name="queryname" value="${queryname}" type="hidden" />
</form>
<form onsubmit="return divSearch(this,'jbsxBox_klp');"
	action="listKbmsKlpSee.action?query=true" method="post"
	name="listKbmsKlpSee">
	<div class="searchBar" align="center">
		<input name="queryname" type="text" id="queryname" size="20"
			value="${queryname}" />
		<button type="submit" class="btn btn-mini">
			检索
		</button>
	</div>
</form>
<div class="divider"></div>
<div class="pageContent"
	<c:if test="${not empty KbmsKlp_list}">style="background-color: #eee; width: 98%"</c:if>
	layoutH="75">
	<c:forEach var="item" items="${KbmsKlp_list}">
		<div style="margin-left:30px;margin-top: 20px;">
			<c:if test="${query != 'true'}">
				<h1
					style="font-family: Arial, sans-serif; font-size: 24px; padding: 4px;">
					${item.name}
				</h1>
			</c:if>
			<c:if test="${query == 'true'}">
				<h1
					style="font-family: Arial, sans-serif; font-size: 36px; padding: 4px;color:#222">
					${item.name}
				</h1>
			</c:if>
		</div>
		<div style="margin-left:30px;margin-top: 20px;">
			<c:if test="${query != 'true'}">
				${item.content}
			</c:if>
			<c:if test="${query == 'true'}">
				<c:set var="s1" value="${item.content}" />
				<c:if test="${fn:length(item.content)>200}">
					<a
						href="${applicationScope.rootpath}listKbmsKlpSee.action?kbmsKlpKey=${item.id}&query=false"
						target="ajax" rel="jbsxBox_klp" title=""><span style="color: #2f556d;">详情 ... ...</span></a>
				</c:if>
				<c:if test="${fn:length(item.content)<=200}">${s1}</c:if>
			</c:if>
		</div>
	</c:forEach>
</div>
<c:if test="${not empty KbmsKlp_list&&query == 'true'}">
	<div class="panelBar">
		<div class="pages">
			<span><s:text name="common.perpage" /> </span>
			<select name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox_klp')"
				class="combox">
				<c:forEach begin="10" end="40" step="10" varStatus="s">
					<option value="${s.index}" ${numPerPage eq
						s.index ? 'selected="selected"' : ''}>
						${s.index}
					</option>
				</c:forEach>
			</select>
			<span><s:text name="common.tiao" />，<s:text
					name="common.total" />: ${totalCount}<s:text name="common.tiao" />
			</span>
		</div>
		<div class="pagination" targetType="navTab" rel="jbsxBox_klp"
			totalCount="${totalCount}" numPerPage="${numPerPage}"
			pageNumShown="10" currentPage="${param.pageNum}"></div>
	</div>
</c:if>