package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the crm_wo table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="crm_wo"
 */

public abstract class BaseCrmWo  implements Serializable {

	public static String REF = "CrmWo";
	public static String PROP_WOS_T55 = "WosT55";
	public static String PROP_WOS_T54 = "WosT54";
	public static String PROP_WOS_T57 = "WosT57";
	public static String PROP_WOS_T56 = "WosT56";
	public static String PROP_WOS_T59 = "WosT59";
	public static String PROP_WOS_T58 = "WosT58";
	public static String PROP_WOS_CALLMODE = "WosCallmode";
	public static String PROP_WOS_T10 = "WosT10";
	public static String PROP_WOS_T11 = "WosT11";
	public static String PROP_WOS_T12 = "WosT12";
	public static String PROP_WOS_T13 = "WosT13";
	public static String PROP_WOS_CALLUCID = "WosCallucid";
	public static String PROP_WOS_T51 = "WosT51";
	public static String PROP_WOS_T14 = "WosT14";
	public static String PROP_WOS_T50 = "WosT50";
	public static String PROP_WOS_T15 = "WosT15";
	public static String PROP_WOS_T53 = "WosT53";
	public static String PROP_WOS_T16 = "WosT16";
	public static String PROP_WOS_T52 = "WosT52";
	public static String PROP_WOS_T17 = "WosT17";
	public static String PROP_WOS_T20 = "WosT20";
	public static String PROP_WOS_T60 = "WosT60";
	public static String PROP_WOS_T23 = "WosT23";
	public static String PROP_WOS_T24 = "WosT24";
	public static String PROP_WOS_T21 = "WosT21";
	public static String PROP_WOS_T22 = "WosT22";
	public static String PROP_WOS_T27 = "WosT27";
	public static String PROP_WOS_T28 = "WosT28";
	public static String PROP_WOS_T25 = "WosT25";
	public static String PROP_WOS_T26 = "WosT26";
	public static String PROP_WOS_T19 = "WosT19";
	public static String PROP_WOS_T18 = "WosT18";
	public static String PROP_ID = "Id";
	public static String PROP_WOS_NO = "WosNo";
	public static String PROP_WOS_CREATETIME = "WosCreatetime";
	public static String PROP_WOS_T30 = "WosT30";
	public static String PROP_WOS_T31 = "WosT31";
	public static String PROP_WOS_T2 = "WosT2";
	public static String PROP_WOS_T36 = "WosT36";
	public static String PROP_WOS_PKCUST = "WosPkcust";
	public static String PROP_WOS_T1 = "WosT1";
	public static String PROP_WOS_T37 = "WosT37";
	public static String PROP_WOS_T4 = "WosT4";
	public static String PROP_WOS_T38 = "WosT38";
	public static String PROP_WOS_T3 = "WosT3";
	public static String PROP_WOS_T39 = "WosT39";
	public static String PROP_WOS_T6 = "WosT6";
	public static String PROP_WOS_T32 = "WosT32";
	public static String PROP_WOS_T5 = "WosT5";
	public static String PROP_WOS_T33 = "WosT33";
	public static String PROP_WOS_T8 = "WosT8";
	public static String PROP_WOS_T34 = "WosT34";
	public static String PROP_WOS_T7 = "WosT7";
	public static String PROP_WOS_T35 = "WosT35";
	public static String PROP_WOS_TYPE = "WosType";
	public static String PROP_WOS_T29 = "WosT29";
	public static String PROP_WOS_STATUS = "WosStatus";
	public static String PROP_WOS_UPDATETIME = "WosUpdatetime";
	public static String PROP_WOS_T41 = "WosT41";
	public static String PROP_WOS_T42 = "WosT42";
	public static String PROP_WOS_T40 = "WosT40";
	public static String PROP_WOS_AGENTID = "WosAgentid";
	public static String PROP_WOS_T49 = "WosT49";
	public static String PROP_WOS_T47 = "WosT47";
	public static String PROP_WOS_T48 = "WosT48";
	public static String PROP_WOS_T45 = "WosT45";
	public static String PROP_WOS_T46 = "WosT46";
	public static String PROP_WOS_T43 = "WosT43";
	public static String PROP_WOS_T44 = "WosT44";
	public static String PROP_WOS_T9 = "WosT9";
	public static String PROP_WOS_CALLER = "WosCaller";


