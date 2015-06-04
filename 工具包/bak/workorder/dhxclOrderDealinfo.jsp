<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveOrderdealinfo.action?navTabId=workorderCardNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<p>
					<label>
						工单编号
						：
					</label>
					<input name="orderdealinfoForm.workorderno"
						id="orderdealinfoForm.workorderno" type="hidden"
						value="${orderdealinfoForm.workorderno}" />
					${orderdealinfoForm.workorderno}
				</p>
				<p>
					<label>
						工单状态
						：
					</label>
					<input name="orderdealinfoForm.wostatus"
						id="orderdealinfoForm.wostatus" type="hidden" value="dhxcl" />
					待后续处理
				</p>
			</fieldset>
			<fieldset>
				<p>
					<label>
						问题部门
						：
					</label>
					<input name="orderdealinfoForm.prodepartment"
						id="orderdealinfoForm.prodepartment" class="" maxlength="100"
						type="text" size="30" value="${orderdealinfoForm.prodepartment}" />
					<input type="hidden" value="${workOrderKey}" id="workOrderKey"
						name="workOrderKey">
					<input type="hidden" value="${orderdealinfoKey}"
						id="orderdealinfoKey" name="orderdealinfoKey">
				</p>
				<p>
					<label>
						问题部门处理人
						：
					</label>
					<input name="orderdealinfoForm.depdealman"
						id="orderdealinfoForm.depdealman" class="" maxlength="20"
						type="text" size="30" value="${orderdealinfoForm.depdealman}" />
				</p>
				<p>
					<label>
						问题责任人
						：
					</label>
					<input name="orderdealinfoForm.assignperson"
						id="orderdealinfoForm.assignperson" class="" maxlength="20"
						type="text" size="30" value="${orderdealinfoForm.assignperson}" />
				</p>
				<p>
					<label>
						问题发生时间 ：
					</label>
					<input type="text" name="orderdealinfoForm.occtime" class="date" size="30" format="yyyy-MM-dd HH:mm:ss" value="${orderdealinfoForm.occtime}" />
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>

				<dl class="nowrap">
					<dt>
						问题描述
						：
					</dt>
					<dd>
						<textarea name="orderdealinfoForm.prodesc"
							id="orderdealinfoForm.prodesc" cols="80" rows="3" maxlength="500">${orderdealinfoForm.prodesc}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						问题原因
						：
					</dt>
					<dd>
						<textarea name="orderdealinfoForm.proreason"
							id="orderdealinfoForm.proreason" cols="80" rows="3"
							maxlength="500">${orderdealinfoForm.proreason}</textarea>
					</dd>
				</dl>
			</fieldset>
			<fieldset>
				<p>
					<label>
						处理时间 ：
					</label>
					<input type="text" name="orderdealinfoForm.dealtime" value="${orderdealinfoForm.dealtime}" class="date" size="30" format="yyyy-MM-dd HH:mm:ss" readonly="readonly"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<dl class="nowrap">
					<dt>
						处理情况
						：
					</dt>
					<dd>
						<textarea name="orderdealinfoForm.prosituation"
							id="orderdealinfoForm.prosituation" cols="80" rows="3"
							maxlength="500">${orderdealinfoForm.prosituation}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						备注
						：
					</dt>
					<dd>
						<textarea name="orderdealinfoForm.remark"
							id="orderdealinfoForm.remark" cols="80" rows="3" maxlength="500">${orderdealinfoForm.remark}</textarea>
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