<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveJobmsg.action?navTabId=jobmsgLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					任务名称：
				</label>
				<input name="jobmsgForm.jobName" id="jobmsgForm.jobName"
					value="${jobmsgForm.jobName}" type="text" size="30"
					class="required" maxlength="100"/>
				<input type="hidden" value="${jobmsgKey}" id="jobmsgKey"
					name="jobmsgKey">
			</p>
			<p>
				<label>
					任务Bean名称：
				</label>
				<input name="jobmsgForm.jobBeanname" id="jobmsgForm.jobBeanname"
					class="required"  maxlength="50" type="text"
					size="30" value="${jobmsgForm.jobBeanname}"/>
			</p>
<p>
				<label>
					年：
				</label>
				<input name="jobmsgForm.jobYear" id="jobmsgForm.jobYear"
					class="required" maxlength="4" type="text"
					size="30" value="${jobmsgForm.jobYear}"  />
			</p>
<p>
				<label>
					星期：
				</label>
				<input name="jobmsgForm.jobWeek" id="jobmsgForm.jobWeek"
					class="required"  maxlength="4" type="text"
					size="30" value="${jobmsgForm.jobWeek}"  />
			</p>
<p>
				<label>
					月份：
				</label>
				<input name="jobmsgForm.jobMonth" id="jobmsgForm.jobMonth"
					class="required" maxlength="4" type="text"
					size="30" value="${jobmsgForm.jobMonth}" />
			</p>
<p>
				<label>
					日期：
				</label>
				<input name="jobmsgForm.jobDay" id="jobmsgForm.jobDay"
					class="required"  maxlength="4" type="text"
					size="30" value="${jobmsgForm.jobDay}"/>
			</p>
<p>
				<label>
					小时：
				</label>
				<input name="jobmsgForm.jobHour" id="jobmsgForm.jobHour"
					class="required" maxlength="4" type="text"
					size="30" value="${jobmsgForm.jobHour}" />
			</p>
<p>
				<label>
					分钟：
				</label>
				<input name="jobmsgForm.jobMinute" id="jobmsgForm.jobMinute"
					class="required" maxlength="4" type="text"
					size="30" value="${jobmsgForm.jobMinute}" />
			</p>
<p>
				<label>
					秒：
				</label>
				<input name="jobmsgForm.jobSecond" id="jobmsgForm.jobSecond"
					class="required" maxlength="4" type="text"
					size="30" value="${jobmsgForm.jobSecond}" />
			</p>
			
			<p>
				<label>
					状态：
				</label>
				<select name="jobmsgForm.jobState" class="required combox">
					<option value="">
						<s:text name="common.listbox"/>
					</option>
					<c:forEach items="${applicationScope.syspara['jobStatusPara']}"
						var="activeState">
						<c:choose>
							<c:when test="${jobmsgForm.jobState == activeState.code}">
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
			<dl class="nowrap">
				<dt>
					备注：
				</dt>
				<dd>
					<textarea name="jobmsgForm.remark" id="jobmsgForm.remark"
						cols="80" rows="5">${jobmsgForm.remark}</textarea>
				</dd>
			</dl>
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