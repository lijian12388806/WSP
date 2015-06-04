package com.liveneo.plat.utils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtils {
	/***************************************************************************
	023
	  该方法适合抓取页面信息进行excel导出，要保证所有信息都在页面上显示。配合js使用
	  * @param fileName EXCEL文件名称
	024
	  * @param listTitle EXCEL文件第一行列标题集合
	025
	  * @param listContent EXCEL文件正文数据集合
	026
	  * @return
	027 
	  */
	 public  final static String exportExcel(String fileName,String[] Title, List<List<String>> lists) {
	  String result="系统提示：Excel文件导出成功！"; 
	  // 以下开始输出到EXCEL
	  try {   
		    FileOutputStream os = new FileOutputStream(fileName); 
	   //定义输出流，以便打开保存对话框_______________________end
	 
	   /** **********创建工作簿************ */
	   WritableWorkbook workbook = Workbook.createWorkbook(os);
	 
	   /** **********创建工作表************ */
	 
	   WritableSheet sheet = workbook.createSheet("Sheet1", 0);
	 
	   /** **********设置纵横打印（默认为纵打）、打印纸***************** */
	   jxl.SheetSettings sheetset = sheet.getSettings();
	   sheetset.setProtected(false);
	 
	 
	   /** ************设置单元格字体************** */
	   WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
	   WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD);
	 
	   /** ************以下设置三种单元格样式，灵活备用************ */
	   // 用于标题居中
	   WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
	   wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
	   wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
	   wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
	   wcf_center.setWrap(false); // 文字是否换行
	    
	   // 用于正文居左
	   WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
	   wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
	   wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
	   wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
	   wcf_left.setWrap(false); // 文字是否换行  
	  
	 
	   /** ***************以下是EXCEL开头大标题，暂时省略********************* */
	   //sheet.addCell(new Label(0, 0, "XX报表", wcf_center));
	   /** ***************以下是EXCEL第一行列标题********************* */
	   for (int i = 0; i < Title.length; i++) {
	    sheet.addCell(new Label(i, 0,Title[i],wcf_center));
	   }  
	   /** ***************以下是EXCEL正文数据********************* */
	   int i=1;
	   for(List<String> l:lists){
	       int j=0;
	       for(String v:l){
	           if(v==null){
	               v="";
	           }
	           sheet.addCell(new Label(j, i,v,wcf_left));
	           j++;
	       }
	       i++;
	   }
	   /** **********将以上缓存中的内容写到EXCEL文件中******** */
	   workbook.write();
	   /** *********关闭文件************* */
	   workbook.close();  
	 
	  } catch (Exception e) {
	   result="系统提示：Excel文件导出失败，原因："+ e.toString();
	   System.out.println(result);
	   e.printStackTrace();
	  }
	  return result;
	 }
	 
	 @SuppressWarnings("static-access")
	public static void main(String[] args) {
		 ExcelUtils excel=new ExcelUtils();
	     List<String> list = new ArrayList<String>();
	     String s1 = "123,456";
	     String s2 = "789,012";
	     list.add(s1);
	     list.add(s2);
	     String[] Title={"机构ID","会员编号","类别","名称","省ID","省名称","城市ID","城市名称","详细地址","联系人","性别","联系手机","联系电话","传真","邮箱","QQ","生日","积分","客户等级","现金账户余额","结算方式","客户类型","购买次数","购买支数","创建人ID","创建人姓名","create_time","del","STS","备注","负责人ID","负责人姓名","审核标识","审核人ID ","审核人姓名","审核日期","分配人ID","分配人姓名","分配日期","修改人ID","修改人姓名  ","修改时间"};
//	     excel.exportExcel("E:\\test\\123.xls",Title, list);
	}

}
