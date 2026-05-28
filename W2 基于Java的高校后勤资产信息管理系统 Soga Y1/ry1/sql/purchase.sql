-- 采购申请表
drop table if exists cs_purchase_requests;
create table cs_purchase_requests (
  id                bigint(20)      not null auto_increment    comment '采购申请ID',
  user_id          bigint(20)      not null                  comment '提交采购申请的用户ID',
  item_name        varchar(50)     not null                  comment '物品名称',
  quantity         int             not null                  comment '物品数量',
  estimated_price  decimal(10,2)   not null                  comment '预计单价',
  total_price      decimal(10,2)   not null                  comment '总价',
  purpose_description varchar(500)  not null                  comment '用途说明',
  request_date     datetime                                  comment '申请日期',
  status           char(1)         default '1'               comment '申请状态（1通过 2拒绝）',
  primary key (id)
) engine=innodb auto_increment=100 comment = '采购申请表';

-- 采购申请状态字典
insert into sys_dict_type values(11, '采购申请状态', 'purchase_status', '0', 'admin', sysdate(), '', null, '采购申请状态列表');
insert into sys_dict_data values(30, 1, '通过', '1', 'purchase_status', '', 'success', 'N', '0', 'admin', sysdate(), '', null, '通过状态');
insert into sys_dict_data values(31, 2, '拒绝', '2', 'purchase_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '拒绝状态'); 