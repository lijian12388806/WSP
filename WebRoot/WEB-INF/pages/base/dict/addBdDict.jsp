<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveBdDict.action?navTabId=dictLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" <c:if test="${empty bdDictKey}">layoutH="56"</c:if>>
<fieldset>
			<p>
				<label>
					<s:text name="dict.dictname"/>：
				</label>
				<input name="bdDictForm.dicttitle" id="bdDictForm.dicttitle"
					value="${bdDictForm.dicttitle}" alt="<s:text name="alt.dict.name"/>" type="text" size="30"
					class="required" />
				<input type="hidden" value="${bdDictKey}" id="bdDictKey"
					name="bdDictKey">
			</p>
			<p>
				<label>
					<s:text name="dict.dictcode"/>：
				</label>
				<input name="bdDictForm.dictcode" id="bdDictForm.dictcode"
					class="required" type="text" size="30"
					value="${bdDictForm.dictcode}" alt="<s:text name="alt.dict.code"/>" />
			</p>
			<p>
				<label>
					<s:text name="common.validornot"/>：
				</label>
				<select name="bdDictForm.isvalid" class="required combox">
					<option value="">
						<s:text name="common.listbox"/>
					</option>
					<option value="Y"
						<c:if test="${bdDictForm.isvalid == 'Y'}">selected</c:if>>
						Y
					</option>
					<option value='N'
						<c:if test="${bdDictForm.isvalid == 'N'}">selected</c:if>>
						N
					</option>
				</select>
			</p>
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
<div class="pageContent" <c:if test="${empty bdDictKey}">style="display:none"</c:if>>
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add" href="${applicationScope.rootpath}addBdDictdetail.action?bdDictKey=${bdDictKey}" rel="dictDetailCardNav" target="navTab"  reloadFlag=1><span><s:text name="common.adddetail"/></span>
				</a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo" rel="selectIDS"
					postType="string" href="${applicationScope.rootpath}deleteBdDictdetail.action?navTabId=dictCardNav"
					class="delete"><span><s:text name="common.batchdel"/></span> </a>
			</li>
			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="188" nowrapTD="false" width="100%">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					<s:text name="dictdetail.code"/>
				</th>
				<th width="100">
					<s:text name="dictdetail.content"/>
				</th>
				<th width="80">
					默认值
				</th>
				<th width="100">
					备注
				</th>
				<th width="80">
					<s:text name="dictdetail.order"/>
				</th>
				<th width="80">
					<s:text name="common.validornot"/>
				</th>
				<th width="70">
					<s:text name="common.operate"/>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.bdDictdetailList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.code}
					</td>
					<td>
						${item.title}
					</td>
					<td>
						${item.value}
					</td>
					<td>
						${item.remark}
					</td>
					<td>
						${item.defaultorder}
					</td>
					<td>
						${item.isvalid} 
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteBdDictdetail.action?selectIDS=${item.id}&navTabId=dictCardNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text name="common.delete"/></span> </a>
						<a class="btnEdit" rel="dictDetailCardNav" href="${applicationScope.rootpath}editBdDictdetail.action?bdDictdetailKey=${item.id}&bdDictKey=${bdDictKey}"
							target="navTab"><span><s:text name="dictdetail.edit"/></span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