	// constructors
	public BaseCrmWo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCrmWo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String wosAgentid;
	private java.lang.String wosCaller;
	private java.lang.String wosCallmode;
	private java.lang.String wosCallucid;
	private java.util.Date wosCreatetime;
	private java.lang.String wosNo;
	private java.lang.String wosPkcust;
	private java.lang.String wosStatus;
	private java.lang.String wosT1;
	private java.lang.String wosT10;
	private java.lang.String wosT11;
	private java.lang.String wosT12;
	private java.lang.String wosT13;
	private java.lang.String wosT14;
	private java.lang.String wosT15;
	private java.lang.String wosT16;
	private java.lang.String wosT17;
	private java.lang.String wosT18;
	private java.lang.String wosT19;
	private java.lang.String wosT2;
	private java.lang.String wosT20;
	private java.lang.String wosT21;
	private java.lang.String wosT22;
	private java.lang.String wosT23;
	private java.lang.String wosT24;
	private java.lang.String wosT25;
	private java.lang.String wosT26;
	private java.lang.String wosT27;
	private java.lang.String wosT28;
	private java.lang.String wosT29;
	private java.lang.String wosT3;
	private java.lang.String wosT30;
	private java.lang.String wosT31;
	private java.lang.String wosT32;
	private java.lang.String wosT33;
	private java.lang.String wosT34;
	private java.lang.String wosT35;
	private java.lang.String wosT36;
	private java.lang.String wosT37;
	private java.lang.String wosT38;
	private java.lang.String wosT39;
	private java.lang.String wosT4;
	private java.lang.String wosT40;
	private java.lang.String wosT41;
	private java.lang.String wosT42;
	private java.lang.String wosT43;
	private java.lang.String wosT44;
	private java.lang.String wosT45;
	private java.lang.String wosT46;
	private java.lang.String wosT47;
	private java.lang.String wosT48;
	private java.lang.String wosT49;
	private java.lang.String wosT5;
	private java.lang.String wosT50;
	private java.lang.String wosT51;
	private java.lang.String wosT52;
	private java.lang.String wosT53;
	private java.lang.String wosT54;
	private java.lang.String wosT55;
	private java.lang.String wosT56;
	private java.lang.String wosT57;
	private java.lang.String wosT58;
	private java.lang.String wosT59;
	private java.lang.String wosT6;
	private java.lang.String wosT60;
	private java.lang.String wosT7;
	private java.lang.String wosT8;
	private java.lang.String wosT9;
	private java.lang.String wosType;
	private java.util.Date wosUpdatetime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: WOS_AGENTID
	 */
	public java.lang.String getWosAgentid () {
		return wosAgentid;
	}

	/**
	 * Set the value related to the column: WOS_AGENTID
	 * @param wosAgentid the WOS_AGENTID value
	 */
	public void setWosAgentid (java.lang.String wosAgentid) {
		this.wosAgentid = wosAgentid;
	}



	/**
	 * Return the value associated with the column: WOS_CALLER
	 */
	public java.lang.String getWosCaller () {
		return wosCaller;
	}

	/**
	 * Set the value related to the column: WOS_CALLER
	 * @param wosCaller the WOS_CALLER value
	 */
	public void setWosCaller (java.lang.String wosCaller) {
		this.wosCaller = wosCaller;
	}



	/**
	 * Return the value associated with the column: WOS_CALLMODE
	 */
	public java.lang.String getWosCallmode () {
		return wosCallmode;
	}

	/**
	 * Set the value related to the column: WOS_CALLMODE
	 * @param wosCallmode the WOS_CALLMODE value
	 */
	public void setWosCallmode (java.lang.String wosCallmode) {
		this.wosCallmode = wosCallmode;
	}



	/**
	 * Return the value associated with the column: WOS_CALLUCID
	 */
	public java.lang.String getWosCallucid () {
		return wosCallucid;
	}

