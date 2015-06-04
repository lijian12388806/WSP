<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListWorkstation.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ListWorkstation.action?search=true"
		method="post" name="ListWorkstation">
		<div class="searchBar">
			<table class="searchContent">
				<tr>

					<td>
						工厂名称
						:
						<input name="queryfactorynamecn" type="text" id="queryfactorynamecn"
							size="15" style="WIDTH: 94px" value="${queryfactorynamecn}"
							onkeydown="" />
					</td>
					<td>
						工厂英文名称
						:
						<input name="queryfactorynameen" type="text" id="queryfactorynameen"
							size="15" style="WIDTH: 94px" value="${queryfactorynameen}"
							onkeydown="" />
					</td>
<td>
						联系人
						:
						<input name="querywslinkman" type="text" id="querywslinkman"
							size="15" style="WIDTH: 94px" value="${querywslinkman}"
							onkeydown="" />
					</td>
					<td>
						联系电话
						:
						<input name="queryphoneno" type="text" id="queryphoneno"
							size="15" style="WIDTH: 94px" value="${queryphoneno}"
							onkeydown="" />
					</td>
					<td>
						<div class="subBar">
							<ul>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">
												<s:text name="common.search" />
											</button>
										</div>
									</div>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="button" onclick="getValue(document.forms['ListWorkstation']);">
												<s:text name="common.clean" />
											</button>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add"
					href="${applicationScope.rootpath}addWorkstation.action"
					rel="addworkstationCardNav" target="navTab" reloadFlag=1><span><s:text
							name="添加" /> </span> </a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}deleteWorkstation?navTabId=workstationLiNav"
					class="delete"><span><s:text name="批量删除" /> </span> </a>
			</li>

			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%" style="table-layout: fixed">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="100">
					工厂名称
				</th>
				<th width="100">
					工厂英文名称
				</th>

				<th width="100">
					工厂联系电话
				</th>
				<th width="100">
					联系人
				</th>
				<th width="100">
					联系人邮箱
				</th>
				<th width="100">
					工厂地址
				</th>
<th width="100">
					备注
				</th>
				<th width="70">
							<s:text name="common.operate" />
						</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.workstationList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						${item.factorynamecn}
					</td>
					<td>
						${item.factorynameen}
					</td>
					<td>
						${item.phoneno}
					</td>
					<td>
						${item.wslinkman}
					</td>
					<td>
						${item.wsemail}
					</td>
					<td>
						${item.wsaddr}
					</td>
<td>
						${item.remark}
					</td>
					<td>
						<a class="btnDel"
							href="${applicationScope.rootpath}deleteWorkstation?selectIDS=${item.id}&navTabId=workstationLiNav"
							target="ajaxTodo" title="<s:text name="common.askdel"/>"><span><s:text
									name="common.delete" /> </span> </a>
						<a class="btnEdit"
								href="${applicationScope.rootpath}editWorkstation?workstationKey=${item.id}"
								target="navTab" rel="workstationCardNav" reloadFlag=1
								title="工厂信息修改"><span>工厂信息修改</span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>

</div>
