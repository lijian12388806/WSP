<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
<!--
	function _pageHis() {
		var caller = '${crmWoForm.wosCaller}';
		var ucid = '${crmWoForm.wosCallucid}';
		var callmode = '${crmWoForm.wosCallmode}';
		var tmp_code = '${tmp_code}';
		var his_wo = $('#his_days').val();
		$.pdialog.open("${applicationScope.rootpath}listCrmWo.action?pageNum=1&numPerPage=20&his_wo="+his_wo+"&caller="+caller+"&callucid="+ucid+"&tmp_code="+tmp_code,
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

	$(document).ready(function() {
		var actFrom = '${actFrom}';
		if(actFrom == 'details'){
			_disableOcx();
		}
		});
//disable 元素
function _disableOcx(){
	$('#woadd input').each(function(){
			$(this).attr('disabled','disabled');
		});
	$('#woadd textarea').each(function(){
		$(this).attr('disabled','disabled');
	});
	$('#woadd select').each(function(){
		$(this).removeClass('combox');
		$(this).attr('disabled','disabled');
	});
	$('#woadd .inputDateButton').each(function(){
		$(this).remove();
		//$(this).removeAttr('onclick');
	});
} 
//工单提交
function btnSubmit(v){ 
	var wa = $('#woAction');
	var status = '${crmWoForm.wosStatus}';
	if(v == 'final_save') v = status;
	var act = "${applicationScope.rootpath}saveCrmWo.action?navTabId=crmwoLiNav&callbackType=closeCurrent&crmWoForm.wosStatus="+v
	wa.attr('action',act);
	wa.submit(); 
}
//-->
</script>
<div class="pageContent" id="woadd">
	<form method="post" action="" class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);"
		id="woAction">
		<input name="crmWoKey" type="hidden" value="${crmWoKey}" />
		<div class="pageFormContent" layoutH="56">
			<c:forEach items="${applicationScope.dictpara['MGR_WO_REGION']}"
				var="region">
				<fieldset>
					<!-- <legend>${region.title}</legend> -->
					<c:forEach var="item" items="${crmwo_init_add}">
						<c:if test="${region.code == item.defColRegion}">
							<c:set value="${item.defCol}" var="col" />
							<c:set value="${item.defColFormat}" var="format" />
							<!-- 文本框 -->
							<c:if test="${item.defColType == 'input'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<input name="crmWoForm.${col}" id="crmWoForm.${col}"
										class="${item.defColRequired} ${item.defColClass}"
										minlength="${item.defColLmin}" maxlength="${item.defColLmax}"
										type="text" size="30" value="${crmWoForm[col]}"
										<c:if test="${item.defCanedit != 'Y'}">readonly="readonly"</c:if> />
								</p>
							</c:if>
							<!-- 下拉框 -->
							<c:if test="${item.defColType == 'select'}">
								<c:choose>
									<c:when test="${col == 'wosPkcust'}">
										<p>
											<label>
												${item.defColTitle}:
											</label>
											<c:forEach items="${wo_cust_list}" var="act">
												<input name="crmWoForm.${col}" value="${act.id}"
													type="radio" class="${item.defColRequired}"
													<c:if test="${crmWoForm[col] == act.id}">checked="checked"</c:if> />
												<a href="${applicationScope.rootpath}editCrmCust.action?crmCustKey=${act.id}&tmp_code=${wo_cust_related}&actFrom=details"
													 rel="custDetailsCardNav" target="dialog"
													reloadFlag=1 title="客户信息详情"><span style="color: blue;">${act.wosName}</span>
												</a>
											</c:forEach>
										</p>
									</c:when>
									<c:otherwise>
										<p>
											<label>
												${item.defColTitle}:
											</label>
											<select name="crmWoForm.${col}"
												class="${item.defColRequired} combox">
												<option value="">
													<s:text name="common.listbox" />
												</option>
												<c:forEach items="${applicationScope.dictpara[format]}"
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
									</c:otherwise>
								</c:choose>
							</c:if>
							<!-- 文本域 -->
							<c:if test="${item.defColType == 'textarea'}">
								<dl class="nowrap">
									<dt>
										${item.defColTitle}:
									</dt>
									<dd>
										<textarea name="crmWoForm.${col}"
											class="${item.defColRequired} ${item.defColClass}"
											id="crmWoForm.${col}" cols="80" rows="2"
											minlength="${item.defColLmin}" maxlength="${item.defColLmax}"
											<c:if test="${item.defCanedit != 'Y'}">readonly="readonly"</c:if>>${crmWoForm[col]}</textarea>
									</dd>
								</dl>
							</c:if>
							<!-- 时间控件 -->
							<c:if test="${item.defColType == 'date'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<input name="crmWoForm.${col}" id="crmWoForm.${col}"
										class="${item.defColRequired} date" type="text" size="30"
										value="${crmWoForm[col]}" format="${item.defColFormat}"
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
									<input name="crmWoForm.${col}" id="crmWoForm.${col}"
										type="hidden" size="30" value="${crmWoForm[col]}" />
								</p>
							</c:if>
							<!-- 多选-->
							<c:if test="${item.defColType == 'checkbox'}">
								<p>
									<label>
										${item.defColTitle}:
									</label>
									<c:set value="${crmWoForm[col]}" var="formvalue" />
									<c:forEach items="${applicationScope.dictpara[format]}"
										var="activeState">
										<input name="crmWoForm.${col}" value="${activeState.code}"
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
									<c:set value="${crmWoForm[col]}" var="formvalue" />
									<c:forEach items="${applicationScope.dictpara[format]}"
										var="activeState">
										<input name="crmWoForm.${col}" value="${activeState.code}"
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
		<c:if test="${not empty his_wo}">
			<li>
				<button class="btn btn-mini btn-primary " type="button"
					onclick="_pageHis();">
					<i class="icon-star"></i><SPAN class="yahei">历史工单:最近</SPAN>
					<input type="text" id="his_days" size="2" value="${his_wo}"
						class="required" />
					天
				</button>
			</li>
		</c:if>
		<c:if test="${actFrom != 'details'}">
			<li>
				<button class="btn btn-mini btn-success" type="button"
					onclick="btnSubmit('final_save')">
					<i class="icon-ok-sign"></i><SPAN class="yahei"><s:text
							name="保存" /> </SPAN>
				</button>
			</li>
			<c:set var="btns" value="${wo_btns}" />
			<c:forEach items="${applicationScope.dictpara['WO_BUTTON']}"
				var="activeState">
				<c:set var="btn_code" value="${activeState.code}" />
				<c:if test="${fn:contains(btns,btn_code)}">
					<li>
						<button class="btn btn-mini btn-success" type="button"
							onclick="btnSubmit('${activeState.code}')">
							<i class="icon-ok-sign"></i><SPAN class="yahei">${activeState.title}</SPAN>
					</li>
				</c:if>
			</c:forEach>
		</c:if>
		<li>
			<button class="btn btn-mini btn-danger close" type="button">
				<i class="icon-remove-sign"></i><SPAN class="yahei">关闭</SPAN>
			</button>
		</li>
	</ul>
</div>