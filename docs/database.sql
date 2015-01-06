/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.20 : Database - wxadjingmo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wxadjingmo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wxadjingmo`;

/*Table structure for table `activelist` */

DROP TABLE IF EXISTS `activelist`;

CREATE TABLE `activelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `packageName` varchar(255) NOT NULL,
  `count` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `pushId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `activelist` */

insert  into `activelist`(`id`,`packageName`,`count`,`date`,`pushId`) values (1,'312',123,'123',7);

/*Table structure for table `applist` */

DROP TABLE IF EXISTS `applist`;

CREATE TABLE `applist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `packageName` varchar(100) NOT NULL,
  `url` varchar(255) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `type` varchar(100) NOT NULL,
  `version` varchar(50) NOT NULL,
  `pushId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `applist` */

insert  into `applist`(`id`,`packageName`,`url`,`hash`,`type`,`version`,`pushId`) values (2,'软任务','发啥呆','dsafdsa','sdfasdf','sfsaf收费',9);

/*Table structure for table `deletelist` */

DROP TABLE IF EXISTS `deletelist`;

CREATE TABLE `deletelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `packageName` varchar(255) NOT NULL,
  `pushId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `deletelist` */

insert  into `deletelist`(`id`,`packageName`,`pushId`) values (1,'萨芬的',5);

/*Table structure for table `feedback` */

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

/*Data for the table `feedback` */

insert  into `feedback`(`id`,`uuid`,`packageName`,`version`,`action`,`state`,`msg`,`datetime`) values (2,'864054001273053','com.shoujiduoduo.wallpaper','1160','install','fail','init.svc.shcmd service no running','2014-12-18');

/*Table structure for table `jingmoinfo` */

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

/*Data for the table `jingmoinfo` */

insert  into `jingmoinfo`(`id`,`uuid`,`version`,`netType`,`channel`,`datetime`,`macAddress`,`systemVersion`,`sdkVersion`,`model`,`language`,`resolution`,`country`,`isTablet`,`size`,`ram`,`rom`,`hasSim`,`isUpdateDeviceInfo`,`hardware`,`isRoot`) values (5,'864054001273053','1','wifi','eken','2015-01-02','00:08:22:f2:e4:fb','4.2.2','17','MR7062L1C2W1','CN_zh','480_800','cn','false','4.86','93945856_1012289536','0_1394900992','false',NULL,'mt8382','true'),(6,'864054001273053','1','wifi','eken','2014-12-18','00:08:22:f2:e4:fb','4.2.2','17','MR7062L1C2W1','CN_zh','480_800','cn','false','4.86','93945856_1012289536','0_1394900992','false',NULL,'mt8382','true'),(7,'864054001273053','1','wifi','eken','2014-12-18','00:08:22:f2:e4:fb','4.2.2','17','MR7062L1C2W1','CN_zh','480_800',NULL,'false','4.86','90832896_1012289536','0_1394900992','false',NULL,'mt8382','true'),(8,'864054001273053','1','wifi','eken','2014-12-18','00:08:22:f2:e4:fb','4.2.2','17','MR7062L1C2W1','CN_zh','480_800',NULL,'false','4.86','90832896_1012289536','0_1394900992','false',NULL,'mt8382','true'),(9,'864054001273053','1','wifi','eken','2014-12-18','00:08:22:f2:e4:fb','4.2.2','17','MR7062L1C2W1','CN_zh','480_800','cn','false','4.86','90832896_1012289536','0_1394900992','false',NULL,'mt8382','true');

/*Table structure for table `pushrule` */

DROP TABLE IF EXISTS `pushrule`;

CREATE TABLE `pushrule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apkNum` int(11) DEFAULT NULL COMMENT '安装个数',
  `pushUrl` text COMMENT '业务请求地址',
  `deviceUrl` text COMMENT '登记设备信息地址',
  `requestRate` varchar(20) DEFAULT NULL COMMENT '业务请求频率',
  `country` varchar(50) DEFAULT NULL COMMENT '国家',
  `size` varchar(20) DEFAULT NULL COMMENT '屏幕大小',
  `ram` varchar(20) DEFAULT NULL COMMENT 'ram大小',
  `channel` varchar(50) DEFAULT NULL COMMENT '渠道号',
  `isTablet` varchar(10) DEFAULT NULL COMMENT '是否是平板',
  `systemVersion` varchar(50) DEFAULT NULL COMMENT '系统版本',
  `sdkVersion` varchar(50) DEFAULT NULL COMMENT 'sdk版本',
  `model` varchar(50) DEFAULT NULL COMMENT '设置型号',
  `resolution` varchar(50) DEFAULT NULL COMMENT '屏幕分辨率',
  `rom` varchar(50) DEFAULT NULL COMMENT 'rom大小',
  `hasSim` varchar(20) DEFAULT NULL COMMENT '是否有SIM卡',
  `isRoot` varchar(20) DEFAULT NULL COMMENT '是否已经root',
  `hardware` varchar(50) DEFAULT NULL COMMENT '包含wmt也直接下发status=true，不下发业务信息',
  `isMatching` tinyint(4) DEFAULT NULL COMMENT '是否匹配',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `pushrule` */

insert  into `pushrule`(`id`,`apkNum`,`pushUrl`,`deviceUrl`,`requestRate`,`country`,`size`,`ram`,`channel`,`isTablet`,`systemVersion`,`sdkVersion`,`model`,`resolution`,`rom`,`hasSim`,`isRoot`,`hardware`,`isMatching`) values (5,5,'wifi','eken','2014-12-18','ae','7','256','新版OTA','0','12','2','3','4','5','0','0','6',0),(6,6,'wifi','eken','2014-12-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,7,'wifi','eken','2014-12-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,8,'wifi','eken','2014-12-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,9,'wifi','eken','2014-12-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `registeredinfo` */

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

/*Data for the table `registeredinfo` */

insert  into `registeredinfo`(`id`,`channel`,`ram`,`rom`,`size`,`resolution`,`systemVersion`,`uuid`,`datetime`,`language`,`sdkVersion`,`version`,`hasSim`,`netType`,`isTablet`,`macAddress`,`model`,`country`,`isRoot`) values (1,'eken','31031296_1012289536','655360_1394900992','4.86','480_800','4.2.2','864054001273053','2015-01-12','CN_zh','17','1','false','wifi','false','00:08:22:f2:e4:fb','MR7062L1C2W1','us','true'),(2,'eken','31031296_1012289536','655360_1394900992','4.86','480_800','4.2.2','864054001273053','2015-01-12','CN_zh','17','1','false','wifi','false','00:08:22:f2:e4:fb','MR7062L1C2W1','us','true');

/*Table structure for table `sys_user` */

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

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`passwd`,`sys_user_type`,`status`,`privilege`,`remark`,`gmt_create`,`gmt_modified`,`channel`) values (1,'test','8af4defdc62234faa80b02fa6ff2bea7',0,1,'1',NULL,'2014-11-15 20:06:01','2014-11-04 15:38:20','a012234'),(2,'test1','c96ef47007e3b0ebd89cdf54030a1fb8',1,1,'1','ceshi','2014-11-15 20:05:56','2014-11-05 17:45:50','a012233'),(3,'test2','ce664eb5984f6aec856aa115b1fc3d69',3,1,'1','','2014-11-15 20:05:58','2014-11-15 14:14:48','a012233');

/*Table structure for table `updatelist` */

DROP TABLE IF EXISTS `updatelist`;

CREATE TABLE `updatelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(20) NOT NULL,
  `url` varchar(250) NOT NULL,
  `hash` varchar(250) DEFAULT NULL,
  `pushId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `updatelist` */

insert  into `updatelist`(`id`,`version`,`url`,`hash`,`pushId`) values (1,'123','发生大幅','23',7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
