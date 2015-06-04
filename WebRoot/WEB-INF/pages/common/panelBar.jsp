<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<div class="panelBar">
	<div class="pages">
		<!-- <span>显示:</span> -->
		<span><s:text name="common.perpage"/></span>
		<select name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<c:forEach begin="10" end="40" step="10" varStatus="s">
				<option value="${s.index}" ${numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
		<!-- <span>条，共: ${totalCount}条</span> -->
		<span><s:text name="common.tiao"/>，<s:text name="common.total"/>: ${totalCount}<s:text name="common.tiao"/></span>
	</div>
	
	<div class="pagination" targetType="navTab" totalCount="${totalCount}" numPerPage="${numPerPage}" pageNumShown="10" currentPage="${param.pageNum}"></div>
</div>