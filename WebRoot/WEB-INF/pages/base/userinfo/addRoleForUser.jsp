<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script language="JavaScript" type="text/javascript"
	src="${applicationScope.rootpath}scripts/selectbox.js"></script>
<form method="post"
	action="${applicationScope.rootpath}saveUserRole.action?navTabId=userinfoLiNav&callbackType=closeCurrent"
	class="required-validate pageForm"
	onsubmit="return validateCallback(this, dialogAjaxDone);"
	name="bdRoleForm">
	<script language="JavaScript">
			function CheckPermissions()
			{
				selectAllOptions(document.bdRoleForm.selectUsers);
							
				if (document.bdRoleForm.selectUsers.value == "")
				{
					alert("没有选择任何人员!");
					return false;
				}	
				return true;
			}
		</script>


	<table border="0" cellspacing="2" align="center">
		<tr>
			<td>
				<em> <s:text name="userinfo.username"/>： </em>
			</td>
			<td>
				<em>${userinfoForm.username}</em>
				<input type="hidden" value="${groupinfoKey}" id="groupinfoKey"
					name="groupinfoKey">
				<input type="hidden" value="${userinfoKey}" id="userinfoKey"
					name="userinfoKey">
			</td>
			
		</tr>
	</table>
	<table border="0" cellspacing="2" align="center">

		<tr>
			<td>
				<div align="center" title="<s:text name="role.lastrole"/>">
					<font size="1"><select name="AllUsers" style="width: 180px;"
							size="10" multiple="multiple"
							ondblclick="moveSelectedOptions(document.bdRoleForm.AllUsers, document.bdRoleForm.selectUsers, false, '')">
							<c:forEach items="${lastroleList}" var="lastRole">
								<option value="${lastRole.id}">
									${lastRole.rolename}
								</option>
							</c:forEach>
						</select> </font>
				</div>
			</td>
			<td>
				<div align="center">
					<font size="1"><input type="button" name="RemoveAll"
							id="RemoveAll" style="width: 30px; margin-bottom: 3px;"
							onclick="moveAllOptions(document.bdRoleForm.selectUsers, document.bdRoleForm.AllUsers, false, '');"
							value="&lt;&lt;"> <br> <input type="button"
							name="Remove" id="Remove" style="width: 30px;"
							onclick="moveSelectedOptions(document.bdRoleForm.selectUsers, document.bdRoleForm.AllUsers, false, '');"
							value="&lt;"> <br> <br> <input type="button"
							name="Add" id="Add" style="width: 30px;"
							onclick="moveSelectedOptions(document.bdRoleForm.AllUsers, document.bdRoleForm.selectUsers, false, '');"
							value="&gt;"> <br> <input type="button"
							name="AddAll" id="AddAll" style="width: 30px;"
							onclick="moveAllOptions(document.bdRoleForm.AllUsers, document.bdRoleForm.selectUsers, false, '');"
							value="&gt;&gt;"> </font>
				</div>
			</td>
			<td>
				<div align="center" title="<s:text name="role.userole"/>">
					<font size="1"><select name="selectUsers"
							style="width: 180px;" size="10" tabindex="-1" multiple="multiple"
							ondblclick="moveSelectedOptions(document.bdRoleForm.selectUsers, document.bdRoleForm.AllUsers, false, '')">
							<c:forEach items="${useroleList}" var="useRole">
								<option value="${useRole.id}">
									${useRole.rolename}
								</option>
							</c:forEach>
						</select> </font>
				</div>
			</td>
		</tr>
		<tr>
			<th align="center">
				<font size="1"><em> <s:text name="role.lastrole"/> </em> </font>
			</th>
			<th>
				<font size="1"><br> </font>
			</th>
			<th align="center">
				<font size="1"><em> <s:text name="role.userole"/> </em> </font>
			</th>
		</tr>
		<tr align="center">
			<td>
				<div align="right">
					<input type="submit" onclick="if(CheckPermissions()) ;"
						value="<s:text name="common.save"/>" />
				</div>
			</td>
			<td height="50" colspan="2" align="left">
				<div class="buttonContent">
					<button type="button" class="close">
						<s:text name="common.cancle" />
					</button>
				</div>
			</td>
		</tr>
	</table>
</form>