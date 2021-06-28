
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '书本ID：标识列',
  `book_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `book_name_pinyin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名拼音',
  `book_category_id` bigint(20) NOT NULL COMMENT '书本类别ID',
  `book_author` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `book_price` float NOT NULL COMMENT '价格',
  `book_image` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `publishing` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社',
  `book_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介',
  `book_state` int(11) NOT NULL DEFAULT 1 COMMENT '书本状态：1 未上架 2 已上架 3 已下架',
  `deploy_datetime` datetime(0) NULL DEFAULT NULL COMMENT '上架日期时间',
  `sales_volume` int(11) NOT NULL DEFAULT 0 COMMENT '销量',
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `book_category_id`(`book_category_id`) USING BTREE,
  INDEX `book_image`(`book_image`) USING BTREE,
  CONSTRAINT `t_book_ibfk_1` FOREIGN KEY (`book_category_id`) REFERENCES `t_book_category` (`book_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '书本信息表' ROW_FORMAT = Dynamic;


INSERT INTO `t_book` VALUES (1, '爱你的样子', 'ANDYZ', 11, '佚名', 32.5, '/commons/imgs/9.png', '工人出版社', '爱真的很沉重', 2, '2019-06-05 16:42:39', 8);
INSERT INTO `t_book` VALUES (2, '冷间谍', 'LJD', 11, '亨宁曼凯尔', 28.8, '/commons/imgs/1.png', '江苏文艺出版社', '烧脑神作', 2, '2020-09-09 16:42:53', 1);
INSERT INTO `t_book` VALUES (3, 'Java从入门到精通', 'JavaCRMDJT', 6, '佚名', 50.4, '/commons/imgs/6.png', '前进出版社', '技术经典', 2, '2020-07-29 17:06:32', 0);

DROP TABLE IF EXISTS `t_book_category`;
CREATE TABLE `t_book_category`  (
  `book_category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '书本类别ID：标识列',
  `book_category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书本类别名称',
  PRIMARY KEY (`book_category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '书本类别表' ROW_FORMAT = Dynamic;


INSERT INTO `t_book_category` VALUES (1, '文学');
INSERT INTO `t_book_category` VALUES (2, '教材教辅');
INSERT INTO `t_book_category` VALUES (3, '童书');
INSERT INTO `t_book_category` VALUES (4, '经管励志');
INSERT INTO `t_book_category` VALUES (5, '艺术');
INSERT INTO `t_book_category` VALUES (6, '科学技术');
INSERT INTO `t_book_category` VALUES (7, '生活');
INSERT INTO `t_book_category` VALUES (8, '期刊');
INSERT INTO `t_book_category` VALUES (9, '文娱');
INSERT INTO `t_book_category` VALUES (10, '教育培训');
INSERT INTO `t_book_category` VALUES (11, '小说');
INSERT INTO `t_book_category` VALUES (12, '电子书');
INSERT INTO `t_book_category` VALUES (13, '邮币');
INSERT INTO `t_book_category` VALUES (14, '人文社科');

DROP TABLE IF EXISTS `t_doc`;
CREATE TABLE `t_doc`  (
  `id` bigint(20) NOT NULL COMMENT '文件ID',
  `file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `mime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件的mime类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file`  (
  `file_id` bigint(20) NOT NULL,
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_datetime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `t_file` VALUES (1602771580850, '1602771580850.jpeg', 'image/jpeg', '2020-10-15 22:19:40');
INSERT INTO `t_file` VALUES (1602771585345, '1602771585345.jpg', 'image/jpeg', '2020-10-15 22:19:45');
INSERT INTO `t_file` VALUES (1602771589029, '1602771589029.jpg', 'image/jpeg', '2020-10-15 22:19:49');

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `order_datetime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单日期时间：默认为系统当前时间',
  `consignee` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人电话',
  `postalcode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人邮编',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人地址',
  `send_type` int(11) NOT NULL COMMENT '发货方式：1 平邮 2 快递',
  `send_datetime` datetime(0) NULL DEFAULT NULL COMMENT '发货日期时间',
  `order_price` float NOT NULL COMMENT '订单总价',
  `order_state` int(11) NOT NULL DEFAULT 1 COMMENT '订单状态：1 未发货 2 已发货 3 已签收 4 已撤单 默认值1',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项ID：标识列',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID：外键',
  `book_id` bigint(20) NOT NULL COMMENT '书籍ID：外键',
  `quantity` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`order_item_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_order_item_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单项表' ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID：标识列',
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名：唯一键，登陆时使用',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码：长度6~10位，MD5加密',
  `type` int(11) NOT NULL COMMENT '用户类型：1 管理员 2 普通用户',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;


INSERT INTO `t_user` VALUES (1, 'test1', 'E10ADC3949BA59ABBE56E057F20F883E', 2);
INSERT INTO `t_user` VALUES (2, 'test2', 'E10ADC3949BA59ABBE56E057F20F883E', 2);
INSERT INTO `t_user` VALUES (3, 'admin', '21232F297A57A5A743894A0E4A801FC3', 1);

DROP TRIGGER IF EXISTS `tri_doc_before_insert_id`;
delimiter ;;
CREATE TRIGGER `tri_doc_before_insert_id` BEFORE INSERT ON `t_doc` FOR EACH ROW set new.id = unix_timestamp( current_timestamp ( 3 ) ) * 1000
;;
delimiter ;


DROP TRIGGER IF EXISTS `tri_order_before_insert_order_id`;
delimiter ;;
CREATE TRIGGER `tri_order_before_insert_order_id` BEFORE INSERT ON `t_order` FOR EACH ROW set new.order_id = unix_timestamp( current_timestamp ( 3 ) ) * 1000
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
