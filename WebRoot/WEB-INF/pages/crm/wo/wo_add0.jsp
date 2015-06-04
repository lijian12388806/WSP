<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
<!--
$(document).ready(function() {
	_pageDown();
	});
	function _pageDown() {
		var callinno = '${workOrderForm.callerno}';
		var ucid = '${wo_ucid}';
		var $box = $("#jbsxBox_order_"+ucid);
		var ordercode = '${orderCode}';
		var ordersrc = '${ordersource}';
		var url;
		if(ordersrc != 'manual'){
			if(ordercode == 'wcl') url = "${applicationScope.rootpath}listworkoder_his.action?pageNum=1&numPerPage=20&his_N=${his_N}&querycallerno="+callinno+"&wo_ucid="+ucid;
			else url = "${applicationScope.rootpath}listOrderdealinfo.action?workOrderKey=${workOrderKey}&wo_ucid="+ucid;
			$box.loadUrl(url,null,function(){
				$box.find("[layoutH]").layoutH();
			});
		}
	}
//-->
</script>
<div class="pageContent" layoutH="255">
	<form method="post"
		action="${applicationScope.rootpath}saveCrmWo.action?navTabId=crmwoLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input name="crmWoKey" type="hidden" value="${crmWoKey}" />
		<div class="lcp_div_left_100">
			<table class="list" nowrapTD="false" width="98%"
				style="table-layout: fixed;">
				<c:forEach var="item" items="${crmwo_init_add}">
					<c:set value="${item.defCol}" var="col" />
					<c:if test="${item.defColType == 'input'}">
						<p>
							<label>
								${item.defColTitle}:
							</label>
							<input name="crmWoForm.${col}" id="crmWoForm.${col}" class=""
								maxlength="20" type="text" size="30" value="${crmWoForm[col]}" />
						</p>
					</c:if>
					<c:if test="${item.defColType == 'select'}">
						<p>
							<label>
								${item.defColTitle}:
							</label>
							<select name="crmWoForm.${col}" class="combox">
								<c:forEach items="${applicationScope.dictpara['Gender']}"
									var="activeState">
									<c:choose>
										<c:when test="${crmWoForm[col] == activeState.code}">
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
						</p>
					</c:if>
					<c:if test="${item.defColType == 'textarea'}">
						<dl class="nowrap">
							<dt>
								${item.defColTitle}:
							</dt>
							<dd>
								<textarea name="crmWoForm.${col}" class="" id="crmWoForm.${col}"
									cols="80" rows="2" maxlength="500">${crmWoForm[col]}</textarea>
							</dd>
						</dl>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</form>
</div>
<div class="formBar">
	<ul>
		<c:set var="btns" value="${wo_btns}"/>
		<c:forEach items="${applicationScope.dictpara['WO_BUTTON']}"
			var="activeState">
			<c:set var="btn_code" value="${activeState.code}"/>
			<c:if test="${fn:contains(btns,btn_code)}">
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="button" onclick="">
								${activeState.title}
							</button>
						</div>
					</div>
				</li>
			</c:if>
		</c:forEach>
		<li>
			<div class="button">
				<div class="buttonContent">
					<button type="button" class="close">
						关闭
					</button>
				</div>
			</div>
		</li>
	</ul>
</div>
<div id="jbsxBox_order_${wo_ucid}" class="unitBox"></div>