<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveWorkstation.action?navTabId=workstationLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);" id="actionForm">
		<div class="pageFormContent" layoutH="56">
		<FIELDSET>
			<p>
				<label>
					工厂名称
					：
				</label>
				<input name="workstationForm.factorynamecn" id="workstationForm.factorynamecn"
					class="required" maxlength="50" type="text" size="30"
					value="${workstationForm.factorynamecn}" />
			</p>
			<p>
				<label>
					工厂英文名称
					：
				</label>
				<input name="workstationForm.factorynameen"
					id="workstationForm.factorynameen" value="${workstationForm.factorynameen}"
					maxlength="50" type="text" size="30" class="" />
				<input type="hidden" value="${workstationKey}" id="workstationKey"
					name="workstationKey">
			</p>
			<p>
				<label>
					联系人
					：
				</label>
				<input name="workstationForm.wslinkman"
					id="workstationForm.wslinkman" value="${workstationForm.wslinkman}"
					maxlength="50" type="text" size="30" class="" />
			</p>
			<p>
				<label>
					工厂联系电话
					：
				</label>
				<input name="workstationForm.phoneno"
					id="workstationForm.phoneno" value="${workstationForm.phoneno}"
					maxlength="30" type="text" size="30" class="phone" />
			</p>
<p>
				<label>
					联系人邮箱
					：
				</label>
				<input name="workstationForm.wsemail" id="workstationForm.wsemail"
					class="email" maxlength="50" type="text" size="30"
					value="${workstationForm.wsemail}" />
			</p>
			<dl class="nowrap">
				<dt>
					工厂地址
					：
				</dt>
				<dd>
					<textarea name="workstationForm.wsaddr"
						id="workstationForm.wsaddr" cols="80" rows="5" maxlength="500">${workstationForm.wsaddr}</textarea>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>
					备注
					：
				</dt>
				<dd>
					<textarea name="workstationForm.remark" id="workstationForm.remark"
						cols="80" rows="5"  maxlength="500">${workstationForm.remark}</textarea>
				</dd>
			</dl>
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