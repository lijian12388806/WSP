<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
<!--
function checkaction(v){ 
	if(v==0){ 
	document.getElementById("actionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderwclLiNav&callbackType=closeCurrent&orderCode=yjd"; 
	}else if(v == 1){ 
	document.getElementById("actionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderwclLiNav&callbackType=closeCurrent&orderCode=dhxcl"; 
	}else if(v == 2){
	document.getElementById("actionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderLiNav&callbackType=closeCurrent&orderCode=ywc";
		}
	$('#actionForm').submit(); 
	} 
//-->
</script>
<div class="pageContent">
	<form method="post" action="" class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);"
		id="actionForm">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<c:choose>
					<c:when test="${ordersource != 'manual'}">
						<p>
							<label>
								来电号码：
							</label>
							<input name="workOrderForm.callerno" id="workOrderForm.callerno"
								class="required" maxlength="20" type="text" size="30"
								value="${workOrderForm.callerno}" readonly="readonly" />
						</p>
					</c:when>
					<c:otherwise>
						<p>
							<label>
								来电号码：
							</label>
							<input name="workOrderForm.callerno" id="workOrderForm.callerno"
								class="required" maxlength="20" type="text" size="30"
								value="${workOrderForm.callerno}" />
						</p>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ordersource != 'manual'}">
						<p>
							<label>
								工单编号 ：
							</label>
							<input name="workOrderForm.workorderno"
								id="workOrderForm.workorderno"
								value="${workOrderForm.workorderno}" maxlength="50" type="text"
								size="30" class="required" />

						</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

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
					<input name="workOrderForm.calltime" id="workOrderForm.calltime"
						value="${workOrderForm.calltime}" type="text" size="20"
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
						公司姓名：
					</label>
					<input type="text" class="" name="workOrderForm.customername"
						value="${workOrderForm.customername}" lookupGroup="workOrderForm"
						size="30" />
				</p>
				<p>
					<label>
						性别 ：
					</label>
					<select name="workOrderForm.infosource" class=""
						lookupGroup="workOrderForm" >
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
						lookupGroup="workOrderForm" />
				</p>
				<p>
					<label>
						QQ号码 ：
					</label>
					<input name="workOrderForm.temp1" id="workOrderForm.temp1"
						class="phone" maxlength="100" type="text" size="30"
						value="${workOrderForm.temp1}" lookupGroup="workOrderForm" />
				</p>
				<p>
					<label>
						电子邮箱地址 ：
					</label>
					<input name="workOrderForm.emailaddr" id="workOrderForm.emailaddr"
						class="email" maxlength="100" type="text" size="30"
						value="${workOrderForm.emailaddr}" lookupGroup="workOrderForm" />
				</p>
				<p>
					<label>
						所属城市 ：
					</label>
					<input name="workOrderForm.netherlands"
						id="workOrderForm.netherlands" class="" maxlength="50" type="text"
						size="30" value="${workOrderForm.netherlands}"
						lookupGroup="workOrderForm" />
				</p>
<p>
				<label>
					新客户 ：
				</label>
				<select name="workOrderForm.isnew" class="required">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.syspara['yesornotPara']}"
						var="activeState">
						<c:choose>
							<c:when test="${workOrderForm.isnew == activeState.code}">
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
				<dl class="nowrap">
					<dt>
						客户地址 ：
					</dt>
					<dd>
						<textarea name="workOrderForm.custaddr"
							id="workOrderForm.custaddr" cols="80" rows="2" maxlength="100"
							lookupGroup="workOrderForm" >${workOrderForm.custaddr}</textarea>
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
						<div class="buttonContent">
							<button type="button" onclick="checkaction(0);">
								结单
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="buttonActive">
						<div class="buttonContent" onclick="checkaction(1);">
							<button type="button">
								后续处理
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</form>
</div>