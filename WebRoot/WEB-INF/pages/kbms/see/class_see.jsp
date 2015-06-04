<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listKbmsClass.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<script type="text/javascript">
	$(function() {
		kbmsklp_list('${kbmsClassKey}');
	});
	//知识点 list
	function kbmsklp_list(c) {
		var $box = $("#jbsxBox_klp");
		var url = "${applicationScope.rootpath}listKbmsKlpSee.action?pageNum=1&numPerPage=20&kbmsClassKey="
				+ c;
		$box.loadUrl(url, null, function() {
			$box.find("[layoutH]").layoutH();
		});
	}
	//-->
</script>
<div class="lcp_div_left" style="width: 100%;" layoutH="2">
	<div class="lcp_div_left" style="margin-top: 10px; width: 30%;">
		<table class="list" nowrapTD="false" width="98%"
			style="table-layout: fixed;">
			<tbody>
				<c:forEach var="item" items="${KbmsClass_list}">
					<tr target="slt_uid" rel="${item.id}">
						<c:set var="kid" value="${item.id}" />
						${KbmsClass_map[kid]}
					</tr>
					<div class="divider"></div>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="lcp_div_right" style="margin-top: 10px; width: 69%;"
		id="jbsxBox_klp">
		
	</div>
</div>