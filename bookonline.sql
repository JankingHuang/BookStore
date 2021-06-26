/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : bookonline

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2021-06-26 16:43:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `book_id` bigint(20) NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `book_name_pinyin` varchar(50) NOT NULL,
  `book_category_id` bigint(20) NOT NULL,
  `book_author` varchar(256) NOT NULL,
  `book_price` float NOT NULL,
  `book_image` bigint(20) DEFAULT NULL,
  `publishing` varchar(50) NOT NULL,
  `book_desc` varchar(1024) NOT NULL,
  `book_state` int(11) NOT NULL,
  `deploy_datetime` datetime DEFAULT NULL,
  `sales_volume` int(11) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_book
-- ----------------------------

-- ----------------------------
-- Table structure for t_book_category
-- ----------------------------
DROP TABLE IF EXISTS `t_book_category`;
CREATE TABLE `t_book_category` (
  `book_category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`book_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_book_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_doc
-- ----------------------------
DROP TABLE IF EXISTS `t_doc`;
CREATE TABLE `t_doc` (
  `id` bigint(20) NOT NULL,
  `file_name` varchar(50) NOT NULL,
  `mime` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_doc
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `order_datetime` datetime NOT NULL,
  `consignee` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `postalcode` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `send_type` int(11) NOT NULL,
  `send_datetime` datetime DEFAULT NULL,
  `order_price` decimal(10,0) NOT NULL,
  `order_state` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `book_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  `user_type` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'test1', 'E10ADC3949BA59ABBE56E057F20F883E', '2');
INSERT INTO `t_user` VALUES ('2', 'test2', '7FA8282AD93047A4D6FE6111C93B308A', '2');
INSERT INTO `t_user` VALUES ('3', 'admin', '21232F297A57A5A743894A0E4A801FC3', '1');
