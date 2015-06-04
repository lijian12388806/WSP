package com.liveneo.plat.service.impl;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import com.liveneo.plat.hibernate.dao.BdDict;
import com.liveneo.plat.hibernate.dao.BdDictdetail;
import com.liveneo.plat.hibernate.dao.dao.iface.BdDictDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.BdDictdetailDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.BdDictServiceIface;
import com.liveneo.plat.utils.BuildXml;
import com.liveneo.plat.utils.CreateXml;
import com.liveneo.plat.utils.FileUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;
import com.liveneo.plat.utils.StringUtil;

public class BdDictService extends AbstractBaseService implements
		BdDictServiceIface {
	private BdDictDAO bdDictDAO;

	private BdDictdetailDAO bdDictdetailDAO;

	public Integer addBdDict(BdDict bean) {
		if (this.checkBdDictUniqueResult(BdDict.PROP_DICTCODE, bean
				.getDictcode(), "")) {
			return this.bdDictDAO.save(bean);
		} else {
			return 0;
		}
	}
	//更新值班人/电话
	public void setDictRemark(BdDict bdDict){
		//更新值班人/电话
		List<BdDictdetail> listbdd= new ArrayList<BdDictdetail>();
		listbdd=this.queryBdDictdetailByDict(bdDict);
		List<String> strs1 = new ArrayList<String>();
		List<String> strs2 = new ArrayList<String>();
		if(listbdd.size()>0){
			for(BdDictdetail b:listbdd){
				if(StringUtils.isNotEmpty(b.getTitle()) || StringUtils.isNotEmpty(b.getCode())){
					strs1.add(b.getCode());	
					strs2.add(b.getTitle()+":"+b.getCode());	
				}
				
			}
		}
//		if(strs1.size() > 0){
			bdDict.setTemp(StringUtil.convertListToString(strs1, ","));
//		}
//		if(strs2.size() > 0){
			bdDict.setRemark(StringUtil.convertListToString(strs2, " "));
//		}
		this.updateBdDict(bdDict);
	}
	public Integer addBdDictdetail(BdDictdetail bean) {
		return this.bdDictdetailDAO.save(bean);
	}

	public void delBdDict(Integer key) {
		
		String hql="Delete From BdDictdetail Where PkDict="+key;
		this.bdDictdetailDAO.bulkUpdate(hql);
		this.bdDictDAO.delete(key);
	}

	public void delBdDictdetail(Integer key) {
		BdDict bdDict = new BdDict();
		bdDict = this.getBdDictdetail(key).getPkDict();
		this.bdDictdetailDAO.delete(key);
		if(!bdDict.equals(null)){
			this.setDictRemark(bdDict);
		}
	}

	public BdDict getBdDict(Integer key) {
		return this.bdDictDAO.get(key);
	}

	public List<BdDict> queryAllBdDict() {
		return bdDictDAO.findAll();
	}

	public List<BdDictdetail> queryBdDictdetail(
			DetachedCriteria detachedCriteria) {
		return this.bdDictdetailDAO.findByCriteria(detachedCriteria);
	}

	public List<BdDict> queryBdDict(DetachedCriteria detachedCriteria) {
		return this.bdDictDAO.findByCriteria(detachedCriteria);
	}

	public List<BdDict> findBdDictByHql(String hql) {
		return this.bdDictDAO.findBySQL(hql);
	}
	public List<BdDict> findBdDictByHql(String hql,int pageNo ,int pageSize){
		return this.bdDictDAO.getListForPage(hql, pageNo, pageSize);
	}
	public int queryCountBdDict(DetachedCriteria detachedCriteria) {
		return this.bdDictDAO.getCountByCriteria(detachedCriteria);
	}

	public List<BdDict> queryBdDictarea(DetachedCriteria detachedCriteria,
			int firstResult, int resultCount) {
		return this.bdDictDAO.findByCriteria(detachedCriteria, firstResult,
				resultCount);
	}

	public List<BdDict> queryBdDict(String dictType) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forEntityName("com.liveneo.lcp.hibernate.dao.BdDict");
		if (StringUtils.isNotEmpty(dictType)) {
			detachedCriteria.add(Restrictions
					.eq(BdDict.PROP_DICTTYPE, dictType));
		}
		return this.bdDictDAO.findByCriteria(detachedCriteria);
	}

	public List<BdDict> queryBdDict(String dictType,
			DetachedCriteria detachedCriteria) {
		if (StringUtils.isNotEmpty(dictType)) {
			detachedCriteria.add(Restrictions.eq("DictType", dictType));
		}
		return this.bdDictDAO.findByCriteria(detachedCriteria);
	}
	public List<BdDictdetail> queryBdDictdetailByDict(BdDict dict) {
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(BdDictdetail.class);
		detachedCriteria.add(Restrictions.eq(BdDictdetail.PROP_PK_DICT, dict));
		detachedCriteria.add(Restrictions.eq(BdDictdetail.PROP_ISVALID, "Y"));
		return this.bdDictdetailDAO.findByCriteria(detachedCriteria);
	}
	public BdDictdetail queryBdDictdetailByCode(String code){
		return this.bdDictdetailDAO.getByUniqueIndex(BdDictdetail.PROP_CODE, code);
		
	}
	public List<BdDictdetail> queryBdDictdetail(String dictCode, String IsValid) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BdDictdetail.class);
		detachedCriteria.createAlias("PkDict", "Dict").add(
				Restrictions.eq("Dict.Dictcode", dictCode));
		if (StringUtils.isNotEmpty(IsValid)) {
			detachedCriteria.add(Restrictions.eq("Isvalid", IsValid));
		} else {
			detachedCriteria.add(Restrictions.eq("Isvalid", "Y"));
		}
		detachedCriteria.addOrder(Order.asc(BdDictdetail.PROP_DEFAULTORDER));
		return this.queryBdDictdetail(detachedCriteria);
	}
	public BdDictdetail queryBdDictdetailByddcode(String dictCode,String detailcode,String IsValid){
		List<BdDictdetail> list = this.queryBdDictdetail(dictCode, "Y");
		if(null!=list&&list.size()>0){
			for(BdDictdetail bb:list){
				if(StringUtils.equals(bb.getCode(),detailcode)){
					return bb;
				}
			}
		}
		return null;
	}

	public void updateBdDict(BdDict bean) {
		this.bdDictDAO.update(bean);
	}

	// 更改功能键设置
	public void updateFeaturecodes(BdDictdetail bean){
		this.bdDictdetailDAO.update(bean);
		try {
			createXml(bean);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		BuildXml.excCmd(BuildXml.reloadCmd);
		
	}

	public void createXml(BdDictdetail b) throws ParseException {
		String timeout = "";
		String discall = "";
		if (StringUtils.equalsIgnoreCase(b.getCode(), "extnpickup")) {
			if (StringUtils.isNotEmpty(b.getValue())) {
				BuildXml.createXmlFile(BuildXml.getFileName(
						CreateXml.featurecodesdir, "group-intercept"),
						CreateXml.initPickupxml(b));
			} else {
				File groupintercept=new File(BuildXml.getFileName(
						CreateXml.featurecodesdir, "group-intercept"));
				if(groupintercept.exists()){
					BuildXml.deleteXmlFile(BuildXml.getFileName(
							CreateXml.featurecodesdir, "group-intercept"));
				}
				
			}
		}
		if (StringUtils.equalsIgnoreCase(b.getCode(), "fixextnpickup")) {
			if (StringUtils.isNotEmpty(b.getValue())) {
				BuildXml.createXmlFile(BuildXml.getFileName(
						CreateXml.featurecodesdir, "intercept-ext"), CreateXml
						.initSpecialPickupxml(b));
			} else {
				File interceptext=new File(BuildXml.getFileName(
						CreateXml.featurecodesdir, "intercept-ext"));
				if(interceptext.exists()){
					BuildXml.deleteXmlFile(BuildXml.getFileName(
							CreateXml.featurecodesdir, "intercept-ext"));
				}
			}
		}
		if (StringUtils.equalsIgnoreCase(b.getCode(), "consultforward")) {
			if (StringUtils.isNotEmpty(b.getValue())) {
				BuildXml.createXmlFile(BuildXml.getFileName(
						CreateXml.featurecodesdir, "zhuanjie"), CreateXml
						.initTransferxml(b));
			} else {
				File zhuanjie=new File(BuildXml.getFileName(
						CreateXml.featurecodesdir, "zhuanjie"));
				if(zhuanjie.exists()){
					BuildXml.deleteXmlFile(BuildXml.getFileName(
							CreateXml.featurecodesdir, "zhuanjie"));
				}
				
			}
		}
		if (StringUtils.equalsIgnoreCase(b.getCode(), "uvoice")) {
			if (StringUtils.isNotEmpty(b.getValue())) {
				BuildXml.createXmlFile(BuildXml.getFileName(
						CreateXml.featurecodesdir, "yijianluyin"), CreateXml
						.initUvoicexml(b));
			} else {
				File zhuanjie=new File(BuildXml.getFileName(
						CreateXml.featurecodesdir, "yijianluyin"));
				if(zhuanjie.exists()){
					BuildXml.deleteXmlFile(BuildXml.getFileName(
							CreateXml.featurecodesdir, "yijianluyin"));
				}
				
			}
		}
		if (StringUtils.equalsIgnoreCase(b.getCode(), "discall")) {
			discall = b.getValue();
			if (StringUtils.isNotEmpty(discall)) {
				FileUtil.updateXmlAttribute(CreateXml.featuresxml,
						"att_xfer", "origination_cancel_key", discall);
			}
		}
		Boolean exist = FileUtil.checkAction(CreateXml.featuresxml);
		if (StringUtils.equalsIgnoreCase(b.getCode(), "calltimeout")) {
			timeout = b.getValue();
			if (StringUtils.isNotEmpty(timeout)) {
				if (exist == false) {
					FileUtil.addXmlAction(CreateXml.featuresxml, timeout);
				} else {
					FileUtil.updateXmlAttribute(CreateXml.featuresxml,
							"att_xfer", "call_timeout", timeout);
				}

			} else {
				if (exist == true) {
					FileUtil.updateXmlAttribute(CreateXml.featuresxml,
							"att_xfer", "call_timeout", "15");
				}
			}
		}
		
	}

	public void updateBdDictdetail(BdDictdetail bean) {
		this.bdDictdetailDAO.update(bean);
	}

	public Boolean checkBdDictUniqueResult(String colname, String colvalue,
			String sKey) {
		List ret = this.queryBdDict(this.uniqueResultCrit(BdDict.class,
				colname, colvalue, sKey));
		if (ret.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean checkBdDictdetailUniqueResult(String colname,
			String colvalue, String sKey) {
		List ret = this.queryBdDictdetail(this.uniqueResultCrit(
				BdDictdetail.class, colname, colvalue, sKey));
		if (ret.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public BdDictdetail getBdDictdetailByCode(String code) {
		List ret = this.queryBdDictdetail(this.uniqueResultCrit(
				BdDictdetail.class, "Code", code, ""));
		if (!ret.isEmpty()) {
			return (BdDictdetail) ret.get(0);
		} else {
			return null;
		}
	}
	public String getBdDictdetailByDcode(String code){
		String t ="";
		BdDictdetail b=new BdDictdetail();
		if(StringUtils.isNotEmpty(code)){
			b=this.bdDictdetailDAO.getByUniqueIndex(BdDictdetail.PROP_CODE, code);
		}
		if(StringUtils.isNotEmpty(b.getTitle())){
			t = b.getTitle();
		}
		return t;
		
	}
	public Map registerBdDictPara() {
		List<BdDict> bdDictList = new ArrayList<BdDict>();
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BdDict.class);
		detachedCriteria.add(Restrictions.eq(BdDict.PROP_ISVALID, "Y"));
		bdDictList = this.queryBdDict(detachedCriteria);
		if (bdDictList.isEmpty()) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (BdDict bdDict : bdDictList) {
			List<BdDictdetail> bdDictdetailList = new ArrayList<BdDictdetail>();
			bdDictdetailList = this
					.queryBdDictdetail(bdDict.getDictcode(), "Y");
			map
					.put(bdDict.getDictcode(),
							(List<BdDictdetail>) bdDictdetailList);
			map
					.put(
							bdDict.getDictcode() + "_MAP",
							(Map<String, BdDictdetail>) getDictDetailMap(bdDictdetailList));
		}
		return map;
	}

	private Map<String, BdDictdetail> getDictDetailMap(
			List<BdDictdetail> bdDictdetailList) {
		Map<String, BdDictdetail> map = new HashMap<String, BdDictdetail>();
		for (BdDictdetail bdDictdetail : bdDictdetailList) {
			map.put(bdDictdetail.getCode(), bdDictdetail);
		}
		return map;
	}

	public void deleteBdDictdetailByIds(String[] selectIDS) {
		List<String> keyList = new ArrayList<String>();
		keyList = ListUtil.ConvertArrayToStringList(selectIDS, "String");
		if (keyList != null) {
			for (String key : keyList) {
				this.delBdDictdetail(IntegerUtil.converStrToInteger(key));
			}
		}
	}

	public BdDictdetail getBdDictdetail(Integer key) {
		return this.bdDictdetailDAO.get(key);
	}

	public void setBdDictDAO(BdDictDAO bdDictDAO) {
		this.bdDictDAO = bdDictDAO;
	}

	public void setBdDictdetailDAO(BdDictdetailDAO bdDictdetailDAO) {
		this.bdDictdetailDAO = bdDictdetailDAO;
	}

}
