<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveMenuinfo.action?navTabId=menuinfoLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
<fieldset>
			<p>
				<label>
					<s:text name="menuinfo.menuname"/>：
				</label>
				<input name="menuinfoForm.menuname" id="menuinfoForm.menuname"
					value="${menuinfoForm.menuname}" alt="" type="text" size="30"
					class="required" />
				<input type="hidden" value="${pkMenuKey}" id="pkMenuKey"
					name="pkMenuKey">
			</p>
			<p>
				<label>
					<s:text name="menuinfo.listSuper"/>：
				</label>
				<select name="menuinfoForm.supermenu" class="combox">
					<option value=''>
						 <s:text name="common.listbox"/>
					</option>
					<c:forEach items="${sessionScope.listSuper}" var="lsr">
						<c:choose>
							<c:when test="${menuinfoForm.supermenu == lsr.id}">
								<option value='<c:out value="${lsr.id}"/>' selected="selected">
									<c:out value="${lsr.menuname}" />
								</option>
							</c:when>
							<c:otherwise>
								<option value='<c:out value="${lsr.id}"/>'>
									<c:out value="${lsr.menuname}" />
								</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>
					<s:text name="menuinfo.menuseq"/>：
				</label>
				<input name="menuinfoForm.menuseq" id="menuinfoForm.menuseq"
					type="text" size="30" value="${menuinfoForm.menuseq}" alt="" />
			</p>
			<p>
				<label>
					<s:text name="menuinfo.isavailable"/>：
				</label>
				<select name="menuinfoForm.isavailable" class="required combox">
					<option value="">
						 <s:text name="common.listbox"/>
					</option>
					<option value="Y"
						<c:if test="${menuinfoForm.isavailable == 'Y'}">selected</c:if>>
						<s:text name="menuinfo.y"/>
					</option>
					<option value='N'
						<c:if test="${menuinfoForm.isavailable == 'N'}">selected</c:if>>
						<s:text name="menuinfo.n"/>
					</option>
				</select>
			</p>
			<p>
				<label>
					<s:text name="menuinfo.rel"/>：
				</label>
				<input name="menuinfoForm.temp1" id="menuinfoForm.temp1"
					type="text" value="${menuinfoForm.temp1}" alt="" />
			</p>
			<dl class="nowrap">
					<dt>
						<s:text name="menuinfo.linkaddress"/>：
					</dt>
					<dd>
						<textarea name="menuinfoForm.linkaddress"
							id="menuinfoForm.linkaddress" cols="100" rows="2">${menuinfoForm.linkaddress}</textarea>
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