	/**
	 * Set the value related to the column: WOS_CALLUCID
	 * @param wosCallucid the WOS_CALLUCID value
	 */
	public void setWosCallucid (java.lang.String wosCallucid) {
		this.wosCallucid = wosCallucid;
	}



	/**
	 * Return the value associated with the column: WOS_CREATETIME
	 */
	public java.util.Date getWosCreatetime () {
		return wosCreatetime;
	}

	/**
	 * Set the value related to the column: WOS_CREATETIME
	 * @param wosCreatetime the WOS_CREATETIME value
	 */
	public void setWosCreatetime (java.util.Date wosCreatetime) {
		this.wosCreatetime = wosCreatetime;
	}



	/**
	 * Return the value associated with the column: WOS_NO
	 */
	public java.lang.String getWosNo () {
		return wosNo;
	}

	/**
	 * Set the value related to the column: WOS_NO
	 * @param wosNo the WOS_NO value
	 */
	public void setWosNo (java.lang.String wosNo) {
		this.wosNo = wosNo;
	}



	/**
	 * Return the value associated with the column: WOS_PKCUST
	 */
	public java.lang.String getWosPkcust () {
		return wosPkcust;
	}

	/**
	 * Set the value related to the column: WOS_PKCUST
	 * @param wosPkcust the WOS_PKCUST value
	 */
	public void setWosPkcust (java.lang.String wosPkcust) {
		this.wosPkcust = wosPkcust;
	}



	/**
	 * Return the value associated with the column: WOS_STATUS
	 */
	public java.lang.String getWosStatus () {
		return wosStatus;
	}

	/**
	 * Set the value related to the column: WOS_STATUS
	 * @param wosStatus the WOS_STATUS value
	 */
	public void setWosStatus (java.lang.String wosStatus) {
		this.wosStatus = wosStatus;
	}



	/**
	 * Return the value associated with the column: WOS_T1
	 */
	public java.lang.String getWosT1 () {
		return wosT1;
	}

	/**
	 * Set the value related to the column: WOS_T1
	 * @param wosT1 the WOS_T1 value
	 */
	public void setWosT1 (java.lang.String wosT1) {
		this.wosT1 = wosT1;
	}



	/**
	 * Return the value associated with the column: WOS_T10
	 */
	public java.lang.String getWosT10 () {
		return wosT10;
	}

	/**
	 * Set the value related to the column: WOS_T10
	 * @param wosT10 the WOS_T10 value
	 */
	public void setWosT10 (java.lang.String wosT10) {
		this.wosT10 = wosT10;
	}



	/**
	 * Return the value associated with the column: WOS_T11
	 */
	public java.lang.String getWosT11 () {
		return wosT11;
	}

	/**
	 * Set the value related to the column: WOS_T11
	 * @param wosT11 the WOS_T11 value
	 */
	public void setWosT11 (java.lang.String wosT11) {
		this.wosT11 = wosT11;
	}



	/**
	 * Return the value associated with the column: WOS_T12
	 */
	public java.lang.String getWosT12 () {
		return wosT12;
	}

	/**
	 * Set the value related to the column: WOS_T12
	 * @param wosT12 the WOS_T12 value
	 */
	public void setWosT12 (java.lang.String wosT12) {
		this.wosT12 = wosT12;
	}



	/**
	 * Return the value associated with the column: WOS_T13
	 */
	public java.lang.String getWosT13 () {
		return wosT13;
	}

	/**
	 * Set the value related to the column: WOS_T13
	 * @param wosT13 the WOS_T13 value
	 */
	public void setWosT13 (java.lang.String wosT13) {
		this.wosT13 = wosT13;
	}



	/**
	 * Return the value associated with the column: WOS_T14
	 */
	public java.lang.String getWosT14 () {
		return wosT14;
	}

	/**
	 * Set the value related to the column: WOS_T14
	 * @param wosT14 the WOS_T14 value
	 */
	public void setWosT14 (java.lang.String wosT14) {
		this.wosT14 = wosT14;
	}



	/**
	 * Return the value associated with the column: WOS_T15
	 */
	public java.lang.String getWosT15 () {
		return wosT15;
	}

