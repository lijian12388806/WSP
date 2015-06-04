<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveBatchUserinfo.action?navTabId=userinfoLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					<s:text name="userinfo.extension"/>：
				</label>
				<input name="userinfoForm.extstart" id="userinfoForm.extstart"
					class="required digits" minlength="4" maxlength="10"  type="text" size="15"
					value="${userinfoForm.extstart}" alt="<s:text name="userinfo.extstart"/>" />
				
			</p>
			<p>
				<label>
					<s:text name="userinfo.zhi"/>：
				</label>
				<input name="userinfoForm.extend" id="userinfoForm.extend"
					class="required digits" minlength="4" maxlength="10"  type="text" size="15"
					value="${userinfoForm.extend}" alt="<s:text name="userinfo.extend"/>" /> 
				
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
								<s:text name="common.save"/>
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								<s:text name="common.cancle"/>
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>