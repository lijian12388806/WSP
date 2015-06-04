<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveBdDict.action?navTabId=dictLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="300">
			<p>
				<label>
					工单编号
					：
				</label>
				<input name="workOrderForm.workorderno"
					id="workOrderForm.workorderno" value="${workOrderForm.workorderno}"
					maxlength="50" type="text" size="30" class="required" readonly="readonly"
					/>
				<input type="hidden" value="${workOrderKey}" id="workOrderKey"
					name="workOrderKey">
			</p>
			<p>
				<label>
					客户名称
					：
				</label>
				<input type="text" class="required" name="workOrderForm.customername"
					value="${workOrderForm.customername}" lookupGroup="workOrderForm" readonly="readonly"/>
				<a class="btnLook"
					href="${applicationScope.rootpath}lookUpCustomer.action?changeUrl=Y"
					lookupGroup="workOrderForm">查找带回</a>
			</p>
			<p>
				<label>
					客户编码
					：
				</label>
				<input name="workOrderForm.customerno" id="workOrderForm.customerno"
					class="required" maxlength="30" type="text" size="30" readonly="readonly"
					value="${workOrderForm.customerno}"/>
			</p>
			<p>
				<label>
					工单类型
					：
				</label>
				<select name="workOrderForm.ordertype" class="required combox" readonly="readonly">
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
			</p>
			<p>
				<label>
					工单来源
					：
				</label>
				<select name="workOrderForm.ordersource" class="required combox" readonly="readonly">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.dictpara['SourceOrder']}"
						var="activeState">
						<c:choose>
							<c:when test="${workOrderForm.ordersource == activeState.code}">
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
					项目类型
					：
				</label>
				<select name="workOrderForm.projecttype" class="required combox" readonly="readonly">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.dictpara['Projecttype']}"
						var="activeState">
						<c:choose>
							<c:when test="${workOrderForm.projecttype == activeState.code}">
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
					工作内容
					：
				</label>
				<select name="workOrderForm.workitem" class="required combox" readonly="readonly">
					<option value="">
						<s:text name="common.listbox" />
					</option>
					<c:forEach items="${applicationScope.dictpara['Order']}"
						var="activeState">
						<c:choose>
							<c:when test="${workOrderForm.workitem == activeState.code}">
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
					项目名称
					：
				</label>
				<input name="workOrderForm.proname" id="workOrderForm.proname"
					class="required" maxlength="50" type="text" size="30" readonly="readonly"
					value="${workOrderForm.proname}" />
			</p>
			<p>
				<label>
					项目代码
					：
				</label>
				<input name="workOrderForm.procode" id="workOrderForm.procode"
					class="required" maxlength="50" type="text" size="30" readonly="readonly"
					value="${workOrderForm.procode}" />
			</p>


			<p>
			<dl class="nowrap">
				<dt>
					客户咨询内容
					：
				</dt>
				<dd>
					<textarea name="workOrderForm.consultcontent" readonly="readonly"
						id="workOrderForm.consultcontent" cols="80" rows="5">${workOrderForm.consultcontent}</textarea>
				</dd>
			</dl>
			</p></div>
<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
								已完成
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								结单
							</button>

						</div>
					</div>
				</li>
			</ul>
		</div>
		</div>

		<div class="pageContent">
			<div class="panelBar">
				<ul class="toolBar">
					<li>
						<a class="add"
							href="${applicationScope.rootpath}addOrderdealinfo.action"
							rel="orderdeakinfoCardNav" target="navTab" reloadFlag=1><span>工单处理
						</span> </a>
					</li>
					<li>
						<a title="<s:text name="common.askdel"/>" target="selectedTodo"
							rel="selectIDS" postType="string"
							href="${applicationScope.rootpath}deleteBdDictdetail?navTabId=dictCardNav"
							class="delete"><span><s:text name="common.batchdel" />
						</span> </a>
					</li>
					<li class="line">
						line
					</li>
				</ul>
			</div>
			<table class="table" layoutH="138" nowrapTD="false" width="100%">
				<thead>
					<tr>
						<th width="22">
							<input type="checkbox" group="selectIDS" class="checkboxCtrl">
						</th>
						<th width="100">
							<s:text name="工单编号" />
						</th>
						<th width="100">
							<s:text name="问题部门" />
						</th>
						<th width="80">
							<s:text name="问题部门处理人" />
						</th>
						<th width="80">
							<s:text name="问题责任人" />
						</th>
						<th width="80">
							<s:text name="问题描述" />
						</th>
						<th width="80">
							<s:text name="问题原因" />
						</th>
						<th width="80">
							<s:text name="处理情况" />
						</th>
						<th width="70">
							<s:text name="common.operate" />
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
								${item.defaultorder}
							</td>
							<td>
								${item.isvalid}
							</td>
							<td>
								<a class="btnDel"
									href="${applicationScope.rootpath}deleteBdDictdetail?selectIDS=${item.id}&navTabId=dictCardNav"
									target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
											name="common.delete" />
								</span> </a>
								<a class="btnEdit" rel="dictDetailCardNav"
									href="${applicationScope.rootpath}editBdDictdetail.action?bdDictdetailKey=${item.id}&bdDictKey=${bdDictKey}"
									target="navTab"><span><s:text name="dictdetail.edit" />
								</span> </a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>