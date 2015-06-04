<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveAdminUserinfo.action?isadmin=Y&navTabId=adminLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					<s:text name="userinfo.username" />
					：
				</label>
				<input name="userinfoForm.username" id="userinfoForm.username"
					value="${userinfoForm.username}"
					alt="<s:text name="common.input"/>" type="text" size="30"
					class="required" />
				<input type="hidden" value="${adminKey}" id="adminKey"
					name="adminKey">
			</p>
			<p>
				<label>
					<s:text name="userinfo.isadmin" />
					：
				</label>
				<select name="userinfoForm.isadmin" class="combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.syspara['yesornotPara']}"
							var="activeState">
							<c:choose>
								<c:when test="${userinfoForm.isadmin == activeState.code}">
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
					<s:text name="userinfo.password" />
					：
				</label>
				<input name="userinfoForm.userpwd" id="userinfoForm.userpwd"
					class="required alphanumeric" minlength="4" maxlength="20"
					type="password" size="30" value="${userinfoForm.userpwd}">
			</p>

			<p>
				<label>
					<s:text name="userinfo.password.again" />
					：
				</label>
				<input name="pwdagain" id="pwdagain" class="required alphanumeric"
					minlength="4" maxlength="20" type="password" size="30"
					value="${pwdagain}">
			</p>
<p>
					<label>
						用户状态：
					</label>
					<select name="userinfoForm.userstatus" class="required combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['UserStatus']}"
							var="activeState">
							<c:choose>
								<c:when test="${userinfoForm.userstatus == activeState.code}">
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
					<s:text name="userinfo.remark" />
					：
				</label>
				<input name="userinfoForm.remark" id="userinfoForm.remark" class="" maxlength="200"
					type="text" size="40" value="${userinfoForm.remark}">
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
								<s:text name="common.save" />
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								<s:text name="common.cancle" />
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>