	/**
	 * Set the value related to the column: WOS_T15
	 * @param wosT15 the WOS_T15 value
	 */
	public void setWosT15 (java.lang.String wosT15) {
		this.wosT15 = wosT15;
	}



	/**
	 * Return the value associated with the column: WOS_T16
	 */
	public java.lang.String getWosT16 () {
		return wosT16;
	}

	/**
	 * Set the value related to the column: WOS_T16
	 * @param wosT16 the WOS_T16 value
	 */
	public void setWosT16 (java.lang.String wosT16) {
		this.wosT16 = wosT16;
	}



	/**
	 * Return the value associated with the column: WOS_T17
	 */
	public java.lang.String getWosT17 () {
		return wosT17;
	}

	/**
	 * Set the value related to the column: WOS_T17
	 * @param wosT17 the WOS_T17 value
	 */
	public void setWosT17 (java.lang.String wosT17) {
		this.wosT17 = wosT17;
	}



	/**
	 * Return the value associated with the column: WOS_T18
	 */
	public java.lang.String getWosT18 () {
		return wosT18;
	}

	/**
	 * Set the value related to the column: WOS_T18
	 * @param wosT18 the WOS_T18 value
	 */
	public void setWosT18 (java.lang.String wosT18) {
		this.wosT18 = wosT18;
	}



	/**
	 * Return the value associated with the column: WOS_T19
	 */
	public java.lang.String getWosT19 () {
		return wosT19;
	}

	/**
	 * Set the value related to the column: WOS_T19
	 * @param wosT19 the WOS_T19 value
	 */
	public void setWosT19 (java.lang.String wosT19) {
		this.wosT19 = wosT19;
	}



	/**
	 * Return the value associated with the column: WOS_T2
	 */
	public java.lang.String getWosT2 () {
		return wosT2;
	}

	/**
	 * Set the value related to the column: WOS_T2
	 * @param wosT2 the WOS_T2 value
	 */
	public void setWosT2 (java.lang.String wosT2) {
		this.wosT2 = wosT2;
	}



	/**
	 * Return the value associated with the column: WOS_T20
	 */
	public java.lang.String getWosT20 () {
		return wosT20;
	}

	/**
	 * Set the value related to the column: WOS_T20
	 * @param wosT20 the WOS_T20 value
	 */
	public void setWosT20 (java.lang.String wosT20) {
		this.wosT20 = wosT20;
	}



	/**
	 * Return the value associated with the column: WOS_T21
	 */
	public java.lang.String getWosT21 () {
		return wosT21;
	}

	/**
	 * Set the value related to the column: WOS_T21
	 * @param wosT21 the WOS_T21 value
	 */
	public void setWosT21 (java.lang.String wosT21) {
		this.wosT21 = wosT21;
	}



	/**
	 * Return the value associated with the column: WOS_T22
	 */
	public java.lang.String getWosT22 () {
		return wosT22;
	}

	/**
	 * Set the value related to the column: WOS_T22
	 * @param wosT22 the WOS_T22 value
	 */
	public void setWosT22 (java.lang.String wosT22) {
		this.wosT22 = wosT22;
	}



	/**
	 * Return the value associated with the column: WOS_T23
	 */
	public java.lang.String getWosT23 () {
		return wosT23;
	}

	/**
	 * Set the value related to the column: WOS_T23
	 * @param wosT23 the WOS_T23 value
	 */
	public void setWosT23 (java.lang.String wosT23) {
		this.wosT23 = wosT23;
	}



	/**
	 * Return the value associated with the column: WOS_T24
	 */
	public java.lang.String getWosT24 () {
		return wosT24;
	}

	/**
	 * Set the value related to the column: WOS_T24
	 * @param wosT24 the WOS_T24 value
	 */
	public void setWosT24 (java.lang.String wosT24) {
		this.wosT24 = wosT24;
	}



	/**
	 * Return the value associated with the column: WOS_T25
	 */
	public java.lang.String getWosT25 () {
		return wosT25;
	}

	/**
	 * Set the value related to the column: WOS_T25
	 * @param wosT25 the WOS_T25 value
	 */
	public void setWosT25 (java.lang.String wosT25) {
		this.wosT25 = wosT25;
	}



