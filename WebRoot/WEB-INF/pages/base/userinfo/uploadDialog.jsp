<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}importExcel.action?navTabId=userinfoLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return iframeCallback(this,dialogAjaxDone);" enctype="multipart/form-data">
		<div class="pageFormContent" layoutH="56" >
			<p>
				<label>选择：</label>
				<input name="upload" type="file">
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