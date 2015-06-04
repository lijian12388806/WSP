package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class SubtotalsForm extends BaseForm {

	private static final long serialVersionUID = 1L;
	private String womaker;
	private String month;
	private String subdate;
	//工单状态
	private int wclwo;
	private int dhxclwo;
	private int ywcwo;
	private int yjdwo;
	//工单类型
	private int OSampledepend;  //小样依赖
	private int OAmodeldepend; // 样板依赖
	private int OSampleReq; // 样板需求
	private int OOrderDelivery;  //订单交货
	private int OOnsiteservice;  //现场服务
	private int OComplainthand; //投诉受理
	private int OReturnReq ;//退货申请

	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getWclwo() {
		return wclwo;
	}
	public void setWclwo(int wclwo) {
		this.wclwo = wclwo;
	}
	public int getDhxclwo() {
		return dhxclwo;
	}
	public void setDhxclwo(int dhxclwo) {
		this.dhxclwo = dhxclwo;
	}
	public int getYwcwo() {
		return ywcwo;
	}
	public void setYwcwo(int ywcwo) {
		this.ywcwo = ywcwo;
	}
	public int getYjdwo() {
		return yjdwo;
	}
	public void setYjdwo(int yjdwo) {
		this.yjdwo = yjdwo;
	}
	public String getWomaker() {
		return womaker;
	}
	public void setWomaker(String womaker) {
		this.womaker = womaker;
	}
	public String getSubdate() {
		return subdate;
	}
	public void setSubdate(String subdate) {
		this.subdate = subdate;
	}
	public int getOSampledepend() {
		return OSampledepend;
	}
	public void setOSampledepend(int sampledepend) {
		OSampledepend = sampledepend;
	}
	public int getOAmodeldepend() {
		return OAmodeldepend;
	}
	public void setOAmodeldepend(int amodeldepend) {
		OAmodeldepend = amodeldepend;
	}
	public int getOSampleReq() {
		return OSampleReq;
	}
	public void setOSampleReq(int sampleReq) {
		OSampleReq = sampleReq;
	}
	public int getOOrderDelivery() {
		return OOrderDelivery;
	}
	public void setOOrderDelivery(int orderDelivery) {
		OOrderDelivery = orderDelivery;
	}
	public int getOOnsiteservice() {
		return OOnsiteservice;
	}
	public void setOOnsiteservice(int onsiteservice) {
		OOnsiteservice = onsiteservice;
	}
	public int getOComplainthand() {
		return OComplainthand;
	}
	public void setOComplainthand(int complainthand) {
		OComplainthand = complainthand;
	}
	public int getOReturnReq() {
		return OReturnReq;
	}
	public void setOReturnReq(int returnReq) {
		OReturnReq = returnReq;
	}
	
	
}
