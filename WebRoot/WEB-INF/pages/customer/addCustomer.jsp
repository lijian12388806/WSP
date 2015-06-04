<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveCustomerinfo.action?navTabId=customerLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input  name="customerKey" type="hidden" value="${customerKey}"/>
		<div class="pageFormContent">
			<fieldset>
				<dl class="nowrap">
					<dt>
						公司名称：
					</dt>
					<dd>
					<textarea name="customerinfoForm.customername" class="required"
							id="customerinfoForm.customername" cols="80" rows="1" maxlength="100">${customerinfoForm.customername}</textarea>
					</dd>
				</dl>
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
					<select name="customerinfoForm.temp2" class="combox">
						<option value="all">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['Gender']}"
							var="activeState">
							<c:choose>
								<c:when test="${customerinfoForm.temp2 == activeState.code}">
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
<div class="pageContent"
	<c:if test="${empty customerKey}">style="display:none"</c:if>>
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addCusphonelist.action?customerKey=${customerKey}"
					rel="addCusphonelistCardNav" target="navTab" reloadFlag=1><span><s:text
							name="添加" /> </span> </a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteCusphonelist.action?navTabId=editCustomerCardNav&customerKey=${customerKey}"
					class="delete"><span><s:text name="批量删除" /> </span> </a>
			</li>

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="380" nowrapTD="false" width="100%"
		asc="asc" desc="desc">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					联系人
				</th>

				<th width="100">
					电话号码
				</th>
				<th width="100">
					备注
				</th>
				<th width="70">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.cusphoneList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.custlinkname}
					</td>
					<td>
						${item.phoneno}
					</td>
					<td>
						${item.remark}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteCusphonelist.action?selectIDS=${item.id}&navTabId=editCustomerCardNav&customerKey=${customerKey}"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
									name="common.delete" /> </span> </a>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editCusphonelist.action?cusphonelistKey=${item.id}&customerKey=${customerKey}"
							target="navTab" rel="cusphonelistCardNav" reloadFlag=1
							title="电话信息修改"><span>电话信息修改</span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>