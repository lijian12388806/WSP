<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveKbmsKlp.action?navTabId=kbmsclassLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return iframeCallback(this,dialogAjaxDone);"
		enctype="multipart/form-data"
		id="actionForm">
		<input type="hidden" name="kbmsKlpKey" value="${kbmsKlpKey}" />
		<div class="pageFormContent" layoutH="56">
			<FIELDSET>
				<dl>
					<dd>
						<input name="uploadify" type="file">
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
								上载
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