/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : xlccc

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 25/02/2019 22:08:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `uid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_property_user` (`uid`),
  CONSTRAINT `fk_property_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of property
-- ----------------------------
BEGIN;
INSERT INTO `property` VALUES (1, 'asdasd', 450);
INSERT INTO `property` VALUES (4, 'asdasda', 450);
INSERT INTO `property` VALUES (5, 'asdasd', 450);
INSERT INTO `property` VALUES (6, 'sa da s d', 450);
INSERT INTO `property` VALUES (8, '阿萨德撒打算', 450);
INSERT INTO `property` VALUES (9, '阿萨德', 451);
INSERT INTO `property` VALUES (10, '撒上说', 451);
INSERT INTO `property` VALUES (11, '奋斗的打算', 451);
INSERT INTO `property` VALUES (12, 's s s', 451);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=480 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (2, 'asd');
INSERT INTO `user` VALUES (4, 'xlccc');
INSERT INTO `user` VALUES (21, 'asdd');
INSERT INTO `user` VALUES (22, 'asd');
INSERT INTO `user` VALUES (222, '33');
INSERT INTO `user` VALUES (333, 'dd');
INSERT INTO `user` VALUES (334, 'demo1');
INSERT INTO `user` VALUES (335, 'demo1');
INSERT INTO `user` VALUES (336, 'aaaa');
INSERT INTO `user` VALUES (337, 'qq');
INSERT INTO `user` VALUES (338, 'a');
INSERT INTO `user` VALUES (446, 'sadssssss');
INSERT INTO `user` VALUES (448, 'sadfasadsf');
INSERT INTO `user` VALUES (449, 'cgsdfgsdf');
INSERT INTO `user` VALUES (450, 'cgsdfgsdf');
INSERT INTO `user` VALUES (451, '阿撒撒撒啊是撒打算');
INSERT INTO `user` VALUES (479, 'asdasdasd');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
