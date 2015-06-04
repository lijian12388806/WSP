/*
Navicat MySQL Data Transfer

Source Server         : 172.16.5.99
Source Server Version : 50095
Source Host           : 172.16.5.99:3306
Source Database       : smartcc

Target Server Type    : MYSQL
Target Server Version : 50095
File Encoding         : 65001

Date: 2014-11-26 15:08:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent_kpi_day_t
-- ----------------------------
DROP TABLE IF EXISTS `agent_kpi_day_t`;
CREATE TABLE `agent_kpi_day_t` (
  `ID` int(11) NOT NULL auto_increment,
  `SKILL_ID` varchar(40) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `STAT_TIME` varchar(20) default NULL,
  `TAIME` varchar(20) default NULL,
  `AGENT_ID` varchar(40) default NULL,
  `AGENT_NAME` varchar(40) default NULL,
  `ONLINE_TIME` decimal(32,0) default NULL,
  `TAIKING_TIME` decimal(32,0) default NULL,
  `WRAPUP_TIME` decimal(32,0) default NULL,
  `HOLD_TIME` decimal(32,0) default NULL,
  `IDLE_TIME` decimal(32,0) default NULL,
  `REST_TIME` decimal(32,0) default NULL,
  `OTHER_TIME` decimal(32,0) default NULL,
  `ANSWER_NUM` decimal(32,0) default NULL,
  `CALLOUT_NUM` decimal(32,0) default NULL,
  `CALLOUT_SUCC_NUM` decimal(32,0) default NULL,
  `TRANSF_NUM` decimal(32,0) default NULL,
  `CONF_NUM` decimal(32,0) default NULL,
  `HOLD_NUM` decimal(32,0) default NULL,
  `WORK_LOAD` decimal(32,0) default NULL,
  `AGENT_WORK_RATE` decimal(32,4) default NULL,
  `AVG_TALKING_TIME` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=709605 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of agent_kpi_day_t
-- ----------------------------

-- ----------------------------
-- Table structure for base_agentdevicestate
-- ----------------------------
DROP TABLE IF EXISTS `base_agentdevicestate`;
CREATE TABLE `base_agentdevicestate` (
  `AgentLoginID` varchar(64) default NULL,
  `ContactID` varchar(64) default NULL,
  `EventID` decimal(32,0) NOT NULL,
  `DeviceDN` varchar(64) NOT NULL,
  `DeviceType` decimal(2,0) default NULL,
  `CurrStatus` decimal(2,0) NOT NULL,
  `StartTime` varchar(64) NOT NULL,
  `LastStatus` decimal(2,0) NOT NULL,
  `LastStatusTimeLen` decimal(32,0) default NULL,
  `Reason` decimal(32,0) default NULL,
  `CallID` decimal(32,0) default NULL,
  `OldCallID` decimal(32,0) default NULL,
  `SecOldCallID` decimal(32,0) default NULL,
  `OtherParty` varchar(64) default NULL,
  `ThirdParty` varchar(64) default NULL,
  `CallingParty` varchar(64) default NULL,
  `CalledParty` varchar(64) default NULL,
  PRIMARY KEY  (`EventID`,`DeviceDN`,`CurrStatus`,`StartTime`,`LastStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_agentdevicestate
-- ----------------------------

-- ----------------------------
-- Table structure for base_agentinfo
-- ----------------------------
DROP TABLE IF EXISTS `base_agentinfo`;
CREATE TABLE `base_agentinfo` (
  `AgentLoginID` varchar(64) NOT NULL,
  `AgentID` varchar(64) default NULL,
  `AgentName` varchar(64) default NULL,
  `AgentDN` varchar(64) default NULL,
  `AgentIP` varchar(64) default NULL,
  `SkillDesc` varchar(256) default NULL,
  `LoginTime` varchar(64) NOT NULL default '',
  `AgentType` decimal(2,0) default NULL,
  `PlatformID` varchar(32) default '',
  PRIMARY KEY  (`AgentLoginID`,`LoginTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_agentinfo
-- ----------------------------

-- ----------------------------
-- Table structure for base_agentstate
-- ----------------------------
DROP TABLE IF EXISTS `base_agentstate`;
CREATE TABLE `base_agentstate` (
  `AgentLoginID` varchar(64) NOT NULL,
  `ContactID` varchar(64) default NULL,
  `EventID` decimal(32,0) NOT NULL,
  `SkillID` decimal(32,0) NOT NULL,
  `AgentStatus` decimal(2,0) default NULL,
  `StartTime` varchar(64) NOT NULL,
  `LastStatus` decimal(2,0) default NULL,
  `LastStatusTimeLen` decimal(32,0) default NULL,
  `Reason` decimal(32,0) default NULL,
  PRIMARY KEY  (`AgentLoginID`,`EventID`,`SkillID`,`StartTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_agentstate
-- ----------------------------

-- ----------------------------
-- Table structure for base_contactinfo
-- ----------------------------
DROP TABLE IF EXISTS `base_contactinfo`;
CREATE TABLE `base_contactinfo` (
  `ContactID` varchar(64) NOT NULL,
  `OriANI` varchar(64) default NULL,
  `OriDNIS` varchar(64) default NULL,
  `ChannelType` decimal(2,0) default NULL,
  `CallDirection` decimal(2,0) default NULL,
  `CallType` decimal(2,0) default NULL,
  `StartTime` varchar(64) default NULL,
  `LastContactID` varchar(64) default '',
  `OriContactID` varchar(64) default '',
  `PlatformID` varchar(32) default '',
  PRIMARY KEY  (`ContactID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_contactinfo
-- ----------------------------

-- ----------------------------
-- Table structure for base_contactstate
-- ----------------------------
DROP TABLE IF EXISTS `base_contactstate`;
CREATE TABLE `base_contactstate` (
  `ContactID` varchar(64) NOT NULL,
  `EventID` decimal(32,0) NOT NULL,
  `ContactStatus` decimal(2,0) NOT NULL,
  `StartTime` varchar(64) NOT NULL,
  `LastStatus` decimal(2,0) NOT NULL,
  `LastStatusTimeLen` decimal(32,0) default NULL,
  `SkillID` decimal(32,0) NOT NULL,
  `DeviceDN` varchar(64) NOT NULL,
  `DeviceType` decimal(2,0) default NULL,
  `Reason` decimal(32,0) default NULL,
  `RouteID` decimal(32,0) default NULL,
  `RouteMaxTime` decimal(32,0) default NULL,
  `WorkUnitID` decimal(32,0) default '0',
  PRIMARY KEY  (`ContactID`,`EventID`,`ContactStatus`,`StartTime`,`LastStatus`,`SkillID`,`DeviceDN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_contactstate
-- ----------------------------

-- ----------------------------
-- Table structure for base_ivrdevicestate
-- ----------------------------
DROP TABLE IF EXISTS `base_ivrdevicestate`;
CREATE TABLE `base_ivrdevicestate` (
  `ContactID` varchar(64) NOT NULL,
  `EventID` decimal(32,0) NOT NULL,
  `DeviceDN` varchar(64) NOT NULL,
  `DeviceType` decimal(2,0) default NULL,
  `StartTime` varchar(64) NOT NULL,
  `CurrStatus` decimal(2,0) NOT NULL,
  `LastStatus` decimal(2,0) NOT NULL,
  `LastStatusTimeLen` decimal(32,0) default NULL,
  `RouteID` decimal(32,0) default NULL,
  `Reason` decimal(32,0) default NULL,
  `CallID` decimal(32,0) default NULL,
  `OldCallID` decimal(32,0) default NULL,
  `SecOldCallID` decimal(32,0) default NULL,
  `OtherParty` varchar(64) default NULL,
  `ThirdParty` varchar(64) default NULL,
  `CallingParty` varchar(64) default NULL,
  `CalledParty` varchar(64) default NULL,
  PRIMARY KEY  (`ContactID`,`EventID`,`DeviceDN`,`StartTime`,`CurrStatus`,`LastStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_ivrdevicestate
-- ----------------------------

-- ----------------------------
-- Table structure for base_recordfile
-- ----------------------------
DROP TABLE IF EXISTS `base_recordfile`;
CREATE TABLE `base_recordfile` (
  `ContactID` varchar(64) NOT NULL,
  `AgentLoginID` varchar(64) default NULL,
  `DeviceDN` varchar(64) NOT NULL,
  `DeviceType` decimal(2,0) default NULL,
  `CallDirection` decimal(2,0) default NULL,
  `CallType` decimal(2,0) default NULL,
  `OriANI` varchar(64) NOT NULL,
  `OriDNIS` varchar(64) default NULL,
  `StartTime` varchar(64) NOT NULL,
  `TimeLength` decimal(32,0) default NULL,
  `FileName` varchar(256) NOT NULL,
  `CallID` decimal(32,0) default NULL,
  `OldCallID` decimal(32,0) default NULL,
  `SecOldCallID` decimal(32,0) default NULL,
  `CallingParty` varchar(64) default NULL,
  `CalledParty` varchar(64) default NULL,
  `OtherParty` varchar(64) default NULL,
  `ThirdParty` varchar(64) default NULL,
  `UserField` varchar(64) default NULL,
  PRIMARY KEY  (`ContactID`,`DeviceDN`,`StartTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_recordfile
-- ----------------------------

-- ----------------------------
-- Table structure for manual_callinfo_stat_day_t
-- ----------------------------
DROP TABLE IF EXISTS `manual_callinfo_stat_day_t`;
CREATE TABLE `manual_callinfo_stat_day_t` (
  `ID` int(20) NOT NULL auto_increment,
  `SKILL_ID` varchar(40) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `STAT_TIME` varchar(20) default NULL,
  `TIME` varchar(20) default NULL,
  `IVR_TRANSF_NUM` decimal(32,0) default NULL,
  `IVR_TRANSF_RATE` decimal(32,4) default NULL,
  `IVR_TRANSF_FAILED` decimal(32,0) default NULL,
  `ANSWER_NUM` decimal(32,0) default NULL,
  `ANSWER_RATE` decimal(32,4) default NULL,
  `ANSWERIN20_RATE` decimal(32,4) default NULL,
  `AVGSUCC_WAIT_TIME` decimal(32,0) default NULL,
  `AVGFAIL_WAITE_TIME` decimal(32,0) default NULL,
  `AVG_TALKING_TIME` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=14754 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manual_callinfo_stat_day_t
-- ----------------------------

-- ----------------------------
-- Procedure structure for PRO_STATAGENTKPI
-- ----------------------------
DROP PROCEDURE IF EXISTS `PRO_STATAGENTKPI`;
DELIMITER ;;
CREATE DEFINER=`ipcc`@`%` PROCEDURE `PRO_STATAGENTKPI`(IN statetime CHAR(40),IN reporttype CHAR(10))
BEGIN
 declare starttime varchar(40); 
   declare endtime varchar(40);
   declare times varchar(20);
if reporttype ='month' then 
   set endtime =date_format((str_to_date(statetime,'%Y-%m-%d %H:%i:%s')) ,'%Y-%m-%d');
   set starttime = date_format(DATE_SUB(str_to_date(statetime,'%Y-%m-%d %H:%i:%s'),INTERVAL 24 HOUR) ,'%Y-%m-%d');
   set times = date_format(DATE_SUB(str_to_date(statetime,'%Y-%m-%d %H:%i:%s'),INTERVAL 24 HOUR) ,'%d' );
   set endtime = CONCAT(endtime,' 00:00:00.000');
   set starttime = CONCAT(starttime,' 00:00:00.000');
   delete from db_ckk.agent_kpi_day where TAIME = times and STAT_TIME>starttime;
   select STATAGENTKPI(starttime,endtime,times);
  select STATAGENTKPI(starttime,endtime,times);
   set starttime =date_format((str_to_date(statetime,'%Y-%m-%d %H:%i:%s')) ,'%Y-%m-%d');
   set endtime =date_format(NOW() ,'%Y-%m-%d');
   set times = date_format((str_to_date(statetime,'%Y-%m-%d %H:%i:%s')) ,'%d');
   set endtime = CONCAT(endtime,' 00:00:00.000');
   set starttime = CONCAT(starttime,' 00:00:00.000');
   delete from db_ckk.agent_kpi_day where TAIME = times and STAT_TIME>starttime;
   select STATAGENTKPI(starttime,endtime,times);
   else
set @tmp=1; 
end if;

end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for PRO_STATCALLINFO
-- ----------------------------
DROP PROCEDURE IF EXISTS `PRO_STATCALLINFO`;
DELIMITER ;;
CREATE DEFINER=`ipcc`@`%` PROCEDURE `PRO_STATCALLINFO`(IN statetime CHAR(40),IN reporttype CHAR(10))
BEGIN
 declare starttime varchar(40); 
   declare endtime varchar(40);
   declare times varchar(20);
if reporttype ='day' then 
   set endtime =date_format((str_to_date(statetime,'%Y-%m-%d %H:%i:%s')) ,'%Y-%m-%d %H:');
   set starttime = date_format(DATE_SUB(str_to_date(statetime,'%Y-%m-%d %H:%i:%s'),INTERVAL 1 HOUR) ,'%Y-%m-%d %H:');
   set times = date_format(DATE_SUB(str_to_date(statetime,'%Y-%m-%d %H:%i:%s'),INTERVAL 1 HOUR) ,'%H' );
   set endtime = CONCAT(endtime,'00:00.000');
   set starttime = CONCAT(starttime,'00:00.000');
   delete from db_ckk.manual_callinfo_stat_day where TIME = times and STAT_TIME>starttime;
   select STATCALLINFO(starttime,endtime,times);
   set starttime =date_format((str_to_date(statetime,'%Y-%m-%d %H:%i:%s')) ,'%Y-%m-%d %H:');
   set endtime =date_format(NOW() ,'%Y-%m-%d %H:');
   set times = date_format((str_to_date(statetime,'%Y-%m-%d %H:%i:%s')) ,'%H');
   set endtime = CONCAT(endtime,'00:00.000');
   set starttime = CONCAT(starttime,'00:00.000');
   delete from db_ckk.manual_callinfo_stat_day where TIME = times and STAT_TIME>starttime;
   select STATCALLINFO(starttime,endtime,times);
   else
set @tmp=1; 
end if;

end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for STATAGENTKPI
-- ----------------------------
DROP FUNCTION IF EXISTS `STATAGENTKPI`;
DELIMITER ;;
CREATE DEFINER=`ipcc`@`%` FUNCTION `STATAGENTKPI`(starttime CHAR(40),endtime CHAR(40),times CHAR(20)) RETURNS varchar(255) CHARSET latin1
BEGIN
delete from AGENT_KPI_DAY_T;
insert into AGENT_KPI_DAY_T (AGENT_ID,ONLINE_TIME)
select g.AgentID,sum(g.loginlenth) from(
select a.AgentLoginID ,b.AgentID,b.AgentDN,b.LoginTime,
a.StartTime as LogoutTime,TIMESTAMPDIFF(SECOND,b.LoginTime,a.StartTime) as loginlenth
from base_agentstate a ,base_agentinfo b where a.AgentLoginID=b.AgentLoginID
and a.EventID='806354953' and b.LoginTime >=starttime and b.LoginTime<endtime)g  group by g.AgentID ;
insert into AGENT_KPI_DAY_T (AGENT_ID,TAIKING_TIME)
select b.AgentID,sum(a.LastStatusTimeLen) 
       from base_agentstate a ,base_agentinfo b where a.AgentLoginID=b.AgentLoginID 
     and a.LastStatus=5 and a.StartTime>=starttime and a.StartTime<endtime group by b.AgentID;
insert into AGENT_KPI_DAY_T (AGENT_ID,IDLE_TIME)
select b.AgentID,sum(a.LastStatusTimeLen) 
       from base_agentstate a ,base_agentinfo b where a.AgentLoginID=b.AgentLoginID 
     and a.LastStatus=3 and a.StartTime>=starttime and a.StartTime<endtime group by b.AgentID;
insert into AGENT_KPI_DAY_T (AGENT_ID,REST_TIME)
select b.AgentID,sum(a.LastStatusTimeLen) 
       from base_agentstate a ,base_agentinfo b where a.AgentLoginID=b.AgentLoginID 
     and a.LastStatus=2 and a.StartTime>=starttime and a.StartTime<endtime group by b.AgentID;
insert into AGENT_KPI_DAY_T (AGENT_ID,WRAPUP_TIME)
select b.AgentID,sum(a.LastStatusTimeLen) 
       from base_agentstate a ,base_agentinfo b where a.AgentLoginID=b.AgentLoginID 
     and a.LastStatus=6 and a.StartTime>=starttime and a.StartTime<endtime group by b.AgentID;
insert into db_ckk.AGENT_KPI_DAY (STAT_TIME,TAIME,AGENT_ID,ONLINE_TIME,TAIKING_TIME,WRAPUP_TIME,IDLE_TIME,REST_TIME)
select CONCAT(date_format(now() ,'%Y-%m-%d %H:%i:%s'),'.000') ,times,y.AGENT_ID,sum(y.ONLINE_TIME),sum(y.TAIKING_TIME)/1000,sum(y.WRAPUP_TIME)/1000,sum(y.IDLE_TIME)/1000,sum(y.REST_TIME)/1000 
       from  AGENT_KPI_DAY_T y group by y.AGENT_ID;
update db_ckk.AGENT_KPI_DAY set AGENT_WORK_RATE = (TAIKING_TIME+WRAPUP_TIME)/ONLINE_TIME where ONLINE_TIME>0;
       RETURN('OK');
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for STATCALLINFO
-- ----------------------------
DROP FUNCTION IF EXISTS `STATCALLINFO`;
DELIMITER ;;
CREATE DEFINER=`ipcc`@`%` FUNCTION `STATCALLINFO`(starttime CHAR(40),endtime CHAR(40),times CHAR(20)) RETURNS varchar(255) CHARSET latin1
BEGIN
delete from MANUAL_CALLINFO_STAT_DAY_T;
insert into MANUAL_CALLINFO_STAT_DAY_T ( SKILL_ID,TIME,ANSWER_NUM,AVGSUCC_WAIT_TIME)
select w.AgentID,'10',count(w.ContactID)as call_num,sum(talkinglen)as totallen  from(select a.AgentLoginID,b.AgentID,b.AgentDN,i.ContactID,i.OriANI,i.OriDNIS,i.CallDirection,
i.CallType,i.StartTime,s.StartTime as EndTime,TIMESTAMPDIFF(SECOND,i.StartTime,s.StartTime)as talkinglen
 from base_contactinfo i,base_contactstate s ,base_agentstate a ,base_agentinfo b
 where i.ContactID=s.ContactID and s.EventID='806355206'and 
 a.ContactID=i.ContactID and a.EventID='806354951'and b.AgentLoginID=a.AgentLoginID and i.CallType='1'and i.CallDirection='1'
  and (i.StartTime>=starttime and i.StartTime<endtime) )w 
 group by w.AgentID;
insert into MANUAL_CALLINFO_STAT_DAY_T ( SKILL_ID,TIME,IVR_TRANSF_NUM,AVGSUCC_WAIT_TIME)
select w.AgentID,'10',count(w.ContactID)as call_num,sum(talkinglen)as totallen  from(select a.AgentLoginID,b.AgentID,b.AgentDN,i.ContactID,i.OriANI,i.OriDNIS,i.CallDirection,
i.CallType,i.StartTime,s.StartTime as EndTime,TIMESTAMPDIFF(SECOND,i.StartTime,s.StartTime)as talkinglen
 from base_contactinfo i,base_contactstate s ,base_agentstate a ,base_agentinfo b
 where i.ContactID=s.ContactID and s.EventID='806355206'and 
 a.ContactID=i.ContactID and a.EventID='806354951'and b.AgentLoginID=a.AgentLoginID and i.CallType='1'and i.CallDirection='2'
  and (i.StartTime>=starttime and i.StartTime<endtime) )w 
 group by w.AgentID;
insert into db_ckk.MANUAL_CALLINFO_STAT_DAY (SKILL_ID,STAT_TIME,TIME,IVR_TRANSF_NUM,ANSWER_NUM,AVGSUCC_WAIT_TIME)
select m.SKILL_ID, CONCAT(date_format(now() ,'%Y-%m-%d %H:%i:%s'),'.000'),times,sum(m.IVR_TRANSF_NUM),sum(m.ANSWER_NUM),sum(m.AVGSUCC_WAIT_TIME)
 from MANUAL_CALLINFO_STAT_DAY_T m GROUP by m.SKILL_ID ;
update db_ckk.MANUAL_CALLINFO_STAT_DAY t set t.AVG_TALKING_TIME=t.AVGSUCC_WAIT_TIME/(t.ANSWER_NUM+t.IVR_TRANSF_NUM) where (t.ANSWER_NUM+t.IVR_TRANSF_NUM)>0;
 RETURN('OK');
end
;;
DELIMITER ;