	/**
	 * Return the value associated with the column: WOS_T26
	 */
	public java.lang.String getWosT26 () {
		return wosT26;
	}

	/**
	 * Set the value related to the column: WOS_T26
	 * @param wosT26 the WOS_T26 value
	 */
	public void setWosT26 (java.lang.String wosT26) {
		this.wosT26 = wosT26;
	}



	/**
	 * Return the value associated with the column: WOS_T27
	 */
	public java.lang.String getWosT27 () {
		return wosT27;
	}

	/**
	 * Set the value related to the column: WOS_T27
	 * @param wosT27 the WOS_T27 value
	 */
	public void setWosT27 (java.lang.String wosT27) {
		this.wosT27 = wosT27;
	}



	/**
	 * Return the value associated with the column: WOS_T28
	 */
	public java.lang.String getWosT28 () {
		return wosT28;
	}

	/**
	 * Set the value related to the column: WOS_T28
	 * @param wosT28 the WOS_T28 value
	 */
	public void setWosT28 (java.lang.String wosT28) {
		this.wosT28 = wosT28;
	}



	/**
	 * Return the value associated with the column: WOS_T29
	 */
	public java.lang.String getWosT29 () {
		return wosT29;
	}

	/**
	 * Set the value related to the column: WOS_T29
	 * @param wosT29 the WOS_T29 value
	 */
	public void setWosT29 (java.lang.String wosT29) {
		this.wosT29 = wosT29;
	}



	/**
	 * Return the value associated with the column: WOS_T3
	 */
	public java.lang.String getWosT3 () {
		return wosT3;
	}

	/**
	 * Set the value related to the column: WOS_T3
	 * @param wosT3 the WOS_T3 value
	 */
	public void setWosT3 (java.lang.String wosT3) {
		this.wosT3 = wosT3;
	}



	/**
	 * Return the value associated with the column: WOS_T30
	 */
	public java.lang.String getWosT30 () {
		return wosT30;
	}

	/**
	 * Set the value related to the column: WOS_T30
	 * @param wosT30 the WOS_T30 value
	 */
	public void setWosT30 (java.lang.String wosT30) {
		this.wosT30 = wosT30;
	}



	/**
	 * Return the value associated with the column: WOS_T31
	 */
	public java.lang.String getWosT31 () {
		return wosT31;
	}

	/**
	 * Set the value related to the column: WOS_T31
	 * @param wosT31 the WOS_T31 value
	 */
	public void setWosT31 (java.lang.String wosT31) {
		this.wosT31 = wosT31;
	}



	/**
	 * Return the value associated with the column: WOS_T32
	 */
	public java.lang.String getWosT32 () {
		return wosT32;
	}

	/**
	 * Set the value related to the column: WOS_T32
	 * @param wosT32 the WOS_T32 value
	 */
	public void setWosT32 (java.lang.String wosT32) {
		this.wosT32 = wosT32;
	}



	/**
	 * Return the value associated with the column: WOS_T33
	 */
	public java.lang.String getWosT33 () {
		return wosT33;
	}

	/**
	 * Set the value related to the column: WOS_T33
	 * @param wosT33 the WOS_T33 value
	 */
	public void setWosT33 (java.lang.String wosT33) {
		this.wosT33 = wosT33;
	}



	/**
	 * Return the value associated with the column: WOS_T34
	 */
	public java.lang.String getWosT34 () {
		return wosT34;
	}

	/**
	 * Set the value related to the column: WOS_T34
	 * @param wosT34 the WOS_T34 value
	 */
	public void setWosT34 (java.lang.String wosT34) {
		this.wosT34 = wosT34;
	}



	/**
	 * Return the value associated with the column: WOS_T35
	 */
	public java.lang.String getWosT35 () {
		return wosT35;
	}

	/**
	 * Set the value related to the column: WOS_T35
	 * @param wosT35 the WOS_T35 value
	 */
	public void setWosT35 (java.lang.String wosT35) {
		this.wosT35 = wosT35;
	}



