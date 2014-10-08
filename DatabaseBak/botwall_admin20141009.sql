/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : botwall_admin

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-10-08 16:21:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_cluster`
-- ----------------------------
DROP TABLE IF EXISTS `t_cluster`;
CREATE TABLE `t_cluster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cluster_interval` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cluster
-- ----------------------------
INSERT INTO `t_cluster` VALUES ('1', '13');
INSERT INTO `t_cluster` VALUES ('2', '13');
INSERT INTO `t_cluster` VALUES ('3', '13');
INSERT INTO `t_cluster` VALUES ('4', '12');

-- ----------------------------
-- Table structure for `t_dbinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_dbinfo`;
CREATE TABLE `t_dbinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `db_ip` varchar(15) DEFAULT NULL,
  `db_port` varchar(16) DEFAULT NULL,
  `db_name` varchar(255) DEFAULT NULL,
  `db_user` varchar(255) DEFAULT NULL,
  `db_passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dbinfo
-- ----------------------------
INSERT INTO `t_dbinfo` VALUES ('2', '134.13.13.13', '12', 'zsy', '1', '2');
INSERT INTO `t_dbinfo` VALUES ('5', '12.12.12.12', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `t_ftpinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_ftpinfo`;
CREATE TABLE `t_ftpinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `port` varchar(16) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ftpinfo
-- ----------------------------
INSERT INTO `t_ftpinfo` VALUES ('6', '1.1.1.1', '11', '2', '1');

-- ----------------------------
-- Table structure for `t_license`
-- ----------------------------
DROP TABLE IF EXISTS `t_license`;
CREATE TABLE `t_license` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `license` varchar(255) DEFAULT NULL,
  `expires` timestamp NULL DEFAULT NULL,
  `isvalid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_license
-- ----------------------------
INSERT INTO `t_license` VALUES ('1', '1dafjdkajgfkldajflfdaf', null, '-1');
INSERT INTO `t_license` VALUES ('2', null, null, '-1');
INSERT INTO `t_license` VALUES ('3', '1dafjdkajgfkldajflfdaf', null, '-1');

-- ----------------------------
-- Table structure for `t_netconfinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_netconfinfo`;
CREATE TABLE `t_netconfinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `netip` varchar(15) DEFAULT NULL,
  `maskip` varchar(15) DEFAULT NULL,
  `gateip` varchar(15) DEFAULT NULL,
  `dns1ip` varchar(15) DEFAULT NULL,
  `dns2ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_netconfinfo
-- ----------------------------
INSERT INTO `t_netconfinfo` VALUES ('7', '2.2.1.1', '1.1.1.1', '1.1.1.1', '1.1.1.1', '1.1.1.1');

-- ----------------------------
-- Table structure for `t_pot`
-- ----------------------------
DROP TABLE IF EXISTS `t_pot`;
CREATE TABLE `t_pot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `mac` char(17) DEFAULT '',
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pot
-- ----------------------------
INSERT INTO `t_pot` VALUES ('1', '192.168.1.2', '', '1');
INSERT INTO `t_pot` VALUES ('3', '2.2.2.2', '', '1');
INSERT INTO `t_pot` VALUES ('4', '3.3.3.3', '', '1');
INSERT INTO `t_pot` VALUES ('6', '121.211.121.26', '', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Username` varchar(32) DEFAULT NULL,
  `Password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'ice', 'ice');

-- ----------------------------
-- Table structure for `t_whitedomain`
-- ----------------------------
DROP TABLE IF EXISTS `t_whitedomain`;
CREATE TABLE `t_whitedomain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_whitedomain
-- ----------------------------
INSERT INTO `t_whitedomain` VALUES ('1', 'ww', 'w');
INSERT INTO `t_whitedomain` VALUES ('2', '2', '1');

-- ----------------------------
-- Table structure for `t_whiteip`
-- ----------------------------
DROP TABLE IF EXISTS `t_whiteip`;
CREATE TABLE `t_whiteip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `ifrunning` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_whiteip
-- ----------------------------
INSERT INTO `t_whiteip` VALUES ('2', '1.1.1.1', '1', '1');
