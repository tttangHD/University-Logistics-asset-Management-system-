-- 完整的数据库创建脚本，包含所有表、数据和最新的需求更改

-- 设置字符集
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- -----------------------------
-- 资产分配表
-- -----------------------------
DROP TABLE IF EXISTS `cs_allocations`;
CREATE TABLE `cs_allocations` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分配ID',
  `asset_id` int(11) NOT NULL COMMENT '资产ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `allocation_date` date NOT NULL COMMENT '分配日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='资产分配表';

-- 资产分配表示例数据
INSERT INTO `cs_allocations` VALUES (1,1,1,'2023-06-01'),(2,2,2,'2023-04-01'),(3,3,3,'2023-02-01');

-- -----------------------------
-- 资产数据详情表
-- -----------------------------
DROP TABLE IF EXISTS `cs_asset_details`;
CREATE TABLE `cs_asset_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资产详情ID',
  `asset_id` int(11) NOT NULL COMMENT '资产ID',
  `serial_number` varchar(100) DEFAULT NULL COMMENT '序列号',
  `warranty_expiry` date DEFAULT NULL COMMENT '保修到期日',
  `maintenance_records` text COMMENT '维护记录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='资产数据详情表';

-- 资产数据详情表示例数据
INSERT INTO `cs_asset_details` VALUES (1,1,'LNX-12345','2023-05-12','2021年7月清洁屏幕'),(2,2,'HP-67890','2023-03-01','2021年10月更换墨盒'),(3,3,'APL-54321','2023-01-15','2022年1月维修触摸屏');

-- -----------------------------
-- 资产管理表
-- -----------------------------
DROP TABLE IF EXISTS `cs_assets`;
CREATE TABLE `cs_assets` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资产ID',
  `name` varchar(255) NOT NULL COMMENT '资产名称',
  `type` varchar(100) NOT NULL COMMENT '资产类型',
  `purchase_date` date NOT NULL COMMENT '购买日期',
  `value` decimal(10,2) NOT NULL COMMENT '资产价值',
  `status` varchar(255) NOT NULL DEFAULT '0' COMMENT '资产状态（0闲置 1在用 2维修）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='资产管理表';

-- 资产管理表示例数据
INSERT INTO `cs_assets` VALUES (1,'联想笔记本电脑','电子设备','2023-05-12',5000.00,'1'),(2,'惠普打印机','办公设备','2023-03-01',1200.00,'1'),(3,'苹果平板电脑','教学工具','2023-01-15',800.00,'2');

-- -----------------------------
-- 报修请求表（审核用）
-- -----------------------------
DROP TABLE IF EXISTS `cs_repair_requests`;
CREATE TABLE `cs_repair_requests` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报修请求ID',
  `user_id` int(11) NOT NULL COMMENT '提交报修请求的用户ID',
  `equipment_name` varchar(255) NOT NULL COMMENT '设备名称',
  `problem_description` text NOT NULL COMMENT '问题描述',
  `request_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请求日期和时间',
  `status` varchar(255) NOT NULL DEFAULT '2' COMMENT '请求状态（1审核成功 2未审核 3审核失败）',
  `asset_id` int(11) NOT NULL COMMENT '资产ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `asset_id` (`asset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='报修请求表';

-- 报修请求表示例数据
INSERT INTO `cs_repair_requests` VALUES 
(1,1,'笔记本电脑','屏幕破裂','2023-08-20 00:00:00','2',1),
(2,1,'打印机','无法打印','2023-08-20 00:00:00','1',2),
(3,3,'笔记本','坏了','2023-08-20 00:00:00','3',3);

-- -----------------------------
-- 报修请求表（提交用）
-- -----------------------------
DROP TABLE IF EXISTS `cs_repair_requests1`;
CREATE TABLE `cs_repair_requests1` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报修请求ID',
  `user_id` int(11) NOT NULL COMMENT '提交报修请求的用户ID',
  `equipment_name` varchar(255) NOT NULL COMMENT '设备名称',
  `problem_description` text NOT NULL COMMENT '问题描述',
  `request_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请求日期和时间',
  `status` varchar(255) NOT NULL DEFAULT '2' COMMENT '请求状态（1报修 2未报修）',
  `asset_id` int(11) NOT NULL COMMENT '资产ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `asset_id` (`asset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='报修请求表';

