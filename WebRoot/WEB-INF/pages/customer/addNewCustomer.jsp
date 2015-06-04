<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveCustomerinfo.action?navTabId=addOrderinfoCardNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<p>
					<label>
						公司名称：
					</label>
					<input name="customerinfoForm.customername"
						id="customerinfoForm.customername"
						value="${customerinfoForm.customername}" maxlength="100"
						type="text" size="40" class="required" />
				</p>
				
			</fieldset>
			<fieldset>
				<p>
					<label>
						客户姓名  ：
					</label>
					<input name="customerinfoForm.custlinkman"
						id="customerinfoForm.custlinkman" class="" maxlength="20"
						type="text" size="30" value="${customerinfoForm.custlinkman}" />
				</p>
				<p>
					<label>
						性别：
					</label>
					<select name="customerinfoForm.infosource" class="combox">
						<option value="all">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['Gender']}"
							var="activeState">
							<c:choose>
								<c:when test="${customerinfoForm.infosource == activeState.code}">
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
				<!-- <p>
					<label>
						联系电话 ：
					</label>
					<input name="customerinfoForm.custphoneno"
						id="customerinfoForm.custphoneno" class="phone" maxlength="100"
						type="text" size="30" value="${customerinfoForm.custphoneno}" />
				</p> -->
				<p>
					<label>
						QQ号码 ：
					</label>
					<input name="customerinfoForm.temp1"
						id="customerinfoForm.temp1" class="phone" maxlength="100"
						type="text" size="30" value="${customerinfoForm.temp1}" />
				</p>
				<p>
					<label>
						电子邮箱地址 ：
					</label>
					<input name="customerinfoForm.emailaddr"
						id="customerinfoForm.emailaddr" class="email" maxlength="100"
						type="text" size="30" value="${customerinfoForm.emailaddr}" />
				</p>
				<p>
					<label>
						所属城市 ：
					</label>
					<input name="customerinfoForm.netherlands"
						id="customerinfoForm.netherlands" class="" maxlength="50"
						type="text" size="30" value="${customerinfoForm.netherlands}" />
				</p>
				<dl class="nowrap">
					<dt>
						客户地址 ：
					</dt>
					<dd>
						<textarea name="customerinfoForm.custaddr"
							id="customerinfoForm.custaddr" cols="80" rows="2" maxlength="100">${customerinfoForm.custaddr}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						备注 ：
					</dt>
					<dd>
						<textarea name="customerinfoForm.remark" class=""
							id="customerinfoForm.remark" cols="80" rows="2" maxlength="500">${customerinfoForm.remark}</textarea>
					</dd>
				</dl>
			</fieldset>
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