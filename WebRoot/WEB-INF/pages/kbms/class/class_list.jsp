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
	function kbmsklp_list(c){
		var $box = $("#jbsxBox");
		var url = "${applicationScope.rootpath}listKbmsKlp.action?pageNum=1&numPerPage=20&kbmsClassKey="+c;
		$box.loadUrl(url, null, function() {
			$box.find("[layoutH]").layoutH();
		});
	}
	function operateTree(k, o) {
		var listKbmsClass = $('#listKbmsClass');
		if (o == 'add')
			$.pdialog.open("addKbmsClass.action?kbmsClassKey=" + k
					+ "&operate=" + o, "addKbmsClassCardNav", "添加子类别", {
				mask : true,
				resizable : true,
				drawable : true,
				maxable : true,
				minable : true,
				fresh : true
			});
		else if (o == 'edit')
			$.pdialog.open("editKbmsClass.action?kbmsClassKey=" + k
					+ "&operate=" + o, "addKbmsClassCardNav", "修改子类别", {
				mask : true,
				resizable : true,
				drawable : true,
				maxable : true,
				minable : true,
				fresh : true
			});
		else if (o == 'del')
			alertMsg.confirm("确定要删除该知识分类吗?", {
				okCall : function() {
					$.post("delKbmsClass.action?selectIDS=" + k, "",
							DWZ.ajaxDone, "json");
					navTab.reloadFlag('kbmsclassLiNav');
				},
				cancelCall : function() {
				}
			});
		else if (o == 'addk')
			$.pdialog.open("addKbmsClass.action?kbmsClassKey=" + k
					+ "&operate=" + o, "addKbmsClassCardNav", "添加知识", {
				mask : true,
				resizable : true,
				drawable : true,
				maxable : true,
				minable : true,
				fresh : true
			});
		else
			alert("操作错误!");
	}
	//-->
</script>
<div class="lcp_div_left" style="width: 100%;">
	<div class="lcp_div_left" style="margin-top: 10px; width: 45%;">
		<div layoutH="38">
			<div style="margin-left: 20px; margin-top: 10px;">
				<ul>
					<li>
						<a class="btn btn-mini"
							href="${applicationScope.rootpath}addKbmsClass.action"
							rel="addKbmsClassCardNav" target="dialog" reloadFlag=1
							mask="true"><span><i class="icon-plus"></i> 添加类别</span> </a>
					</li>
				</ul>
			</div>
			<table class="list" nowrapTD="false" width="98%"
				style="table-layout: fixed">
				<tbody>
					<c:forEach var="item" items="${KbmsClass_list}">
						<div style="margin-top: 10px;">
							<tr target="slt_uid" rel="${item.id}">
								<c:set var="kid" value="${item.id}" />
								${KbmsClass_map[kid]}
							</tr>
							<div class="divider"></div>
						</div>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>
	</div>
	<div class="lcp_div_right" style="margin-top: 10px; width: 54%;"
		id="jbsxBox">

	</div>
</div>
