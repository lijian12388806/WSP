<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageContent">
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>菜单列表</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
				${menutree}
				<div id="jbsxBox" class="unitBox" style="margin-left:156px;">
					<jsp:include page="queryMenuinfoPage.jsp"></jsp:include>
				</div>
	
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
</div>
