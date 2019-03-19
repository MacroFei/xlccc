/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : GFQ_xlccc

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 20/03/2019 07:26:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crop
-- ----------------------------
DROP TABLE IF EXISTS `crop`;
CREATE TABLE `crop` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `variety` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '品种',
  `temperayure` int(50) DEFAULT NULL COMMENT '温度',
  `humidity` int(50) DEFAULT NULL COMMENT '湿度',
  `co2` int(50) DEFAULT NULL COMMENT 'CO2',
  `illumination` int(50) DEFAULT NULL COMMENT '光照',
  `company` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '公司',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域_省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域_市',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域_区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of crop
-- ----------------------------
BEGIN;
INSERT INTO `crop` VALUES (1, '西虹死111', 112111, 777, 88, 89789, '中国许111', '浙江111', '航周', '共数111');
INSERT INTO `crop` VALUES (2, '男挂', 22, 44, 442, 2232, '三大', '萨吉', '鸡儿', '泗塘');
INSERT INTO `crop` VALUES (3, '丝瓜', 22, 77, 99, 666, '密度', '北京', '骄傲', '你是');
COMMIT;

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `unit_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备型号',
  `device_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备类别',
  `working_condition` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '工作状态',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '区',
  `company` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '公司',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equipment
-- ----------------------------
BEGIN;
INSERT INTO `equipment` VALUES (1, 'S001', 'pta00', '湿度', '不知道', '浙江', '私闯', '汉周', '城市');
INSERT INTO `equipment` VALUES (2, 'S002', 'asd22', '温度', '正常', '浙江', '中国', '中', '安迪');
INSERT INTO `equipment` VALUES (3, 'S004', 'sadijo', 'as', 'sdjai', 'fsdijo', 'qiojdfs', 'ioj', 'ij');
INSERT INTO `equipment` VALUES (4, 'oij', 'ioj', 'jio', 'ijo', 'oij', 'oji', 'ijo', 'iojo');
INSERT INTO `equipment` VALUES (5, 'joik', 'jko', 'kjl', 'jkl', 'jkl', 'ljk', 'lkj', 'lkj');
INSERT INTO `equipment` VALUES (6, 'kjl', 'qqq', 'kljqqq', 'kjlqqq', 'kjlqqq', 'kljjkqqq', 'lkljqqq', 'lkqqq');
COMMIT;

-- ----------------------------
-- Table structure for irrigate
-- ----------------------------
DROP TABLE IF EXISTS `irrigate`;
CREATE TABLE `irrigate` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `greenhouse` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属大棚',
  `working_condition` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '工作状态',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域_省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域_市',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域_区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of irrigate
-- ----------------------------
BEGIN;
INSERT INTO `irrigate` VALUES (1, 'S001', 'asd', 'asd', 'aaa', 'aaa', 'aaa');
INSERT INTO `irrigate` VALUES (2, 'S000', 'asdj', 'jsjs', 'asnio', 'nsad', 'dscxn');
INSERT INTO `irrigate` VALUES (3, 'As2', 'dsfj', 'ndf', 'ndwfs', 'nsdf', 'qfdns');
INSERT INTO `irrigate` VALUES (4, 'xlccc', 'asd', 'sadjni', 'sij ', 'iu', 'iujn');
INSERT INTO `irrigate` VALUES (5, 'iiwi', 'ino', 'noij', 'jnk', 'jkn', 'jkn');
COMMIT;

-- ----------------------------
-- Table structure for user_demo
-- ----------------------------
DROP TABLE IF EXISTS `user_demo`;
CREATE TABLE `user_demo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `phone` int(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
