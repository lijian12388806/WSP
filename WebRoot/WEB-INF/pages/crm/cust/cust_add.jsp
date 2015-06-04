<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		var actFrom = '${actFrom}';
		if(actFrom == 'details'){
			_disableOcx();
		}
		});
//disable 元素
function _disableOcx(){
	$('#custadd input').each(function(){
			$(this).attr('disabled','disabled');
		});
	$('#custadd textarea').each(function(){
		$(this).attr('disabled','disabled');
	});
	$('#custadd select').each(function(){
		$(this).removeClass('combox');
		$(this).attr('disabled','disabled');
	});
	$('#custadd .inputDateButton').each(function(){
		$(this).remove();
		//$(this).removeAttr('onclick');
	});
} 
//保存
function btnSubmit(){ 
	var wa = $('#CustAction');
	var act = "${applicationScope.rootpath}saveCrmCust.action?navTabId=crmCustLiNav&callbackType=closeCurrent"
	wa.attr('action',act);
	wa.submit(); 
}
//历史工单
function cust_pageHis() {
		var caller = $('#wosPhone').val();
		var his_wo = $('#his_days').val();
		var tmp_code = '${cust_wo_related}';
		$.pdialog.open("${applicationScope.rootpath}listCrmWo.action?pageNum=1&numPerPage=20&his_wo="+his_wo+"&tmp_code="+tmp_code+"&caller="+caller,
				"WoHisCardNav", "历史工单", {
					height :450,
					width :900,
					mask:true,
					resizable :true,
					drawable :true,
					maxable :true,
					minable :true,
					fresh :true
				});
	}
//-->
</script>
<div class="pageContent" id="custadd">
	<form method="post" action="" class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);"
		id="CustAction">
		<input name="crmCustKey" type="hidden" value="${crmCustKey}" />
		<div class="pageFormContent" layoutH="56">
			<c:forEach items="${applicationScope.dictpara['MGR_WO_REGION']}"
				var="region">
				<fieldset>
					<!-- <legend>${region.title}</legend> -->
					<c:forEach var="item" items="${crmCust_init_add}">
						<c:if test="${region.code == item.defColRegion}">
							<c:set value="${item.defCol}" var="col" />
							<c:set value="${item.defColFormat}" var="format" />
							<!-- 文本框 -->
							<c:if test="${item.defColType == 'input'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<input name="crmCustForm.${col}" id="${col}"
										class="${item.defColRequired} ${item.defColClass}"
										minlength="${item.defColLmin}" maxlength="${item.defColLmax}"
										type="text" size="30" value="${crmCustForm[col]}"
										<c:if test="${item.defCanedit != 'Y'}">readonly="readonly"</c:if> />
								</p>
							</c:if>
							<!-- 下拉框 -->
							<c:if test="${item.defColType == 'select'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<select name="crmCustForm.${col}"
										class="${item.defColRequired} combox">
										<option value="">
											<s:text name="common.listbox" />
										</option>
										<c:forEach items="${applicationScope.dictpara[format]}"
											var="activeState">
											<c:choose>
												<c:when test="${crmCustForm[col] == activeState.code}">
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
							<!-- 文本域 -->
							<c:if test="${item.defColType == 'textarea'}">
								<dl class="nowrap">
									<dt>
										${item.defColTitle}:
									</dt>
									<dd>
										<textarea name="crmCustForm.${col}"
											class="${item.defColRequired} ${item.defColClass}"
											id="${col}" cols="80" rows="2"
											minlength="${item.defColLmin}" maxlength="${item.defColLmax}"
											<c:if test="${item.defCanedit != 'Y'}">readonly="readonly"</c:if>>${crmCustForm[col]}</textarea>
									</dd>
								</dl>
							</c:if>
							<!-- 时间控件 -->
							<c:if test="${item.defColType == 'date'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<input name="crmCustForm.${col}" id="${col}"
										class="${item.defColRequired} date" type="text" size="30"
										value="${crmCustForm[col]}" format="${item.defColFormat}"
										<c:if test="${item.defCanedit != 'Y'}">readonly="readonly"</c:if> />
									<a class="inputDateButton" href="javascript:;">选择</a>
								</p>
							</c:if>
							<!-- 隐藏域 -->
							<c:if test="${item.defColType == 'hidden'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<input name="crmCustForm.${col}" id="${col}"
										type="hidden" size="30" value="${crmCustForm[col]}" />
								</p>
							</c:if>
							<!-- 多选-->
							<c:if test="${item.defColType == 'checkbox'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<c:set value="${crmCustForm[col]}" var="formvalue" />
									<c:forEach items="${applicationScope.dictpara[format]}"
										var="activeState">
										<input name="crmCustForm.${col}" value="${activeState.code}"
											type="checkbox"
											<c:if test="${fn:contains(formvalue,activeState.code)}">checked="checked"</c:if>
											<c:if test="${item.defCanedit != 'Y'}">onclick="return false"</c:if> />${activeState.title}
									</c:forEach>
								</p>
							</c:if>
							<!-- 单选 -->
							<c:if test="${item.defColType == 'radio'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<c:set value="${crmCustForm[col]}" var="formvalue" />
									<c:forEach items="${applicationScope.dictpara[format]}"
										var="activeState">
										<input name="crmCustForm.${col}" value="${activeState.code}"
											type="radio"
											<c:if test="${fn:contains(formvalue,activeState.code)}">checked="checked"</c:if>
											<c:if test="${item.defCanedit != 'Y'}">onclick="return false"</c:if> />${activeState.title}
									</c:forEach>
								</p>
							</c:if>
						</c:if>
					</c:forEach>
				</fieldset>
			</c:forEach>
		</div>
	</form>
</div>
<div class="formBar">
	<ul>
		<li>
			<button class="btn btn-mini btn-primary " type="button"
				onclick="cust_pageHis();">
				<i class="icon-star"></i><SPAN class="yahei">历史工单:最近</SPAN>
				<input type="text" id="his_days" size="2" value="7" class="required" />
				天
			</button>
		</li>
		<c:if test="${actFrom != 'details'}">
			<li>
				<button class="btn btn-mini btn-success" type="button"
					onclick="btnSubmit()">
					<i class="icon-ok-sign"></i><SPAN class="yahei"><s:text
							name="保存" /> </SPAN>
				</button>
			</li>
		</c:if>
		<li>
			<button class="btn btn-mini btn-danger close" type="button">
				<i class="icon-remove-sign"></i><SPAN class="yahei">关闭</SPAN>
			</button>
		</li>
	</ul>
</div>