	/**
	 * Return the value associated with the column: WOS_T36
	 */
	public java.lang.String getWosT36 () {
		return wosT36;
	}

	/**
	 * Set the value related to the column: WOS_T36
	 * @param wosT36 the WOS_T36 value
	 */
	public void setWosT36 (java.lang.String wosT36) {
		this.wosT36 = wosT36;
	}



	/**
	 * Return the value associated with the column: WOS_T37
	 */
	public java.lang.String getWosT37 () {
		return wosT37;
	}

	/**
	 * Set the value related to the column: WOS_T37
	 * @param wosT37 the WOS_T37 value
	 */
	public void setWosT37 (java.lang.String wosT37) {
		this.wosT37 = wosT37;
	}



	/**
	 * Return the value associated with the column: WOS_T38
	 */
	public java.lang.String getWosT38 () {
		return wosT38;
	}

	/**
	 * Set the value related to the column: WOS_T38
	 * @param wosT38 the WOS_T38 value
	 */
	public void setWosT38 (java.lang.String wosT38) {
		this.wosT38 = wosT38;
	}



	/**
	 * Return the value associated with the column: WOS_T39
	 */
	public java.lang.String getWosT39 () {
		return wosT39;
	}

	/**
	 * Set the value related to the column: WOS_T39
	 * @param wosT39 the WOS_T39 value
	 */
	public void setWosT39 (java.lang.String wosT39) {
		this.wosT39 = wosT39;
	}



	/**
	 * Return the value associated with the column: WOS_T4
	 */
	public java.lang.String getWosT4 () {
		return wosT4;
	}

	/**
	 * Set the value related to the column: WOS_T4
	 * @param wosT4 the WOS_T4 value
	 */
	public void setWosT4 (java.lang.String wosT4) {
		this.wosT4 = wosT4;
	}



	/**
	 * Return the value associated with the column: WOS_T40
	 */
	public java.lang.String getWosT40 () {
		return wosT40;
	}

	/**
	 * Set the value related to the column: WOS_T40
	 * @param wosT40 the WOS_T40 value
	 */
	public void setWosT40 (java.lang.String wosT40) {
		this.wosT40 = wosT40;
	}



	/**
	 * Return the value associated with the column: WOS_T41
	 */
	public java.lang.String getWosT41 () {
		return wosT41;
	}

	/**
	 * Set the value related to the column: WOS_T41
	 * @param wosT41 the WOS_T41 value
	 */
	public void setWosT41 (java.lang.String wosT41) {
		this.wosT41 = wosT41;
	}



	/**
	 * Return the value associated with the column: WOS_T42
	 */
	public java.lang.String getWosT42 () {
		return wosT42;
	}

	/**
	 * Set the value related to the column: WOS_T42
	 * @param wosT42 the WOS_T42 value
	 */
	public void setWosT42 (java.lang.String wosT42) {
		this.wosT42 = wosT42;
	}



	/**
	 * Return the value associated with the column: WOS_T43
	 */
	public java.lang.String getWosT43 () {
		return wosT43;
	}

	/**
	 * Set the value related to the column: WOS_T43
	 * @param wosT43 the WOS_T43 value
	 */
	public void setWosT43 (java.lang.String wosT43) {
		this.wosT43 = wosT43;
	}



	/**
	 * Return the value associated with the column: WOS_T44
	 */
	public java.lang.String getWosT44 () {
		return wosT44;
	}

	/**
	 * Set the value related to the column: WOS_T44
	 * @param wosT44 the WOS_T44 value
	 */
	public void setWosT44 (java.lang.String wosT44) {
		this.wosT44 = wosT44;
	}



	/**
	 * Return the value associated with the column: WOS_T45
	 */
	public java.lang.String getWosT45 () {
		return wosT45;
	}

	/**
	 * Set the value related to the column: WOS_T45
	 * @param wosT45 the WOS_T45 value
	 */
	public void setWosT45 (java.lang.String wosT45) {
		this.wosT45 = wosT45;
	}



	/**
	 * Return the value associated with the column: WOS_T46
	 */
	public java.lang.String getWosT46 () {
		return wosT46;
	}

