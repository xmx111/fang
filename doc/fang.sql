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
   name                 varchar(20) comment '����',
   moblie               varchar(20) comment '�ֻ�',
   password             varchar(20) comment '����',
   create_time          datetime comment '����ʱ��',
   modify_time          char(10) comment '�޸�ʱ��',
   primary key (id)
);

alter table t_agent comment '�����˱�';

/*==============================================================*/
/* Table: t_agent_third_account                                 */
/*==============================================================*/
create table t_agent_third_account
(
   id                   bigint(20) not null comment 'id',
   website_id           bigint(20) comment '��վ_id',
   agent_id             bigint(20) comment '������_id',
   account_no           varchar(20) comment '�˺�',
   password             varchar(20) comment '����',
   create_time          datetime comment '����ʱ��',
   modify_time          datetime comment '�޸�ʱ��',
   primary key (id)
);

alter table t_agent_third_account comment '�������˺�';

/*==============================================================*/
/* Table: t_collect_website                                     */
/*==============================================================*/
create table t_collect_website
(
   id                   bigint(20) not null comment 'id',
   name                 bigint(20) comment '��վ����',
   url                  varchar(40) comment '��վ��ַ',
   icon                 varchar(40) comment '��վͼ��',
   create_time          datetime comment '����ʱ��',
   modify_time          datetime comment '�޸�ʱ��',
   primary key (id)
);

alter table t_collect_website comment '�ɼ�Դ��վ';

/*==============================================================*/
/* Table: t_grading                                             */
/*==============================================================*/
create table t_grading
(
   id                   bigint(20) not null comment 'id',
   code                 varchar(20) comment '¥�̴���',
   name                 varchar(30) comment '¥������',
   another_name         varchar(30) comment '¥�̱���',
   status               int comment '״̬',
   province             int comment 'ʡ',
   city                 int comment '��',
   district             int comment '��',
   cbd                  int comment '��Ȧ',
   estate_type          int comment '��ҵ����',
   estate_addr          varchar(60) comment '��ҵ��ַ',
   position_describe1   varchar(60) comment '��λ����1',
   position_describe2   varchar(60) comment '��λ����2',
   room_drawing         bigint(20) comment '����ͼ',
   map_drawing          bigint(20) comment 'λ��ͼ',
   create_time          datetime comment '����ʱ��',
   modify_time          datetime comment '�޸�ʱ��',
   primary key (id)
);

alter table t_grading comment '¥�̱�';

/*==============================================================*/
/* Table: t_grading_info                                        */
/*==============================================================*/
create table t_grading_info
(
   id                   bigint(20) not null comment '¥��_id',
   grading_id           bigint(20) comment '¥��_id',
   traffic_describe     varchar(1000) comment '��ͨ״��',
   university           varchar(400) comment '��ѧ',
   school               varchar(400) comment '��Сѧ',
   kindergarten         varchar(400) comment '�׶�԰',
   mall                 varchar(400) comment '�̳�',
   post_office          varchar(400) comment '�ʾ�',
   bank                 varchar(400) comment '����',
   hospital             varchar(400) comment 'ҽԺ',
   other                varchar(400) comment '����',
   tel                  varchar(400) comment '��ϵ�绰',
   create_time          datetime comment '����ʱ��',
   modify_time          datetime comment '�޸�ʱ��',
   primary key (id)
);

alter table t_grading_info comment '¥����Ϣ��';

