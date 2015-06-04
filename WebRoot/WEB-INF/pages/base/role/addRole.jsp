<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
function kkk(){
	var json = arguments[0], result="";
//	alert(json.checked);

	$(json.items).each(function(i){
		result += "<p>name:"+this.name + " value:"+this.value+" text: "+this.text+"</p>";
	});
	$("#resultBox").html(result);
	
}
</script>
<div class="pageContent">
	<form method="post"
		action="${applicationScope.rootpath}saveRole.action?navTabId=roleLiNav&callbackType=closeCurrent"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="56">
			<p>
				<label>
					<s:text name="role.rolename" />
					：
				</label>
				<input name="roleForm.rolename" id="roleForm.rolename"
					value="${roleForm.rolename}" alt="<s:text name="common.input"/>"
					type="text" size="30" class="required" />
				<input type="hidden" value="${roleKey}" id="roleKey" name="roleKey">
			</p>
			<p></p>
			<div class="driver"></div>
			<p>
				<label>
					<s:text name="role.rolemenu" />：
				</label>
			<ul class="tree treeFolder treeCheck expand" oncheck="kkk">
				<li>
					${listmenus}
				</li>
			</ul>
			</p>
			<p>
				<dl class="nowrap">
					<dt>
						<s:text name="role.description" />
						：
					</dt>
					<dd>
						<textarea name="roleForm.description" id="roleForm.description"
							cols="80" rows="5">${roleForm.description}</textarea>
					</dd>
				</dl>
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
								<s:text name="common.save" />
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								<s:text name="common.cancle" />
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>