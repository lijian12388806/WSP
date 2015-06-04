<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
<!--
function checkaction(v){ 
	if(v==0){ 
	document.getElementById("allactionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderywcLiNav&callbackType=closeCurrent&orderCode=yjd"; 
	}else if(v == 1){ 
	document.getElementById("allactionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderywcLiNav&callbackType=closeCurrent&orderCode=ywc"; 
	}else if(v == 2){
	document.getElementById("allactionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderywcLiNav&callbackType=closeCurrent&orderCode=ywc";
		}
	$('#allactionForm').submit(); 
	} 
//-->
</script>
<div class="pageContent">
	<form method="post" action="" class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);"
		id="allactionForm">
		<div class="pageFormContent" layoutH="200">
			<fieldset>
				<p>
					<label>
						来电号码 ：
					</label>
					${workOrderForm.callerno}
					<input name="workOrderForm.callerno" id="workOrderForm.callerno" type="hidden"
						value="${workOrderForm.callerno}" />
				</p>
				<p>
					<label>
						
					</label>
				</p>
				<p>
					<label>
						工单编号 ：
					</label>
					${workOrderForm.workorderno}
					
					<input name="workOrderForm.workorderno" id="workOrderForm.workorderno"  type="hidden"
						value="${workOrderForm.workorderno}" />
				</p>
				<p>
					<label>
						工单类型 ：
					</label>
					<select name="workOrderForm.ordertype" class="required combox">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['OrderType']}"
							var="activeState">
							<c:choose>
								<c:when test="${workOrderForm.ordertype == activeState.code}">
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
					<span style="color: red">*</span>
				</p>
				<p>
					<label>
						接听时间：
					</label>
					${workOrderForm.calltime}
					<input name="workOrderForm.calltime" id="workOrderForm.calltime"
						value="${workOrderForm.calltime}" type="hidden" size="30"
						class="date" format="yyyy-MM-dd HH:mm:ss" />
				</p>
				<dl class="nowrap">
					<dt>
						客户咨询内容 ：
					</dt>
					<dd>
						<textarea name="workOrderForm.consultcontent"
							id="workOrderForm.consultcontent" cols="80" rows="2">${workOrderForm.consultcontent}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						处理结果 ：
					</dt>
					<dd>
						<textarea name="workOrderForm.nextaction"
							id="workOrderForm.nextaction" cols="80" rows="2">${workOrderForm.nextaction}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						备注 ：
					</dt>
					<dd>
						<textarea name="workOrderForm.remark" id="workOrderForm.remark"
							cols="80" rows="2">${workOrderForm.remark}</textarea>
						<input name="workOrderForm.generatemode"
							id="workOrderForm.generatemode" type="hidden"
							value="${workOrderForm.generatemode}" />
					</dd>
				</dl>
			</fieldset>
			<fieldset>
				<p>
					<label>
						客户名称 ：
					</label>
					<input name="workOrderForm.custlinkman"
					id="workOrderForm.custlinkman"
					value="${workOrderForm.custlinkman}" maxlength="50" type="text"
					size="30" class="required" lookupGroup="workOrderForm" />
					<a class="btnLook"
						href="${applicationScope.rootpath}lookUpCustomer.action?changeUrl=Y"
						lookupGroup="workOrderForm">查找带回</a>
					<input type="hidden" value="${workOrderKey}" id="workOrderKey"
						name="workOrderKey">
					<input type="hidden" value="${workOrderForm.customerid}"
						id="workOrderForm.customerid" name="workOrderForm.customerid"
						lookupGroup="workOrderForm">
				</p>
				<p>
					<label>
						公司名称：
					</label>
					<input type="text" class="" name="workOrderForm.customername"
					value="${workOrderForm.customername}"
					lookupGroup="workOrderForm" size="30" disabled/>
				</p>
				<p>
					<label>
						性别 ：
					</label>
					<select name="workOrderForm.infosource" class="" disabled="disabled"
						lookupGroup="workOrderForm">
						<option value="">
							<s:text name="common.listbox" />
						</option>
						<c:forEach items="${applicationScope.dictpara['Gender']}"
							var="activeState">
							<c:choose>
								<c:when test="${workOrderForm.infosource == activeState.code}">
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
						联系电话 ：
					</label>
					<input name="workOrderForm.custphoneno"
						id="workOrderForm.custphoneno" class="" maxlength="100"
						type="text" size="30" value="${workOrderForm.custphoneno}"
						lookupGroup="workOrderForm" readonly="readonly"/>
				</p>
				<p>
					<label>
						QQ号码 ：
					</label>
					<input name="workOrderForm.temp1" id="workOrderForm.temp1"
						class="phone" maxlength="100" type="text" size="30"
						value="${workOrderForm.temp1}" lookupGroup="workOrderForm" readonly="readonly"/>
				</p>
				<p>
					<label>
						电子邮箱地址 ：
					</label>
					<input name="workOrderForm.emailaddr" id="workOrderForm.emailaddr"
						class="email" maxlength="100" type="text" size="30"
						value="${workOrderForm.emailaddr}" lookupGroup="workOrderForm" readonly="readonly"/>
				</p>
				<p>
					<label>
						所属城市 ：
					</label>
					<input name="workOrderForm.netherlands"
						id="workOrderForm.netherlands" class="" maxlength="50" type="text"
						size="30" value="${workOrderForm.netherlands}"
						lookupGroup="workOrderForm" readonly="readonly"/>
				</p>
				<dl class="nowrap">
					<dt>
						客户地址 ：
					</dt>
					<dd>
						<textarea name="workOrderForm.custaddr"
							id="workOrderForm.custaddr" cols="80" rows="2" maxlength="100"
							lookupGroup="workOrderForm" readonly="readonly">${workOrderForm.custaddr}</textarea>
					</dd>
				</dl>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div align="left">
						<em>实际接单人账号 : </em>
						<input name="workOrderForm.actusername"
							id="workOrderForm.actusername" class="required" maxlength="50"
							type="text" size="30" value="${workOrderForm.actusername}" />
					</div>
				</li>
				<li>
					<div class="buttonActive">
						<div class="buttonContent" onclick="checkaction(1);">
							<button type="button">
								保存
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="button" onclick="checkaction(0);">
								结单
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</form>
</div>
<div class="pageContent"
	<c:if test="${empty workOrderKey || orderCode == 'wcl'}">style="display:none"</c:if>>
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addYwcOrderdealinfo.action?workOrderKey=${workOrderKey}&pageflag=all"
					rel="addYwcOrderdealinfoCardNav" target="navTab" reloadFlag=1><span>处理工单
				</span> </a>
			</li>

			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteOrderdealinfo.action?navTabId=workorderCardNav"
					class="delete"><span>批量删除</span> </a>
			</li>

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="380" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					工单编号
				</th>
				<th width="100">
					问题部门
				</th>
				<th width="100">
					问题部门处理人
				</th>
				<th width="100">
					问题责任人
				</th>
				<th width="100">
					问题描述
				</th>
				<th width="100">
					问题原因
				</th>
				<th width="100">
					处理情况
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
			<c:forEach var="item" items="${sessionScope.orderdealList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.workorderno}
					</td>
					<td>
						${item.prodepartment}
					</td>
					<td>
						${item.depdealman}
					</td>
					<td>
						${item.assignperson}
					</td>
					<td>
						${item.prodesc}
					</td>
					<td>
						${item.proreason}
					</td>
					<td>
						${item.prosituation}
					</td>
					<td>
						${item.remark}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteOrderdealinfo.action?selectIDS=${item.id}&navTabId=workorderCardNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
									name="common.delete" /> </span> </a>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editYwcOrderdealinfo.action?orderdealinfoKey=${item.id}&workOrderKey=${workOrderKey}&pageflag=all"
							target="navTab" rel="editYwcOrderdealinfoCardNav" reloadFlag=1
							title="处理信息"><span>修改工单 </span> </a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>