/*==============================================================*/
/* Table: t_house                                               */
/*==============================================================*/
create table t_house
(
   id                   bigint(20) not null comment 'id',
   code                 varchar(10) not null comment '�ڲ�����',
   agent_id             bigint(20) comment '������_id',
   collect_fang_uuid    varchar(64) comment '�ɼ���Դ_uuid',
   use_type             tinyint(1) comment '��;',
   sales_type           tinyint(1) comment '��������',
   status               tinyint(1) comment '״̬',
   grading_name         varchar(30) comment '¥������',
   province             int comment 'ʡ',
   city                 int comment '��',
   district             varchar(20) comment '����',
   cbd                  varchar(20) comment '��Ȧ',
   address              varchar(80) comment '��ַ',
   building_no          varchar(20) comment '¥��',
   unit_no              varchar(20) comment '��Ԫ',
   house_no             varchar(20) comment '����',
   floor                int comment '¥��',
   total_floor          int comment '��¥��',
   sales_base_price     decimal(12,2) comment '���۵׼�',
   room                 int comment '��',
   hall                 int comment '��',
   kitchen              int comment '��',
   toilet               int comment '��',
   sales_price          decimal(12,2) comment '���ۼ�',
   sales_unit_price     decimal(12,2) comment '����ÿƽ�׼�',
   balcony              int comment '��̨',
   position             varchar(20) comment 'λ��',
   depth                double comment '����',
   floor_height         double comment '���',
   gate_width           double comment '�ſ�',
   floor_num            tinyint(1) comment '����',
   level                tinyint(1) comment '����',
   office_rate          double comment 'ʵ��',
   parking_length       double comment '����',
   parking_width        double comment '���',
   pay_month            decimal(12,2) comment '����',
   capacity             varchar(20) comment '����',
   feature              varchar(40) comment '��ɫ',
   publish_price        int comment '�۸�',
   lowest_price         int comment '����׸�',
   property_right_type2 tinyint(1) comment '��Ȩ����',
   building_year        int comment '�������',
   building_area        int comment '�������',
   usable_area          double comment 'ʹ�����',
   housing_type         tinyint(1) comment 'סլ����',
   decoration_type2     tinyint(1) comment 'װ������',
   orientation          tinyint(1) comment '����',
   building_structure   tinyint(1) comment '�����ṹ',
   certificate_five     tinyint(1) comment '��֤����',
   only_housing         tinyint(1) comment 'Ψһס��',
   look_time_type       varchar(20) comment '����ʱ��',
   inner_code           varchar(40) comment '�ڲ����',
   tax_type             tinyint(1) comment '˰������',
   lease_price          decimal(12,2) comment '�����',
   lease_unit_price     decimal(12,2) comment '����ÿƽ�׼�',
   pay_type             tinyint(1) comment '֧����ʽ',
   detain               int comment 'Ѻ',
   pay                  int comment '��',
   delegation_type      tinyint(1) comment 'ί�з�ʽ',
   delegation_time      datetime comment 'ί��ʱ��',
   manager_price        decimal(12,2) comment '�����',
   ready_time           datetime comment '����ʱ��',
   delegation_no        varchar(20) comment 'ί�б��',
   source_type          tinyint(1) comment '��Դ',
   actuality_type       tinyint(1) comment '��״',
   property_right_type  tinyint(1) comment '��Ȩ',
   decoration_type      tinyint(1) comment 'װ��',
   credentials_type     tinyint(1) comment '֤��',
   base_service         varchar(40) comment '����',
   furniture            varchar(40) comment '�Ҿ�',
   electronics          varchar(40) comment '�ҵ�',
   payment_type         tinyint(1) comment '���ʽ',
   commission_type      tinyint(1) comment '��ӵ',
   has_key              tinyint(1) comment 'Կ��',
   key_no               varchar(20) comment 'Կ�ױ��',
   owner                varchar(20) comment 'ҵ��',
   owner_mobile         varchar(20) comment 'ҵ���绰',
   contact              varchar(20) comment '��ϵ��',
   property_credentials varchar(20) comment '����֤',
   nationality          varchar(20) comment '����',
   contact_explain      varchar(100) comment '��ϵ˵��',
   remark               varchar(100) comment '��ע',
   create_time          datetime comment '����ʱ��',
   modify_time          datetime comment '�޸�ʱ��',
   primary key (id, code)
);

alter table t_house comment '��Դ��Ϣ';

/*==============================================================*/
/* Table: t_house_count                                         */
/*==============================================================*/
create table t_house_count
(
   id                   bigint(20) not null comment 'id',
   house_source_id      bigint(20) comment '��Դ_id',
   click_num            int comment '�����',
   collect_num          int comment '�ɼ���',
   inform_num           int comment '�ٱ���',
   primary key (id)
);

alter table t_house_count comment '��Դͳ����Ϣ��';