-- 报修请求表示例数据
INSERT INTO `cs_repair_requests1` VALUES 
(1,1,'笔记本电脑','屏幕破裂','2023-08-20 15:46:23','1',1),
(2,1,'打印机','无法打印','2023-08-20 15:46:23','2',2),
(3,3,'笔记本','坏了','2023-08-20 15:55:32','2',3);

-- -----------------------------
-- 用户管理表
-- -----------------------------
DROP TABLE IF EXISTS `cs_users`;
CREATE TABLE `cs_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `role` enum('admin','user','manager') NOT NULL DEFAULT 'user' COMMENT '用户角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户管理表';

-- 用户管理表示例数据
INSERT INTO `cs_users` VALUES 
(1,'admin123','password123','admin@example.com','admin'),
(2,'user001','userpass','user1@example.com','user'),
(3,'manager01','managerpass','manager@example.com','manager');

-- -----------------------------
-- 字典类型表
-- -----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- 字典类型表数据
INSERT INTO `sys_dict_type` VALUES 
(11,'报修状态','baoxiu','0','admin',CURRENT_TIMESTAMP,'','','报修状态列表'),
(12,'资产状态','zichan','0','admin',CURRENT_TIMESTAMP,'','','资产状态列表'),
(13,'报修状态1','baoxiu1','0','admin',CURRENT_TIMESTAMP,'','','报修状态1列表');

-- 采购申请状态字典
INSERT INTO `sys_dict_type` VALUES(14, '采购申请状态', 'purchase_status', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '采购申请状态列表');

-- -----------------------------
-- 字典数据表
-- -----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- 字典数据表数据
-- 报修状态字典数据
INSERT INTO `sys_dict_data` VALUES
(30, 1, '审核成功', '1', 'baoxiu', '1', 'success', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '审核成功状态'),
(31, 2, '未审核', '2', 'baoxiu', '2', 'primary', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '未审核状态'),
(32, 3, '审核失败', '3', 'baoxiu', '3', 'danger', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '审核失败状态');

-- 资产状态字典数据
INSERT INTO `sys_dict_data` VALUES
(33, 1, '在用', '1', 'zichan', '1', 'default', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '在用状态'),
(34, 2, '维修', '2', 'zichan', '2', 'danger', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '维修状态'),
(35, 3, '闲置', '0', 'zichan', '0', 'info', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '闲置状态');

-- 报修状态1字典数据
INSERT INTO `sys_dict_data` VALUES
(36, 1, '报修', '1', 'baoxiu1', '1', 'success', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '报修状态'),
(37, 2, '未报修', '2', 'baoxiu1', '2', 'default', 'Y', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '未报修状态');

-- 采购申请状态字典数据
INSERT INTO `sys_dict_data` VALUES
(38, 1, '通过', '1', 'purchase_status', '', 'success', 'N', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '通过状态'),
(39, 2, '拒绝', '2', 'purchase_status', '', 'danger', 'N', '0', 'admin', CURRENT_TIMESTAMP, '', NULL, '拒绝状态');

-- -----------------------------
-- 采购管理菜单
-- -----------------------------
-- 采购管理菜单
INSERT INTO `sys_menu` VALUES('2000', '采购管理', '0', '4', '#', '', 'M', '0', '1', '', 'fa fa-shopping-cart', 'admin', CURRENT_TIMESTAMP, '', NULL, '采购管理菜单');

-- 采购申请菜单
INSERT INTO `sys_menu` VALUES('2001', '采购申请', '2000', '1', '/system/purchase', '', 'C', '0', '1', 'system:purchase:view', 'fa fa-shopping-basket', 'admin', CURRENT_TIMESTAMP, '', NULL, '采购申请菜单');

-- 采购申请按钮
INSERT INTO `sys_menu` VALUES('2002', '采购申请查询', '2001', '1',  '#', '', 'F', '0', '1', 'system:purchase:list',         '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '');
INSERT INTO `sys_menu` VALUES('2003', '采购申请新增', '2001', '2',  '#', '', 'F', '0', '1', 'system:purchase:add',          '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '');
INSERT INTO `sys_menu` VALUES('2004', '采购申请修改', '2001', '3',  '#', '', 'F', '0', '1', 'system:purchase:edit',         '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '');
INSERT INTO `sys_menu` VALUES('2005', '采购申请删除', '2001', '4',  '#', '', 'F', '0', '1', 'system:purchase:remove',       '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '');
INSERT INTO `sys_menu` VALUES('2006', '采购申请导出', '2001', '5',  '#', '', 'F', '0', '1', 'system:purchase:export',       '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '');

-- -----------------------------
-- 资产管理相关菜单
-- -----------------------------
-- 确保存在系统工具菜单
INSERT INTO `sys_menu` VALUES(3, '系统工具', 0, 3, '#', '', 'M', '0', '1', '', 'fa fa-bars', 'admin', CURRENT_TIMESTAMP, '', NULL, '系统工具目录')
ON DUPLICATE KEY UPDATE menu_id = 3;

-- 资产数据详情菜单
INSERT INTO `sys_menu` VALUES(1062, '资产数据详情', 3, 1, '/system/csdetails', '', 'C', '0', '1', 'system:csdetails:view', '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '资产数据详情菜单')
ON DUPLICATE KEY UPDATE menu_id = 1062;

-- 资产分配菜单
INSERT INTO `sys_menu` VALUES(1068, '资产分配', 3, 2, '/system/csallocations', '', 'C', '0', '1', 'system:csallocations:view', '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '资产分配菜单')
ON DUPLICATE KEY UPDATE menu_id = 1068;

-- 资产管理菜单
INSERT INTO `sys_menu` VALUES(1074, '资产管理', 3, 3, '/system/csassets', '', 'C', '0', '1', 'system:csassets:view', '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '资产管理菜单')
ON DUPLICATE KEY UPDATE menu_id = 1074;

-- 报修审核菜单
INSERT INTO `sys_menu` VALUES(1080, '报修审核', 3, 4, '/system/csrequests', 'menuItem', 'C', '0', '1', 'system:csrequests:view', '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '报修审核菜单')
ON DUPLICATE KEY UPDATE menu_id = 1080;

-- 用户管理菜单
INSERT INTO `sys_menu` VALUES(1086, '用户管理', 3, 5, '/system/users', '', 'C', '0', '1', 'system:users:view', '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '用户管理菜单')
ON DUPLICATE KEY UPDATE menu_id = 1086;

-- 报修请求菜单
INSERT INTO `sys_menu` VALUES(1092, '报修请求', 3, 6, '/system/csrequests1', 'menuItem', 'C', '0', '1', 'system:csrequests1:view', '#', 'admin', CURRENT_TIMESTAMP, '', NULL, '报修请求菜单')
ON DUPLICATE KEY UPDATE menu_id = 1092;

-- -----------------------------
-- 采购管理表结构
-- -----------------------------
DROP TABLE IF EXISTS `cs_purchase`;
CREATE TABLE `cs_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购申请ID',
  `user_id` int(11) NOT NULL COMMENT '申请用户ID',
  `equipment_name` varchar(255) NOT NULL COMMENT '设备名称',
  `quantity` int(11) NOT NULL COMMENT '数量',
  `estimated_price` decimal(10,2) DEFAULT NULL COMMENT '预估价格',
  `description` text COMMENT '详细描述',
  `request_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请日期和时间',
  `status` varchar(255) NOT NULL DEFAULT '0' COMMENT '申请状态（0待审核 1通过 2拒绝）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='采购申请表';

-- 采购申请表示例数据
INSERT INTO `cs_purchase` VALUES 
(1, 1, '办公笔记本电脑', 5, 25000.00, 'Intel i7处理器，16GB内存，512GB SSD', CURRENT_TIMESTAMP, '0'),
(2, 2, '激光打印机', 2, 3000.00, '黑白激光打印机，支持双面打印', CURRENT_TIMESTAMP, '1'),
(3, 3, '投影仪', 1, 4500.00, '高清投影仪，亮度4000流明', CURRENT_TIMESTAMP, '2');

SET FOREIGN_KEY_CHECKS = 1; 