<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveKbmsClass.action?navTabId=kbmsclassLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this,dialogAjaxDone);"
		id="actionForm">
		<input type="hidden" name="kbmsClassKey" value="${kbmsClassKey}"/>
		<input type="hidden" name="operate" value="${operate}"/>
		<div class="pageFormContent" layoutH="56">
			<FIELDSET>
				<p>
					<label>
						类别名称：
					</label>
					<input name="kbmsClassForm.title"
						id="kbmsClassForm.title"
						value="${kbmsClassForm.title}" type="text" size="20" class="required"/>
				</p>
				<p>
					<label>
						排序：
					</label>
					<input name="kbmsClassForm.ord"
						id="kbmsClassForm.ord"
						value="${kbmsClassForm.ord}" type="text" size="20" class="required"/>
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
								关闭
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>