	/**
	 * Set the value related to the column: WOS_T46
	 * @param wosT46 the WOS_T46 value
	 */
	public void setWosT46 (java.lang.String wosT46) {
		this.wosT46 = wosT46;
	}



	/**
	 * Return the value associated with the column: WOS_T47
	 */
	public java.lang.String getWosT47 () {
		return wosT47;
	}

	/**
	 * Set the value related to the column: WOS_T47
	 * @param wosT47 the WOS_T47 value
	 */
	public void setWosT47 (java.lang.String wosT47) {
		this.wosT47 = wosT47;
	}



	/**
	 * Return the value associated with the column: WOS_T48
	 */
	public java.lang.String getWosT48 () {
		return wosT48;
	}

	/**
	 * Set the value related to the column: WOS_T48
	 * @param wosT48 the WOS_T48 value
	 */
	public void setWosT48 (java.lang.String wosT48) {
		this.wosT48 = wosT48;
	}



	/**
	 * Return the value associated with the column: WOS_T49
	 */
	public java.lang.String getWosT49 () {
		return wosT49;
	}

	/**
	 * Set the value related to the column: WOS_T49
	 * @param wosT49 the WOS_T49 value
	 */
	public void setWosT49 (java.lang.String wosT49) {
		this.wosT49 = wosT49;
	}



	/**
	 * Return the value associated with the column: WOS_T5
	 */
	public java.lang.String getWosT5 () {
		return wosT5;
	}

	/**
	 * Set the value related to the column: WOS_T5
	 * @param wosT5 the WOS_T5 value
	 */
	public void setWosT5 (java.lang.String wosT5) {
		this.wosT5 = wosT5;
	}



	/**
	 * Return the value associated with the column: WOS_T50
	 */
	public java.lang.String getWosT50 () {
		return wosT50;
	}

	/**
	 * Set the value related to the column: WOS_T50
	 * @param wosT50 the WOS_T50 value
	 */
	public void setWosT50 (java.lang.String wosT50) {
		this.wosT50 = wosT50;
	}



	/**
	 * Return the value associated with the column: WOS_T51
	 */
	public java.lang.String getWosT51 () {
		return wosT51;
	}

	/**
	 * Set the value related to the column: WOS_T51
	 * @param wosT51 the WOS_T51 value
	 */
	public void setWosT51 (java.lang.String wosT51) {
		this.wosT51 = wosT51;
	}



	/**
	 * Return the value associated with the column: WOS_T52
	 */
	public java.lang.String getWosT52 () {
		return wosT52;
	}

	/**
	 * Set the value related to the column: WOS_T52
	 * @param wosT52 the WOS_T52 value
	 */
	public void setWosT52 (java.lang.String wosT52) {
		this.wosT52 = wosT52;
	}



	/**
	 * Return the value associated with the column: WOS_T53
	 */
	public java.lang.String getWosT53 () {
		return wosT53;
	}

	/**
	 * Set the value related to the column: WOS_T53
	 * @param wosT53 the WOS_T53 value
	 */
	public void setWosT53 (java.lang.String wosT53) {
		this.wosT53 = wosT53;
	}



	/**
	 * Return the value associated with the column: WOS_T54
	 */
	public java.lang.String getWosT54 () {
		return wosT54;
	}

	/**
	 * Set the value related to the column: WOS_T54
	 * @param wosT54 the WOS_T54 value
	 */
	public void setWosT54 (java.lang.String wosT54) {
		this.wosT54 = wosT54;
	}



	/**
	 * Return the value associated with the column: WOS_T55
	 */
	public java.lang.String getWosT55 () {
		return wosT55;
	}

	/**
	 * Set the value related to the column: WOS_T55
	 * @param wosT55 the WOS_T55 value
	 */
	public void setWosT55 (java.lang.String wosT55) {
		this.wosT55 = wosT55;
	}



	/**
	 * Return the value associated with the column: WOS_T56
	 */
	public java.lang.String getWosT56 () {
		return wosT56;
	}

	/**
	 * Set the value related to the column: WOS_T56
	 * @param wosT56 the WOS_T56 value
	 */
	public void setWosT56 (java.lang.String wosT56) {
		this.wosT56 = wosT56;
	}



