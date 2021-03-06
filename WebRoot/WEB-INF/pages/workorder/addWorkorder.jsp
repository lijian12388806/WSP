<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
<!--
//初始化信息
$(document).ready(function() {
	_pageDown();
	});
	function _pageDown() {
		var callinno = '${workOrderForm.callerno}';
		var ucid = '${wo_ucid}';
		var $box = $("#jbsxBox_order_"+ucid);
		var ordercode = '${orderCode}';
		var ordersrc = '${ordersource}';
		var url;
		if(ordersrc != 'manual'){
			if(ordercode == 'wcl') url = "${applicationScope.rootpath}listworkoder_his.action?pageNum=1&numPerPage=20&his_N=${his_N}&querycallerno="+callinno+"&wo_ucid="+ucid;
			else url = "${applicationScope.rootpath}listOrderdealinfo.action?workOrderKey=${workOrderKey}&wo_ucid="+ucid;
			$box.loadUrl(url,null,function(){
				$box.find("[layoutH]").layoutH();
			});
		}
	}
//action
function checkaction(v){ 
	var tabId = '${tabId}';
	var af = $('#actionForm');
	var action = "${applicationScope.rootpath}saveWorkOrder.action?navTabId="+tabId+"&callbackType=closeCurrent&orderCode="
	if(v==0) af.attr('action',action+"yjd"); 
	else if(v == 1) af.attr('action',action+"dhxcl");
	else if(v == 2) af.attr('action',action+"dhxcl");
	else if(v == 3) af.attr('action',action+"ywc");
	af.submit(); 
}
//-->
</script>
<form method="post" action="" class="required-validate pageForm"
	onsubmit="return validateCallback(this, navTabAjaxDone);"
	id="actionForm">
	<input type="hidden" value="${workOrderKey}" id="workOrderKey" name="workOrderKey">
	<input type="hidden" value="${workOrderForm.temp8}" id="workOrderForm.temp8" name="workOrderForm.temp8">
	<input type="hidden" value="${workOrderForm.temp7}" id="workOrderForm.temp7" name="workOrderForm.temp7">
	<div class="lcp_div_left" style="width: 100%;">
		<div class="lcp_div_left" style="margin-top: 10px; width: 50%;">
			<table class="list" nowrapTD="false" width="98%"
				style="table-layout: fixed;">
				<tbody>
					<tr>
						<td align="right" width="20%" class="yahei">
							<c:if test="${ordersource == 'manual'}">电话号码:</c:if>
							<c:if test="${ordersource == 'callin'}">来电号码:</c:if>
							<c:if test="${ordersource == 'callout'}">外呼号码:</c:if>
						</td>
						<td align="left" width="80%">
							<c:choose>
								<c:when test="${ordersource != 'manual'}">
									<input name="workOrderForm.callerno"
										id="workOrderForm.callerno" class="required" maxlength="20"
										type="text" size="20" value="${workOrderForm.callerno}"
										readonly="readonly" />
								</c:when>
								<c:otherwise>
									<input name="workOrderForm.callerno"
										id="workOrderForm.callerno" class="required" maxlength="20"
										type="text" size="20" value="${workOrderForm.callerno}" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							工单编号:
						</td>
						<td align="left" width="80%">
							<c:choose>
								<c:when test="${ordersource != 'manual'}">
									<input name="workOrderForm.workorderno"
										id="workOrderForm.workorderno"
										value="${workOrderForm.workorderno}" maxlength="50"
										type="text" size="30" class="required" readonly="readonly"/>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							工单类型:
						</td>
						<td align="left" width="80%">
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
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							接听时间:
						</td>
						<td align="left" width="80%">
							<input name="workOrderForm.calltime" id="workOrderForm.calltime"
								value="${workOrderForm.calltime}" type="text" size="20"
								class="required date" format="yyyy-MM-dd HH:mm:ss" />
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							客户咨询内容:
						</td>
						<td align="left" width="80%">
							<textarea name="workOrderForm.consultcontent"
								id="workOrderForm.consultcontent" style="width:98%" rows="3">${workOrderForm.consultcontent}</textarea>
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							处理结果:
						</td>
						<td align="left" width="80%">
							<textarea name="workOrderForm.nextaction"
								id="workOrderForm.nextaction" style="width:98%" rows="2">${workOrderForm.nextaction}</textarea>
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							备注:
						</td>
						<td align="left" width="80%">
							<textarea name="workOrderForm.remark" id="workOrderForm.remark"
								style="width:98%" rows="2">${workOrderForm.remark}</textarea>
							<input name="workOrderForm.generatemode"
								id="workOrderForm.generatemode" type="hidden"
								value="${workOrderForm.generatemode}" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="lcp_div_left" style="margin-top: 10px; width: 50%;">
			<table class="list" nowrapTD="false" width="98%"
				style="table-layout: fixed;">
				<tbody>
					<tr>
						<td align="right" width="20%" class="yahei">
							客户名称 :
						</td>
						<td align="left" width="80%">
							<input name="workOrderForm.custlinkman"
								id="workOrderForm.custlinkman"
								value="${workOrderForm.custlinkman}" maxlength="50" type="text"
								size="20" class="required" lookupGroup="workOrderForm" />
							<a class="btnLook"
								href="${applicationScope.rootpath}lookUpCustomer.action?changeUrl=Y"
								lookupGroup="workOrderForm">查找带回</a>
							<input type="hidden" value="${workOrderForm.customerid}"
								id="workOrderForm.customerid" name="workOrderForm.customerid"
								lookupGroup="workOrderForm">
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							公司姓名:
						</td>
						<td align="left" width="80%">
							<input type="text" class="" name="workOrderForm.customername"
								value="${workOrderForm.customername}"
								lookupGroup="workOrderForm" size="20" />
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							性别 :
						</td>
						<td align="left" width="80%">
							<select name="workOrderForm.infosource" class=""
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
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							联系电话:
						</td>
						<td align="left" width="80%">
							<input name="workOrderForm.custphoneno"
								id="workOrderForm.custphoneno" class="" maxlength="100"
								type="text" size="20" value="${workOrderForm.custphoneno}"
								lookupGroup="workOrderForm"/>
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							QQ号码:
						</td>
						<td align="left" width="80%">
							<input name="workOrderForm.temp1" id="workOrderForm.temp1"
								class="phone" maxlength="100" type="text" size="20"
								value="${workOrderForm.temp1}" lookupGroup="workOrderForm" />
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							电子邮箱地址:
						</td>
						<td align="left" width="80%">
							<input name="workOrderForm.emailaddr"
								id="workOrderForm.emailaddr" class="email" maxlength="100"
								type="text" size="20" value="${workOrderForm.emailaddr}"
								lookupGroup="workOrderForm" />
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							所属城市:
						</td>
						<td align="left" width="80%">
							<input name="workOrderForm.netherlands"
								id="workOrderForm.netherlands" class="" maxlength="50"
								type="text" size="20" value="${workOrderForm.netherlands}"
								lookupGroup="workOrderForm" />
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							新客户 :
						</td>
						<td align="left" width="80%">
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
							<span style="color: red">*</span>
						</td>
					</tr>
					<tr>
						<td align="right" width="20%" class="yahei">
							客户地址 :
						</td>
						<td align="left" width="80%">
							<textarea name="workOrderForm.custaddr"
								id="workOrderForm.custaddr" rows="2" maxlength="100" style="width:98%"
								lookupGroup="workOrderForm">${workOrderForm.custaddr}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="lcp_div_left" style="margin-top: 10px; width: 100%;">
		<table class="list" nowrapTD="false" width="98%"
			style="table-layout: fixed;">
			<tbody>
				<tr>
					<td align="right" width="50%">
						<c:if test="${orderCode == 'dhxcl'}">
							<button class="btn btn-mini btn-success" type="button"
								onclick="checkaction(2);">
								<i class="icon-ok-sign"></i><SPAN class="yahei"><s:text
										name="保存" /> </SPAN>
							</button>
							<button class="btn btn-mini btn-success" type="button"
								onclick="checkaction(3);">
								<i class="icon-ok-sign"></i><SPAN class="yahei"><s:text
										name="已完成" /> </SPAN>
							</button>
						</c:if>
						<c:if test="${orderCode == 'ywc'}">
							<button class="btn btn-mini btn-success" type="button"
								onclick="checkaction(3);">
								<i class="icon-ok-sign"></i><SPAN class="yahei"><s:text
										name="保存" /> </SPAN>
							</button>
						</c:if>
						<c:if test="${orderCode == 'wcl'}">
							<button class="btn btn-mini btn-success" type="button"
								onclick="checkaction(1);">
								<i class="icon-ok-sign"></i><SPAN class="yahei"><s:text
										name="后续处理" /> </SPAN>
							</button>
						</c:if>
						<c:if test="${orderCode != 'all'}">
						<button class="btn btn-mini btn-success" type="button"
							onclick="checkaction(0);">
							<i class="icon-ok-sign"></i><SPAN class="yahei"><s:text
									name="结单" /> </SPAN>
						</button>
						</c:if>
						<button class="btn btn-mini btn-primary close"  type="button">
							<i class="icon-remove-sign"></i><SPAN class="yahei">关闭</SPAN>
						</button>
					</td>
					<td align="center" width="50%">
						<em>实际接单人账号 : </em>
						<input name="workOrderForm.actusername"
							id="workOrderForm.actusername" class="required" maxlength="50"
							type="text" size="30" value="${workOrderForm.actusername}" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</form>
<div id="jbsxBox_order_${wo_ucid}" class="unitBox"></div>