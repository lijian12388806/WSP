<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveUserinfo.action?navTabId=userinfoLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<p>
					<label>
						坐席员姓名：
					</label>
					<input name="userinfoForm.agentname" id="userinfoForm.agentname"
						class="required" maxlength="50" type="text" size="30"
						value="${userinfoForm.agentname}" />
				</p>
				<p>
					<label>
						坐席分机号：
					</label>
					<input name="userinfoForm.extno" id="userinfoForm.extno"
						class="required" type="text" size="30" maxlength="10"
						value="${userinfoForm.extno}" />
				</p>
				<p>
					<label>
						坐席账号：
					</label>
					<input name="userinfoForm.username" id="userinfoForm.username"
						value="${userinfoForm.username}" type="text" size="30"
						class="required" maxlength="20" />
					<input type="hidden" value="${userinfoKey}" id="userinfoKey"
						name="userinfoKey">
				</p>
				<p>
					<label>
						坐席登录密码：
					</label>
					<input name="userinfoForm.userpwd" id="userinfoForm.userpwd"
						class="required" minlength="4" maxlength="20" type="password"
						size="30" value="${userinfoForm.userpwd}" />
				</p>
				<p>
					<label>
						坐席类型：
					</label>
					<select name="userinfoForm.agenttype" class="combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['AgentType']}"
							var="activeState">
							<c:choose>
								<c:when test="${userinfoForm.agenttype == activeState.code}">
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
						CTI中登录号：
					</label>
					<input name="userinfoForm.agentno" id="userinfoForm.agentno"
						class="required" maxlength="50" type="text" size="30"
						value="${userinfoForm.agentno}" />
				</p>
				<p>
					<label>
						CTI中登录密码：
					</label>
					<input name="userinfoForm.ctipwd" id="userinfoForm.ctipwd"
						class="required" minlength="4" maxlength="50" type="password"
						size="30" value="${userinfoForm.ctipwd}" />
				</p>
				<p>
					<label>
						技能组：
					</label>
					<!--<c:forEach items="${listSkill}"
					var="activeState">
					<input name="userinfoForm.limitcheckbox" value="${activeState.skillname}" type="checkbox" <c:if test="${fn:contains(userinfoForm.temp1,activeState.skillname)}">checked="checked"</c:if>
						/>${activeState.skillname}
				</c:forEach>-->
					<input name="userinfoForm.temp2" id="userinfoForm.temp2" class=""
						type="text" size="30" maxlength="100"
						value="${userinfoForm.temp2}" />
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
						是否管理员：
					</label>
					<select name="userinfoForm.isadmin" class="required combox">
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
			</fieldset>
			<fieldset>
				<p>
					<label>
						工厂名称：
					</label>
					<input name="userinfoForm.factory" id="userinfoForm.factory"
						class="" type="text" size="30" maxlength="50"
						value="${userinfoForm.factory}" lookupGroup="userinfoForm" />
					<input type="hidden" name="userinfoForm.temp1"
						value="${userinfoForm.temp1}" lookupGroup="userinfoForm" />
					<a class="btnLook"
						href="${applicationScope.rootpath}lookUpWorkstation.action?changeUrl=Y"
						lookupGroup="userinfoForm">查找带回</a>
				</p>
				<p>
					<label>
						职位：
					</label>
					<input name="userinfoForm.position" id="userinfoForm.position"
						class="" type="text" size="30" maxlength="20"
						value="${userinfoForm.position}" />
				</p>
				<p>
					<label>
						电子邮箱：
					</label>
					<input name="userinfoForm.agentemail" id="userinfoForm.agentemail"
						class="email" type="text" size="30" maxlength="50"
						value="${userinfoForm.agentemail}" />
				</p>
				<p>
					<label>
						电话：
					</label>
					<input name="userinfoForm.phoneno" id="userinfoForm.phoneno"
						class="" type="text" size="30" maxlength="50"
						value="${userinfoForm.phoneno}" />
				</p>

			</fieldset>
			<fieldset>
				
				<p>
					<label>
						授权方式：
					</label>
					<select name="userinfoForm.authtype" class="required combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['AuthorizeType']}"
							var="activeState">
							<c:choose>
								<c:when test="${userinfoForm.authtype == activeState.code}">
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
				<dl class="nowrap">
					<dt>
						授权地址：
					</dt>
					<dd>
						<textarea name="userinfoForm.authaddr" id="userinfoForm.authaddr"
							maxlength="100" cols="80" rows="2">${userinfoForm.authaddr}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						CTI地址：
					</dt>
					<dd>
						<textarea name="userinfoForm.ctiaddr" id="userinfoForm.ctiaddr"
							maxlength="100" cols="80" rows="2">${userinfoForm.ctiaddr}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						备用CTI地址：
					</dt>
					<dd>
						<textarea name="userinfoForm.ctiaddrbak"
							id="userinfoForm.ctiaddrbak" maxlength="100" cols="80" rows="2">${userinfoForm.ctiaddrbak}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						备注：
					</dt>
					<dd>
						<textarea name="userinfoForm.remark" id="userinfoForm.remark"
							maxlength="50" cols="80" rows="2">${userinfoForm.remark}</textarea>
					</dd>
				</dl>
			</fieldset>
		</div>

		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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
					<div class="button">
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