<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}listWorkratioReport.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
<!-- 查询条件 -->
	<input type="hidden" value="${queryareaStart}" id="queryareaStart"
		name="queryareaStart">
	<input type="hidden" value="${queryareaEnd}" id="queryareaEnd"
		name="queryareaEnd">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListWorkratioReport.action" method="post" name="listWorkratioReport">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						统计时间:
						<input name="queryareaStart" id="queryareaStart" value="${queryareaStart}"
							type="text" size="20" class="date" format="yyyy-MM-dd"
							yearstart="0" yearend="100" />
					</td>
					<td>
						到:
						<input name="queryareaEnd" id="queryareaEnd" value="${queryareaEnd}"
							type="text" size="20" class="date" format="yyyy-MM-dd"
							yearstart="0" yearend="100" />
					</td>
					<td>
						<div class="subBar">
							<ul>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">
												检索
											</button>
										</div>
									</div>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="button"
												onclick="getValue(document.forms['listWorkratioReport']);">
												清除
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
			<li><a class="icon" href="${applicationScope.rootpath}download.action?loadflag=wo&fileName=${fileName}" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="116" nowrapTD="false" width="100%">
		<thead>
			<tr>
				<th width="100">
					客服专员
				</th>
				<th width="100">
					总单量
				</th>
				<th width="100">
					结单量
				</th>
				<th width="100">
					结单率
				</th>
				<th width="100">
					总耗时（分钟）
				</th>
				<th width="100">
					平均耗时（分钟）
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.countFormList}">
				<tr>
					<td>
						${item.userName}
					</td>
					<td>
						${item.totalCount}
					</td>
					<td>
						${item.closeCount}
					</td>
					<td>
						${item.ratio}
					</td>
					<td>
						${item.totalTime}
					</td>
					<td>
						${item.aveTime}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
