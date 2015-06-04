<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="56">
		<p>
			<label>
				<input type='radio' name='choice' id='choiceAgent' checked
					value='agent'>
				坐席工号:
			</label>
			<label>

				<input type='text' id='agentDN' name='agentDN' value=''>
			</label>
		</p>
		<p>
			<label>
				<input type='radio' name='choice' id='choiceSkill'
					value='skillgroup'>
				技能组:
			</label>
			<label>
				<select name='skillVal' id='skillVal' style='width: 153px;'>
					<option value='1003'>
						订单处理
					</option>
				</select>
			</label>
		</p>
		<!-- <p>
		<input type='button' value='确定' name='setDispathBtn' id='dispathBtn'
			onclick='javascript:phone.${sessionScope.dispatchMode}();'>
	</p>  --> 
	</div>
	<div class="formBar">
		<ul>
			<li>
				<div class="buttonActive">
					<div class="buttonContent"
						onclick='javascript:phone.${sessionScope.dispatchMode}();'>
						<button type="button">
							确定
						</button>
					</div>
				</div>
			</li>
			<li>
				<div class="buttonActive">
					<div class="buttonContent">
						<button type="button" class="close">
							取消
						</button>
					</div>
				</div>
			</li>
		</ul>
	</div>
</div>