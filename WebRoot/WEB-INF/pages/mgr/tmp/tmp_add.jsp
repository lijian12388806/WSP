<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveMgrTemplet.action?navTabId=mgrtempletLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogAjaxDone);"
		id="actionForm">
		<input type="hidden" name="mgrTempletKey" value="${mgrTempletKey}" />
		<div class="pageFormContent" layoutH="56">
			<FIELDSET>
				<p>
					<label>
						模板编号：
					</label>
					<input name="mgrTempletForm.tmpCode" id="mgrTempletForm.tmpCode"
						value="${mgrTempletForm.tmpCode}" type="text" size="20" class="" />
				</p>
				<p>
					<label>
						模板名称：
					</label>
					<input name="mgrTempletForm.tmpName" id="mgrTempletForm.tmpName"
						value="${mgrTempletForm.tmpName}" type="text" size="20" class="" />
				</p>
				<p>
					<label>
						模板类型：
					</label>
					<select name="mgrTempletForm.tmpType" class="required combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['MGR_TYPE']}"
							var="activeState">
							<c:choose>
								<c:when test="${mgrTempletForm.tmpType == activeState.code}">
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
						列表数据显示：
					</label>
					<c:forEach items="${applicationScope.dictpara['WO_BUTTON']}"
						var="activeState">
						<input name="mgrTempletForm.tmpListdata" value="${activeState.code}"
							type="checkbox"
							<c:if test="${fn:contains(mgrTempletForm.tmpListdata,activeState.code)}">checked="checked"</c:if> />${activeState.title}
						</c:forEach>
				</p>
				<p>
					<label>
						模板状态：
					</label>
					<select name="mgrTempletForm.tmpStatus" class="required combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['UserStatus']}"
							var="activeState">
							<c:choose>
								<c:when test="${mgrTempletForm.tmpStatus == activeState.code}">
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
						按钮定义：
					</label>
					<c:forEach items="${applicationScope.dictpara['WO_BUTTON']}"
						var="activeState">
						<input name="mgrTempletForm.tmpBtn" value="${activeState.code}"
							type="checkbox"
							<c:if test="${fn:contains(mgrTempletForm.tmpBtn,activeState.code)}">checked="checked"</c:if> />${activeState.title}
						</c:forEach>
				</p>
				<p>
					<label>
						关联工单/客户：
					</label>
					<input name="mgrTempletForm.tmpRelated" id="mgrTempletForm.tmpRelated"
						value="${mgrTempletForm.tmpRelated}" type="text" size="20" class="" />
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
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>