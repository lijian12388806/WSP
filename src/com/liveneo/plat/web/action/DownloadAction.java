package com.liveneo.plat.web.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang3.StringUtils;

import com.liveneo.plat.hibernate.dao.Workorder;
import com.liveneo.plat.service.impl.BdDictService;
import com.liveneo.plat.utils.CreateXml;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.ExcelUtils;
import com.liveneo.plat.web.action.base.AbstractActionSupport;

public class DownloadAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 最终压缩后的zip文件的路径，传递给通用的下载Action
	private String fileName;
	private String loadflag;
	private String filedate;
	private String filewav;
	private String sessionname;
	private BdDictService bdDictService;
	public String getDownloadFileName() {
		String fileName = this.getRequest().getParameter("fileName");
		String filewav = this.getRequest().getParameter("filewav");
		String downFileName = "";
		if (StringUtils.equalsIgnoreCase(loadflag, "restore")) {
			downFileName = fileName + ".zip";
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "excel")) {
			downFileName = fileName;
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "recording")) {
			if(StringUtils.isNotEmpty(fileName)){
				downFileName = StringUtils.substringAfter(fileName, "/noneccrecord/ivrvoice/");
			}else{
				downFileName="empty.wav";
			}
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "license")) {
			downFileName = filewav;
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "wo")) {
			downFileName = fileName;
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "report")) {
			downFileName = fileName;
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "commonexcel")) {
			downFileName = fileName;
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "softphone")) {
			downFileName = fileName;
		}
		try {
			downFileName = new String(downFileName.getBytes(), "ISO8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return downFileName;
	}

	public void setFileName(String fileName)
			throws UnsupportedEncodingException {
		// 用UTF-8重新编码文件名,解决中文乱码
		this.fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
	}

	public InputStream getInputStream() throws UnsupportedEncodingException,
			FileNotFoundException {
		// attachment,以附件的方式下载文件,会打开保存文件对话框;inline,以内联的方式下载,浏览器会直接打开文件
		String file = "";
		if (StringUtils.equalsIgnoreCase(loadflag, "softphone")) {
			file = getServletContext().getRealPath(
					"/softphone/" + fileName);
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "restore")) {
			file = CreateXml.backuptarget + fileName + ".zip";
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "excel")) {
			file = getServletContext().getRealPath(
					"/WEB-INF/pages/template/" + fileName);
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "recording")) {
			HttpURLConnection connection = null;
			try {
				URL url = new URL(fileName);
				connection = (HttpURLConnection)url.openConnection();
				 connection.connect();
//				 BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				 this.getResponse().setHeader("application/x-msdownload",
							"attachment;file=" + java.net.URLEncoder.encode(file, "UTF-8"));
				 return new BufferedInputStream(connection.getInputStream());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(getServletContext().getRealPath("/noneccrecord/ivrvoice/")+"/"+StringUtils.substringAfter(fileName, "/opt/AppServer/tomcat/webapps/noneccrecord/ivrvoice/"));
			
//		file="D:/apache-tomcat-6.0.35/webapps/npworkplat/noneccrecord/ivrvoice/file1680475804236541293_ivrvoice.wav";
			
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "license")) {
			file = fileName;
		}
		if (StringUtils.equalsIgnoreCase(loadflag, "wo")) {
			WorkOrderAction w=new WorkOrderAction(); 
			List<Workorder> ws =new ArrayList<Workorder>();
			ws=(List<Workorder>) this.getSession().getAttribute(sessionname);
			if(ws.size()>0){
				this.createWorkorderExcel(getServletContext().getRealPath("/excel/wo_info.xls"),ws,"工单信息");
			}
			file = getServletContext().getRealPath(
					"/excel/")+"/"+fileName;
			System.out.println("file:"+file);
		}
		//报表查询
		if (StringUtils.equalsIgnoreCase(loadflag, "report")) {
			String title = this.getRequest().getParameter("title");
			title = java.net.URLDecoder.decode(title,"UTF-8");
			title = java.net.URLDecoder.decode(title,"UTF-8");
			String tvalue = this.getRequest().getParameter("tvalue");
			//标题
			String[] titles = title.split(",");
			//每一个tr中的td
			List<List<String>> tds = new ArrayList<List<String>>();
			String[] tr = tvalue.split(";");
			for (int j = 0; j < tr.length; j++) {
				List<String> td = new ArrayList<String>(); 
				String[] fields = tr[j].split(",");
				for(String v:fields){
			           if(v==null){
			               v="";
			           }
			           td.add(v);
			       }
				tds.add(td);
			}
			//生成excel文件
			ExcelUtils.exportExcel(getServletContext()
					.getRealPath("/excel/")
					+ "/" + fileName,titles, tds);
			file = getServletContext().getRealPath(
					"/excel/")+"/"+fileName;
		}
		//公用方法信息
		if (StringUtils.equalsIgnoreCase(loadflag, "commonexcel")) {
			String title = this.getRequest().getParameter("title");
			title = java.net.URLDecoder.decode(title,"UTF-8");
			title = java.net.URLDecoder.decode(title,"UTF-8");
			//标题
			String[] titles = title.split(",");
			//每一个tr中的td
			List<List<String>> tds = new ArrayList<List<String>>();
			tds = (List<List<String>>) this.getSession().getAttribute(sessionname);
			//生成excel文件
			ExcelUtils.exportExcel(getServletContext()
					.getRealPath("/excel/")
					+ "/" + fileName,titles, tds);
			file = getServletContext().getRealPath(
					"/excel/")+"/"+fileName;
		}
		this.getResponse().setHeader("application/x-msdownload",
				"attachment;file=" + java.net.URLEncoder.encode(file, "UTF-8"));
		// 如果fileName是绝对路径
		return new BufferedInputStream(new FileInputStream(file));
	}
	//工单导出
	public  void createWorkorderExcel(String fileName, List<Workorder> list,String title) {
//		System.out.println("content:"+list.size());
		WritableWorkbook wwb;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet(title, 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLUE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.CENTRE);
			ws.setRowView(1, 500);
			// 填充数据的内容 

			Workorder[] p = new Workorder[list.size()];
			for (int i = 0; i < list.size(); i++) {
				p[i] = (Workorder) list.get(i);
				if (i == 0) {
					ws.addCell(new Label(0, 0, "工单编号", wcf));
					ws.addCell(new Label(1, 0, "工单状态", wcf));
					ws.addCell(new Label(2, 0, "客服专员", wcf));
					ws.addCell(new Label(3, 0, "来电号码", wcf));
					ws.addCell(new Label(4, 0, "工单来源", wcf));
					ws.addCell(new Label(5, 0, "客户代码", wcf));
					ws.addCell(new Label(6, 0, "客户名称", wcf));
					ws.addCell(new Label(7, 0, "工厂名称", wcf));
					ws.addCell(new Label(8, 0, "项目名称", wcf));
					ws.addCell(new Label(9, 0, "项目代码", wcf));
					ws.addCell(new Label(10, 0, "工单类型", wcf));
					
					ws.addCell(new Label(11, 0, "工作内容", wcf));
					ws.addCell(new Label(12, 0, "客户咨询内容", wcf));
					ws.addCell(new Label(13, 0, "处理结果", wcf));
					
					
					ws.addCell(new Label(14, 0, "生成类型", wcf));
					ws.addCell(new Label(15, 0, "创建时间", wcf));
					ws.addCell(new Label(16, 0, "处理时间", wcf));
					ws.addCell(new Label(17, 0, "结单时间", wcf));
					ws.addCell(new Label(18, 0, "备注", wcf));
				}
				ws.addCell(new Label(0, i + 1, p[i].getWorkorderno(),new WritableCellFormat()));
				ws.addCell(new Label(1, i + 1, this.bdDictService.getBdDictdetailByDcode(p[i].getWostatus()), new WritableCellFormat()));
				ws.addCell(new Label(2, i + 1, p[i].getPkUserinfo().getUsername(), new WritableCellFormat()));
				ws.addCell(new Label(3, i + 1, p[i].getCallerno(), new WritableCellFormat()));
				ws.addCell(new Label(4, i + 1, this.bdDictService.getBdDictdetailByDcode(p[i].getOrdersource()), new WritableCellFormat()));
				ws.addCell(new Label(5, i + 1, p[i].getCustomerno(), new WritableCellFormat()));
				ws.addCell(new Label(6, i + 1, p[i].getCustomername(), new WritableCellFormat()));
				ws.addCell(new Label(7, i + 1, p[i].getTemp8(),new WritableCellFormat()));
				ws.addCell(new Label(8, i + 1, p[i].getProname(), new WritableCellFormat()));
				ws.addCell(new Label(9, i + 1, p[i].getProcode(), new WritableCellFormat()));
				ws.addCell(new Label(10, i + 1, this.bdDictService.getBdDictdetailByDcode(p[i].getOrdertype()), new WritableCellFormat()));
				
				ws.addCell(new Label(11, i + 1, this.bdDictService.getBdDictdetailByDcode(p[i].getWorkitem()), new WritableCellFormat()));
				ws.addCell(new Label(12, i + 1, p[i].getConsultcontent(), new WritableCellFormat()));
				ws.addCell(new Label(13, i + 1, p[i].getNextaction(), new WritableCellFormat()));
				
				ws.addCell(new Label(14, i + 1, this.bdDictService.getBdDictdetailByDcode(p[i].getGeneratemode()), new WritableCellFormat()));
				ws.addCell(new Label(15, i + 1, DateUtil.formatDateByFormat(p[i].getCalltime(), "yyyy-MM-dd HH:mm:ss"), new WritableCellFormat()));
				ws.addCell(new Label(16, i + 1, DateUtil.formatDateByFormat(p[i].getDealtime(), "yyyy-MM-dd HH:mm:ss"), new WritableCellFormat()));
				ws.addCell(new Label(17, i + 1, DateUtil.formatDateByFormat(p[i].getCompletetime(), "yyyy-MM-dd HH:mm:ss"), new WritableCellFormat()));
				ws.addCell(new Label(18, i + 1, p[i].getRemark(), new WritableCellFormat()));
			}

			wwb.write();
			wwb.close();
		} catch (Exception e) {
		}
	}
	// 文件名
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getFileName() {
		return fileName;
	}

	public String getLoadflag() {
		return loadflag;
	}

	public void setLoadflag(String loadflag) {
		this.loadflag = loadflag;
	}

	public String getFiledate() {
		return filedate;
	}

	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}

	public String getFilewav() {
		return filewav;
	}

	public void setFilewav(String filewav) {
		this.filewav = filewav;
	}

	public String getSessionname() {
		return sessionname;
	}

	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}

	public BdDictService getBdDictService() {
		return bdDictService;
	}

	public void setBdDictService(BdDictService bdDictService) {
		this.bdDictService = bdDictService;
	}
	
}
