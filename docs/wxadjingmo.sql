/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : wxadjingmo

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2014-12-22 23:05:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activelist`
-- ----------------------------
DROP TABLE IF EXISTS `activelist`;
CREATE TABLE `activelist` (
  `id` int(11) NOT NULL,
  `packageName` varchar(255) NOT NULL,
  `count` int(11) NOT NULL,
  `date` int(11) NOT NULL,
  `pushId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activelist
-- ----------------------------

-- ----------------------------
-- Table structure for `applist`
-- ----------------------------
DROP TABLE IF EXISTS `applist`;
CREATE TABLE `applist` (
  `id` int(11) NOT NULL,
  `packageName` varchar(100) NOT NULL,
  `url` varchar(255) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `type` varchar(100) NOT NULL,
  `version` varchar(50) NOT NULL,
  `pushId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applist
-- ----------------------------

-- ----------------------------
-- Table structure for `deletelist`
-- ----------------------------
DROP TABLE IF EXISTS `deletelist`;
CREATE TABLE `deletelist` (
  `id` int(11) NOT NULL,
  `packageName` varchar(255) NOT NULL,
  `pushId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deletelist
-- ----------------------------

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(100) NOT NULL,
  `packageName` varchar(100) DEFAULT NULL,
  `version` varchar(20) DEFAULT NULL,
  `action` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `msg` text,
  `datetime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('2', '864054001273053', 'com.shoujiduoduo.wallpaper', '1160', 'install', 'fail', 'init.svc.shcmd service no running', '2014-12-18');

-- ----------------------------
-- Table structure for `jingmoinfo`
-- ----------------------------
DROP TABLE IF EXISTS `jingmoinfo`;
CREATE TABLE `jingmoinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(100) NOT NULL,
  `version` varchar(50) NOT NULL,
  `netType` varchar(20) NOT NULL,
  `channel` varchar(40) NOT NULL,
  `datetime` varchar(20) NOT NULL,
  `macAddress` varchar(50) NOT NULL,
  `systemVersion` varchar(50) NOT NULL,
  `sdkVersion` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `language` varchar(20) NOT NULL,
  `resolution` varchar(20) NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  `isTablet` varchar(50) NOT NULL,
  `size` varchar(20) NOT NULL,
  `ram` varchar(20) NOT NULL,
  `rom` varchar(20) NOT NULL,
  `hasSim` varchar(50) NOT NULL,
  `isUpdateDeviceInfo` varchar(100) DEFAULT NULL,
  `hardware` varchar(50) DEFAULT NULL,
  `isRoot` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uudiindexs` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of jingmoinfo
-- ----------------------------
INSERT INTO `jingmoinfo` VALUES ('5', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', '00:08:22:f2:e4:fb', '4.2.2', '17', 'MR7062L1C2W1', 'CN_zh', '480_800', '0', 'false', '4.86', '93945856_1012289536', '0_1394900992', 'false', null, 'mt8382', 'true');
INSERT INTO `jingmoinfo` VALUES ('6', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', '00:08:22:f2:e4:fb', '4.2.2', '17', 'MR7062L1C2W1', 'CN_zh', '480_800', '0', 'false', '4.86', '93945856_1012289536', '0_1394900992', 'false', null, 'mt8382', 'true');
INSERT INTO `jingmoinfo` VALUES ('7', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', '00:08:22:f2:e4:fb', '4.2.2', '17', 'MR7062L1C2W1', 'CN_zh', '480_800', null, 'false', '4.86', '90832896_1012289536', '0_1394900992', 'false', null, 'mt8382', 'true');
INSERT INTO `jingmoinfo` VALUES ('8', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', '00:08:22:f2:e4:fb', '4.2.2', '17', 'MR7062L1C2W1', 'CN_zh', '480_800', null, 'false', '4.86', '90832896_1012289536', '0_1394900992', 'false', null, 'mt8382', 'true');
INSERT INTO `jingmoinfo` VALUES ('9', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', '00:08:22:f2:e4:fb', '4.2.2', '17', 'MR7062L1C2W1', 'CN_zh', '480_800', '0', 'false', '4.86', '90832896_1012289536', '0_1394900992', 'false', null, 'mt8382', 'true');

-- ----------------------------
-- Table structure for `pushrule`
-- ----------------------------
DROP TABLE IF EXISTS `pushrule`;
CREATE TABLE `pushrule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pushId` varchar(100) NOT NULL,
  `apkNum` int(11) DEFAULT NULL,
  `pushUrl` text,
  `deviceUrl` text,
  `requestRate` varchar(20) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `ram` varchar(20) DEFAULT NULL,
  `channel` varchar(50) DEFAULT NULL,
  `isTablet` varchar(10) DEFAULT NULL,
  `systemVersion` varchar(50) DEFAULT NULL,
  `sdkVersion` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `resolution` varchar(50) DEFAULT NULL,
  `rom` varchar(50) DEFAULT NULL,
  `hasSim` varchar(20) DEFAULT NULL,
  `isRoot` varchar(20) DEFAULT NULL,
  `hardware` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uudiindexs` (`pushId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pushrule
-- ----------------------------
INSERT INTO `pushrule` VALUES ('5', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `pushrule` VALUES ('6', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `pushrule` VALUES ('7', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `pushrule` VALUES ('8', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `pushrule` VALUES ('9', '864054001273053', '1', 'wifi', 'eken', '2014-12-18', null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `registeredinfo`
-- ----------------------------
DROP TABLE IF EXISTS `registeredinfo`;
CREATE TABLE `registeredinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `channel` varchar(40) NOT NULL COMMENT '渠道号',
  `ram` varchar(40) NOT NULL COMMENT 'RAM大小',
  `rom` varchar(40) NOT NULL COMMENT 'ROM大小',
  `size` varchar(20) NOT NULL COMMENT '屏幕大小',
  `resolution` varchar(20) NOT NULL COMMENT '屏幕分辨率',
  `systemVersion` varchar(20) NOT NULL COMMENT '系统版本',
  `uuid` varchar(100) NOT NULL COMMENT 'UUID(mac_imei_simId_androidId)',
  `datetime` varchar(50) NOT NULL COMMENT '首次运行时间',
  `language` varchar(10) NOT NULL COMMENT '系统语言(国家代号_语言代号)',
  `sdkVersion` varchar(50) NOT NULL COMMENT 'sdk版本',
  `version` varchar(50) NOT NULL COMMENT '当前版本',
  `hasSim` varchar(50) NOT NULL COMMENT 'cpuId',
  `netType` varchar(20) NOT NULL COMMENT '网络类型',
  `isTablet` varchar(50) NOT NULL COMMENT 'cpu名字',
  `macAddress` varchar(50) NOT NULL COMMENT 'cpu类型',
  `model` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `isRoot` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uuidindexs` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of registeredinfo
-- ----------------------------
INSERT INTO `registeredinfo` VALUES ('1', 'eken', '31031296_1012289536', '655360_1394900992', '4.86', '480_800', '4.2.2', '864054001273053', '2014-12-15', 'CN_zh', '17', '1', 'false', 'wifi', 'false', '00:08:22:f2:e4:fb', 'MR7062L1C2W1', '0', 'true');
INSERT INTO `registeredinfo` VALUES ('2', 'eken', '31031296_1012289536', '655360_1394900992', '4.86', '480_800', '4.2.2', '864054001273053', '2014-12-16', 'CN_zh', '17', '1', 'false', 'wifi', 'false', '00:08:22:f2:e4:fb', 'MR7062L1C2W1', '0', 'true');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `passwd` varchar(96) DEFAULT NULL,
  `sys_user_type` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `privilege` varchar(300) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `channel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'test', '8af4defdc62234faa80b02fa6ff2bea7', '0', '1', '1', null, '2014-11-15 20:06:01', '2014-11-04 15:38:20', 'a012234');
INSERT INTO `sys_user` VALUES ('2', 'test1', 'c96ef47007e3b0ebd89cdf54030a1fb8', '1', '1', '1', 'ceshi', '2014-11-15 20:05:56', '2014-11-05 17:45:50', 'a012233');
INSERT INTO `sys_user` VALUES ('3', 'test2', 'ce664eb5984f6aec856aa115b1fc3d69', '3', '1', '1', '', '2014-11-15 20:05:58', '2014-11-15 14:14:48', 'a012233');

-- ----------------------------
-- Table structure for `update`
-- ----------------------------
DROP TABLE IF EXISTS `update`;
CREATE TABLE `update` (
  `id` int(11) NOT NULL,
  `version` varchar(20) NOT NULL,
  `url` varchar(250) NOT NULL,
  `hash` varchar(250) DEFAULT NULL,
  `pushId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of update
-- ----------------------------
