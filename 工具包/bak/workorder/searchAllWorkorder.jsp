<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!--<script type="text/javascript">

function checkaction(v){ 
	if(v==0){ 
	document.getElementById("allactionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderallLiNav&callbackType=closeCurrent&orderCode=yjd"; 
	}else if(v == 1){ 
	document.getElementById("allactionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderallLiNav&callbackType=closeCurrent&orderCode=dhxcl"; 
	}else if(v == 2){
	document.getElementById("allactionForm").action="${applicationScope.rootpath}saveWorkOrder.action?navTabId=workorderallLiNav&callbackType=closeCurrent&orderCode=ywc";
		}
	$('#allactionForm').submit(); 
	} 

</script>-->
<div class="pageContent">
		<div class="pageFormContent" layoutH="150">
			<fieldset>
				<p>
					<label>
						来电号码 ：
					</label>
					${workOrderForm.callerno}
				</p>
				<p>
					<label>
						工单编号 ：
					</label>
					${workOrderForm.workorderno}
				</p>

				<p>
					<label>
						工单类型 ：
					</label>
					
						<c:forEach items="${applicationScope.dictpara['OrderType']}"
							var="activeState">
								<c:if test="${workOrderForm.ordertype == activeState.code}">
									<option value="${activeState.code}" selected>
										${activeState.title}
									</option>
								</c:if>
						</c:forEach>
				</p>
				<p>
					<label>
						接听时间：
					</label>
					${workOrderForm.calltime}
				</p>
				<dl class="nowrap">
					<dt>
						客户咨询内容 ：
					</dt>
					<dd>
						${workOrderForm.consultcontent}
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						处理结果 ：
					</dt>
					<dd>
						${workOrderForm.nextaction}
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>
						备注 ：
					</dt>
					<dd>
						${workOrderForm.remark}
					</dd>
				</dl>
			</fieldset>
			<fieldset>
				<p>
					<label>
						客户名称：
					</label>
					${workOrderForm.custlinkman}
					<input type="hidden" value="${workOrderKey}" id="workOrderKey"
						name="workOrderKey">
				</p>
				<p>
					<label>
						公司名称 ：
					</label>
					${workOrderForm.customername}
					
				</p>
				<p>
					<label>
						性别 ：
					</label>
						<c:forEach items="${applicationScope.dictpara['Gender']}"
							var="activeState">
								<c:if test="${workOrderForm.infosource == activeState.code}">
									<option value="${activeState.code}" selected>
										${activeState.title}
									</option>
								</c:if>
						</c:forEach>
				</p>
				<p>
					<label>
						联系电话 ：
					</label>
					${workOrderForm.custphoneno}
				</p>
				<p>
					<label>
						QQ号码 ：
					</label>
					${workOrderForm.temp1}
				</p>
				<p>
					<label>
						电子邮箱地址 ：
					</label>
					${workOrderForm.emailaddr}
				</p>
				<p>
					<label>
						所属城市 ：
					</label>
					${workOrderForm.netherlands}
				</p>
				<dl class="nowrap">
					<dt>
						客户地址 ：
					</dt>
					<dd>
						${workOrderForm.custaddr}
					</dd>
				</dl>
			</fieldset>
		</div>
		<div class="formBar" align="center">
			<ul>
				<li>
					<div>
						
					</div>
				</li>
<li> <div></div> </li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								关闭
							</button>
						</div>
					</div>
				</li>
<li></li><li></li><li></li><li></li><li></li><li></li>
			</ul>
		</div>
</div>
<div class="pageContent">
	<table class="table" layoutH="480" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
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
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.orderdealList}">
				<tr target="slt_uid" rel="${item.id}">
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>