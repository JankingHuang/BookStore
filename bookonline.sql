/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : bookonline

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2021-06-28 23:05:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '书本ID：标识列',
  `book_name` varchar(50) NOT NULL COMMENT '书名',
  `book_name_pinyin` varchar(50) NOT NULL COMMENT '书名拼音',
  `book_category_id` bigint(20) NOT NULL COMMENT '书本类别ID',
  `book_author` varchar(256) NOT NULL COMMENT '作者',
  `book_price` float NOT NULL COMMENT '价格',
  `book_image` varchar(256) DEFAULT NULL COMMENT '图片',
  `publishing` varchar(50) NOT NULL COMMENT '出版社',
  `book_desc` varchar(1024) NOT NULL COMMENT '简介',
  `book_state` int(11) NOT NULL DEFAULT '1' COMMENT '书本状态：1 未上架 2 已上架 3 已下架',
  `deploy_datetime` datetime DEFAULT NULL COMMENT '上架日期时间',
  `sales_volume` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`book_id`) USING BTREE,
  KEY `book_category_id` (`book_category_id`) USING BTREE,
  KEY `book_image` (`book_image`) USING BTREE,
  CONSTRAINT `t_book_ibfk_1` FOREIGN KEY (`book_category_id`) REFERENCES `t_book_category` (`book_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='书本信息表';

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '你努力去爱的样子', 'ANDYZ', '11', '佚名', '32.5', '/static/imgs/1.jpg', '工人出版社', '爱真的很沉重', '2', '2019-06-05 16:42:39', '8');
INSERT INTO `t_book` VALUES ('2', '冷间谍', 'LJD', '11', '亨宁曼凯尔', '28.8', '/static/imgs/2.jpg', '江苏文艺出版社', '烧脑神作', '2', '2020-09-09 16:42:53', '1');
INSERT INTO `t_book` VALUES ('3', 'Java从入门到精通', 'JavaCRMDJT', '6', '佚名', '50.4', '/static/imgs/3.jpg', '前进出版社', '技术经典', '2', '2020-07-29 17:06:32', '6');
INSERT INTO `t_book` VALUES ('4', '麦田里的守望者', 'MTLDSWZ', '1', '杰罗姆-大卫-塞林格', '29.9', '/static/imgs/4.jpg', '译林出版社', '该书以主人公霍尔顿自叙的语气讲述自己被学校开除后在纽约城游荡将近两昼夜的经历和心灵感受。它不仅生动细致地描绘了一个不安现状的中产阶级子弟的苦闷彷徨、孤独愤世的精神世界，一个青春期少年矛盾百出的心理特征，也批判了成人社会的虚伪和做作。霍尔顿是个性洛复杂而又矛盾的青少年的典型。他有一颗纯洁善良、追求美好生活和崇高理想的童心。', '1', '2021-06-28 08:40:09', '0');
INSERT INTO `t_book` VALUES ('5', '乞力马扎罗的雪', 'QLMZLDX', '1', '海明威', '39.9', '/static/imgs/5.jpg', '花山出版社', '《乞力马扎罗的雪》是海明威最直接描写死亡，以生与死为主题的作品。其中哈里作为主人公，在病重将死之际半昏迷半清醒的状态下回顾了自己一生中脑海中还存有的一些记忆，而这些都笼罩在死亡的阴影下，尤其是战争带给哈里的巨大创伤，对死亡他由原先的恐惧，暴躁到愤怒，厌倦最后是坦然的接受了。', '3', '2021-06-28 08:49:39', '13');
INSERT INTO `t_book` VALUES ('6', '人间失格', 'RJSG', '6', '太宰治', '49.9', '/static/imgs/6.jpg', '江苏凤凰出版社', '《人间失格》是日本小说家太宰治创作的一部半自传体小说，于1948年在杂志《展望》上作为全三回的连载小说发表。该小说描述了叶藏是如何一步一步走向丧失为人的资格的道路的，藉由叶藏的独白，窥探作者的内心世界——“充满了可耻的一生”。', '2', '2021-06-28 08:54:01', '6');
INSERT INTO `t_book` VALUES ('7', '无声告白', 'WSGB', '3', '伍绮诗', '19.9', '/static/imgs/7.jpg', '纽约时报', '《无声告白》是由伍绮诗所著的长篇小说，于2015年8月由江苏凤凰文艺出版社出版。该小说谱写了詹姆斯一家的秘密，故事编排精妙细致，文笔沉稳内敛，不仅跃升为《纽约时报》畅销书，还获得包括美国亚马逊网站在内的无数媒体评选出的2014年度最佳图书，', '2', '2021-06-28 08:59:56', '326');
INSERT INTO `t_book` VALUES ('8', '等一朵花开', 'DYDHK', '7', '林蒂浣', '29.9', '/static/imgs/8.jpg', '浙江新华书店出版社', '花开半夏，高中时的一见钟情懵懂却难以忘怀这么多年，t他们连再见一面都是奢望要多大的勇气才能跨越彼此间八年的阻碍祁桑榆说我在等一朵花开江然却说我等到的是一份隽永的相守……\r\n\r\n', '2', '2021-06-28 09:09:45', '0');
INSERT INTO `t_book` VALUES ('9', '下次你路过人间已无我', 'XCNLGRJYWW', '7', '余光中', '39.9', '/static/imgs/9.jpg', '江西人民出版社', '“下次你路过，人间已无我”的意思就是下次你路过我这里，我已经走了，表示不会还在原地等你。曾经的你，也就是那个性格的你，不在了。现在出现在她面前的就是重生的你，另一种性格的你。', '2', '2021-06-28 09:13:11', '123');
INSERT INTO `t_book` VALUES ('10', '微表情心理学', 'WBQXLX', '10', '鸿雁', '39.9', '/static/imgs/10.jpg', '吉林出版社', '教你瞬间看透人心 ', '1', '2021-06-28 09:17:17', '0');
INSERT INTO `t_book` VALUES ('11', '植物百科', 'ZWBK', '6', '魏红霞', '9.9', '/static/imgs/11.jpg', '北京教育出版社', '本书为北京少年儿童出版社出版的一部植物科普读物，作者纪江红。本书以详尽的资料、简洁的文字、生动的图片向读者展示了一个栩栩如生的植物世界，读者不仅可以清晰地看到植物从简单到复杂的进化脚印，而且可以获得对各类植物的崭新认识。作者：纪江红 ISBN:10位[7530118498]13位[9787530118498] 出版社：北京少年儿童 出版...', '2', '2021-06-28 11:45:18', '6');
INSERT INTO `t_book` VALUES ('12', '神奇化学', 'SQHX', '6', '崔钟雷', '29.9', '/static/imgs/12.jpg', '黑龙江美术出版社', '\r\n\r\n介绍了生命科学、化学领域中各方面的基础知识，通过趣味性、知识性、实用性良好结合的具体实例，让孩子换上科学的角度去认识感知', '1', '2021-06-28 11:47:49', '4');
INSERT INTO `t_book` VALUES ('13', '毛毛', 'MM', '3', '米切尔恩德', '29.9', '/static/imgs/13.jpg', '二十一世纪出版社', '毛毛，电影《摆渡人》中的角色，由张榕容饰演。 毛毛和管春本是两小无猜，青梅竹马的一对，但是毛毛因为一次意外失去了记忆，醒来后看见陌生的男子管春很是意外，此时的管春决定找回她的记忆，一心一意为了她改变所有，也因此毛毛与管春再次走上甜蜜幸福的生活。', '1', '2021-06-28 11:51:15', '7');
INSERT INTO `t_book` VALUES ('14', '杨梅', 'YM', '3', '黄春华', '29.9', '/static/imgs/14.jpg', '中国少年出版社', '杨梅果实酸甜可口，色泽艳丽，富含维生素，营养价值极高，是我国的特产水果之一，深受消费者欢迎。', '1', '2021-06-28 11:53:18', '32');
INSERT INTO `t_book` VALUES ('15', '不平静的坟墓', 'BPJDFM', '2', '徐建忠', '9.9', '/static/imgs/15.jpg', '外语出版社', '帮助孩子提高英语阅读能力', '1', '2021-06-28 11:55:36', '89');
INSERT INTO `t_book` VALUES ('16', '不做你的损友', 'BZNDSY', '4', '伍美珍', '29.9', '/static/imgs/16.jpg', '明天出版社', '成长智慧书系列', '1', '2021-06-28 12:00:41', '0');
INSERT INTO `t_book` VALUES ('17', '生活需要仪式感', 'SHXYYSG', '5', '连山', '9.9', '/static/imgs/17.jpg', '吉林文史出版社', '将就的是日子，讲究的才是生活', '1', '2021-06-28 12:05:07', '15');
INSERT INTO `t_book` VALUES ('18', '愿所有相遇都恰逢其时', 'YSYXYDQFQS', '12', 'DTT', '9.9', '/static/imgs/18.jpg', '湖南出版社', '结束的已经结束，相逢的终会遇见', '1', '2021-06-28 12:07:26', '56');
INSERT INTO `t_book` VALUES ('19', '你若盛开，蝴蝶自来', 'NRSK，HDZL', '5', '文娟', '29.9', '/static/imgs/19.jpg', '吉林文史出版社', '人生在世，不就是为了一场盛开吗', '1', '2021-06-28 12:08:50', '0');
INSERT INTO `t_book` VALUES ('20', 'JAVA入门基础', 'JAVARMJC', '2', '传智播客', '99.9', '/static/imgs/20.jpg', '清华大学出版社', '学IT学JAVA', '1', '2021-06-28 12:11:36', '64');

-- ----------------------------
-- Table structure for t_book_category
-- ----------------------------
DROP TABLE IF EXISTS `t_book_category`;
CREATE TABLE `t_book_category` (
  `book_category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '书本类别ID：标识列',
  `book_category_name` varchar(50) NOT NULL COMMENT '书本类别名称',
  PRIMARY KEY (`book_category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='书本类别表';

-- ----------------------------
-- Records of t_book_category
-- ----------------------------
INSERT INTO `t_book_category` VALUES ('1', '文学');
INSERT INTO `t_book_category` VALUES ('2', '教材教辅');
INSERT INTO `t_book_category` VALUES ('3', '童书');
INSERT INTO `t_book_category` VALUES ('4', '经管励志');
INSERT INTO `t_book_category` VALUES ('5', '艺术');
INSERT INTO `t_book_category` VALUES ('6', '科学技术');
INSERT INTO `t_book_category` VALUES ('7', '生活');
INSERT INTO `t_book_category` VALUES ('8', '期刊');
INSERT INTO `t_book_category` VALUES ('9', '文娱');
INSERT INTO `t_book_category` VALUES ('10', '教育培训');
INSERT INTO `t_book_category` VALUES ('11', '小说');
INSERT INTO `t_book_category` VALUES ('12', '电子书');
INSERT INTO `t_book_category` VALUES ('13', '邮币');
INSERT INTO `t_book_category` VALUES ('14', '人文社科');

-- ----------------------------
-- Table structure for t_doc
-- ----------------------------
DROP TABLE IF EXISTS `t_doc`;
CREATE TABLE `t_doc` (
  `id` bigint(20) NOT NULL COMMENT '文件ID',
  `file_name` varchar(50) NOT NULL COMMENT '文件名',
  `mime` varchar(50) NOT NULL COMMENT '文件的mime类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文件表';

-- ----------------------------
-- Records of t_doc
-- ----------------------------

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `file_id` bigint(20) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `content_type` varchar(50) NOT NULL,
  `update_datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_file
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `order_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单日期时间：默认为系统当前时间',
  `consignee` varchar(50) NOT NULL COMMENT '收货人',
  `phone` varchar(50) NOT NULL COMMENT '收货人电话',
  `postalcode` varchar(50) NOT NULL COMMENT '收货人邮编',
  `address` varchar(50) NOT NULL COMMENT '收货人地址',
  `send_type` int(11) NOT NULL COMMENT '发货方式：1 平邮 2 快递',
  `send_datetime` datetime DEFAULT NULL COMMENT '发货日期时间',
  `order_price` float NOT NULL COMMENT '订单总价',
  `order_state` int(11) NOT NULL DEFAULT '1' COMMENT '订单状态：1 未发货 2 已发货 3 已签收 4 已撤单 默认值1',
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项ID：标识列',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID：外键',
  `book_id` bigint(20) NOT NULL COMMENT '书籍ID：外键',
  `quantity` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`order_item_id`) USING BTREE,
  KEY `order_id` (`order_id`) USING BTREE,
  KEY `book_id` (`book_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单项表';

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID：标识列',
  `user_name` varchar(10) NOT NULL COMMENT '用户名：唯一键，登陆时使用',
  `password` varchar(32) NOT NULL COMMENT '用户密码：长度6~10位，MD5加密',
  `type` int(11) NOT NULL COMMENT '用户类型：1 管理员 2 普通用户',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'test1', 'E10ADC3949BA59ABBE56E057F20F883E', '2');
INSERT INTO `t_user` VALUES ('2', 'test2', 'E10ADC3949BA59ABBE56E057F20F883E', '2');
INSERT INTO `t_user` VALUES ('3', 'admin', '21232F297A57A5A743894A0E4A801FC3', '1');
DROP TRIGGER IF EXISTS `tri_doc_before_insert_id`;
DELIMITER ;;
CREATE TRIGGER `tri_doc_before_insert_id` BEFORE INSERT ON `t_doc` FOR EACH ROW set new.id = unix_timestamp( current_timestamp ( 3 ) ) * 1000
;
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_order_before_insert_order_id`;
DELIMITER ;;
CREATE TRIGGER `tri_order_before_insert_order_id` BEFORE INSERT ON `t_order` FOR EACH ROW set new.order_id = unix_timestamp( current_timestamp ( 3 ) ) * 1000
;
;;
DELIMITER ;
