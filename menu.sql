-- 采购管理菜单
INSERT INTO sys_menu VALUES('2000', '采购管理', '0', '4', '#', '', 'M', '0', '1', '', 'fa fa-shopping-cart', 'admin', SYSDATE(), '', NULL, '采购管理菜单');

-- 采购申请菜单
INSERT INTO sys_menu VALUES('2001', '采购申请', '2000', '1', '/system/purchase', '', 'C', '0', '1', 'system:purchase:view', 'fa fa-shopping-basket', 'admin', SYSDATE(), '', NULL, '采购申请菜单');

-- 采购申请按钮
INSERT INTO sys_menu VALUES('2002', '采购申请查询', '2001', '1',  '#', '', 'F', '0', '1', 'system:purchase:list',         '#', 'admin', SYSDATE(), '', NULL, '');
INSERT INTO sys_menu VALUES('2003', '采购申请新增', '2001', '2',  '#', '', 'F', '0', '1', 'system:purchase:add',          '#', 'admin', SYSDATE(), '', NULL, '');
INSERT INTO sys_menu VALUES('2004', '采购申请修改', '2001', '3',  '#', '', 'F', '0', '1', 'system:purchase:edit',         '#', 'admin', SYSDATE(), '', NULL, '');
INSERT INTO sys_menu VALUES('2005', '采购申请删除', '2001', '4',  '#', '', 'F', '0', '1', 'system:purchase:remove',       '#', 'admin', SYSDATE(), '', NULL, '');
INSERT INTO sys_menu VALUES('2006', '采购申请导出', '2001', '5',  '#', '', 'F', '0', '1', 'system:purchase:export',       '#', 'admin', SYSDATE(), '', NULL, '');

-- 采购申请状态字典
INSERT INTO sys_dict_type VALUES(11, '采购申请状态', 'purchase_status', '0', 'admin', SYSDATE(), '', NULL, '采购申请状态列表');

-- 采购申请状态字典数据
INSERT INTO sys_dict_data VALUES(30, 1, '通过', '1', 'purchase_status', '', 'success', 'N', '0', 'admin', SYSDATE(), '', NULL, '通过状态');
INSERT INTO sys_dict_data VALUES(31, 2, '拒绝', '2', 'purchase_status', '', 'danger', 'N', '0', 'admin', SYSDATE(), '', NULL, '拒绝状态'); 