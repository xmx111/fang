/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/7/19 15:51:08                           */
/*==============================================================*/


drop table if exists t_agent;

drop table if exists t_agent_third_account;

drop table if exists t_collect_website;

drop table if exists t_grading;

drop table if exists t_grading_info;

drop table if exists t_house;

drop table if exists t_house_count;

drop table if exists t_house_release;

drop table if exists t_house_source;

/*==============================================================*/
/* Table: t_agent                                               */
/*==============================================================*/
create table t_agent
(
   id                   bigint not null comment 'id',
   name                 varchar(20) comment '姓名',
   moblie               varchar(20) comment '手机',
   password             varchar(20) comment '密码',
   create_time          datetime comment '创建时间',
   modify_time          char(10) comment '修改时间',
   primary key (id)
);

alter table t_agent comment '经纪人表';

/*==============================================================*/
/* Table: t_agent_third_account                                 */
/*==============================================================*/
create table t_agent_third_account
(
   id                   bigint(20) not null comment 'id',
   website_id           bigint(20) comment '网站_id',
   agent_id             bigint(20) comment '经纪人_id',
   account_no           varchar(20) comment '账号',
   password             varchar(20) comment '密码',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_agent_third_account comment '第三方账号';

/*==============================================================*/
/* Table: t_collect_website                                     */
/*==============================================================*/
create table t_collect_website
(
   id                   bigint(20) not null comment 'id',
   name                 bigint(20) comment '网站名称',
   url                  varchar(40) comment '网站地址',
   icon                 varchar(40) comment '网站图标',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_collect_website comment '采集源网站';

/*==============================================================*/
/* Table: t_grading                                             */
/*==============================================================*/
create table t_grading
(
   id                   bigint(20) not null comment 'id',
   code                 varchar(20) comment '楼盘代码',
   name                 varchar(30) comment '楼盘名称',
   another_name         varchar(30) comment '楼盘别名',
   status               int comment '状态',
   province             int comment '省',
   city                 int comment '市',
   district             int comment '区',
   cbd                  int comment '商圈',
   estate_type          int comment '物业类型',
   estate_addr          varchar(60) comment '物业地址',
   position_describe1   varchar(60) comment '方位描述1',
   position_describe2   varchar(60) comment '方位描述2',
   room_drawing         bigint(20) comment '户型图',
   map_drawing          bigint(20) comment '位置图',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_grading comment '楼盘表';

/*==============================================================*/
/* Table: t_grading_info                                        */
/*==============================================================*/
create table t_grading_info
(
   id                   bigint(20) not null comment '楼盘_id',
   grading_id           bigint(20) comment '楼盘_id',
   traffic_describe     varchar(1000) comment '交通状况',
   university           varchar(400) comment '大学',
   school               varchar(400) comment '中小学',
   kindergarten         varchar(400) comment '幼儿园',
   mall                 varchar(400) comment '商场',
   post_office          varchar(400) comment '邮局',
   bank                 varchar(400) comment '银行',
   hospital             varchar(400) comment '医院',
   other                varchar(400) comment '其它',
   tel                  varchar(400) comment '联系电话',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_grading_info comment '楼盘信息表';

/*==============================================================*/
/* Table: t_house                                               */
/*==============================================================*/
create table t_house
(
   id                   bigint(20) not null comment 'id',
   code                 varchar(10) not null comment '内部编码',
   agent_id             bigint(20) comment '经纪人_id',
   collect_fang_uuid    varchar(64) comment '采集房源_uuid',
   use_type             tinyint(1) comment '用途',
   sales_type           tinyint(1) comment '销售类型',
   status               tinyint(1) comment '状态',
   grading_name         varchar(30) comment '楼盘名称',
   province             int comment '省',
   city                 int comment '市',
   district             varchar(20) comment '区县',
   cbd                  varchar(20) comment '商圈',
   address              varchar(80) comment '地址',
   building_no          varchar(20) comment '楼号',
   unit_no              varchar(20) comment '单元',
   house_no             varchar(20) comment '房号',
   floor                int comment '楼层',
   total_floor          int comment '总楼层',
   sales_base_price     decimal(12,2) comment '出售底价',
   room                 int comment '室',
   hall                 int comment '厅',
   kitchen              int comment '厨',
   toilet               int comment '卫',
   sales_price          decimal(12,2) comment '出售价',
   sales_unit_price     decimal(12,2) comment '出售每平米价',
   balcony              int comment '阳台',
   position             varchar(20) comment '位置',
   depth                double comment '进深',
   floor_height         double comment '层高',
   gate_width           double comment '门宽',
   floor_num            tinyint(1) comment '层数',
   level                tinyint(1) comment '级别',
   office_rate          double comment '实率',
   parking_length       double comment '长度',
   parking_width        double comment '宽度',
   pay_month            decimal(12,2) comment '包月',
   capacity             varchar(20) comment '排量',
   feature              varchar(40) comment '特色',
   publish_price        int comment '价格',
   lowest_price         int comment '最低首付',
   property_right_type2 tinyint(1) comment '产权性质',
   building_year        int comment '建筑年代',
   building_area        int comment '建筑面积',
   usable_area          double comment '使用面积',
   housing_type         tinyint(1) comment '住宅类型',
   decoration_type2     tinyint(1) comment '装修类型',
   orientation          tinyint(1) comment '朝向',
   building_structure   tinyint(1) comment '建筑结构',
   certificate_five     tinyint(1) comment '产证满五',
   only_housing         tinyint(1) comment '唯一住房',
   look_time_type       varchar(20) comment '看房时间',
   inner_code           varchar(40) comment '内部编号',
   tax_type             tinyint(1) comment '税费类型',
   lease_price          decimal(12,2) comment '出租价',
   lease_unit_price     decimal(12,2) comment '出租每平米价',
   pay_type             tinyint(1) comment '支付方式',
   detain               int comment '押',
   pay                  int comment '付',
   delegation_type      tinyint(1) comment '委托方式',
   delegation_time      datetime comment '委托时间',
   manager_price        decimal(12,2) comment '管理费',
   ready_time           datetime comment '交房时间',
   delegation_no        varchar(20) comment '委托编号',
   source_type          tinyint(1) comment '来源',
   actuality_type       tinyint(1) comment '现状',
   property_right_type  tinyint(1) comment '产权',
   decoration_type      tinyint(1) comment '装修',
   credentials_type     tinyint(1) comment '证书',
   base_service         varchar(40) comment '配套',
   furniture            varchar(40) comment '家具',
   electronics          varchar(40) comment '家电',
   payment_type         tinyint(1) comment '付款方式',
   commission_type      tinyint(1) comment '付拥',
   has_key              tinyint(1) comment '钥匙',
   key_no               varchar(20) comment '钥匙编号',
   owner                varchar(20) comment '业主',
   owner_mobile         varchar(20) comment '业主电话',
   contact              varchar(20) comment '联系人',
   property_credentials varchar(20) comment '房产证',
   nationality          varchar(20) comment '国籍',
   contact_explain      varchar(100) comment '联系说明',
   remark               varchar(100) comment '备注',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id, code)
);

alter table t_house comment '房源信息';

/*==============================================================*/
/* Table: t_house_count                                         */
/*==============================================================*/
create table t_house_count
(
   id                   bigint(20) not null comment 'id',
   house_source_id      bigint(20) comment '房源_id',
   click_num            int comment '点击数',
   collect_num          int comment '采集数',
   inform_num           int comment '举报数',
   primary key (id)
);

alter table t_house_count comment '房源统计信息表';

/*==============================================================*/
/* Table: t_house_release                                       */
/*==============================================================*/
create table t_house_release
(
   id                   bigint(20) not null comment 'id',
   code                 varchar(10) comment '内部编码',
   agent_id             bigint(20) comment '经纪人_id',
   collect_fang_uuid    varchar(64) comment '采集房源_uuid',
   use_type             tinyint(1) comment '用途',
   sales_type           tinyint(1) comment '销售类型',
   status               tinyint(1) comment '状态',
   grading_name         varchar(30) comment '楼盘名称',
   province             int comment '省',
   city                 int comment '市',
   district             varchar(20) comment '区县',
   cbd                  varchar(20) comment '商圈',
   address              varchar(80) comment '地址',
   building_no          varchar(20) comment '楼号',
   unit_no              varchar(20) comment '单元',
   house_no             varchar(20) comment '房号',
   floor                int comment '楼层',
   total_floor          int comment '总楼层',
   sales_base_price     decimal(12,2) comment '出售底价',
   room                 int comment '室',
   hall                 int comment '厅',
   kitchen              int comment '厨',
   toilet               int comment '卫',
   sales_price          decimal(12,2) comment '出售价',
   sales_unit_price     decimal(12,2) comment '出售每平米价',
   balcony              int comment '阳台',
   position             varchar(20) comment '位置',
   depth                double comment '进深',
   floor_height         double comment '层高',
   gate_width           double comment '门宽',
   floor_num            tinyint(1) comment '层数',
   level                tinyint(1) comment '级别',
   office_rate          double comment '实率',
   parking_length       double comment '长度',
   parking_width        double comment '宽度',
   pay_month            decimal(12,2) comment '包月',
   capacity             varchar(20) comment '排量',
   feature              varchar(40) comment '特色',
   publish_price        int comment '价格',
   lowest_price         int comment '最低首付',
   property_right_type2 tinyint(1) comment '产权性质',
   building_year        int comment '建筑年代',
   building_area        int comment '建筑面积',
   usable_area          double comment '使用面积',
   housing_type         tinyint(1) comment '住宅类型',
   decoration_type2     tinyint(1) comment '装修类型',
   orientation          tinyint(1) comment '朝向',
   building_structure   tinyint(1) comment '建筑结构',
   certificate_five     tinyint(1) comment '产证满五',
   only_housing         tinyint(1) comment '唯一住房',
   look_time_type       varchar(20) comment '看房时间',
   inner_code           varchar(40) comment '内部编号',
   tax_type             tinyint(1) comment '税费类型',
   lease_price          decimal(12,2) comment '出租价',
   lease_unit_price     decimal(12,2) comment '出租每平米价',
   pay_type             tinyint(1) comment '支付方式',
   detain               int comment '押',
   pay                  int comment '付',
   delegation_type      tinyint(1) comment '委托方式',
   delegation_time      datetime comment '委托时间',
   manager_price        decimal(12,2) comment '管理费',
   ready_time           datetime comment '交房时间',
   delegation_no        varchar(20) comment '委托编号',
   source_type          tinyint(1) comment '来源',
   actuality_type       tinyint(1) comment '现状',
   property_right_type  tinyint(1) comment '产权',
   decoration_type      tinyint(1) comment '装修',
   credentials_type     tinyint(1) comment '证书',
   base_service         varchar(40) comment '配套',
   furniture            varchar(40) comment '家具',
   electronics          varchar(40) comment '家电',
   payment_type         tinyint(1) comment '付款方式',
   commission_type      tinyint(1) comment '付拥',
   has_key              tinyint(1) comment '钥匙',
   key_no               varchar(20) comment '钥匙编号',
   owner                varchar(20) comment '业主',
   owner_mobile         varchar(20) comment '业主电话',
   contact              varchar(20) comment '联系人',
   property_credentials varchar(20) comment '房产证',
   nationality          varchar(20) comment '国籍',
   contact_explain      varchar(100) comment '联系说明',
   remark               varchar(100) comment '备注',
   describes            longtext comment '房源描述',
   tag1                 varchar(20) comment '标签1',
   tag2                 varchar(20) comment '标签2',
   tag3                 varchar(20) comment '标签3',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_house_release comment '房源发布信息';

/*==============================================================*/
/* Table: t_house_source                                        */
/*==============================================================*/
create table t_house_source
(
   id                   bigint(20) not null comment 'id',
   uuid                 varchar(64) not null comment 'uuid',
   source               varchar(20) comment '来源',
   url                  varchar(200) comment '来源url',
   source_id            varchar(64) comment '外部id',
   title                varchar(60) comment '标题',
   grading_name         varchar(60) comment '楼盘名称',
   use_type             varchar(20) comment '用途',
   sales_type           varchar(20) comment '销售类型',
   status               varchar(20) comment '状态',
   province             int comment '省',
   city                 int comment '市',
   district             varchar(20) comment '区',
   cbd                  varchar(20) comment '商圈',
   room                 int comment '室',
   hall                 int comment '厅',
   kitchen              int comment '厨',
   toilet               int comment '卫',
   balcony              int comment '阳台',
   floor                int comment '楼层',
   total_floor          int comment '总楼层',
   publish_price        decimal(12,2) comment '价格',
   property_right_type  varchar(20) comment '产权性质',
   building_year        varchar(20) comment '建筑年代',
   building_area        double comment '建筑面积',
   usable_area          double comment '使用面积',
   housing_type         varchar(20) comment '住宅类型',
   decoration_type      varchar(20) comment '装修类型',
   building_structure   varchar(20) comment '建筑结构',
   orientation          varchar(20) comment '朝向',
   describes            varchar(1000) comment '房源描述',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table t_house_source comment '原始房源';

