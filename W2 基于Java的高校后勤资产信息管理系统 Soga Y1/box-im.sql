# Host: localhost  (Version: 5.5.47)
# 
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "adver"
#

DROP TABLE IF EXISTS `adver`;
CREATE TABLE `adver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '联关用户表',
  `title` varchar(255) DEFAULT NULL COMMENT '题标',
  `content` varchar(500) DEFAULT NULL COMMENT '容内',
  `image` varchar(255) DEFAULT NULL COMMENT '片图',
  `position` int(11) DEFAULT '0' COMMENT '告广位置，广告1:1，广告2:2，广告3:3',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='广告表';

#
# Data for table "adver"
#

INSERT INTO `adver` VALUES (5,10000,'在线答疑系统','在线答疑系统','http://localhost:8080/moonlighting/systemImages/2020010511352183b17.png',1,'2025-03-22 17:41:30'),(6,10000,'在线答疑系统','在线答疑系统','http://localhost:8080/moonlighting/systemImages/202001051135101d248.png',2,'2025-03-22 17:42:03'),(7,10000,'在线答疑系统','在线答疑系统','http://localhost:8080/moonlighting/systemImages/20200105113453a5759.png',3,'2025-03-22 17:42:21');

#
# Structure for table "banner"
#

DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '联关用户表',
  `title` varchar(255) DEFAULT '' COMMENT '题标',
  `image` varchar(255) DEFAULT NULL COMMENT '片图',
  `order_status` int(11) DEFAULT NULL,
  `is_effect` int(11) DEFAULT '1' COMMENT '否是有效，1有效，0无效',
  `create_time` datetime DEFAULT NULL COMMENT '立建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `u_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='轮播表';

#
# Data for table "banner"
#

INSERT INTO `banner` VALUES (1,10000,'11','http://localhost:8080/moonlighting/systemImages/202001051138584ac8d.jpg',1,1,'2025-03-23 10:08:42'),(2,10000,'22','http://localhost:8080/moonlighting/systemImages/202001051139093b0bb.jpg',2,1,'2025-03-23 10:08:59'),(3,10000,'33','http://localhost:8080/moonlighting/systemImages/202001051139203164b.jpg',3,1,'2025-03-23 10:09:15');

#
# Structure for table "chat"
#

DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_fa` int(11) NOT NULL COMMENT '送方发',
  `user_id_jie` int(11) NOT NULL COMMENT '接收方',
  `content` varchar(500) DEFAULT NULL COMMENT '容内',
  `image` varchar(255) DEFAULT NULL COMMENT '片图',
  `create_time` datetime DEFAULT NULL COMMENT '建立时间',
  `is_look` int(1) NOT NULL DEFAULT '0' COMMENT '息消是否已查看，0:未查看，1:已查看',
  `is_remove_fa` int(1) NOT NULL DEFAULT '0' COMMENT '发送方判断是否删除，0:未删除，1:删除',
  `is_remove_jie` int(1) NOT NULL DEFAULT '0' COMMENT '接收方判断是否删除，0:未删除，1:删除',
  `chat_signal` varchar(255) DEFAULT NULL COMMENT '聊天信号',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id_fa` (`user_id_fa`) USING BTREE,
  KEY `user_id_jie` (`user_id_jie`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='聊天表';

#
# Data for table "chat"
#

INSERT INTO `chat` VALUES (1,10003,10000,'请问在吗？？可以问问这问题吗',NULL,'2025-02-24 16:22:21',1,0,0,'20190324162221cd1cd'),(2,10000,10003,'请问在吗？？可以问问这问题吗',NULL,'2025-02-24 16:23:32',1,0,0,'20190324162221cd1cd'),(3,10003,10000,'请问在吗？？可以问问这问题吗',NULL,'2025-02-24 16:30:52',1,0,0,'20190324162221cd1cd'),(4,10000,10002,'请问在吗？？可以问问这问题吗',NULL,'2025-02-24 16:32:04',1,0,0,'2019032416320458132'),(5,10000,10003,'okok',NULL,'2025-02-24 16:35:42',1,0,0,'20190324162221cd1cd'),(6,10000,10003,'请问在吗？？可以问问这问题吗',NULL,'2025-02-24 16:39:50',1,0,0,'20190324162221cd1cd'),(7,10003,10000,'请问在吗？？可以问问这问题吗',NULL,'2025-03-24 16:40:45',1,0,0,'20190324162221cd1cd'),(8,10003,10004,'您好！',NULL,'2025-04-08 15:56:38',1,0,0,'201904081556383db98'),(9,10004,10003,'请问在吗？？可以问问这问题吗',NULL,'2025-04-08 16:56:46',1,0,0,'201904081556383db98'),(10,10003,10004,'请问在吗？？可以问问这问题吗',NULL,'2025-04-08 17:00:28',1,0,0,'201904081556383db98'),(11,10002,10000,'你好',NULL,'2025-04-27 13:43:47',1,0,0,'2019032416320458132'),(12,10002,10000,'请问在吗？？可以问问这问题吗',NULL,'2025-04-29 20:50:35',1,0,0,'2019032416320458132'),(13,10003,10000,'请问在吗？？可以问问这问题吗',NULL,'2025-05-05 21:27:17',1,0,0,'20190324162221cd1cd'),(14,10000,10002,'你好，在的',NULL,'2025-05-11 16:05:41',1,0,0,'2019032416320458132'),(15,10000,10003,'请问在吗？？可以问问这问题吗',NULL,'2025-05-11 16:06:26',1,0,0,'20190324162221cd1cd'),(16,10002,10000,'1\n',NULL,'2025-02-17 11:24:35',0,0,0,'2019032416320458132');

#
# Structure for table "collect"
#

DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '联关用户表',
  `forum_id` int(11) NOT NULL COMMENT '关联帖子表',
  `create_time` datetime DEFAULT NULL COMMENT '立建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `u_id` (`user_id`) USING BTREE,
  KEY `forum _id` (`forum_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='收藏表';

#
# Data for table "collect"
#

INSERT INTO `collect` VALUES (1,10002,2,'2025-02-24 16:13:58'),(3,10002,5,'2025-02-28 20:50:00');

#
# Structure for table "forum"
#

DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `forum_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '联关用户表',
  `title` varchar(255) DEFAULT NULL COMMENT '题标',
  `content` varchar(500) DEFAULT NULL COMMENT '容内',
  `image` varchar(255) DEFAULT NULL COMMENT '片图',
  `is_effect` int(11) DEFAULT '1' COMMENT '否是有效1是0否',
  `create_time` datetime DEFAULT NULL COMMENT '立建时间',
  PRIMARY KEY (`forum_id`) USING BTREE,
  KEY `u_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='帖子表';

#
# Data for table "forum"
#

INSERT INTO `forum` VALUES (1,10003,'Java编程规范个人总结',NULL,'',0,'2025-02-24 16:04:02'),(2,10003,'Java编程规范个人总结','命名规约：1、所有命名不能以美元符和下划线开始和结尾；2、禁止拼音加英文类，UserDao..方法，变量，参数用userDao；3、常量名全部大写，下划线隔开；4抽象类使用Abstract或者Base开头，异常类使用Exception结尾；5、boolean属性命名不能使用is开头，如果使用到了设计模式，建议在类名中体现出具体模式；6、LoginProxy接口类中方法不加权限修饰符，接口和实现类 实现类以Impl结尾。7、MVC各层命名规约：（1）Service/Dao层：获取单个对象 get 前缀，获取多个对象 list 前缀，获取统计值的方法 count 前缀，插入 save 前缀，删除 remove，修改 update；（2）领域模型：数据对象 DO 是数据表名，数据传输对象 DTO 是业务领域相关的名称，展示对象 VO 是网页名称 使用了模板框架，POJO是 DO DTO BO VO 统称。','',1,'2025-02-24 16:11:20'),(3,10002,'给大家推荐本书','下面这本java ee企业级应用开发教程，出于黑马程序员，此书的内容编写的十分紧凑、简洁而不简单，里边的案例讲解的知识点很清晰，很人性化非常适合学习，推荐给正在学java ee的小伙伴。','http://localhost:8080/moonlighting/forumImages/202001051131507775b.jpg',1,'2025-02-24 16:13:37'),(4,10003,'农作物','看看农作物可以怎么发育','https://img2.baidu.com/it/u=2617166693,804983494&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=333',1,'2025-02-24 16:16:02'),(5,10003,'关于Web前端开发','前端开发是创建Web页面或app等前端界面呈现给用户的过程。前端开发通过HTML，CSS及JavaScript以及衍生出来的各种技术、框架、解决方案，来实现互联网产品的用户界面交互 。它从网页制作演变而来，名称上有很明显的时代特征。在互联网的演化进程中，网页制作是Web1.0时代的产物，早期网站主要内容都是静态，以图片和文字为主，用户使用网站的行为也以浏览为主。随着互联网技术的发展和HTML5、CSS3的应用，现代网页更加美观，交互效果显著，功能更加强大。关于想学习web前端开发的小伙伴，个人给出一点学习建议：第一阶段学习html5+css3+ps,会熟练的应用ps可以让你的网页加分不少。第二阶段：js+jq+bootstrap, 学完第二阶段已经可以做些比较炫酷网页了，第三阶段：vue+react+ Angular等框架，对于要走web前端开发的小伙伴，第三阶段的知识必不可少哦。','',1,'2025-02-24 16:19:47'),(6,10000,'心情贴','今天是周日，来学校的第三周结束了，这些天总感觉心情有点复杂！','',1,'2025-02-24 22:37:44'),(7,10002,'酒店专业的难','酒店专业的难','https://img1.baidu.com/it/u=2460030085,1334732683&fm=253&fmt=auto&app=138&f=JPEG?w=882&h=500',1,'2025-02-25 16:59:50'),(8,10002,'关于Web前端开发','','https://img1.baidu.com/it/u=1903815925,1018706504&fm=253&fmt=auto&app=138&f=JPEG?w=600&h=359',1,'2025-02-25 17:04:46'),(9,10004,'清明假期','今天是清明放假的最后一天了，好好过，加油！','',1,'2025-02-08 15:12:47'),(10,10004,'一张好看的图片送给大家','','http://localhost:8080/moonlighting/forumImages/20200105113016ffe04.png',1,'2025-02-08 15:13:58'),(11,10003,'毕业将至','距离答辩越来越近了，每当走在校园的每个角落，总感慨这四年过得太快了，我的大学生活所剩无几！','',1,'2025-02-11 16:26:41'),(12,10003,'生活就该这样','生活吧，其实每个人都有自己的难处，但是只要我们不向困难低头，一切都会好起来的！','http://localhost:8080/moonlighting/forumImages/20200105112948a49fa.jpg',1,'2025-02-11 16:37:04'),(13,10002,'星空壁纸','','http://localhost:8080/moonlighting/forumImages/2020010511293525e1d.jpg',1,'2025-02-11 16:53:01'),(14,10000,'111','111','',0,'2025-01-05 10:49:21'),(15,10000,'测试','','http://localhost:8080/moonlighting/forumImages/20200105110102f27be.jpg',0,'2025-01-05 11:01:05');

#
# Structure for table "forum_reply"
#

DROP TABLE IF EXISTS `forum_reply`;
CREATE TABLE `forum_reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_id` int(11) NOT NULL COMMENT '联关帖子表',
  `user_id` int(11) NOT NULL COMMENT '联关用户表',
  `reply_content` varchar(500) DEFAULT NULL COMMENT '复回内容',
  `reply_image` varchar(255) DEFAULT NULL COMMENT '复回图片',
  `reply_time` datetime DEFAULT NULL COMMENT '复回时间',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '回复状态0未查看1已查看',
  PRIMARY KEY (`reply_id`) USING BTREE,
  KEY `forum _id` (`forum_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='帖子回复表';

#
# Data for table "forum_reply"
#

INSERT INTO `forum_reply` VALUES (1,3,10003,'这问题不错',NULL,'2025-02-24 16:16:59',1),(2,4,10003,'这问题不错',NULL,'2025-02-24 16:17:46',1),(3,8,10004,'这问题不错',NULL,'2025-02-08 15:22:22',1),(4,3,10003,'这问题不错',NULL,'2025-02-11 16:28:08',0);

#
# Structure for table "im_friend"
#

DROP TABLE IF EXISTS `im_friend`;
CREATE TABLE `im_friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `friend_id` bigint(20) NOT NULL COMMENT '好友id',
  `friend_nick_name` varchar(255) NOT NULL COMMENT '好友昵称',
  `friend_head_image` varchar(255) DEFAULT '' COMMENT '好友头像',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_friend_id` (`friend_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='好友';

#
# Data for table "im_friend"
#

INSERT INTO `im_friend` VALUES (1,2,1,'123','','2025-02-11 17:50:00'),(2,1,2,'123321','','2025-02-11 17:50:00'),(3,3,2,'123321','','2025-02-11 17:53:59'),(4,2,3,'测试','','2025-02-11 17:53:59'),(5,1,3,'测试','','2025-02-11 17:58:44'),(6,3,1,'123','','2025-02-11 17:58:44');

#
# Structure for table "im_group"
#

DROP TABLE IF EXISTS `im_group`;
CREATE TABLE `im_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '群名字',
  `owner_id` bigint(20) NOT NULL COMMENT '群主id',
  `head_image` varchar(255) DEFAULT '' COMMENT '群头像',
  `head_image_thumb` varchar(255) DEFAULT '' COMMENT '群头像缩略图',
  `notice` varchar(1024) DEFAULT '' COMMENT '群公告',
  `remark` varchar(255) DEFAULT '' COMMENT '群备注',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='群';

#
# Data for table "im_group"
#


#
# Structure for table "im_group_member"
#

DROP TABLE IF EXISTS `im_group_member`;
CREATE TABLE `im_group_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group_id` bigint(20) NOT NULL COMMENT '群id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `alias_name` varchar(255) DEFAULT '' COMMENT '组内显示名称',
  `head_image` varchar(255) DEFAULT '' COMMENT '用户头像',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `quit` tinyint(1) DEFAULT '0' COMMENT '是否已退出',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_group_id` (`group_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='群成员';

#
# Data for table "im_group_member"
#


#
# Structure for table "im_group_message"
#

DROP TABLE IF EXISTS `im_group_message`;
CREATE TABLE `im_group_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group_id` bigint(20) NOT NULL COMMENT '群id',
  `send_id` bigint(20) NOT NULL COMMENT '发送用户id',
  `content` text COMMENT '发送内容',
  `type` tinyint(1) NOT NULL COMMENT '消息类型 0:文字 1:图片 2:文件 3:语音 10:系统提示',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 0:正常  2:撤回',
  `send_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  PRIMARY KEY (`id`),
  KEY `idx_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='群消息';

#
# Data for table "im_group_message"
#


#
# Structure for table "im_private_message"
#

DROP TABLE IF EXISTS `im_private_message`;
CREATE TABLE `im_private_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `send_id` bigint(20) NOT NULL COMMENT '发送用户id',
  `recv_id` bigint(20) NOT NULL COMMENT '接收用户id',
  `content` text COMMENT '发送内容',
  `type` tinyint(1) NOT NULL COMMENT '消息类型 0:文字 1:图片 2:文件 3:语音 10:系统提示',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:未读 1:已读 2:撤回',
  `send_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  PRIMARY KEY (`id`),
  KEY `idx_send_recv_id` (`send_id`,`recv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='私聊消息';

#
# Data for table "im_private_message"
#

INSERT INTO `im_private_message` VALUES (1,2,1,'123123123',0,1,'2025-02-11 17:50:06'),(2,3,1,'11',0,1,'2025-02-11 17:59:18'),(3,1,3,'1',0,1,'2025-02-11 17:59:29'),(4,1,3,'1',0,1,'2025-02-11 18:00:29');

#
# Structure for table "im_user"
#

DROP TABLE IF EXISTS `im_user`;
CREATE TABLE `im_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `nick_name` varchar(255) NOT NULL COMMENT '用户昵称',
  `head_image` varchar(255) DEFAULT '' COMMENT '用户头像',
  `head_image_thumb` varchar(255) DEFAULT '' COMMENT '用户头像缩略图',
  `password` varchar(255) NOT NULL COMMENT '密码(明文)',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别 0:男 1::女',
  `signature` varchar(1024) DEFAULT '' COMMENT '个性签名',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_name` (`user_name`),
  KEY `idx_nick_name` (`nick_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户';

#
# Data for table "im_user"
#

INSERT INTO `im_user` VALUES (1,'123123','123','','','$2a$10$qPxkfubAxlKsQsANB./5C.4On5tvFeM8HwzFUPXCxaYr1kAzceI1K',0,'',NULL,'2025-02-11 17:49:10'),(2,'123321','123321','','','$2a$10$Fbhb66U4IdKIqDKpsJdSh.HJyAxQWLEJtEM47Fv9xs.yvQxnW8pV6',0,'',NULL,'2025-02-11 17:49:48'),(3,'admin1','测试','','','$2a$10$a7qcheQJgIyuBvI7FSXA.ObdkG1UrrtiIgcLwr0.DtCdqOodKVFP.',0,'',NULL,'2025-02-11 17:53:09'),(4,'123123123','王伟','','','$2a$10$qb7sUT8pafFaycmRBHxLCumxWuMK82ohWYIQ.8tuLRdDhwE.7UK6q',0,'',NULL,'2025-02-17 12:47:01');

#
# Structure for table "mailbox"
#

DROP TABLE IF EXISTS `mailbox`;
CREATE TABLE `mailbox` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '题主',
  `content` varchar(500) DEFAULT NULL COMMENT '容内',
  `image` varchar(255) DEFAULT NULL COMMENT '图片',
  `create_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `u_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='信箱表';

#
# Data for table "mailbox"
#

INSERT INTO `mailbox` VALUES (1,10000,'关于答疑模块','希望平台可以优化','','2025-01-24 16:25:03'),(2,10000,'体验','还有一些关于体验性的东西，亦可以优化','http://localhost:8080/moonlighting/mailboxImages/202001051136418ce6d.png','2025-01-24 16:26:12'),(3,10003,'提个建议','希望平台对虚假信息严格禁止','http://localhost:8080/moonlighting/mailboxImages/20200105113551c7ee1.png','2025-01-11 16:21:31');

#
# Structure for table "notice"
#

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '户表用',
  `title` varchar(255) DEFAULT NULL COMMENT '题标',
  `content` varchar(500) DEFAULT NULL COMMENT '容内',
  `image` varchar(255) DEFAULT NULL COMMENT '片图',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `u_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='公告表';

#
# Data for table "notice"
#

INSERT INTO `notice` VALUES (1,10000,'平台1.0版本上线了！','平台1.0版本上线了，请大家尽情体验吧！在体验的过程中碰到什么问题，可以通过平台信箱告知平台哦，祝大家生活愉快！','','2025-03-24 16:47:36');

#
# Structure for table "system_upset"
#

DROP TABLE IF EXISTS `system_upset`;
CREATE TABLE `system_upset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '关联用户表',
  `welcom_text` varchar(255) DEFAULT NULL COMMENT '欢迎语',
  `company_addres` varchar(255) DEFAULT NULL COMMENT 'å€åœ°',
  `company` varchar(255) DEFAULT NULL COMMENT '司公',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `company_logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `we_chat` varchar(255) DEFAULT NULL COMMENT '信微',
  `create_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "system_upset"
#

INSERT INTO `system_upset` VALUES (3,10000,'欢迎来到在线答疑系统','在线答疑系统','在线答疑系统','555555555','17807705555','http://localhost:8080/moonlighting/systemImages/2020010511393275ac8.png','luxing13953','2025-01-22 17:26:51');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '称昵',
  `password` varchar(255) DEFAULT '' COMMENT '码密',
  `user_leven` int(11) DEFAULT '0' COMMENT '户用等级',
  `user_category` varchar(255) DEFAULT NULL COMMENT '普通用户类别',
  `sex` int(11) DEFAULT '0' COMMENT '别性0女1男',
  `phone` varchar(255) NOT NULL COMMENT '话电',
  `pirthday` datetime DEFAULT NULL COMMENT '日生',
  `email` varchar(255) DEFAULT NULL COMMENT '箱邮',
  `header_image` varchar(255) DEFAULT NULL COMMENT '像头',
  `question` varchar(255) DEFAULT NULL COMMENT '回找密码问题',
  `answer` varchar(255) DEFAULT NULL COMMENT '回找密码答案',
  `create_time` datetime DEFAULT NULL COMMENT '立建时间',
  `is_effect` int(11) DEFAULT '1' COMMENT '否是有效，1有效，0无效',
  `is_work` int(11) DEFAULT '1' COMMENT '0不可以发布1可以发布',
  `remark` varchar(255) DEFAULT NULL COMMENT '注备',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (10000,'小辉','小辉','e10adc3949ba59abbe56e057f20f883e',1,'管理员',1,'17807705665',NULL,'1395302251@qq.com','http://localhost:8080/moonlighting/headerImages/2020010511220709699.jpg',NULL,NULL,'2025-01-22 17:16:07',1,1,'单位：右江公司，地址：百色右江区，电话：17807705665，qq：1395302251'),(10001,'小黄','小黄','e10adc3949ba59abbe56e057f20f883e',1,'管理员',1,'17807705665',NULL,'1395302251@qq.com','http://localhost:8080/moonlighting/headerImages/202001051121571b236.jpg',NULL,NULL,'2025-01-24 10:32:59',1,1,NULL),(10002,'黄先生','小辉同学','e10adc3949ba59abbe56e057f20f883e',0,'学生',1,'17807705665',NULL,'1395302251@qq.com','http://localhost:8080/moonlighting/headerImages/20200105112141830e0.jpg',NULL,NULL,'2025-01-24 10:46:23',1,1,'可以发布兼职'),(10003,'陈先生','小陈88','e10adc3949ba59abbe56e057f20f883e',0,'学生',1,'17807705665',NULL,'1529117748@qq.com','http://localhost:8080/moonlighting/headerImages/20200105112128eaba6.jpg','我的妈妈叫啥名字？','小秀秀','2025-01-24 10:48:24',1,1,'单位：右江公司，地址：右江区，电话：17807705665，qq：1395302251'),(10004,'小黄','小黄88','e10adc3949ba59abbe56e057f20f883e',0,'学生',1,'17807705665',NULL,'123456@qq.com','http://localhost:8080/moonlighting/headerImages/2020010511204514401.jpg','我是谁呢？','大地','2025-01-08 11:06:34',1,1,NULL);

#
# Structure for table "work"
#

DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `work_category` varchar(255) DEFAULT NULL COMMENT '职兼类别,促销、传单派发、设计、家教、会计、计算机、服务员、其他',
  `phone` varchar(255) DEFAULT NULL COMMENT '话电',
  `content` varchar(500) DEFAULT NULL COMMENT '容内',
  `image` varchar(255) DEFAULT NULL COMMENT '片图',
  `title` varchar(255) DEFAULT NULL COMMENT '题标',
  `is_auditing` int(11) NOT NULL DEFAULT '0' COMMENT '否是审核0否1是',
  `is_effect` int(11) NOT NULL DEFAULT '1' COMMENT '否是有效，1有效，0无效',
  `create_time` datetime DEFAULT NULL COMMENT '立建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `u_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "work"
#

INSERT INTO `work` VALUES (1,10002,'空乘专业','17807705665','为什么要做一名空姐? 因为我性格开朗,善于与人沟通,喜欢帮助别人,并且我也非常的热爱 这 份工作? 希望我用微笑服务于每一位乘客.','','踮起脚尖亲吻',1,1,'2025-01-24 11:03:04'),(2,10000,'酒店管理专业','17807705660','男员工站立时,怎么办? 答:两眼正视前方,头正肩平,下颌微收,挺身收腹;两手自然交 叉于背后;双脚分开,与肩同宽或比肩略宽。','','自娱自乐自我闹っ',1,1,'2025-01-24 11:10:42'),(3,10000,'空乘专业','17807705664','为什么要做一名空姐? 因为我性格开朗,善于与人沟通,喜欢帮助别人,并且我也非常的热爱 这 份工作? 希望我用微笑服务于每一位乘客.','','顏夕の未歌',1,1,'2025-01-24 11:16:46'),(4,10002,'计算机专业','13471714079','什么是数据完整性？数据完整性分为哪几种？实体完整性在表里是由什么来实现的？（数据库方面的问题）','','漓殇う',1,1,'2025-01-25 16:35:39'),(5,10002,'空乘专业','13471714079','为什么要做一名空姐? 因为我性格开朗,善于与人沟通,喜欢帮助别人,并且我也非常的热爱 这 份工作? 希望我用微笑服务于每一位乘客.','','心亡泪凉っ',1,1,'2025-01-29 10:13:00'),(6,10004,'酒店管理专业','17807705665','男员工站立时,怎么办? 答:两眼正视前方,头正肩平,下颌微收,挺身收腹;两手自然交 叉于背后;双脚分开,与肩同宽或比肩略宽。','http://localhost:8080/moonlighting/workImages/20200105112423441ed.jpg','今世我陪你白发苍苍',1,0,'2025-01-08 14:59:16'),(7,10002,'空乘专业','17807705668','为什么要做一名空姐? 因为我性格开朗,善于与人沟通,喜欢帮助别人,并且我也非常的热爱 这 份工作? 希望我用微笑服务于每一位乘客.','','爱你如初',1,0,'2025-02-11 23:14:24'),(8,10003,'计算机专业','17807705665','什么是数据完整性？数据完整性分为哪几种？实体完整性在表里是由什么来实现的？（数据库方面的问题）','http://localhost:8080/moonlighting/workImages/20200105112440ee631.jpg','可乐丶不渴',1,1,'2025-01-11 15:57:32'),(9,10003,'空乘专业','17807705665','消息：食堂传单派发，时间：4月19号上午9点，地点：右江区中山一路，招聘人数10人，工作八小时薪酬80元，可通过线上联系和电话联系，先到先得，谢谢！','','___向日葵╮微笑',1,1,'2025-02-11 15:59:51'),(10,10003,'酒店管理专业','17807705665','男员工站立时,怎么办? 答:两眼正视前方,头正肩平,下颌微收,挺身收腹;两手自然交 叉于背后;双脚分开,与肩同宽或比肩略宽。','','忆亦何为',1,1,'2025-02-11 16:01:49'),(11,10000,'酒店管理专业','17807705665','男员工站立时,怎么办? 答:两眼正视前方,头正肩平,下颌微收,挺身收腹;两手自然交 叉于背后;双脚分开,与肩同宽或比肩略宽。','','我又不是星星发什么光',1,1,'2025-02-11 16:16:22'),(12,10003,'空乘专业','17807705665','为什么要做一名空姐? 因为我性格开朗,善于与人沟通,喜欢帮助别人,并且我也非常的热爱 这 份工作? 希望我用微笑服务于每一位乘客.','','橘柚香',0,0,'2025-02-14 10:34:14'),(13,10003,'计算机专业','17807705665','什么是数据完整性？数据完整性分为哪几种？实体完整性在表里是由什么来实现的？（数据库方面的问题）','','六句迷人诗',0,1,'2025-02-18 14:02:14');
