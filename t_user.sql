/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-12-05 18:29:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_register_time` time DEFAULT NULL,
  `user_role` varchar(50) DEFAULT NULL,
  `user_credit` bigint(20) DEFAULT NULL,
  `user_is_active` tinyint(1) DEFAULT NULL,
  `user_last_login_time` time DEFAULT NULL,
  `user_key` varchar(255) DEFAULT NULL,
  `user_cart_status` tinyint(1) DEFAULT NULL,
  `user_balance` double(20,2) DEFAULT '0.00',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'owen', '123', 'owen@qq.com', '13333445566', '00:00:00', 'admin', '268', '1', null, null, null, '2543.24');
INSERT INTO `t_user` VALUES ('2', 'huang', '123', 'huang@qq.com', '13566778899', '00:00:00', 'user', '260', '1', null, null, null, '784.00');
INSERT INTO `t_user` VALUES ('3', 'fool', '123', 'fool@qq.com', '13633445566', '00:00:00', 'manager', '888', '1', null, null, null, '12.35');