	/**
	 * Return the value associated with the column: WOS_T57
	 */
	public java.lang.String getWosT57 () {
		return wosT57;
	}

	/**
	 * Set the value related to the column: WOS_T57
	 * @param wosT57 the WOS_T57 value
	 */
	public void setWosT57 (java.lang.String wosT57) {
		this.wosT57 = wosT57;
	}



	/**
	 * Return the value associated with the column: WOS_T58
	 */
	public java.lang.String getWosT58 () {
		return wosT58;
	}

	/**
	 * Set the value related to the column: WOS_T58
	 * @param wosT58 the WOS_T58 value
	 */
	public void setWosT58 (java.lang.String wosT58) {
		this.wosT58 = wosT58;
	}



	/**
	 * Return the value associated with the column: WOS_T59
	 */
	public java.lang.String getWosT59 () {
		return wosT59;
	}

	/**
	 * Set the value related to the column: WOS_T59
	 * @param wosT59 the WOS_T59 value
	 */
	public void setWosT59 (java.lang.String wosT59) {
		this.wosT59 = wosT59;
	}



	/**
	 * Return the value associated with the column: WOS_T6
	 */
	public java.lang.String getWosT6 () {
		return wosT6;
	}

	/**
	 * Set the value related to the column: WOS_T6
	 * @param wosT6 the WOS_T6 value
	 */
	public void setWosT6 (java.lang.String wosT6) {
		this.wosT6 = wosT6;
	}



	/**
	 * Return the value associated with the column: WOS_T60
	 */
	public java.lang.String getWosT60 () {
		return wosT60;
	}

	/**
	 * Set the value related to the column: WOS_T60
	 * @param wosT60 the WOS_T60 value
	 */
	public void setWosT60 (java.lang.String wosT60) {
		this.wosT60 = wosT60;
	}



	/**
	 * Return the value associated with the column: WOS_T7
	 */
	public java.lang.String getWosT7 () {
		return wosT7;
	}

	/**
	 * Set the value related to the column: WOS_T7
	 * @param wosT7 the WOS_T7 value
	 */
	public void setWosT7 (java.lang.String wosT7) {
		this.wosT7 = wosT7;
	}



	/**
	 * Return the value associated with the column: WOS_T8
	 */
	public java.lang.String getWosT8 () {
		return wosT8;
	}

	/**
	 * Set the value related to the column: WOS_T8
	 * @param wosT8 the WOS_T8 value
	 */
	public void setWosT8 (java.lang.String wosT8) {
		this.wosT8 = wosT8;
	}



	/**
	 * Return the value associated with the column: WOS_T9
	 */
	public java.lang.String getWosT9 () {
		return wosT9;
	}

	/**
	 * Set the value related to the column: WOS_T9
	 * @param wosT9 the WOS_T9 value
	 */
	public void setWosT9 (java.lang.String wosT9) {
		this.wosT9 = wosT9;
	}



	/**
	 * Return the value associated with the column: WOS_TYPE
	 */
	public java.lang.String getWosType () {
		return wosType;
	}

	/**
	 * Set the value related to the column: WOS_TYPE
	 * @param wosType the WOS_TYPE value
	 */
	public void setWosType (java.lang.String wosType) {
		this.wosType = wosType;
	}



	/**
	 * Return the value associated with the column: WOS_UPDATETIME
	 */
	public java.util.Date getWosUpdatetime () {
		return wosUpdatetime;
	}

	/**
	 * Set the value related to the column: WOS_UPDATETIME
	 * @param wosUpdatetime the WOS_UPDATETIME value
	 */
	public void setWosUpdatetime (java.util.Date wosUpdatetime) {
		this.wosUpdatetime = wosUpdatetime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.CrmWo)) return false;
		else {
			com.liveneo.plat.hibernate.dao.CrmWo crmWo = (com.liveneo.plat.hibernate.dao.CrmWo) obj;
			if (null == this.getId() || null == crmWo.getId()) return false;
			else return (this.getId().equals(crmWo.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	 public String toString () {
		return super.toString();
	}



}