/*==============================================================*/
/* Table: t_house_release                                       */
/*==============================================================*/
create table t_house_release
(
   id                   bigint(20) not null comment 'id',
   code                 varchar(10) comment '�ڲ�����',
   agent_id             bigint(20) comment '������_id',
   collect_fang_uuid    varchar(64) comment '�ɼ���Դ_uuid',
   use_type             tinyint(1) comment '��;',
   sales_type           tinyint(1) comment '��������',
   status               tinyint(1) comment '״̬',
   grading_name         varchar(30) comment '¥������',
   province             int comment 'ʡ',
   city                 int comment '��',
   district             varchar(20) comment '����',
   cbd                  varchar(20) comment '��Ȧ',
   address              varchar(80) comment '��ַ',
   building_no          varchar(20) comment '¥��',
   unit_no              varchar(20) comment '��Ԫ',
   house_no             varchar(20) comment '����',
   floor                int comment '¥��',
   total_floor          int comment '��¥��',
   sales_base_price     decimal(12,2) comment '���۵׼�',
   room                 int comment '��',
   hall                 int comment '��',
   kitchen              int comment '��',
   toilet               int comment '��',
   sales_price          decimal(12,2) comment '���ۼ�',
   sales_unit_price     decimal(12,2) comment '����ÿƽ�׼�',
   balcony              int comment '��̨',
   position             varchar(20) comment 'λ��',
   depth                double comment '����',
   floor_height         double comment '���',
   gate_width           double comment '�ſ�',
   floor_num            tinyint(1) comment '����',
   level                tinyint(1) comment '����',
   office_rate          double comment 'ʵ��',
   parking_length       double comment '����',
   parking_width        double comment '���',
   pay_month            decimal(12,2) comment '����',
   capacity             varchar(20) comment '����',
   feature              varchar(40) comment '��ɫ',
   publish_price        int comment '�۸�',
   lowest_price         int comment '����׸�',
   property_right_type2 tinyint(1) comment '��Ȩ����',
   building_year        int comment '�������',
   building_area        int comment '�������',
   usable_area          double comment 'ʹ�����',
   housing_type         tinyint(1) comment 'סլ����',
   decoration_type2     tinyint(1) comment 'װ������',
   orientation          tinyint(1) comment '����',
   building_structure   tinyint(1) comment '�����ṹ',
   certificate_five     tinyint(1) comment '��֤����',
   only_housing         tinyint(1) comment 'Ψһס��',
   look_time_type       varchar(20) comment '����ʱ��',
   inner_code           varchar(40) comment '�ڲ����',
   tax_type             tinyint(1) comment '˰������',
   lease_price          decimal(12,2) comment '�����',
   lease_unit_price     decimal(12,2) comment '����ÿƽ�׼�',
   pay_type             tinyint(1) comment '֧����ʽ',
   detain               int comment 'Ѻ',
   pay                  int comment '��',
   delegation_type      tinyint(1) comment 'ί�з�ʽ',
   delegation_time      datetime comment 'ί��ʱ��',
   manager_price        decimal(12,2) comment '�����',
   ready_time           datetime comment '����ʱ��',
   delegation_no        varchar(20) comment 'ί�б��',
   source_type          tinyint(1) comment '��Դ',
   actuality_type       tinyint(1) comment '��״',
   property_right_type  tinyint(1) comment '��Ȩ',
   decoration_type      tinyint(1) comment 'װ��',
   credentials_type     tinyint(1) comment '֤��',
   base_service         varchar(40) comment '����',
   furniture            varchar(40) comment '�Ҿ�',
   electronics          varchar(40) comment '�ҵ�',
   payment_type         tinyint(1) comment '���ʽ',
   commission_type      tinyint(1) comment '��ӵ',
   has_key              tinyint(1) comment 'Կ��',
   key_no               varchar(20) comment 'Կ�ױ��',
   owner                varchar(20) comment 'ҵ��',
   owner_mobile         varchar(20) comment 'ҵ���绰',
   contact              varchar(20) comment '��ϵ��',
   property_credentials varchar(20) comment '����֤',
   nationality          varchar(20) comment '����',
   contact_explain      varchar(100) comment '��ϵ˵��',
   remark               varchar(100) comment '��ע',
   describes            longtext comment '��Դ����',
   tag1                 varchar(20) comment '��ǩ1',
   tag2                 varchar(20) comment '��ǩ2',
   tag3                 varchar(20) comment '��ǩ3',
   create_time          datetime comment '����ʱ��',
   modify_time          datetime comment '�޸�ʱ��',
   primary key (id)
);

alter table t_house_release comment '��Դ������Ϣ';

/*==============================================================*/
/* Table: t_house_source                                        */
/*==============================================================*/
create table t_house_source
(
   id                   bigint(20) not null comment 'id',
   uuid                 varchar(64) not null comment 'uuid',
   source               varchar(20) comment '��Դ',
   url                  varchar(200) comment '��Դurl',
   source_id            varchar(64) comment '�ⲿid',
   title                varchar(60) comment '����',
   grading_name         varchar(60) comment '¥������',
   use_type             varchar(20) comment '��;',
   sales_type           varchar(20) comment '��������',
   status               varchar(20) comment '״̬',
   province             int comment 'ʡ',
   city                 int comment '��',
   district             varchar(20) comment '��',
   cbd                  varchar(20) comment '��Ȧ',
   room                 int comment '��',
   hall                 int comment '��',
   kitchen              int comment '��',
   toilet               int comment '��',
   balcony              int comment '��̨',
   floor                int comment '¥��',
   total_floor          int comment '��¥��',
   publish_price        decimal(12,2) comment '�۸�',
   property_right_type  varchar(20) comment '��Ȩ����',
   building_year        varchar(20) comment '�������',
   building_area        double comment '�������',
   usable_area          double comment 'ʹ�����',
   housing_type         varchar(20) comment 'סլ����',
   decoration_type      varchar(20) comment 'װ������',
   building_structure   varchar(20) comment '�����ṹ',
   orientation          varchar(20) comment '����',
   describes            varchar(1000) comment '��Դ����',
   create_time          datetime comment '����ʱ��',
   modify_time          datetime comment '�޸�ʱ��',
   primary key (id)
);

alter table t_house_source comment 'ԭʼ��Դ';

