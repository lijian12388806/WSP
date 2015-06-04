<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>

<script type="text/javascript">
	function checkEqual(){
	var pwd=document.getElementById("userinfoForm.extenpwd").value;
	var agpwd=document.getElementById("pwdagain").value;
	var saveb = getElement('update');
		if(pwd == agpwd){	
			document.getElementById("msgid_dictCode").innerHTML = "";
			saveb.disabled=false;
			return;
		}else{
		document.getElementById("msgid_dictCode").innerHTML = "密码不一致";
			saveb.disabled=true;
			return;
		}
	}


</script>
<div class="pageContent" style="width:800px;heigth:800px">
	<form method="post"
		action="${applicationScope.rootpath}savePwd.action?navTabId=loginLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" value="${sessionScope.user.id}" id="adminKey"
			name="adminKey">
		<div class="pageFormContent" layoutH="56" >
			<p>
				<label>
					<s:text name="密码"/>
				</label>
				<input name="oldpwd" id="oldpwd"
					class="required" minlength="4" maxlength="20"
					type="password" size="30" alt="" />
			</p>
			<p>
				<label>
					<s:text name="userinfo.newpwd"/>
				</label>
				<input name="userinfoForm.userpwd" id="userinfoForm.userpwd"
					class="required alphanumeric" minlength="4" maxlength="20"
					type="password" size="30" alt="" />
			</p>
			<p>
				<label>
					<s:text name="userinfo.password.again"/>
				</label>
				<input name="pwdagain" id="pwdagain" class="required alphanumeric"
					minlength="4" maxlength="20" type="password" size="30"
					alt="" onblur="but()"/>
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" id="update">
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