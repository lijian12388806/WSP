<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="pageContent">
	<h1>
		定时任务时间规则
	</h1>
	<fieldset>
<legend>说明 ：</legend>
		<dl><dd>字段 允许值 允许的特殊字符</dd> </dl>
<dl><dd>秒 0-59 , - * / </dd></dl>
<dl><dd>分 0-59 , - * / </dd></dl>
<dl><dd>小时 0-23 , - * / </dd></dl>
<dl><dd>日期 1-31 , - * ? / L W C </dd></dl>
<dl><dd>月份 1-12 或者 JAN-DEC , - * / </dd></dl>
<dl><dd>星期 1-7 或者 SUN-SAT , - * ? / L C # </dd></dl>
<dl><dd>年（可选） 留空, 1970-2099 , - * / </dd></dl>
<dl><dd>“*”字符被用来指定所有的值。如：”*“在分钟的字段域里表示“每分钟”。 </dd></dl>
<dl><dd>“?”字符只在日期域和星期域中使用。它被用来指定“非明确的值”。当你需要通过在这两个域中的一个来指定一些东西的时候，它是有用的。看下面的例子你就会明白。 月份中的日期和星期中的日期这两个元素时互斥的一起应该通过设置一个问号(?)来表明不想设置那个字段</dd></dl>
<dl><dd>“-”字符被用来指定一个范围。如：“10-12”在小时域意味着“10点、11点、12点”。 </dd></dl>
<dl><dd>“,”字符被用来指定另外的值。如：“MON,WED,FRI”在星期域里表示”星期一、星期三、星期五”. </dd></dl>
<dl><dd>L是‘last’的省略写法可以表示day-of-month和day-of-week域，但在两个字段中的意思不同，例如day-of-month域中表示一个月的最后一天， 如果在day-of-week域表示‘7’或者‘SAT’，如果在day-of-week域中前面加上数字，它表示一个月的最后几天，例如‘6L’就表示一个月的最后一个 星期五</dd></dl>
	</fieldset>

<fieldset>
<legend>表达式举例: </legend>
	<dl><dd>"0 0 12 * * ?" 每天中午12点触发 </dd> </dl>
<dl><dd>"0 15 10 ? * *" 每天上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 * * ?" 每天上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 * * ? *" 每天上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 * * ? 2005" 2005年的每天上午10:15触发 </dd> </dl>
<dl><dd>"0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发 </dd> </dl>
<dl><dd>"0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发 </dd> </dl>
<dl><dd>"0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 </dd> </dl>
<dl><dd>"0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发 </dd> </dl>
<dl><dd>"0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发 </dd> </dl>
<dl><dd>"0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 15 * ?" 每月15日上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 L * ?" 每月最后一日的上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发 </dd> </dl>
<dl><dd>"0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发 </dd> </dl>
<dl><dd>每天早上6点 0 6 * * * </dd> </dl>
<dl><dd>每两个小时 0 */2 * * * </dd> </dl>
<dl><dd>晚上11点到早上8点之间每两个小时，早上八点 0 23-7/2，8 * * * </dd> </dl>
<dl><dd>每个月的4号和每个礼拜的礼拜一到礼拜三的早上11点 0 11 4 * 1-3 </dd> </dl>
<dl><dd>1月1日早上4点 0 4 1 1 </dd> </dl>
</fieldset>
</div>