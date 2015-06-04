<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form id="pagerForm" method="post"
	action="${applicationScope.rootpath}ListIvrvoice.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection"
		value="${param.orderDirection}" />
<!-- 查询条件 -->
	<input type="hidden" value="${querycallerid}" id="querycallerid"
		name="querycallerid">
	<input type="hidden" value="${queryfactory}" id="queryfactory"
		name="queryfactory">
	<input type="hidden" value="${startdate1}" id="startdate1"
		name="startdate1">
	<input type="hidden" value="${stopdate1}" id="stopdate1"
		name="stopdate1">
	<input type="hidden" value="${querydnis}"
		id="querydnis" name="querydnis">

<input type="hidden" value="${startdate2}" id="startdate2"
		name="startdate2">
	<input type="hidden" value="${stopdate2}" id="stopdate2"
		name="stopdate2">
	<input type="hidden" value="${queryStatus}"
		id="queryStatus" name="queryStatus">
</form>
<script language="JavaScript"
	src="${applicationScope.rootpath}scripts/formcheck.js"></script>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="ListIvrvoice.action?search=true" method="post"
		name="ListIvrvoice">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						来电号码：
						<input type="text" name="querycallerid" id="querycallerid" value="${querycallerid}"
							maxlength="20" />
					</td>
					<td>
						开始时间 ：
						<input name="startdate1" id="startdate1" value="${startdate1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span><s:text name="syslog.dao" /> </span>
						<input name="stopdate1" id="stopdate1" value="${stopdate1}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
					</td><td>
						结束时间 ：
						<input name="startdate2" id="startdate2" value="${startdate2}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
						<span><s:text name="syslog.dao" /> </span>
						<input name="stopdate2" id="stopdate2" value="${stopdate2}"
							type="text" size="20" class="date" format="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<td>
						被叫号码：
						<input type="text" name="querydnis" value="${querydnis}"
							maxlength="20" />
					</td>
					<td>
						处理状态：
						<select name="queryStatus">
							<option value="">
								<s:text name="common.listbox" />
							</option>
							<option value="0" <c:if test="${ queryStatus =='0' }">selected</c:if>>
								未处理
							</option>
							<option value="1" <c:if test="${ queryStatus =='1' }">selected</c:if>>
								已处理
							</option>
						</select>
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
											<button type="button"
												onclick="getValue(document.forms['ListIvrvoice']);">
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
	<table class="table" layoutH="116" nowrapTD="false" width="100%"
		asc="asc" desc="desc" style="table-layout: fixed">
		<thead>
			<tr>
				<th width="100">
					来电号码
				</th>
				<th width="100">
					被叫号码
				</th>
				<th width="100">
					开始时间
				</th>
				<th width="100">
					结束时间
				</th>
				<th width="100">
					处理状态
				</th>
				<th width="100">
					处理人
				</th>
				<th width="70">
					<s:text name="common.operate" />
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${sessionScope.ivrvoiceList}">
				<tr target="slt_uid" rel="">
					<td>
						${item.callerid}
					</td>
					<td>
						${item.dnis}
					</td>
					<td>
					${item.starttime}
						
					</td>
					<td>
					${item.endtime}
						
					</td>
					<td>
						<c:if test="${empty item.ischeck }">未处理</c:if>
						<c:if test="${item.ischeck =='0'}">未处理</c:if>
						<c:if test="${item.ischeck =='1'}">已处理</c:if>
					</td>
					<td>
						${item.n2}
					</td>
					<td>
						<a class="btnAttach"
							href="${applicationScope.rootpath}download.action?fileName=${item.n3}&loadflag=recording"
							target="_black" title="下载"><span>下载</span> </a> 
						<a class="btnMusic"
							href="playmusic.action?musicpath=${item.filename}&pathflag=upload"
							rel="musicCardNav" target="dialog" reloadFlag=1 width="254"
							height="300" title="播放"><span>播放 </span> </a>
						<a class="btnEdit"
							href="${applicationScope.rootpath}editVoice?ivrvoiceKey=${item.id}"
							target="navTab" rel="editVoiceCardNav" reloadFlag=1
							title="处理"><span>处理</span> </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/pages/common/panelBar.jsp"></c:import>
</div>
