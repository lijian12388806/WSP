-- MySQL dump 10.11
--
-- Host: localhost    Database: db_ckk
-- ------------------------------------------------------
-- Server version	5.0.95

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agent_call_list`
--

DROP TABLE IF EXISTS `agent_call_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_call_list` (
  `ID` int(11) NOT NULL auto_increment,
  `STAT_TIME` varchar(20) default NULL,
  `AGENT_ID` varchar(40) default NULL,
  `AGENT_NAME` varchar(40) default NULL,
  `SKILL_ID` varchar(40) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `START_TIME` varchar(50) default NULL,
  `TALKING_TIME` decimal(32,0) default NULL,
  `CALLER` varchar(20) default NULL,
  `CALLED` varchar(20) default NULL,
  `REC_PATH` varchar(120) default NULL,
  `DIRECTION` decimal(2,0) default NULL,
  `CALLTYPE` decimal(2,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8170 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_call_list`
--

LOCK TABLES `agent_call_list` WRITE;
/*!40000 ALTER TABLE `agent_call_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_call_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_kpi_day`
--

DROP TABLE IF EXISTS `agent_kpi_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_kpi_day` (
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
) ENGINE=MyISAM AUTO_INCREMENT=215288 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_kpi_day`
--

LOCK TABLES `agent_kpi_day` WRITE;
/*!40000 ALTER TABLE `agent_kpi_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_kpi_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_kpi_month`
--

DROP TABLE IF EXISTS `agent_kpi_month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_kpi_month` (
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_kpi_month`
--

LOCK TABLES `agent_kpi_month` WRITE;
/*!40000 ALTER TABLE `agent_kpi_month` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_kpi_month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_kpi_year`
--

DROP TABLE IF EXISTS `agent_kpi_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_kpi_year` (
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
  `HOLD_TIME` decimal(32,0) NOT NULL,
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_kpi_year`
--

LOCK TABLES `agent_kpi_year` WRITE;
/*!40000 ALTER TABLE `agent_kpi_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_kpi_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bd_dict`
--

DROP TABLE IF EXISTS `bd_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bd_dict` (
  `PK_DICT` int(11) NOT NULL auto_increment,
  `DICTCODE` varchar(20) default NULL,
  `DICTTITLE` varchar(20) default NULL,
  `DICTTYPE` varchar(20) default NULL,
  `ISVALID` varchar(10) default NULL,
  `REMARK` varchar(100) default NULL,
  `TEMP` varchar(100) default NULL,
  PRIMARY KEY  (`PK_DICT`)
) ENGINE=MyISAM AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bd_dict`
--

LOCK TABLES `bd_dict` WRITE;
/*!40000 ALTER TABLE `bd_dict` DISABLE KEYS */;
INSERT INTO `bd_dict` VALUES (52,'LOGTYPE','日志分类',NULL,'Y',NULL,NULL),(55,'CUSTOMER','客户',NULL,'Y',NULL,NULL),(56,'ORDERSTATUS','状态',NULL,'Y',NULL,NULL),(60,'OrderType','工单类型',NULL,'Y',NULL,NULL),(61,'Projecttype','项目类型',NULL,'Y',NULL,NULL),(62,'SourceOrder','工单来源',NULL,'Y',NULL,NULL),(63,'WorkOrderStatus','工单状态',NULL,'Y',NULL,NULL),(64,'Order','订单',NULL,'Y',NULL,NULL),(65,'CusinfoSource','客户信息来源',NULL,'Y',NULL,NULL),(66,'Sampletemplate','小样样板',NULL,'Y',NULL,NULL),(67,'Onsiteservice','现场服务',NULL,'Y',NULL,NULL),(68,'Complainthandling','投诉处理',NULL,'Y',NULL,NULL),(69,'GenerateMode','生成类型',NULL,'Y',NULL,NULL),(70,'AgentType','坐席类型',NULL,'Y',NULL,NULL),(71,'UserStatus','用户状态',NULL,'Y',NULL,NULL),(72,'AuthorizeType','授权方式',NULL,'Y',NULL,NULL),(73,'CustType1','客户分类一',NULL,'Y',NULL,NULL),(74,'Distribute','经销',NULL,'Y',NULL,NULL),(75,'DirectMark','直销',NULL,'Y',NULL,NULL),(76,'CustType3','客户分类三',NULL,'Y',NULL,NULL),(77,'SynStatus','同步状态',NULL,'Y',NULL,NULL),(78,'CallCreateType','创建类型',NULL,'Y',NULL,NULL),(79,'AgentStatus','当前状态',NULL,'Y',NULL,NULL),(80,'ISLost','是否呼损',NULL,'Y',NULL,NULL),(81,'Compare','比较符号',NULL,'Y',NULL,NULL),(82,'CustType2','客户分类二',NULL,'Y',NULL,NULL),(83,'QT','其他',NULL,'Y',NULL,NULL),(84,'WorkingCalendar','工作日历',NULL,'Y',NULL,NULL),(85,'RTime_day','报表时间-日',NULL,'Y',NULL,NULL),(86,'CallType','呼叫类型',NULL,'Y',NULL,NULL),(87,'CallDirection','呼叫方向',NULL,'Y',NULL,NULL),(88,'Gender','性别',NULL,'Y',NULL,NULL),(93,'0101','121购购订单处理','OnDuty','Y','nick:13466502772','13466502772'),(94,'0102','产品咨询','OnDuty','Y','hebe:15811003291 nick:13466502772','15811003291 13466502772'),(95,'0103','大宗采购','OnDuty','Y','高潇涵:18612940053','18612940053'),(96,'0105','售后服务','OnDuty','Y','Blair:18310975776','18310975776'),(97,'0104','渠道合作','OnDuty','Y','高潇涵:18612940053','18612940053'),(98,'0106','广告合作','OnDuty','Y','Blair:18310975776','18310975776'),(99,'0107','投诉与建议','OnDuty','Y','Blair:18310975776','18310975776'),(100,'StaCode','满意度',NULL,'Y',NULL,NULL),(102,'1111','测试','OnDuty','Y','',''),(103,'SYS_BUTTON','系统参数-按钮分类',NULL,'Y',NULL,NULL),(104,'IPCC_CALLTYPE','IPCC-呼叫类型',NULL,'Y',NULL,NULL),(105,'IPCC_CALLDIRECTION','IPCC-呼叫方向',NULL,'Y',NULL,NULL);
/*!40000 ALTER TABLE `bd_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bd_dictdetail`
--

DROP TABLE IF EXISTS `bd_dictdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bd_dictdetail` (
  `PK_DICTDETAIL` int(11) NOT NULL auto_increment,
  `PK_DICT` int(11) NOT NULL,
  `CODE` varchar(100) default NULL,
  `TITLE` varchar(100) default NULL,
  `VALUE` varchar(100) default NULL,
  `ISVALID` varchar(2) default NULL,
  `REMARK` varchar(100) default NULL,
  `DEFAULTORDER` int(11) default NULL,
  PRIMARY KEY  (`PK_DICTDETAIL`)
) ENGINE=MyISAM AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bd_dictdetail`
--

LOCK TABLES `bd_dictdetail` WRITE;
/*!40000 ALTER TABLE `bd_dictdetail` DISABLE KEYS */;
INSERT INTO `bd_dictdetail` VALUES (3,48,'REGUSERS','用户数',NULL,'Y','',1),(9,52,'LOGTYPE-SC','删除',NULL,'Y','',1),(10,52,'LOGTYPE-XZ','新增',NULL,'Y','',1),(11,52,'LOGTYPE-DC','登出',NULL,'Y','',0),(14,55,'Liveneo','朗泰恒盛',NULL,'Y','',1),(16,56,'未审核','未审核',NULL,'Y','',1),(21,60,'O_Sampledepend','咨询',NULL,'Y','Sampletemplate',1),(22,60,'O_Amodeldepend','渠道',NULL,'Y','Sampletemplate',2),(23,60,'O_SampleReq','采购',NULL,'Y','Sampletemplate',3),(24,60,'O_OrderDelivery','投诉',NULL,'Y','Order',4),(25,60,'O_Onsiteservice','售后',NULL,'Y','Onsiteservice',5),(26,60,'O_Complainthand','退换货',NULL,'Y','Complainthandling',6),(27,60,'O_ReturnReq','其他',NULL,'Y','Complainthandling',7),(28,61,'Order','订单',NULL,'Y','',1),(29,61,'Sampletemplate','小样样板',NULL,'Y','',2),(30,61,'Onsiteservice','现场服务',NULL,'Y','',3),(31,61,'Complainthandling','投诉处理',NULL,'Y','',4),(32,62,'customer','客户',NULL,'Y','',1),(33,62,'sell','销售',NULL,'Y','',2),(34,63,'wcl','未处理',NULL,'Y','',1),(35,63,'dhxcl','待后续处理',NULL,'Y','',2),(36,63,'ywc','已完成',NULL,'Y','',3),(37,63,'yjd','已结单',NULL,'Y','',4),(38,64,'ylsycyc','依赖书延迟异常',NULL,'Y','',1),(39,64,'wlwhycyc','物料维护延迟异常',NULL,'Y','',2),(40,64,'ddycyc','订单延迟异常 ',NULL,'Y','',3),(41,64,'wljhyc','物流交货异常',NULL,'Y','',4),(42,64,'ddjdyc','订单进度的查询',NULL,'Y','',5),(43,65,'byhand','手工创建',NULL,'Y','',1),(44,65,'datesyn','资料同步',NULL,'Y','',2),(45,66,'S_delayExc','小样、样板延迟异常',NULL,'Y','',1),(46,66,'S_repeatExc','小样、样板重复异常',NULL,'Y','',2),(47,66,'S_majorMeet','重大项目的满足',NULL,'Y','',3),(48,66,'S_progressQuery','进度的查询',NULL,'Y','',4),(49,67,'On_serviceDispatch','服务人员对重大项目和特大项目的调配（调动大区、战略客户、应用管理部的全国资源）',NULL,'Y','',1),(50,67,'On_sampleDispatch','对重大项目和特大项目的样漆/样板/现场试刷/样板楼的人员分配 ',NULL,'Y','',2),(51,67,'On_specialDisplay','对特殊效果和产品的调样，样板的工厂间分配',NULL,'Y','',3),(52,68,'C_ComplaintsExc','投诉退货、换货异常',NULL,'Y','',1),(53,68,'C_compensateExc','样品赔偿异常',NULL,'Y','',2),(54,68,'C_produceExc','换货生产异常',NULL,'Y','',3),(55,68,'C_cchedule','进度查询',NULL,'Y','',4),(56,69,'caller','来电',NULL,'Y','',1),(57,69,'manual','手工',NULL,'Y','',2),(58,70,'OAgent','普通坐席',NULL,'Y','',1),(59,70,'LAgent','班长席',NULL,'Y','',2),(60,71,'Y','可用',NULL,'Y','',1),(61,71,'N','不可用',NULL,'Y','',2),(62,72,'Batch','批量授权',NULL,'Y','',1),(63,72,'Single','单机授权',NULL,'Y','',2),(64,73,'Distribute','经销',NULL,'Y','',1),(65,73,'DirectMark','直销',NULL,'Y','',2),(66,74,'A','A',NULL,'Y','',1),(67,74,'AA','AA',NULL,'Y','',2),(68,74,'AAA','AAA',NULL,'Y','',3),(69,75,'Ocust','普通客户',NULL,'Y','',1),(70,75,'Lcust','大客户',NULL,'Y','',2),(71,75,'VIPcust','VIP客户',NULL,'Y','',3),(72,76,'EastChina','华东',NULL,'Y','',1),(73,76,'NorthChina','华北',NULL,'Y','',2),(74,76,'SouthChina','华南',NULL,'Y','',3),(75,76,'Northeast','东北',NULL,'Y','',4),(76,76,'Luyu','鲁豫',NULL,'Y','',5),(77,76,'WestReason','西部',NULL,'Y','',6),(78,77,'Nsyn','未同步',NULL,'Y','',1),(79,77,'Ysyn','已同步',NULL,'Y','',2),(80,78,'Ivr','IVR',NULL,'Y','',1),(81,78,'Callin','坐席呼入',NULL,'Y','',2),(82,78,'Callout','坐席呼出',NULL,'Y','',3),(83,78,'LeaveMsg','留言',NULL,'Y','',4),(84,78,'Qt','其他',NULL,'Y','',5),(85,79,'login','登录中',NULL,'Y','',1),(86,79,'logout','未登录',NULL,'Y','',2),(87,80,'Y','是',NULL,'Y','',1),(88,80,'N','否',NULL,'Y','',2),(89,81,'=','=',NULL,'Y','',1),(90,81,'>','>',NULL,'Y','',2),(91,81,'>=','>=',NULL,'Y','',3),(92,81,'<','<',NULL,'Y','',4),(93,81,'<=','<=',NULL,'Y','',5),(94,82,'A','A',NULL,'Y','',1),(95,82,'AA','AA',NULL,'Y','',2),(96,82,'AAA','AAA',NULL,'Y','',3),(97,82,'Ocust','普通客户',NULL,'Y','',4),(98,82,'Lcust','大客户',NULL,'Y','',5),(99,82,'VIPcust','VIP客户',NULL,'Y','',6),(101,84,'Y','是',NULL,'Y','节假日',1),(102,84,'N','否',NULL,'Y','工作日',2),(104,85,'09:00','09:00',NULL,'Y','',1),(105,85,'10:00','10:00',NULL,'Y','',2),(106,85,'11:00','10:00',NULL,'Y','',3),(107,85,'12:00','12:00',NULL,'Y','',4),(108,85,'13:00','13:00',NULL,'Y','',5),(109,85,'14:00','14:00',NULL,'Y','',6),(110,85,'15:00','15:00',NULL,'Y','',7),(111,85,'16:00','16:00',NULL,'Y','',8),(112,85,'17:00','17:00',NULL,'Y','',9),(113,85,'18:00','18:00',NULL,'Y','',10),(114,86,'1','外部呼叫',NULL,'Y','',1),(115,86,'2','内部呼叫',NULL,'Y','',2),(116,87,'1','呼入',NULL,'Y','',1),(117,87,'2','呼出',NULL,'Y','',2),(118,88,'Male','男',NULL,'Y','',1),(119,88,'Female','女',NULL,'Y','',2),(134,93,'13466502772','nick',NULL,'Y','',0),(135,94,'13466502772','nick',NULL,'Y','',1),(136,98,'18310975776','Blair',NULL,'Y','',0),(137,99,'18310975776','Blair',NULL,'Y','',0),(138,95,'18612940053','高潇涵',NULL,'Y','',0),(139,96,'18310975776','Blair',NULL,'Y','',0),(140,97,'18612940053','高潇涵',NULL,'Y','',0),(141,100,'1','满意',NULL,'Y','',1),(142,100,'2','一般',NULL,'Y','满意:1',2),(143,100,'3','不满意',NULL,'Y','一般:2 满意:1',3),(152,94,'15811003291','hebe',NULL,'Y','nick:13466502772',2),(153,103,'0','新增',NULL,'Y','',0),(154,103,'1','删除',NULL,'Y','',1),(155,103,'2','修改',NULL,'Y','',2),(156,103,'3','Excel导出',NULL,'Y','',3),(157,104,'1','外部呼叫',NULL,'Y','',0),(158,104,'2','内部呼叫',NULL,'Y','',1),(159,105,'1','呼入',NULL,'Y','',0),(160,105,'2','呼出',NULL,'Y','',1);
/*!40000 ALTER TABLE `bd_dictdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bd_jobmsg`
--

DROP TABLE IF EXISTS `bd_jobmsg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bd_jobmsg` (
  `Job_id` int(11) NOT NULL auto_increment,
  `Job_name` varchar(100) default NULL,
  `CronExpression` varchar(32) default NULL,
  `Job_state` varchar(4) default NULL,
  `Create_time` datetime default NULL,
  `Last_modify_time` datetime default NULL,
  `Create_oper` varchar(32) default NULL,
  `Job_year` varchar(4) default NULL,
  `Job_month` varchar(4) default NULL,
  `Job_day` varchar(4) default NULL,
  `Job_week` varchar(4) default NULL,
  `Job_hour` varchar(4) default NULL,
  `Job_minute` varchar(4) default NULL,
  `Job_second` varchar(4) default NULL,
  `Job_beanName` varchar(50) default NULL,
  `remark` text,
  PRIMARY KEY  (`Job_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bd_jobmsg`
--

LOCK TABLES `bd_jobmsg` WRITE;
/*!40000 ALTER TABLE `bd_jobmsg` DISABLE KEYS */;
INSERT INTO `bd_jobmsg` VALUES (1,'同步客户资料','0 01 10 * * ? *','N',NULL,'2013-07-22 10:53:40',NULL,'*','*','*','?','10','01','0','synCustomerTrigger',''),(4,'同步IPCC报表数据-日报','0 09 12 * * ? *','N','2013-05-08 15:49:08','2013-05-24 10:43:23',NULL,'*','*','*','?','12','09','0','synReportFormsTriggerDay',''),(5,'同步坐席及技能组信息','0 25 13 * * ? *','N','2013-05-13 10:24:11','2013-05-28 16:36:43',NULL,'*','*','*','?','13','25','0','synReportFormsDetailTrigger',''),(6,'同步IPCC报表数据-月报','0 30 11 * * ? *','N','2013-05-23 11:01:29',NULL,NULL,'*','*','*','?','11','30','0','synReportFormsTriggerMonth',''),(7,'同步IPCC报表数据-年报','0 04 11 * * ? *','N','2013-05-23 11:02:44',NULL,NULL,'*','*','*','?','11','04','0','synReportFormsTriggerYear',''),(8,'同步IPCC报表数据','0/5 * * * * ? *','N',NULL,'2014-08-15 12:16:39',NULL,'*','*','*','?','*','*','0/5','synIpccReportTaskTrigger','');
/*!40000 ALTER TABLE `bd_jobmsg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bd_role`
--

DROP TABLE IF EXISTS `bd_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bd_role` (
  `pk_role` int(11) NOT NULL auto_increment,
  `rolename` varchar(20) default NULL,
  `description` varchar(50) default NULL,
  PRIMARY KEY  (`pk_role`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bd_role`
--

LOCK TABLES `bd_role` WRITE;
/*!40000 ALTER TABLE `bd_role` DISABLE KEYS */;
INSERT INTO `bd_role` VALUES (8,'系统管理员',''),(10,'产品维护',''),(11,'普通座席',''),(12,'测试角色',''),(45,'测试','');
/*!40000 ALTER TABLE `bd_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bd_rolemenu`
--

DROP TABLE IF EXISTS `bd_rolemenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bd_rolemenu` (
  `pk_rolemenu` int(11) NOT NULL auto_increment,
  `pk_role` int(11) NOT NULL,
  `pk_menu` int(11) NOT NULL,
  `permissions` varchar(20) default NULL,
  PRIMARY KEY  (`pk_rolemenu`),
  KEY `FK_RM_ROLE` USING BTREE (`pk_role`),
  KEY `FK_RM_MENU` USING BTREE (`pk_menu`)
) ENGINE=MyISAM AUTO_INCREMENT=274 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bd_rolemenu`
--

LOCK TABLES `bd_rolemenu` WRITE;
/*!40000 ALTER TABLE `bd_rolemenu` DISABLE KEYS */;
INSERT INTO `bd_rolemenu` VALUES (273,45,28,'0,1,2'),(272,45,25,'0,1,2'),(271,45,24,'0,2'),(270,45,23,'0,1');
/*!40000 ALTER TABLE `bd_rolemenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bd_userinforole`
--

DROP TABLE IF EXISTS `bd_userinforole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bd_userinforole` (
  `PK_USERINFOROLE` int(11) NOT NULL auto_increment,
  `pk_userinfo` int(11) NOT NULL,
  `pk_role` int(11) NOT NULL,
  PRIMARY KEY  (`PK_USERINFOROLE`),
  KEY `FK_UR_USER` USING BTREE (`pk_userinfo`),
  KEY `FK_UR_ROLE` USING BTREE (`pk_role`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bd_userinforole`
--

LOCK TABLES `bd_userinforole` WRITE;
/*!40000 ALTER TABLE `bd_userinforole` DISABLE KEYS */;
INSERT INTO `bd_userinforole` VALUES (2,6,10),(11,14,8),(19,12,8),(20,1,8),(23,7,8),(24,7,10),(25,13,8),(26,19,8),(27,20,11),(28,21,11),(29,22,11),(37,23,45),(31,24,11),(36,25,11),(35,26,11);
/*!40000 ALTER TABLE `bd_userinforole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calldetail`
--

DROP TABLE IF EXISTS `calldetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calldetail` (
  `PK_CALLDETAIL` varchar(50) NOT NULL,
  `CALLDETAILID` varchar(50) NOT NULL,
  `CALLINTIME` varchar(50) default NULL,
  `ANI` varchar(50) default NULL,
  `ANIAREA` varchar(50) default NULL,
  `ANICITY` varchar(50) default NULL,
  `BUSITYPE` varchar(50) default NULL,
  `SVRRESULT` varchar(50) default NULL,
  `LEAVETIME` varchar(50) default NULL,
  `UCID` varchar(50) default NULL,
  `CREATETYPE` varchar(50) default NULL,
  `ISLOST` varchar(50) default NULL,
  `AGENTID` varchar(50) default NULL,
  `N1` varchar(50) default NULL,
  `N2` varchar(50) default NULL,
  `N3` varchar(50) default NULL,
  PRIMARY KEY  (`PK_CALLDETAIL`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calldetail`
--

LOCK TABLES `calldetail` WRITE;
/*!40000 ALTER TABLE `calldetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `calldetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `callout_stat_day`
--

DROP TABLE IF EXISTS `callout_stat_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `callout_stat_day` (
  `ID` int(11) NOT NULL auto_increment,
  `SKILL_ID` varchar(40) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `STAT_TIME` varchar(20) default NULL,
  `TIME` varchar(20) default NULL,
  `CALLOUT_NUM` decimal(32,0) default NULL,
  `CALLOUT_SUCC_NUM` decimal(32,0) default NULL,
  `CALLOUT_SUCC_RATE` decimal(32,4) default NULL,
  `IVR_CALLOUT_NUM` decimal(32,0) default NULL,
  `IVR_CALLOUT_SNUM` decimal(32,0) default NULL,
  `IVR_CALLOUT_SRATE` decimal(32,4) default NULL,
  `MANUAL_CALLOUT_NUM` decimal(32,0) default NULL,
  `MANUAL_CALLOUT_SNUM` decimal(32,0) default NULL,
  `MANUAL_CALLOUT_SRATE` decimal(32,4) default NULL,
  `AVG_TALKING_TIME` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callout_stat_day`
--

LOCK TABLES `callout_stat_day` WRITE;
/*!40000 ALTER TABLE `callout_stat_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `callout_stat_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `callout_stat_month`
--

DROP TABLE IF EXISTS `callout_stat_month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `callout_stat_month` (
  `ID` int(11) NOT NULL auto_increment,
  `SKILL_ID` varchar(40) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `STAT_TIME` varchar(20) default NULL,
  `TIME` varchar(20) default NULL,
  `CALLOUT_NUM` decimal(32,0) default NULL,
  `CALLOUT_SUCC_NUM` decimal(32,0) default NULL,
  `CALLOUT_SUCC_RATE` decimal(32,4) default NULL,
  `IVR_CALLOUT_NUM` decimal(32,0) default NULL,
  `IVR_CALLOUT_SNUM` decimal(32,0) default NULL,
  `IVR_CALLOUT_SRATE` decimal(32,4) default NULL,
  `MANUAL_CALLOUT_NUM` decimal(32,0) default NULL,
  `MANUAL_CALLOUT_SNUM` decimal(32,0) default NULL,
  `MANUAL_CALLOUT_SRATE` decimal(32,4) default NULL,
  `AVG_TALKING_TIME` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callout_stat_month`
--

LOCK TABLES `callout_stat_month` WRITE;
/*!40000 ALTER TABLE `callout_stat_month` DISABLE KEYS */;
/*!40000 ALTER TABLE `callout_stat_month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `callout_stat_year`
--

DROP TABLE IF EXISTS `callout_stat_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `callout_stat_year` (
  `ID` int(11) NOT NULL auto_increment,
  `SKILL_ID` varchar(40) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `STAT_TIME` varchar(20) default NULL,
  `TIME` varchar(20) default NULL,
  `CALLOUT_NUM` decimal(32,0) default NULL,
  `CALLOUT_SUCC_NUM` decimal(32,0) default NULL,
  `CALLOUT_SUCC_RATE` decimal(32,4) default NULL,
  `IVR_CALLOUT_NUM` decimal(32,0) default NULL,
  `IVR_CALLOUT_SNUM` decimal(32,0) default NULL,
  `IVR_CALLOUT_SRATE` decimal(32,4) default NULL,
  `MANUAL_CALLOUT_NUM` decimal(32,0) default NULL,
  `MANUAL_CALLOUT_SNUM` decimal(32,0) default NULL,
  `MANUAL_CALLOUT_SRATE` decimal(32,4) default NULL,
  `AVG_TALKING_TIME` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callout_stat_year`
--

LOCK TABLES `callout_stat_year` WRITE;
/*!40000 ALTER TABLE `callout_stat_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `callout_stat_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cusphonelist`
--

DROP TABLE IF EXISTS `cusphonelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cusphonelist` (
  `PK_CUSPHONELIST` int(11) NOT NULL auto_increment,
  `PK_CUSTOMERINFO` int(11) NOT NULL,
  `CUSTLINKNAME` varchar(100) default NULL,
  `PHONENO` varchar(30) default NULL,
  `SYNSTATUS` varchar(10) default NULL,
  `UPDATETIME` datetime NOT NULL,
  `NOLEVEL` varchar(10) default NULL,
  `REMARK` text,
  `TEMP1` text,
  `TEMP2` text,
  `TEMP3` text,
  `TEMP4` text,
  PRIMARY KEY  (`PK_CUSPHONELIST`),
  KEY `FK_CUSTOMERINFO` USING BTREE (`PK_CUSTOMERINFO`)
) ENGINE=MyISAM AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cusphonelist`
--

LOCK TABLES `cusphonelist` WRITE;
/*!40000 ALTER TABLE `cusphonelist` DISABLE KEYS */;
/*!40000 ALTER TABLE `cusphonelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerinfo`
--

DROP TABLE IF EXISTS `customerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerinfo` (
  `PK_CUSTOMERINFO` int(11) NOT NULL auto_increment,
  `CUSTOMERNO` varchar(30) default NULL,
  `CUSTOMERNAME` varchar(100) default NULL,
  `CUSTLINKMAN` varchar(100) default NULL,
  `CUSTPHONENO` text,
  `POSTCODE` varchar(10) default NULL,
  `EMAILADDR` varchar(100) default NULL,
  `NETHERLANDS` varchar(50) default NULL,
  `CUSTTYPE` varchar(10) default NULL,
  `CUSTLEVEL` varchar(10) default NULL,
  `CUSTSTATUS` varchar(10) default NULL,
  `PROVINCE` varchar(20) default NULL,
  `CITY` varchar(20) default NULL,
  `CUSTADDR` varchar(200) default NULL,
  `INFOSOURCE` varchar(10) default NULL,
  `UPDATETIME` datetime default NULL,
  `REMARK` text,
  `TEMP1` text,
  `TEMP2` text,
  `TEMP3` text,
  `TEMP4` text,
  `TEMP5` text,
  `TEMP6` text,
  `TEMP7` text,
  `TEMP8` text,
  `SALESORG` varchar(20) default NULL,
  `SALESOFFICE` varchar(200) default NULL,
  `SALESGROUP` varchar(20) default NULL,
  `SALESNAME` varchar(20) default NULL,
  `CUSTAREA` varchar(20) default NULL,
  PRIMARY KEY  (`PK_CUSTOMERINFO`)
) ENGINE=MyISAM AUTO_INCREMENT=290 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerinfo`
--

LOCK TABLES `customerinfo` WRITE;
/*!40000 ALTER TABLE `customerinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `PK_DEPARTMENT` int(11) NOT NULL,
  `SPK_DEPARTMENT` int(11) default NULL,
  `DEPNAME` varchar(50) default NULL,
  `REMARK` text,
  `TEMP1` text,
  `TEMP2` text,
  `TEMP3` text,
  `TEMP4` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dskillstat`
--

DROP TABLE IF EXISTS `dskillstat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dskillstat` (
  `ID` int(11) NOT NULL auto_increment,
  `STATDATE` varchar(20) default NULL,
  `SKILL_ID` varchar(20) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `CALL_NUM` decimal(32,0) default NULL,
  `SUCCESS_NUM` decimal(32,0) default NULL,
  `FAILED_NUM` decimal(32,0) default NULL,
  `SUCCESSIN20_NUM` decimal(32,0) default NULL,
  `F_WAIT_TIME` decimal(32,0) default NULL,
  `S_WAIT_TIME` decimal(32,0) default NULL,
  `TAIKING_TIME` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dskillstat`
--

LOCK TABLES `dskillstat` WRITE;
/*!40000 ALTER TABLE `dskillstat` DISABLE KEYS */;
INSERT INTO `dskillstat` VALUES (1,'2013-04-11','1','skill1','55','0','22','22','234','123','777'),(2,'2013-04-11','2','skill2','55','1','33','22','234','123','999'),(3,'2013-04-11','3','skill33','66',NULL,'33','33','432','123','888');
/*!40000 ALTER TABLE `dskillstat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hskillstat`
--

DROP TABLE IF EXISTS `hskillstat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hskillstat` (
  `ID` int(11) NOT NULL auto_increment,
  `STATDATE` varchar(20) default NULL,
  `Intrahour` int(11) default NULL,
  `SKILL_ID` varchar(20) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `CALL_NUM` decimal(32,0) default NULL,
  `SUCCESS_NUM` decimal(32,0) default NULL,
  `FAILED_NUM` decimal(32,0) default NULL,
  `SUCCESSIN20_NUM` decimal(32,0) default NULL,
  `F_WAIT_TIME` decimal(32,0) default NULL,
  `S_WAIT_TIME` decimal(32,0) default NULL,
  `TAIKING_TIME` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hskillstat`
--

LOCK TABLES `hskillstat` WRITE;
/*!40000 ALTER TABLE `hskillstat` DISABLE KEYS */;
INSERT INTO `hskillstat` VALUES (1,'2013-04-11',1,'1','skill1','77','0','11','22','22','777','0'),(2,'2013-04-11',2,'2','skill2','99','33','11','22','33','888','999'),(3,'2013-04-11',3,'1','skill','55','22','22','22','33','888','999');
/*!40000 ALTER TABLE `hskillstat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivrvoice`
--

DROP TABLE IF EXISTS `ivrvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivrvoice` (
  `PK_IVRVOICE` int(11) NOT NULL,
  `LEAVEWORDNUM` varchar(50) default NULL,
  `SERVERIP` varchar(50) default NULL,
  `CALLERID` varchar(50) default NULL,
  `STARTTIME` varchar(24) default NULL,
  `ENDTIME` varchar(24) default NULL,
  `STARTDATE` varchar(24) default NULL,
  `ENDDATE` varchar(24) default NULL,
  `FILENAME` varchar(255) default NULL,
  `ISNOTICE` varchar(1) default NULL,
  `ISCHECK` varchar(1) default NULL,
  `DNIS` varchar(24) default NULL,
  `CREATE_DATE` varchar(24) default NULL,
  `PROCESSRESULT` varchar(255) default NULL,
  `UCID` varchar(100) default NULL,
  `VDUID` varchar(100) default NULL,
  `N1` varchar(100) default NULL,
  `N2` varchar(100) default NULL,
  `N3` varchar(100) default NULL,
  `FULLSTARTDATE` varchar(24) default NULL,
  `FULLENDDATE` varchar(24) default NULL,
  PRIMARY KEY  (`PK_IVRVOICE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivrvoice`
--

LOCK TABLES `ivrvoice` WRITE;
/*!40000 ALTER TABLE `ivrvoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `ivrvoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logmsg`
--

DROP TABLE IF EXISTS `logmsg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logmsg` (
  `pk_logmsg` int(11) NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `createtime` datetime default NULL,
  `ip` varchar(30) default NULL,
  `logtype` varchar(30) default NULL,
  `logcontent` text,
  `entityname` varchar(200) default NULL,
  PRIMARY KEY  (`pk_logmsg`)
) ENGINE=MyISAM AUTO_INCREMENT=9648 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logmsg`
--

LOCK TABLES `logmsg` WRITE;
/*!40000 ALTER TABLE `logmsg` DISABLE KEYS */;
/*!40000 ALTER TABLE `logmsg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manual_callinfo_stat_day`
--

DROP TABLE IF EXISTS `manual_callinfo_stat_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manual_callinfo_stat_day` (
  `ID` int(11) NOT NULL auto_increment,
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
) ENGINE=MyISAM AUTO_INCREMENT=19116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manual_callinfo_stat_day`
--

LOCK TABLES `manual_callinfo_stat_day` WRITE;
/*!40000 ALTER TABLE `manual_callinfo_stat_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `manual_callinfo_stat_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manual_callinfo_stat_month`
--

DROP TABLE IF EXISTS `manual_callinfo_stat_month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manual_callinfo_stat_month` (
  `ID` int(11) NOT NULL auto_increment,
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manual_callinfo_stat_month`
--

LOCK TABLES `manual_callinfo_stat_month` WRITE;
/*!40000 ALTER TABLE `manual_callinfo_stat_month` DISABLE KEYS */;
/*!40000 ALTER TABLE `manual_callinfo_stat_month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manual_callinfo_stat_year`
--

DROP TABLE IF EXISTS `manual_callinfo_stat_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manual_callinfo_stat_year` (
  `ID` int(11) NOT NULL auto_increment,
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manual_callinfo_stat_year`
--

LOCK TABLES `manual_callinfo_stat_year` WRITE;
/*!40000 ALTER TABLE `manual_callinfo_stat_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `manual_callinfo_stat_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `md_crmd_customers-old`
--

DROP TABLE IF EXISTS `md_crmd_customers-old`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `md_crmd_customers-old` (
  `Id` char(36) NOT NULL,
  `ADDRNUMBER` varchar(10) default NULL,
  `CITY1` varchar(40) default NULL,
  `HOME_CITY` varchar(40) default NULL,
  `POST_CODE1` varchar(10) default NULL,
  `STREET` varchar(60) default NULL,
  `COUNTRY` varchar(3) default NULL,
  `MC_CITY1` varchar(25) default NULL,
  `MC_STREET` varchar(25) default NULL,
  `CustomerId` varchar(10) NOT NULL,
  `TYPE` int(11) default NULL,
  `BU_GROUP` varchar(10) default NULL,
  `CustomerName` varchar(100) default NULL,
  `ContactId` varchar(16) default NULL,
  `ContactName` varchar(100) default NULL,
  `FLGDEFAULT` varchar(1) default NULL,
  `HOME_FLAG` varchar(1) default NULL,
  `TEL_NUMBER` varchar(30) default NULL,
  `TEL_EXTENS` varchar(10) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `md_crmd_customers-old`
--

LOCK TABLES `md_crmd_customers-old` WRITE;
/*!40000 ALTER TABLE `md_crmd_customers-old` DISABLE KEYS */;
/*!40000 ALTER TABLE `md_crmd_customers-old` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `md_crmd_customers`
--

DROP TABLE IF EXISTS `md_crmd_customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `md_crmd_customers` (
  `Id` char(36) NOT NULL,
  `ADDRNUMBER` varchar(10) default NULL,
  `CITY1` varchar(40) default NULL,
  `HOME_CITY` varchar(40) default NULL,
  `POST_CODE1` varchar(10) default NULL,
  `STREET` varchar(60) default NULL,
  `COUNTRY` varchar(3) default NULL,
  `MC_CITY1` varchar(25) default NULL,
  `MC_STREET` varchar(25) default NULL,
  `CustomerId` varchar(10) NOT NULL,
  `TYPE` int(11) default NULL,
  `BU_GROUP` varchar(10) default NULL,
  `CustomerName` varchar(100) default NULL,
  `ContactId` varchar(16) default NULL,
  `ContactName` varchar(100) default NULL,
  `FLGDEFAULT` varchar(1) default NULL,
  `HOME_FLAG` varchar(1) default NULL,
  `TEL_NUMBER` varchar(30) default NULL,
  `TEL_EXTENS` varchar(10) default NULL,
  `KUNNR` varchar(10) default NULL,
  `VKORG` varchar(4) default NULL,
  `VTEXT` varchar(20) default NULL,
  `VTWEG` varchar(2) default NULL,
  `SPART` varchar(2) default NULL,
  `VKGRP` varchar(3) default NULL,
  `VKBUR` varchar(4) default NULL,
  `BEZEI` varchar(20) default NULL,
  `KVGR1` varchar(3) default NULL,
  `KVGR2` varchar(3) default NULL,
  `KVGR3` varchar(3) default NULL,
  `KVGR4` varchar(3) default NULL,
  `KVGR5` varchar(3) default NULL,
  `PERNR` int(11) default NULL,
  `STEXT_P` varchar(40) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `md_crmd_customers`
--

LOCK TABLES `md_crmd_customers` WRITE;
/*!40000 ALTER TABLE `md_crmd_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `md_crmd_customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `md_crmd_opportunity`
--

DROP TABLE IF EXISTS `md_crmd_opportunity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `md_crmd_opportunity` (
  `Id` char(36) NOT NULL,
  `EXP_REVENUE` decimal(15,2) default NULL,
  `STARTDATE` datetime default NULL,
  `EXPECT_END` datetime default NULL,
  `CURR_PHASE` varchar(3) default NULL,
  `PHASE_SINCE` datetime default NULL,
  `PROBABILITY` int(11) default NULL,
  `SOURCE` varchar(3) default NULL,
  `DESCRIPTION_OPP` varchar(40) default NULL,
  `DESCR_OPP_UC` varchar(40) default NULL,
  `CUSTOMER_STATUS` varchar(4) default NULL,
  `OBJECT_ID` varchar(10) default NULL,
  `PROCESS_TYPE` varchar(4) default NULL,
  `POSTING_DATE` datetime default NULL,
  `DESCRIPTION` varchar(40) default NULL,
  `CREATED_AT` datetime default NULL,
  `CREATED_BY` varchar(12) default NULL,
  `CHANGED_AT` datetime default NULL,
  `CHANGED_BY` varchar(12) default NULL,
  `DESCRIPTION_UC` varchar(40) default NULL,
  `OBJECT_TYPE` varchar(10) default NULL,
  `CRM_CHANGED_AT` datetime default NULL,
  `Phase_Name` varchar(20) NOT NULL,
  `ADDRNUMBER` varchar(10) default NULL,
  `CITY1` varchar(40) default NULL,
  `HOME_CITY` varchar(40) default NULL,
  `POST_CODE1` varchar(10) default NULL,
  `STREET` varchar(60) default NULL,
  `COUNTRY` varchar(3) default NULL,
  `MC_CITY1` varchar(25) default NULL,
  `MC_STREET` varchar(25) default NULL,
  `HOME_FLAG` varchar(1) default NULL,
  `TEL_NUMBER` varchar(30) default NULL,
  `TEL_EXTENS` varchar(10) default NULL,
  `CustomerId` varchar(10) default NULL,
  `TYPE` int(11) default NULL,
  `BU_GROUP` varchar(10) default NULL,
  `CustomerName` varchar(100) default NULL,
  `FLGDEFAULT` varchar(1) default NULL,
  `ContactId` varchar(16) default NULL,
  `ContactName` varchar(100) default NULL,
  `GUID` varchar(16) default NULL,
  `PARTNER_NO` varchar(50) default NULL,
  `PARTNER` varchar(50) default NULL,
  `ADDRESS_NO` varchar(10) default NULL,
  `Project_Property_Name` varchar(50) default NULL,
  `Project_Type_Name` varchar(50) default NULL,
  `Project_Catalog_Name` varchar(50) default NULL,
  `ZPROVINCE` varchar(50) default NULL,
  `ZCITY` varchar(50) default NULL,
  `Acreage` varchar(50) default NULL,
  `Project_Status` varchar(50) default NULL,
  `Project_TU_Catalog` varchar(50) default NULL,
  `Payment_Name` varchar(50) default NULL,
  `Project_Region` varchar(50) default NULL,
  `IU_Industial` varchar(50) default NULL,
  `IU_ProjectType` varchar(50) default NULL,
  `IU_Cooperate` varchar(50) default NULL,
  `TU_ProjectStatus` varchar(50) default NULL,
  `stat` varchar(50) default NULL,
  `stsma` varchar(50) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `md_crmd_opportunity`
--

LOCK TABLES `md_crmd_opportunity` WRITE;
/*!40000 ALTER TABLE `md_crmd_opportunity` DISABLE KEYS */;
/*!40000 ALTER TABLE `md_crmd_opportunity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuinfo`
--

DROP TABLE IF EXISTS `menuinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menuinfo` (
  `PK_MENU` int(11) NOT NULL auto_increment,
  `MENUNAME` varchar(50) default NULL,
  `SUPERMENU` int(11) default NULL,
  `MENUSEQ` int(11) default NULL,
  `ISAVAILABLE` varchar(2) default NULL,
  `LINKADDRESS` varchar(200) default NULL,
  `TEMP1` varchar(200) default NULL,
  `TEMP2` varchar(200) default NULL,
  PRIMARY KEY  (`PK_MENU`)
) ENGINE=MyISAM AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuinfo`
--

LOCK TABLES `menuinfo` WRITE;
/*!40000 ALTER TABLE `menuinfo` DISABLE KEYS */;
INSERT INTO `menuinfo` VALUES (1,'账号及安全管理',0,4,'Y','','',NULL),(2,'基础数据',45,1,'Y','ListBdDict.action?changeUrl=Y&pageNum=1&numPerPage=20&onduty=false','dictLiNav',NULL),(3,'用户角色与权限',1,3,'Y','ListRole.action?changeUrl=Y&pageNum=1&numPerPage=20','roleLiNav',NULL),(4,'管理员账号',46,2,'Y','ListAdminUserinfo.action?changeUrl=Y&pageNum=1&numPerPage=20','adminLiNav',NULL),(5,'菜单管理',45,2,'Y','ListMenuinfoMain.action?changeUrl=Y&pageNum=1&numPerPage=20','menuinfoLiNav',NULL),(9,'话务平台管理',0,3,'Y','','',NULL),(10,'操作日志',45,1,'Y','ListLogmsg.action?changeUrl=Y&pageNum=1&numPerPage=20','logmsgLiNav',NULL),(22,'工单管理',0,2,'Y','','',NULL),(23,'工单办理',22,1,'Y','ListWorkorder.action?orderCode=wcl&pageCode=wcl&pageCode=wcl&changeUrl=Y&pageNum=1&numPerPage=20','workorderwclLiNav',NULL),(24,'后续处理工单',22,2,'Y','ListWorkorder.action?orderCode=dhxcl&pageCode=dhxcl&changeUrl=Y&pageNum=1&numPerPage=20','workorderdhxclLiNav',NULL),(29,'工厂信息管理',44,7,'N','ListWorkstation.action?changeUrl=Y&pageNum=1&numPerPage=20','workstationLiNav',NULL),(31,'IVR留言调听',9,1,'Y','ListIvrvoice.action?changeUrl=Y&pageNum=1&numPerPage=20','ivrvoiceLiNav',NULL),(32,'呼叫记录',9,2,'Y','ListCalldetail.action?changeUrl=Y&pageNum=1&numPerPage=20','calldetailLiNav',NULL),(33,'客户电话号码',1,8,'N','ListCusphonelist.action?changeUrl=Y&pageNum=1&numPerPage=20','cusphonelistLiNav',NULL),(34,'满意度调查',9,5,'Y','ListSatscore.action?changeUrl=Y&pageNum=1&numPerPage=20','satscoreLiNav',NULL),(37,'工单报表',0,4,'Y','','',NULL),(38,'待办工单统计年报',37,1,'Y','listYearWclwo.action?fileName=wcl_year_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20','yearWclwoLiNav',NULL),(39,'工单分类汇总年报',37,4,'Y','listYearStwo.action?fileName=st_year_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ','yearstwoLiNav',NULL),(40,'待办工单统计月报',37,2,'Y','listMonthWclwo.action?fileName=wcl_month_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20','monthWclwoLiNav',NULL),(41,'待办工单统计日报',37,3,'Y','listDayWclwo.action?fileName=wcl_day_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ','dayWclwoLiNav',NULL),(42,'工单分类汇总月报',37,5,'Y','listMonthStwo.action?fileName=st_month_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ','monthstwoLiNav',NULL),(43,'工单分类汇总日报',37,6,'Y','listDayStwo.action?fileName=st_day_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ','daystwoLiNav',NULL),(45,'系统管理',0,6,'Y','','',NULL),(46,'系统设置',0,7,'Y','','',NULL),(48,'工单量和结单率统计',37,7,'Y','ListWorkratioReport.action?changeUrl=Y&pageNum=1&numPerPage=20','',NULL),(49,'技能组指标统计日报',37,8,'N','listDskillstat.action?fileName=skill_day_report.xls&changeUrl=Y&pageNum=1&numPerPage=20','dskillstatLiNav',NULL),(51,'IVR话务量统计日报',60,10,'N','listTblIvrstatDay.action?ivrtimeflag=day&fileName=tbl_ivr_day.xls&changeUrl=Y&pageNum=1&numPerPage=20','tblIvrstatLiNav',NULL),(52,'IVR话务量统计月报',60,11,'N','listTblIvrstatMonth.action?ivrtimeflag=month&fileName=tbl_ivr_month.xls&changeUrl=Y&pageNum=1&numPerPage=20','tblIvrstatLiNav',NULL),(53,'IVR话务量统计年报',60,12,'N','listTblIvrstatYear.action?ivrtimeflag=year&fileName=tbl_ivr_year.xls&changeUrl=Y&pageNum=1&numPerPage=20','tblIvrstatLiNav',NULL),(54,'人工话务量统计日报',60,13,'Y','listMcsDay.action?mcstimeflag=day&fileName=mcs_day.xls&changeUrl=Y&pageNum=1&numPerPage=20','mcsLiNav',NULL),(55,'人工话务量统计月报',60,14,'N','listMcsMonth.action?mcstimeflag=month&fileName=mcs_month.xls&changeUrl=Y&pageNum=1&numPerPage=20','mcsLiNav',NULL),(56,'人工话务量统计年报',60,15,'N','listMcsYear.action?mcstimeflag=year&fileName=mcs_year.xls&changeUrl=Y&pageNum=1&numPerPage=20','mcsLiNav',NULL),(58,'坐席KPI技能分组统计月报',60,17,'N','listAgentKpiMonth.action?akpitimeflag=month&fileName=agent_kpi_month.xls&changeUrl=Y&pageNum=1&numPerPage=20','agentKpiLiNav',NULL),(60,'IPCC报表',0,5,'Y','','',NULL),(61,'坐席话务明细',60,25,'N','listAgentCallList.action?fileName=agent_call_list.xls&changeUrl=Y&pageNum=1&numPerPage=20','aclLiNav',NULL),(62,'技能组话务明细',60,26,'N','listSkillCallList.action?fileName=skill_call_list.xls&changeUrl=Y&pageNum=1&numPerPage=20','sclLiNav',NULL),(63,'外呼话务量统计日报',60,22,'N','listCosDay.action?costimeflag=day&fileName=call_out_day.xls&changeUrl=Y&pageNum=1&numPerPage=20','cosLiNav',NULL),(64,'外呼话务量统计月报',60,23,'N','listCosMonth.action?costimeflag=month&fileName=call_out_month.xls&changeUrl=Y&pageNum=1&numPerPage=20','cosLiNav',NULL),(25,'客户信息管理',44,5,'Y','ListCustomerinfo.action?changeUrl=Y&pageNum=1&numPerPage=20','customerLiNav',NULL),(26,'工单查询',22,4,'Y','ListWorkorder.action?orderCode=all&pageCode=all&changeUrl=Y&pageNum=1&numPerPage=20','workorderallLiNav',NULL),(28,'用户账号',1,1,'Y','ListUserinfo.action?changeUrl=Y&pageNum=1&numPerPage=20','userinfoLiNav','0,1,2'),(30,'工单结单',22,3,'Y','ListWorkorder.action?orderCode=ywc&pageCode=ywc&changeUrl=Y&pageNum=1&numPerPage=20','workorderywcLiNav',NULL),(65,'外呼话务量统计年报',60,24,'N','listCosYear.action?costimeflag=year&fileName=call_out_year.xls&changeUrl=Y&pageNum=1&numPerPage=20','cosLiNav',NULL),(35,'定时任务',45,3,'Y','ListJobmsg.action?changeUrl=Y&pageNum=1&numPerPage=20','jobmsgLiNav',NULL),(50,'技能组指标统计时报',37,9,'N','listHskillstat.action?fileName=skill_hour_report.xls&changeUrl=Y&pageNum=1&numPerPage=20','hskillstatLiNav',NULL),(44,'信息管理',0,1,'Y','','',NULL),(47,'工作日历',9,6,'Y','listWorkingcalendar.action?changeUrl=Y&pageNum=1&numPerPage=20','workingcalendarLiNav',NULL),(57,'坐席KPI技能分组统计日报',60,16,'Y','listAgentKpiDay.action?akpitimeflag=day&fileName=agent_kpi_day.xls&changeUrl=Y&pageNum=1&numPerPage=20','agentKpiLiNav',NULL),(59,'坐席KPI技能分组统计年报',60,18,'N','listAgentKpiYear.action?akpitimeflag=year&fileName=agent_kpi_year.xls&changeUrl=Y&pageNum=1&numPerPage=20','agentKpiLiNav',NULL),(66,'值班管理',45,5,'Y','ListBdDuty.action?changeUrl=Y&pageNum=1&numPerPage=20&onduty=true','dutyLiNav',NULL),(67,'坐席签入签处明细',60,0,'Y','listIpccReport.action?fileName=ipcc_report_agentinfo.xls&changeUrl=Y&pageNum=1&numPerPage=20&reportType=agentinfo','ipccReportLiNav',NULL),(68,'通话明细',60,1,'Y','listIpccReport.action?fileName=ipcc_report_callinfo.xls&changeUrl=Y&pageNum=1&numPerPage=20&reportType=callinfo','ipccReportLiNav',NULL);
/*!40000 ALTER TABLE `menuinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdealinfo`
--

DROP TABLE IF EXISTS `orderdealinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdealinfo` (
  `PK_ORDERDEALINFO` int(11) NOT NULL auto_increment,
  `PK_WORKORDER` int(11) NOT NULL,
  `WORKORDERNO` varchar(50) default NULL,
  `PROKEYWORD` varchar(50) default NULL,
  `PRODEPARTMENT` varchar(20) default NULL,
  `DEPDEALMAN` varchar(20) default NULL,
  `PRODESC` text,
  `PROREASON` text,
  `PROSITUATION` text,
  `OCCTIME` datetime default NULL,
  `DEALTIME` datetime default NULL,
  `TYPEINPERSON` varchar(20) default NULL,
  `ASSIGNPERSON` varchar(20) default NULL,
  `TYPEINTIME` datetime default NULL,
  `WOSTATUS` varchar(20) default NULL,
  `CREATETYPE` varchar(20) default NULL,
  `REMARK` text,
  `TEMP1` text,
  `TEMP2` text,
  `TEMP3` text,
  `TEMP4` text,
  `TEMP5` text,
  `TEMP6` text,
  PRIMARY KEY  (`PK_ORDERDEALINFO`)
) ENGINE=MyISAM AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdealinfo`
--

LOCK TABLES `orderdealinfo` WRITE;
/*!40000 ALTER TABLE `orderdealinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdealinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderproductfeatures`
--

DROP TABLE IF EXISTS `orderproductfeatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderproductfeatures` (
  `pk_orderproductfeature` int(11) NOT NULL,
  `pk_orderproduct` int(11) default NULL,
  `pk_feature` int(11) default NULL,
  `authorizednumber` int(11) default NULL,
  `expirationDate` varchar(50) default NULL,
  `remark` char(10) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderproductfeatures`
--

LOCK TABLES `orderproductfeatures` WRITE;
/*!40000 ALTER TABLE `orderproductfeatures` DISABLE KEYS */;
INSERT INTO `orderproductfeatures` VALUES (1,1,18,33,'2013-02-06','333'),(2,1,18,6,'2013-02-06',''),(3,3,18,22,'2013-02-06','222'),(6,5,19,50,'',''),(7,5,20,50,'',''),(8,4,19,50,'',''),(9,4,20,50,'','');
/*!40000 ALTER TABLE `orderproductfeatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderproducts`
--

DROP TABLE IF EXISTS `orderproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderproducts` (
  `pk_orderproduct` int(11) NOT NULL,
  `pk_order` int(11) default NULL,
  `pk_product` int(11) default NULL,
  `productlocate` varchar(50) default NULL,
  `lictype` varchar(50) default NULL,
  `applytime` datetime default NULL,
  `gentime` datetime default NULL,
  `licdays` int(11) default NULL,
  `hostid` varchar(50) default NULL,
  `licfile` longtext,
  `remark` varchar(250) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderproducts`
--

LOCK TABLES `orderproducts` WRITE;
/*!40000 ALTER TABLE `orderproducts` DISABLE KEYS */;
INSERT INTO `orderproducts` VALUES (1,1,15,'BJ','SIPUSERS',NULL,NULL,33,'aabbccdd','lcplic_S0001153.0.0.xml',''),(2,2,15,'212','SIPUSERS',NULL,NULL,222,'22222','lcplic_S0002153.0.0.xml','222'),(3,3,15,'test','SIPUSERS','2013-02-06 00:00:00','2013-02-07 00:00:00',2,'222','lcplic_S003LCPV33.0.0.xml',''),(4,4,15,'北京','SIPUSERS','2013-02-07 00:00:00',NULL,NULL,'BC305BD94F58','lcplic_S0001LCPV33.0.0.xml','test'),(5,5,15,'BJ','SIPUSERS','2013-02-01 00:00:00','2013-10-26 00:00:00',33,'B8AC6F496F98','lcplic_S0002LCPV33.0.0.xml','');
/*!40000 ALTER TABLE `orderproducts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `pk_order` int(11) NOT NULL,
  `pk_customer` int(11) default NULL,
  `orderno` varchar(50) default NULL,
  `orderdesc` longtext,
  `orderstatus` varchar(50) default NULL,
  `remark` varchar(250) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (4,14,'S0001','测试','未审核',''),(5,14,'S0002','测试','未审核','');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `satscore`
--

DROP TABLE IF EXISTS `satscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `satscore` (
  `PK_SATSCORE` int(11) NOT NULL auto_increment,
  `UCID` varchar(50) NOT NULL,
  `CALLERNO` varchar(24) default NULL,
  `AGENTID` varchar(8) default NULL,
  `EXTNO` varchar(8) default NULL,
  `SVCTIME` varchar(24) default NULL,
  `SVCPOINT` varchar(2) default NULL,
  `VDUID` varchar(100) default NULL,
  `N1` varchar(100) default NULL,
  `N2` varchar(100) default NULL,
  `N3` varchar(100) default NULL,
  PRIMARY KEY  (`PK_SATSCORE`)
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `satscore`
--

LOCK TABLES `satscore` WRITE;
/*!40000 ALTER TABLE `satscore` DISABLE KEYS */;
/*!40000 ALTER TABLE `satscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_call_list`
--

DROP TABLE IF EXISTS `skill_call_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_call_list` (
  `ID` int(11) NOT NULL auto_increment,
  `STAT_TIME` varchar(20) default NULL,
  `AGENT_ID` varchar(40) default NULL,
  `AGENT_NAME` varchar(40) default NULL,
  `SKILL_ID` varchar(40) default NULL,
  `SKILL_DESC` varchar(60) default NULL,
  `START_TIME` varchar(50) default NULL,
  `TALKING_TIME` decimal(32,0) default NULL,
  `CALLER` varchar(20) default NULL,
  `CALLED` varchar(20) default NULL,
  `REC_PATH` varchar(120) default NULL,
  `DIRECTION` decimal(2,0) default NULL,
  `CALLTYPE` decimal(2,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4960 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_call_list`
--

LOCK TABLES `skill_call_list` WRITE;
/*!40000 ALTER TABLE `skill_call_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_call_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_ivrstat_day`
--

DROP TABLE IF EXISTS `tbl_ivrstat_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_ivrstat_day` (
  `ID` int(11) NOT NULL auto_increment,
  `STAT_TIME` varchar(20) default NULL,
  `TIME` varchar(20) default NULL,
  `IVR_CODE` varchar(20) default NULL,
  `CALL_NUM_OUTSIDE` decimal(32,0) default NULL,
  `CALL_NUM_INSIDE` decimal(32,0) default NULL,
  `CALL_NUM_IVRONLY` decimal(32,0) default NULL,
  `IVR_SERVICERATE` decimal(32,4) default NULL,
  `IVR_SERVICE_LEN` decimal(32,0) default NULL,
  `IVR_AVGSERVICE_LEN` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9325 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_ivrstat_day`
--

LOCK TABLES `tbl_ivrstat_day` WRITE;
/*!40000 ALTER TABLE `tbl_ivrstat_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_ivrstat_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_ivrstat_month`
--

DROP TABLE IF EXISTS `tbl_ivrstat_month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_ivrstat_month` (
  `ID` int(11) NOT NULL auto_increment,
  `STAT_TIME` varchar(20) default NULL,
  `TIME` varchar(20) default NULL,
  `IVR_CODE` varchar(20) default NULL,
  `CALL_NUM_OUTSIDE` decimal(32,0) default NULL,
  `CALL_NUM_INSIDE` decimal(32,0) default NULL,
  `CALL_NUM_IVRONLY` decimal(32,0) default NULL,
  `IVR_SERVICERATE` decimal(32,4) default NULL,
  `IVR_SERVICE_LEN` decimal(32,0) default NULL,
  `IVR_AVGSERVICE_LEN` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_ivrstat_month`
--

LOCK TABLES `tbl_ivrstat_month` WRITE;
/*!40000 ALTER TABLE `tbl_ivrstat_month` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_ivrstat_month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_ivrstat_year`
--

DROP TABLE IF EXISTS `tbl_ivrstat_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_ivrstat_year` (
  `ID` int(11) NOT NULL auto_increment,
  `STAT_TIME` varchar(20) default NULL,
  `TIME` varchar(20) default NULL,
  `IVR_CODE` varchar(20) default NULL,
  `CALL_NUM_OUTSIDE` decimal(32,0) default NULL,
  `CALL_NUM_INSIDE` decimal(32,0) default NULL,
  `CALL_NUM_IVRONLY` decimal(32,0) default NULL,
  `IVR_SERVICERATE` decimal(32,4) default NULL,
  `IVR_SERVICE_LEN` decimal(32,0) default NULL,
  `IVR_AVGSERVICE_LEN` decimal(32,0) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_ivrstat_year`
--

LOCK TABLES `tbl_ivrstat_year` WRITE;
/*!40000 ALTER TABLE `tbl_ivrstat_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_ivrstat_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uploadfile`
--

DROP TABLE IF EXISTS `uploadfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uploadfile` (
  `pk_upfile` int(11) NOT NULL auto_increment,
  `filename` varchar(50) default NULL,
  `filetype` varchar(20) default NULL,
  `filepath` varchar(100) default NULL,
  `createtime` datetime default NULL,
  PRIMARY KEY  (`pk_upfile`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uploadfile`
--

LOCK TABLES `uploadfile` WRITE;
/*!40000 ALTER TABLE `uploadfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `uploadfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `PK_USERINFO` int(11) NOT NULL auto_increment,
  `USERNAME` varchar(20) default NULL,
  `USERPWD` varchar(50) default NULL,
  `ISADMIN` varchar(10) default NULL,
  `REMARK` varchar(50) default NULL,
  `PK_DEPARTMENT` int(11) default NULL,
  `PK_WORKSTATION` int(11) default NULL,
  `FACTORY` varchar(50) default NULL,
  `AGENTNO` varchar(20) default NULL,
  `CTIPWD` varchar(20) default NULL,
  `EXTNO` varchar(50) default NULL,
  `AGENTNAME` varchar(50) default NULL,
  `AGENTEMAIL` varchar(50) default NULL,
  `PHONENO` varchar(50) default NULL,
  `AGENTSTATUS` varchar(50) default NULL,
  `LASTLOGINTIME` datetime default NULL,
  `AGENTTYPE` varchar(10) default NULL,
  `POSITION` varchar(50) default NULL,
  `USERSTATUS` varchar(50) default NULL,
  `DELFLAG` varchar(50) default NULL,
  `CTIADDR` varchar(100) default NULL,
  `CTIADDRBAK` varchar(100) default NULL,
  `AUTHADDR` varchar(100) default NULL,
  `AUTHTYPE` varchar(50) default NULL,
  `TEMP1` varchar(100) default NULL,
  `TEMP2` varchar(100) default NULL,
  `TEMP3` varchar(100) default NULL,
  `TEMP4` varchar(100) default NULL,
  `TEMP5` varchar(100) default NULL,
  `AUTOREPORT` varchar(10) default NULL,
  PRIMARY KEY  (`PK_USERINFO`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'admin','ywrTAw4Wmq==','true','测试',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'superadmin','C3vWzxjHzg1PBG==','true','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'liuning','mtiZna==','false','',NULL,NULL,'','1006','1234','3001','liuning','','',NULL,NULL,'OAgent','','Y',NULL,'172.16.5.65','','','Batch','','1001=1;',NULL,NULL,NULL,NULL),(29,'123','mJeZmJeZ','false','',NULL,NULL,'','213','213213','123','123','','','false',NULL,'','','N','Y','','','','Batch','','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workingcalendar`
--

DROP TABLE IF EXISTS `workingcalendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workingcalendar` (
  `PK_WORKINGCALENDAR` int(11) NOT NULL auto_increment,
  `WORKINGDATE` varchar(10) NOT NULL,
  `ISVACATION` varchar(1) NOT NULL,
  `REAMRK` varchar(100) default NULL,
  `N1` varchar(20) default NULL,
  `N2` varchar(20) default NULL,
  `N3` varchar(20) default NULL,
  PRIMARY KEY  (`PK_WORKINGCALENDAR`)
) ENGINE=MyISAM AUTO_INCREMENT=388 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workingcalendar`
--

LOCK TABLES `workingcalendar` WRITE;
/*!40000 ALTER TABLE `workingcalendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `workingcalendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workorder`
--

DROP TABLE IF EXISTS `workorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workorder` (
  `PK_WORKORDER` int(11) NOT NULL auto_increment,
  `PK_CUSTOMERINFO` int(11) default NULL,
  `WORKORDERNO` varchar(50) default NULL,
  `CUSTOMERNO` varchar(50) default NULL,
  `CUSTOMERNAME` varchar(100) default NULL,
  `CALLERNO` varchar(20) default NULL,
  `WOSTATUS` varchar(20) default NULL,
  `ORDERTYPE` varchar(20) default NULL,
  `PROJECTTYPE` varchar(20) default NULL,
  `WORKITEM` varchar(100) default NULL,
  `PRONAME` varchar(50) default NULL,
  `PROCODE` varchar(50) default NULL,
  `ORDERSOURCE` varchar(10) default NULL,
  `GENERATEMODE` varchar(20) default NULL,
  `CALLTIME` datetime default NULL,
  `PK_USERINFO` int(11) NOT NULL,
  `DEALTIME` datetime default NULL,
  `AUDITPERSON` varchar(20) default NULL,
  `AUDITTIME` datetime default NULL,
  `COMPLETEPERSON` varchar(20) default NULL,
  `COMPLETETIME` datetime default NULL,
  `REMARK` text,
  `CONSULTCONTENT` text,
  `NEXTACTION` text,
  `REMINDFLAG` varchar(10) default NULL,
  `TEMP1` text,
  `TEMP2` text,
  `TEMP3` text,
  `TEMP4` text,
  `TEMP5` text,
  `TEMP6` text,
  `TEMP7` text,
  `TEMP8` text,
  `ACTUSERNAME` varchar(20) default NULL,
  PRIMARY KEY  (`PK_WORKORDER`),
  KEY `FK_ORDER_CUST` USING BTREE (`PK_CUSTOMERINFO`),
  KEY `FK_ORDER_USER` USING BTREE (`PK_USERINFO`)
) ENGINE=MyISAM AUTO_INCREMENT=517 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workorder`
--

LOCK TABLES `workorder` WRITE;
/*!40000 ALTER TABLE `workorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `workorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workstation`
--

DROP TABLE IF EXISTS `workstation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workstation` (
  `PK_WORKSTATION` int(11) NOT NULL auto_increment,
  `FACTORYNAMECN` varchar(50) default NULL,
  `FACTORYNAMEEN` varchar(50) default NULL,
  `PHONENO` varchar(30) default NULL,
  `WSLINKMAN` varchar(50) default NULL,
  `WSEMAIL` varchar(50) default NULL,
  `WSADDR` text,
  `REMARK` text,
  `TEMP1` text,
  `TEMP2` text,
  `TEMP3` text,
  `TEMP4` text,
  PRIMARY KEY  (`PK_WORKSTATION`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workstation`
--

LOCK TABLES `workstation` WRITE;
/*!40000 ALTER TABLE `workstation` DISABLE KEYS */;
/*!40000 ALTER TABLE `workstation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-26 18:10:27
