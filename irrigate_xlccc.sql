/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : irrigate_xlccc

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 2/3/2019 15:31:58
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
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '标示符_返回数据_手动',
  `limitMax` int(20) DEFAULT '100' COMMENT '界限最大值',
  `limitMin` int(20) DEFAULT '0' COMMENT '界限最小值',
  `tag` varchar(20) DEFAULT NULL COMMENT '标识符',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of crop
-- ----------------------------
BEGIN;
INSERT INTO `crop` VALUES (3, '南瓜', 22, 44, 442, 2232, '浙江大学有限公司', '浙江省', '杭州市', '山头区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (4, '南瓜2', 22, 44, 442, 2232, '浙江大学有限公司', '浙江省', '杭州市', '山头区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (5, '南瓜3', 22, 77, 99, 666, '浙江大学有限公司', '浙江省', '杭州市', '山头区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (6, '南瓜41', 22, 44, 442, 2232, '浙江大学有限公司', '浙江省', '宁波市', '江东区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (7, '丝瓜1', 22, 77, 99, 666, '浙江大学有限公司', '福建省', '福清市', '三山镇', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (8, '丝瓜2', 22, 77, 99, 666, 'Linkp公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (10, '丝瓜3', 22, 77, 99, 666, 'Linkp公司', '福建省', '福州市', '马尾区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (11, '丝瓜4', 22, 77, 99, 666, 'Linkp公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (12, '南瓜5', 22, 44, 442, 2232, 'Linkp公司', '浙江省', '宁波市', '江东区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (13, '丝瓜6', 22, 77, 99, 666, 'Linkp公司', '福建省', '福清市', '三山镇', 'B', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (14, '丝瓜7', 22, 77, 99, 666, '三大公司', '福建省', '福州市', '山头区', 'B', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (15, '南瓜8', 22, 44, 442, 2232, '三大公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (16, '丝瓜9', 22, 77, 99, 666, '三大公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (17, '南瓜0', 22, 44, 442, 2232, '中国公司', '浙江省', '宁波市', '江东区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (18, '丝瓜11', 22, 77, 99, 666, 'Linkp公司', '福建省', '福清市', '三山镇', 'B', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (19, '丝瓜12', 22, 77, 99, 666, 'Link公司', '福建省', '福州市', '马尾区', 'B', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (20, '南瓜13', 22, 44, 442, 2232, '中国公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (21, '丝瓜14', 22, 77, 99, 666, 'Link公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (22, '南瓜15', 22, 44, 442, 2232, '美国公司', '浙江省', '宁波市', '江东区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (23, '丝瓜16', 22, 77, 99, 666, 'Link公司', '福建省', '福清市', '三山镇', 'B', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (24, '丝瓜17', 22, 77, 99, 666, 'Link公司', '福建省', '福州市', '马尾区', 'B', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (25, '南瓜18', 22, 44, 442, 2232, '美国公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (26, '丝瓜19', 22, 77, 99, 666, 'Link公司', '浙江省', '杭州市', '拱墅区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (27, '南瓜20', 22, 44, 442, 2232, '三大公司', '浙江省', '宁波市', '山头区', 'A', 100, 0, NULL, NULL);
INSERT INTO `crop` VALUES (28, '丝瓜21', 22, 77, 99, 666, 'Link公司', '福建省', '福清市', '三山镇', 'B', 100, 0, NULL, NULL);
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
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '识别分类',
  `tag` varchar(20) DEFAULT NULL COMMENT '标识符',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equipment
-- ----------------------------
BEGIN;
INSERT INTO `equipment` VALUES (1, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (2, 'S002', 'A型号', 'A类', '正常', '四川', '宁波', '山脚', '浙江大学有限公司', 'B', NULL, NULL);
INSERT INTO `equipment` VALUES (3, 'S0099', 'B型号', 'B类', '正常', '浙江', '绍兴', '山头', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (4, 'S0041', 'B型号', 'B类', '异常', '浙江', '绍兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (5, 'S0051', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (9, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (10, 'S005', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (11, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (12, 'S002', 'A型号', 'A类', '正常', '四川', '宁波', '山脚', '浙江大学有限公司', 'B', NULL, NULL);
INSERT INTO `equipment` VALUES (13, 'S0099', 'B型号', 'B类', '正常', '浙江', '绍兴', '山头', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (14, 'S004', 'B型号', 'B类', '异常', '浙江', '绍兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (15, 'S005', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (16, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (17, 'S002', 'A型号', 'A类', '正常', '四川', '宁波', '山脚', '浙江大学有限公司', 'B', NULL, NULL);
INSERT INTO `equipment` VALUES (18, 'S0099', 'B型号', 'B类', '正常', '浙江', '绍兴', '山头', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (19, 'S004', 'B型号', 'B类', '异常', '浙江', '绍兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (20, 'S005', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (21, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (22, 'S002', 'A型号', 'A类', '正常', '四川', '宁波', '山脚', '浙江大学有限公司', 'B', NULL, NULL);
INSERT INTO `equipment` VALUES (23, 'S0099', 'B型号', 'B类', '正常', '浙江', '绍兴', '山头', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (24, 'S004', 'B型号', 'B类', '异常', '浙江', '绍兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (25, 'S005', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (26, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (27, 'S002', 'A型号', 'A类', '正常', '四川', '宁波', '山脚', '浙江大学有限公司', 'B', NULL, NULL);
INSERT INTO `equipment` VALUES (28, 'S0099', 'B型号', 'B类', '正常', '浙江', '绍兴', '山头', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (29, 'S004', 'B型号', 'B类', '异常', '浙江', '绍兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (30, 'S005', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (31, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (32, 'S002', 'A型号', 'A类', '正常', '四川', '宁波', '山脚', '浙江大学有限公司', 'B', NULL, NULL);
INSERT INTO `equipment` VALUES (33, 'S0099', 'B型号', 'B类', '正常', '浙江', '绍兴', '山头', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (34, 'S004', 'B型号', 'B类', '异常', '浙江', '绍兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (35, 'S005', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (36, 'C001', 'A型号', 'A类', '正常', '浙江', '杭州', '山头', '浙江大学有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (37, 'S002', 'A型号', 'A类', '正常', '四川', '宁波', '山脚', '浙江大学有限公司', 'B', NULL, NULL);
INSERT INTO `equipment` VALUES (38, 'S0099', 'B型号', 'B类', '正常', '浙江', '绍兴', '山头', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (39, 'S004', 'B型号', 'B类', '异常', '浙江', '绍兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
INSERT INTO `equipment` VALUES (40, 'S005', 'BA型号', 'C类', '报废', '浙江', '嘉兴', '平原', '中国MID有限公司', 'A', NULL, NULL);
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
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '识别分类',
  `tag` varchar(20) DEFAULT NULL COMMENT '标识符',
  `date` datetime DEFAULT NULL COMMENT '定时',
  `irrigated_time` varchar(50) DEFAULT NULL COMMENT '灌溉时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of irrigate
-- ----------------------------
BEGIN;
INSERT INTO `irrigate` VALUES (1, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (2, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (3, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (9, 'SSS001', '陈某的大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (10, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (11, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (12, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (13, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (14, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (15, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (16, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (17, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (18, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (19, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (20, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (21, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (22, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (23, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (24, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (25, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (26, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (27, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (28, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (29, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (30, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (31, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (32, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (33, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (34, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (35, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (36, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (37, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (38, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (39, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (40, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (41, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (42, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (43, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (44, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (45, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (46, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (47, 'S0023', 'A大棚', '正常', '浙江', '杭州', '西湖', 'A', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (48, 'S004', 'B大棚', '正常', '中国', '日本', '山头', 'B', NULL, NULL, NULL, NULL);
INSERT INTO `irrigate` VALUES (49, 'S006', 'C大棚', '正常', '中国', '日本', '平原', 'A', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_demo
-- ----------------------------
DROP TABLE IF EXISTS `user_demo`;
CREATE TABLE `user_demo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '所属区域',
  `role` int(4) DEFAULT '1' COMMENT '用户权限(0全部可以，1可以访问A，2可以访问B)',
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '识别分类',
  `uuid` varchar(255) DEFAULT NULL COMMENT 'uuidForAndroid',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_demo
-- ----------------------------
BEGIN;
INSERT INTO `user_demo` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '22222312111', '21@22sdasjid.com', '浙江', 0, 'A', '0', NULL);
INSERT INTO `user_demo` VALUES (2, 'xlccc', 'e10adc3949ba59abbe56e057f20f883e', '12312341234', 'macrofei@163.com', '浙江', 1, 'A', '0', NULL);
INSERT INTO `user_demo` VALUES (9, 'admind', '84cdc8c876561b7075671749e92e575a', '18072911111', '47@qq.com', '福建省', 1, 'A', '0', NULL);
INSERT INTO `user_demo` VALUES (10, 'adminDemo', 'asjdiaoijoiasdjoiasdj', '12312312322', 'aoidsj@aiai.com', '华山东', 1, 'B', '0', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
