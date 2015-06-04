<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveWorkingcalendar.action?navTabId=workingcalendarLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogAjaxDone);"
		id="actionForm">
		<input type="hidden" name="workingcalendarKey" value="${workingcalendarKey}"/>
		<div class="pageFormContent" layoutH="56">
			<FIELDSET>
				<c:if test="${empty workingcalendarKey}">
				<p>
					<label>
						从：
					</label>
					<input name="workingcalendarForm.starttime"
						id="workingcalendarForm.starttime"
						value="${workingcalendarForm.starttime}" type="text" size="20"
						class="date" format="yyyy-MM-dd" class="required"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<label>
						到：
					</label>
					<input name="workingcalendarForm.stoptime"
						id="workingcalendarForm.stoptime"
						value="${workingcalendarForm.stoptime}" type="text" size="20"
						class="date" format="yyyy-MM-dd" class="required"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				</c:if>
				<c:if test="${not empty workingcalendarKey}">
				<p>
					<label>
						日期：
					</label>
					<input name="workingcalendarForm.workingdate"
						id="workingcalendarForm.workingdate"
						value="${workingcalendarForm.workingdate}" type="text" size="20"
						class="date" format="yyyy-MM-dd" class="required"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				</c:if>
				<p>
					<label>
						是否节假日：
					</label>
					<select name="workingcalendarForm.isvacation" class="required combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['WorkingCalendar']}"
							var="activeState">
							<c:choose>
								<c:when test="${workingcalendarForm.isvacation == activeState.code}">
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
						值班人：
					</label>
					<input name="workingcalendarForm.n2"
						id="workingcalendarForm.n2"
						value="${workingcalendarForm.n2}" type="text" size="20" class=""/>
				</p>
				<p>
					<label>
						值班电话：
					</label>
					<input name="workingcalendarForm.n1"
						id="workingcalendarForm.n1"
						value="${workingcalendarForm.n1}" type="text" size="20" class="phone"/>
				</p>
				<dl class="nowrap">
					<dt>
						备注 ：
					</dt>
					<dd>
						<textarea name="workingcalendarForm.reamrk"
							id="workingcalendarForm.reamrk" cols="80" rows="5"
							maxlength="500">${workingcalendarForm.reamrk}</textarea>
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
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>