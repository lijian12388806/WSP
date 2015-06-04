<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveBdDutydetail.action?navTabId=dutyCardNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			
			<p>
				<label>
					值班人：
				</label>
				<input name="bdDictForm.title" id="bdDictForm.title"
					class="required" type="text" size="30"
					value="${bdDictForm.title}" alt="<s:text name="alt.dictdetail.name"/>" />
			</p>
			<p>
				<label>
					电话号码：
				</label>
				<input name="bdDictForm.code" id="bdDictForm.code"
					value="${bdDictForm.code}" alt="<s:text name="alt.dictdetail.code"/>" type="text" size="30"
					class="required" />
				<input type="hidden" value="${bdDictKey}" id="bdDictKey"
					name="bdDictKey">
				<input type="hidden" value="${bdDictdetailKey}" id="bdDictdetailKey"
					name="bdDictdetailKey">
			</p>
			<p>
				<label>
					<s:text name="common.validornot"/>：
				</label>
				<select name="bdDictForm.detailisvalid" class="required combox">
					<option value="">
						<s:text name="common.listbox"/>
					</option>
					<option value="Y"
						<c:if test="${bdDictForm.detailisvalid == 'Y'}">selected</c:if>>
						Y
					</option>
					<option value='N'
						<c:if test="${bdDictForm.detailisvalid == 'N'}">selected</c:if>>
						N
					</option>
				</select>
			</p>
			<p>
				<label>
					<s:text name="dictdetail.order"/>：
				</label>
				<input name="bdDictForm.defaultorder" id="bdDictForm.defaultorder"
					type="text" size="30"
					value="${bdDictForm.defaultorder}" alt="" />
			</p>
		</div>

		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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
<%--

onclick="Javascript:location.href = '${applicationScope.rootpath}editBdDict.action?bdDictKey=${bdDictKey}';" />
--%>