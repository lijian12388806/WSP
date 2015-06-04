<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveVoice.action?navTabId=ivrvoiceLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<p>
					<label>
						工厂：${ivrvoiceForm.n1}
					</label>
				</p>
				<p>
					<label>
						来电号码：${ivrvoiceForm.callerid}
					</label>
				</p>
				<p>
					<label>
						被叫号码：${ivrvoiceForm.dnis}
					</label>
				</p>
				<p>
					<label>
						来电时间：${ivrvoiceForm.startdate}
					</label>
				</p>
				<dl class="nowrap">
					<dt>
						处理说明 ：
					</dt>
					<dd>
						<textarea name="ivrvoiceForm.processresult" class="" <c:if test="${not empty ivrvoiceForm.ischeck}">disabled</c:if>
							id="ivrvoiceForm.processresult" cols="80" rows="5" maxlength="250">${ivrvoiceForm.processresult}</textarea>
						<input type="hidden" id="ivrvoiceKey" name="ivrvoiceKey" value="${ivrvoiceKey}">
					</dd>
				</dl>
			</fieldset>
		</div>

		<div class="formBar">
			<ul>
				<c:if test="${empty ivrvoiceForm.ischeck}">
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									处理
								</button>
							</div>
						</div>
					</li>
				</c:if>
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