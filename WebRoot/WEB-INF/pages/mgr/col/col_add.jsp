<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
	$(function() {
		var displayf = '${mgrWoDefineForm.defColType}';
		var displaynum = $('#defColFormat');
		if (displayf == 'select' || displayf == 'date'
				|| displayf == 'checkbox' || displayf == 'radio') {
			displaynum.css('display', '');
			displaynum.addClass("required");
			//if(displayf == 'date') displaynum.attr('alt','yyyy-MM-dd');
			//else if(displayf == 'select') displaynum.attr('alt','initParam');
		} else {
			displaynum.css('display', 'none');
		}
		$("#defColType").bind(
				'change',
				function() {
					var v = $(this).val();
					if (v == 'select' || v == 'date' || v == 'checkbox'
							|| v == 'radio') {
						displaynum.css('display', '');
						displaynum.addClass("required");
						//if(v == 'date') displaynum.attr('alt','yyyy-MM-dd');
						//else if(v == 'select') displaynum.attr('alt','initParam');
					} else {
						displaynum.css('display', 'none');
					}
				});
	});
	//-->
</script>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveMgrWoDefine.action?navTabId=addMgrWoDefineCardNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="mgrWoDefineKey" value="${mgrWoDefineKey}" />
		<input type="hidden" name="mgrTempletKey" value="${mgrTempletKey}" />
		<input type="hidden" name="coltype" value="${coltype}" />
		<div class="pageFormContent" layoutH="56">
			<FIELDSET>
				<p>
					<label>
						字段名称：
					</label>
					<select name="mgrWoDefineForm.defCol" class="required combox">
						<c:forEach items="${applicationScope.dictpara['MGR-COL']}"
							var="activeState">
							<c:choose>
								<c:when test="${mgrWoDefineForm.defCol == activeState.code}">
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
				<p>
					<label>
						显示名称：
					</label>
					<input name="mgrWoDefineForm.defColTitle"
						id="mgrWoDefineForm.defColTitle"
						value="${mgrWoDefineForm.defColTitle}" type="text" size="20"
						class="required" />
				</p>
				<p>
					<label>
						编辑框类型：
					</label>
					<select name="mgrWoDefineForm.defColType" class="required combox"
						id="defColType">
						<c:forEach items="${applicationScope.dictpara['MGR-COL-TYPE']}"
							var="activeState">
							<c:choose>
								<c:when test="${mgrWoDefineForm.defColType == activeState.code}">
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
					<input name="mgrWoDefineForm.defColFormat" id="defColFormat"
						value="${mgrWoDefineForm.defColFormat}" type="text" size="20"
						class="" />
				</p>
				<c:if test="${coltype == 'add'||coltype == 'edit'}">
					<p>
						<label>
							可编辑：
						</label>
						<input name="mgrWoDefineForm.defCanedit"
							id="mgrWoDefineForm.defCanedit" value="Y"
							type="checkbox" size="20" class=""
							<c:if test="${mgrWoDefineForm.defCanedit == 'Y'}">checked="checked"</c:if> />
					</p>
					<p>
						<label>
							最小长度：
						</label>
						<input name="mgrWoDefineForm.defColLmin"
							id="mgrWoDefineForm.defColLmin"
							value="${mgrWoDefineForm.defColLmin}" type="text" size="20"
							class="required" />
					</p>
					<p>
						<label>
							最大长度：
						</label>
						<input name="mgrWoDefineForm.defColLmax"
							id="mgrWoDefineForm.defColLmax"
							value="${mgrWoDefineForm.defColLmax}" type="text" size="20"
							class="required" />
					</p>
					<p>
						<label>
							表单验证：
						</label>
						<select name="mgrWoDefineForm.defColClass" class="combox">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<c:forEach items="${applicationScope.dictpara['MGR-CLASS']}"
								var="activeState">
								<c:choose>
									<c:when
										test="${mgrWoDefineForm.defColClass == activeState.code}">
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
					<p>
						<label>
							必填：
						</label>
						<input name="mgrWoDefineForm.defColRequired"
							id="mgrWoDefineForm.defColRequired" value="required"
							type="checkbox" size="20" class=""
							<c:if test="${mgrWoDefineForm.defColRequired == 'required'}">checked="checked"</c:if> />
					</p>
					<p>
					<label>
						区域划分：
					</label>
					<select name="mgrWoDefineForm.defColRegion" class="combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['MGR_WO_REGION']}"
							var="activeState">
							<c:choose>
								<c:when
									test="${mgrWoDefineForm.defColRegion == activeState.code}">
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
				<p>
					<label>
						排序：
					</label>
					<input name="mgrWoDefineForm.defColOrder"
						id="mgrWoDefineForm.defColOrder"
						value="${mgrWoDefineForm.defColOrder}" type="text" size="20"
						class="required" />
				</p>
			</FIELDSET>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
								保存
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="button" class="close">
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>