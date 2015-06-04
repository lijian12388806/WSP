<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
<!--
function checkaction(v){ 
	if(v==0){ 
	document.getElementById("newactionForm").action="${applicationScope.rootpath}savenewWorkOrder.action?navTabId=workorderwclLiNav&callbackType=closeCurrent&orderCode=yjd"; 
	}else if(v == 1){ 
	document.getElementById("newactionForm").action="${applicationScope.rootpath}savenewWorkOrder.action?navTabId=workorderwclLiNav&callbackType=closeCurrent&orderCode=dhxcl"; 
	}else if(v == 2){
	document.getElementById("newactionForm").action="${applicationScope.rootpath}savenewWorkOrder.action?navTabId=workorderLiNav&callbackType=closeCurrent&orderCode=ywc";
		}
	$('#newactionForm').submit(); 
	} 
//-->
</script>

<form method="post" action="" class="required-validate pageForm"
	onsubmit="return validateCallback(this, navTabAjaxDone);"
	id="newactionForm">
	<div class="pageFormContent" layoutH="56">
		<fieldset>
			<c:choose>
				<c:when test="${ordersource != 'manual'}">
					<p>
						<label>
							来电号码：
						</label>
						<input name="newworkOrderForm.callerno"
							id="newworkOrderForm.callerno" class="required" maxlength="20"
							type="text" size="30" value="${newworkOrderForm.callerno}"
							readonly="readonly" />
					</p>
				</c:when>
				<c:otherwise>
					<p>
						<label>
							来电号码：
						</label>
						<input name="newworkOrderForm.callerno"
							id="newworkOrderForm.callerno" class="required" maxlength="20"
							type="text" size="30" value="${newworkOrderForm.callerno}" />
					</p>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${ordersource != 'manual'}">
					<p>
						<label>
							工单编号 ：
						</label>
						<input name="newworkOrderForm.workorderno"
							id="newworkOrderForm.workorderno"
							value="${newworkOrderForm.workorderno}" maxlength="50"
							type="text" size="30" class="required" />
					</p>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<p>
				<label>
					工单类型 ：
				</label>
				<select name="newworkOrderForm.ordertype" class="required combox">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.dictpara['OrderType']}"
						var="activeState">
						<c:choose>
							<c:when test="${newworkOrderForm.ordertype == activeState.code}">
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
				<input name="newworkOrderForm.calltime"
					id="newworkOrderForm.calltime" value="${newworkOrderForm.calltime}"
					type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss"
					readonly />
			</p>
			<dl class="nowrap">
				<dt>
					客户咨询内容 ：
				</dt>
				<dd>
					<textarea name="newworkOrderForm.consultcontent"
						id="newworkOrderForm.consultcontent" cols="80" rows="2">${newworkOrderForm.consultcontent}</textarea>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>
					处理结果 ：
				</dt>
				<dd>
					<textarea name="newworkOrderForm.nextaction"
						id="newworkOrderForm.nextaction" cols="80" rows="2">${newworkOrderForm.nextaction}</textarea>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>
					备注 ：
				</dt>
				<dd>
					<textarea name="newworkOrderForm.remark"
						id="newworkOrderForm.remark" cols="80" rows="2">${newworkOrderForm.remark}</textarea>
					<input name="newworkOrderForm.generatemode"
						id="newworkOrderForm.generatemode" type="hidden"
						value="${newworkOrderForm.generatemode}" />
				</dd>
			</dl>
		</fieldset>
		<fieldset>
			<p>
				<label>
					客户名称 ：
				</label>
				<input name="newworkOrderForm.custlinkman"
					id="newworkOrderForm.custlinkman"
					value="${newworkOrderForm.custlinkman}" maxlength="50" type="text"
					size="30" class="required" lookupGroup="newworkOrderForm" />
				<a class="btnLook"
					href="${applicationScope.rootpath}lookUpCustomer.action?changeUrl=Y"
					lookupGroup="newworkOrderForm">查找带回</a>
				<input type="hidden" value="${newworkOrderKey}" id="newworkOrderKey"
					name="newworkOrderKey">
				<input type="hidden" value="${newworkOrderForm.customerid}"
					id="newworkOrderForm.customerid" name="newworkOrderForm.customerid"
					lookupGroup="workOrderForm">
			</p>
			<p>
				<label>
					公司姓名：
				</label>
				<input type="text" class="" name="newworkOrderForm.customername"
					value="${newworkOrderForm.customername}"
					lookupGroup="newworkOrderForm" size="30" />

			</p>
			<p>
				<label>
					性别 ：
				</label>
				<select name="newworkOrderForm.infosource" class=""
					lookupGroup="newworkOrderForm">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.dictpara['Gender']}"
						var="activeState">
						<c:choose>
							<c:when test="${newworkOrderForm.infosource == activeState.code}">
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
				<input name="newworkOrderForm.custphoneno"
					id="newworkOrderForm.custphoneno" class="" maxlength="100"
					type="text" size="30" value="${newworkOrderForm.custphoneno}"
					lookupGroup="newworkOrderForm" />
			</p>
			<p>
				<label>
					QQ号码 ：
				</label>
				<input name="newworkOrderForm.temp1" id="newworkOrderForm.temp1"
					class="phone" maxlength="100" type="text" size="30"
					value="${newworkOrderForm.temp1}" lookupGroup="newworkOrderForm" />
			</p>
			<p>
				<label>
					电子邮箱地址 ：
				</label>
				<input name="newworkOrderForm.emailaddr"
					id="newworkOrderForm.emailaddr" class="email" maxlength="100"
					type="text" size="30" value="${newworkOrderForm.emailaddr}"
					lookupGroup="newworkOrderForm" />
			</p>
			<p>
				<label>
					所属城市 ：
				</label>
				<input name="newworkOrderForm.netherlands"
					id="newworkOrderForm.netherlands" class="" maxlength="50"
					type="text" size="30" value="${newworkOrderForm.netherlands}"
					lookupGroup="newworkOrderForm" />
			</p>
			<p>
				<label>
					新客户 ：
				</label>
				<select name="newworkOrderForm.isnew" class="required">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.syspara['yesornotPara']}"
						var="activeState">
						<c:choose>
							<c:when test="${newworkOrderForm.isnew == activeState.code}">
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
					<textarea name="newworkOrderForm.custaddr"
						id="newworkOrderForm.custaddr" cols="80" rows="2" maxlength="100"
						lookupGroup="newworkOrderForm">${newworkOrderForm.custaddr}</textarea>
				</dd>
			</dl>
		</fieldset>
	</div>

	<div class="formBar">
		<ul>
			<li>
				<div align="left">
					<em>实际接单人账号 : </em>
					<input name="newworkOrderForm.actusername"
						id="newworkOrderForm.actusername" class="required" maxlength="50"
						type="text" size="30" value="${newworkOrderForm.actusername}" />
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