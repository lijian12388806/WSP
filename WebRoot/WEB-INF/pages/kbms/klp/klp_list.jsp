<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	onsubmit="return divSearch(this,'jbsxBox');"
	action="${applicationScope.rootpath}listKbmsKlp.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
	<!-- 查询条件 -->
</form>
<form onsubmit="return divSearch(this,'jbsxBox');"
	action="listKbmsKlp.action?kbmsClassKey=${kbmsClassKey}" method="post"
	name="listKbmsKlp">
	<div class="searchBar">
		关键词:
		<input name="queryname" type="text" id="queryname" size="15"
			style="WIDTH: 94px" value="${queryname}" />
		<button type="submit" class="btn btn-mini">
			检索
		</button>
		<button type="button" class="btn btn-mini"
			onclick="javascript: getValue(document.forms['listKbmsKlp']);">
			清除
		</button>
	</div>
</form>
<div class="pageContent" style="margin-top: 10px;">
	<div class="panelBar">
		<ul class="toolBar">
			<c:if
				test="${not empty kbmsClassKey && fn:contains(kbmsClassKey,'000000000')}">
				<li>
					<a class="add"
						href="${applicationScope.rootpath}addKbmsKlp.action?kbmsClassKey=${kbmsClassKey}"
						rel="addKbmsKlpCardNav" target="dialog" reloadFlag=1 width="1024"
						height="472" mask="true"><span>添加</span> </a>
				</li>
			</c:if>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}editKbmsKlp.action?kbmsKlpKey={slt_uid}"
					rel="addKbmsKlpCardNav" target="dialog" reloadFlag=1 width="1024"
					height="472" mask="true"><span>修改</span> </a>
			</li>
			<li>
				<a title="<s:text name="common.askdel"/>" target="selectedTodo"
					rel="selectIDS" postType="string"
					href="${applicationScope.rootpath}delKbmsKlp.action?navTabId=kbmsclassLiNav"
					class="delete"><span>批量删除</span> </a>
			</li>
			<li>
				<a class="edit"
					href="${applicationScope.rootpath}uploadKbmsKlp.action?kbmsKlpKey={slt_uid}"
					rel="addKbmsKlpCardNav" target="dialog" reloadFlag=1 mask="true"><span>添加附件</span> </a>
			</li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		style="table-layout: fixed">
		<thead>
			<tr>
				<th width="2%">
					<input type="checkbox" group="selectIDS" class="checkboxCtrl">
				</th>
				<th width="20%">
					知识点
				</th>
				<th width="20%">
					类别
				</th>
				<th width="10%">
					发布日期
				</th>
				<th width="10%">
					更新日期
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${KbmsKlp_list}">
				<tr target="slt_uid" rel="${item.id}">
					<td>
						<input name="selectIDS" value="${item.id}" type="checkbox">
					</td>
					<td>
						<a class=""
							href="${applicationScope.rootpath}detailsKbmsKlp.action?kbmsKlpKey=${item.id}"
							rel="addKbmsKlpCardNav" target="dialog" reloadFlag=1 width="1024"
							height="472" mask="true"><span style="color: blue">${item.name}</span>
						</a>
					</td>
					<td>
						${item.kind}
					</td>
					<td>
						<fmt:formatDate value="${item.createdate}" pattern="yyyy-MM-dd" />
					</td>
					<td>
						<fmt:formatDate value="${item.modifydate}" pattern="yyyy-MM-dd" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<jsp:include page="/WEB-INF/pages/common/panelBarBox.jsp"></jsp:include>
</div>
