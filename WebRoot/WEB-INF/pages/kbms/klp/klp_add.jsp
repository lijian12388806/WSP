<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveKbmsKlp.action?navTabId=kbmsclassLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this,dialogAjaxDone);"
		id="actionForm">
		<input type="hidden" name="kbmsKlpKey" value="${kbmsKlpKey}" />
		<input type="hidden" name="kbmsClassKey" value="${kbmsClassKey}" />
		<div class="pageFormContent" layoutH="56">
			<FIELDSET>
				<p>
					<label>
						知识点名称：
					</label>
					<input name="kbmsKlpForm.name" id="kbmsKlpForm.name"
						value="${kbmsKlpForm.name}" type="text" size="20" class="required"
						maxlength="50" />
				</p>
				<dl class="nowrap">
					<dt>
						内容：
					</dt>
					<dd>
						<textarea class="editor" name="kbmsKlpForm.content" rows="18"
							cols="110">${kbmsKlpForm.content}</textarea>
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
								关闭
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>