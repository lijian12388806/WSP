<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent" layoutH="56">
	<table width='100%' align='right' cellpadding='5' cellspacing='5'>
		<tr>
			<td>
				<input id='radio' type='radio' name='radioRest' value='1' />
				开会
			</td>
			<td>
				<input id='radio' type='radio' name='radioRest' value='2' />
				就餐
			</td>
			<td>
				<input id='radio' type='radio' name='radioRest' value='3' />
				培训
			</td>
		</tr>
		<tr>
			<td>
				<input id='radio' type='radio' name='radioRest' value='4' />
				离开
			</td>
			<td>
				<input id='radio' type='radio' name='radioRest' value='5' />
				外出
			</td>
			<td>
				<input id='radio' type='radio' name='radioRest' value='6' />
				辅导
			</td>
		</tr>
		<tr valign="bottom">
			<td colspan='3' align='center'>
				<input type='button' value='确定' name='setRestBtn' id='restBtn'
					onclick='javascript:phone.setRest();'>
			</td>
		</tr>
	</table>
</div>