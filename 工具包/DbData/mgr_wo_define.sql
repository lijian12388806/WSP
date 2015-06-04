/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : crm_test

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2015-04-21 12:21:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mgr_wo_define
-- ----------------------------
DROP TABLE IF EXISTS `mgr_wo_define`;
CREATE TABLE `mgr_wo_define` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEF_TMP_CODE` varchar(32) DEFAULT NULL COMMENT '模板编码',
  `DEF_TYPE` varchar(32) DEFAULT NULL COMMENT '类型-查询列表、添加、编辑页面、查看页面',
  `DEF_COL` varchar(125) DEFAULT NULL COMMENT '字段',
  `DEF_COL_TITLE` varchar(125) DEFAULT NULL COMMENT '字段名称',
  `DEF_COL_TYPE` varchar(32) DEFAULT NULL COMMENT '字段显示类型',
  `DEF_COL_LMIN` varchar(32) DEFAULT NULL COMMENT '字段最小长度',
  `DEF_COL_LMAX` varchar(32) DEFAULT NULL COMMENT '字段最大长度',
  `DEF_COL_CLASS` varchar(32) DEFAULT NULL COMMENT '字段是否必填',
  `DEF_COL_DISPLAY` varchar(32) DEFAULT NULL COMMENT '字段显示',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mgr_wo_define
-- ----------------------------
INSERT INTO `mgr_wo_define` VALUES ('1', 't_01', 'list', 'WOS_NO', '工单编号', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('2', 't_01', 'list', 'WOS_CALLINNO', '来电号码', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('3', 't_01', 'list', 'WOS_TYPE', '工单类型', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('4', 't_01', 'list', 'WOS_STATUS', '工单状态', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('5', 't_01', 'list', 'WOS_T1', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('6', 't_01', 'list', 'WOS_T2', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('7', 't_01', 'list', 'WOS_T3', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('8', 't_01', 'list', 'WOS_T4', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('9', 't_01', 'list', 'WOS_T5', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('10', 't_01', 'list', 'WOS_T6', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('11', 't_01', 'list', 'WOS_T7', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('12', 't_01', 'list', 'WOS_T8', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('13', 't_01', 'list', 'WOS_T9', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('14', 't_01', 'list', 'WOS_T10', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('15', 't_01', 'list', 'WOS_T11', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('16', 't_01', 'list', 'WOS_T12', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('17', 't_01', 'list', 'WOS_T13', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('18', 't_01', 'list', 'WOS_T14', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('19', 't_01', 'list', 'WOS_T15', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('20', 't_01', 'list', 'WOS_T16', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('21', 't_01', 'list', 'WOS_T17', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('22', 't_01', 'list', 'WOS_T18', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('23', 't_01', 'list', 'WOS_T19', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('24', 't_01', 'list', 'WOS_T20', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('25', 't_01', 'list', 'WOS_T21', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('26', 't_01', 'list', 'WOS_T22', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('27', 't_01', 'list', 'WOS_T23', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('28', 't_01', 'list', 'WOS_T24', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('29', 't_01', 'list', 'WOS_T25', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('30', 't_01', 'list', 'WOS_T26', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('31', 't_01', 'list', 'WOS_T27', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('32', 't_01', 'list', 'WOS_T28', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('33', 't_01', 'list', 'WOS_T29', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('34', 't_01', 'list', 'WOS_T30', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('35', 't_01', 'list', 'WOS_T31', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('36', 't_01', 'list', 'WOS_T32', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('37', 't_01', 'list', 'WOS_T33', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('38', 't_01', 'list', 'WOS_T34', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('39', 't_01', 'list', 'WOS_T35', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('40', 't_01', 'list', 'WOS_T36', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('41', 't_01', 'list', 'WOS_T37', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('42', 't_01', 'list', 'WOS_T38', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('43', 't_01', 'list', 'WOS_T39', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('44', 't_01', 'list', 'WOS_T40', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('45', 't_01', 'list', 'WOS_T41', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('46', 't_01', 'list', 'WOS_T42', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('47', 't_01', 'list', 'WOS_T43', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('48', 't_01', 'list', 'WOS_T44', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('49', 't_01', 'list', 'WOS_T45', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('50', 't_01', 'list', 'WOS_T46', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('51', 't_01', 'list', 'WOS_T47', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('52', 't_01', 'list', 'WOS_T48', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('53', 't_01', 'list', 'WOS_T49', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('54', 't_01', 'list', 'WOS_T50', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('55', 't_01', 'list', 'WOS_T51', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('56', 't_01', 'list', 'WOS_T52', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('57', 't_01', 'list', 'WOS_T53', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('58', 't_01', 'list', 'WOS_T54', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('59', 't_01', 'list', 'WOS_T55', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('60', 't_01', 'list', 'WOS_T56', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('61', 't_01', 'list', 'WOS_T57', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('62', 't_01', 'list', 'WOS_T58', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('63', 't_01', 'list', 'WOS_T59', '未定义', 'input', '4', '20', 'required', 'Y');
INSERT INTO `mgr_wo_define` VALUES ('64', 't_01', 'list', 'WOS_T60', '未定义', 'input', '4', '20', 'required', 'Y');
