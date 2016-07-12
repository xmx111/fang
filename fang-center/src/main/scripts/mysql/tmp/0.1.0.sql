-- create database dev character set = utf8;
-- create user 'dev'@'%' identified by 'dev';
-- grant all privileges on dev.* to 'dev'@'%';
-- create user 'dev'@'localhost' identified by 'dev';
-- grant all privileges on dev.* to 'dev'@'localhost';
-- flush privileges;

-- 删除库;
drop table if exists 
ump_activity_sku, 
ump_activity_sku_info, 
ump_activity_sku_info_bak, 
ump_config,
ump_coupon,
ump_coupon_download,
ump_coupon_scheme,
ump_coupon_scheme_his,
ump_coupon_status_log,
ump_coupon_use,
ump_marketing_activity,
ump_marketing_activity_his,
ump_marketing_tool,
ump_mjs_gift_info,
ump_mlj_info,
ump_offline_activity_coupon,
ump_offline_coupon,
ump_offline_coupon_use,
ump_offline_shop_activity,
ump_offline_shop_coupon,
ump_order_pmt,
ump_order_status,
ump_seq,
ump_xscx_info  
cascade; 

-- 创建库脚本;
CREATE TABLE `ump_activity_sku` (
  `product_id` bigint(20) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `ver` int(11) DEFAULT NULL COMMENT '版本',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '活动结束时间',
  PRIMARY KEY (`product_id`,`activity_id`),
  KEY `idx_ump_sku_time` (`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品级活动，货品范围';

CREATE TABLE `ump_activity_sku_info` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL COMMENT '活动id',
  `activity_ver` int(11) NOT NULL COMMENT '活动版本',
  `activity_name` varchar(256) NOT NULL COMMENT '活动名',
  `activity_ad` varchar(256) NOT NULL COMMENT '活动广告',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动结束时间',
  `product_id` bigint(20) NOT NULL COMMENT '货品id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌id',
  `cat_id` bigint(20) NOT NULL COMMENT '分类id',
  `tool_id` int(11) NOT NULL COMMENT '营销工具id',
  `tool_name` varchar(32) NOT NULL COMMENT '工具名',
  `tool_code` varchar(32) NOT NULL COMMENT '工具代码',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `tool_priority` smallint(4) NOT NULL COMMENT '工具优先级',
  PRIMARY KEY (`id`),
  KEY `idx_ump_act_sku_info_pid` (`product_id`),
  KEY `idx_ump_act_sku_info_actid` (`activity_id`),
  KEY `idx_ump_act_sku_info_time` (`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单级活动与相关货品的信息表';

CREATE TABLE `ump_activity_sku_info_bak` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL COMMENT '活动id',
  `activity_ver` int(11) NOT NULL COMMENT '活动版本',
  `activity_name` varchar(256) NOT NULL COMMENT '活动名',
  `activity_ad` varchar(256) NOT NULL COMMENT '活动广告',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动结束时间',
  `product_id` bigint(20) NOT NULL COMMENT '货品id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌id',
  `cat_id` bigint(20) NOT NULL COMMENT '分类id',
  `tool_id` int(11) NOT NULL COMMENT '营销工具id',
  `tool_name` varchar(32) NOT NULL COMMENT '工具名',
  `tool_code` varchar(32) NOT NULL COMMENT '工具代码',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `tool_priority` smallint(4) NOT NULL COMMENT '工具优先级',
  PRIMARY KEY (`id`),
  KEY `idx_ump_act_sku_info_pid` (`product_id`),
  KEY `idx_ump_act_sku_info_actid` (`activity_id`),
  KEY `idx_ump_act_sku_info_time` (`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单级活动与相关货品的信息表副表';

CREATE TABLE `ump_config` (
  `id` varchar(128) NOT NULL DEFAULT '',
  `edit` tinyint(4) NOT NULL DEFAULT '1' COMMENT '可否编辑:1编辑，0只读',
  `value` varchar(4096) DEFAULT NULL COMMENT 'json协议数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置表';

CREATE TABLE `ump_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(30) NOT NULL COMMENT '优惠券码',
  `cpns_id` int(11) NOT NULL COMMENT '优惠券方案id',
  `member_id` bigint(20) DEFAULT NULL COMMENT '会员id',
  `order_id` bigint(20) DEFAULT NULL COMMENT '优惠券产生订单号',
  `order_type` tinyint(4) DEFAULT '1' COMMENT '订单类型，1为电商订单，2为线下订单',
  `batch_id` int(11) DEFAULT NULL COMMENT '优惠券产生批次',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '优惠券产生时间',
  `active_time` timestamp NULL DEFAULT NULL COMMENT '优惠券激活时间',
  `effect_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '有效起始时间',
  `effect_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '有效结束时间',
  `status` tinyint(4) NOT NULL COMMENT '优惠券状态：0未激活，1激活，2已使用，3失效(可单独取消某些已发放出去的优惠券)',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `recovery` tinyint(4) DEFAULT '0' COMMENT '是否需要回收标记，如果优惠券被使用了，又需要回收则打上该标记，0是不回收，1是需回收',
  `reminded` tinyint(4) DEFAULT '0' COMMENT '优惠券到期短信提醒标记，1为已提醒，0为未提醒',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_code` (`code`),
  KEY `idx_active_time` (`active_time`),
  KEY `idx_effect_end_time` (`effect_end_time`),
  KEY `idx_effect_start_time` (`effect_start_time`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券表';

CREATE TABLE `ump_coupon_download` (
  `batch_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '下载批次',
  `cpns_id` int(11) NOT NULL COMMENT '优惠券方案id',
  `num` int(11) NOT NULL COMMENT '下载数量',
  `account_id` bigint(20) NOT NULL COMMENT '下载账户id',
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '下载时间',
  `ip` varchar(32) DEFAULT NULL COMMENT 'ip地址',
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ump_coupon_scheme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠券方案id',
  `name` varchar(32) NOT NULL COMMENT '优惠券方案名称',
  `prefix` varchar(50) DEFAULT NULL COMMENT '生成优惠券前缀',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `info` varchar(4096) DEFAULT NULL COMMENT '规则',
  `max_num` int(11) DEFAULT NULL COMMENT '最大发放张数',
  `limit_num` int(11) DEFAULT NULL COMMENT '每人可获取张数',
  `user_grade` varchar(255) DEFAULT NULL COMMENT '可参与活动的会员等级(等级的id串,如1,2,3)',
  `channel` varchar(255) DEFAULT NULL COMMENT '可使用渠道(渠道的id串,如1,2,3)',
  `remind_days` int(11) DEFAULT '0' COMMENT '优惠券到期前多少天短信提醒，单位天',
  `update_account_id` int(11) DEFAULT NULL COMMENT '更新活动者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `source` tinyint(4) NOT NULL DEFAULT '1' COMMENT '优惠券来源：1电商,2门店',
  `create_account_id` int(11) NOT NULL COMMENT '创建活动者',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `del` tinyint(4) DEFAULT '0' COMMENT '1已删除',
  `ver` int(11) NOT NULL DEFAULT '1' COMMENT '版本',
  `dynamic` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1动态配置优惠券时间',
  `effect_start_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '优惠券有效始时间',
  `effect_end_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '优惠券有效结束时间',
  `act_days_limit` int(11) DEFAULT NULL COMMENT '优惠券领取后多少天激活',
  `valid_days_limit` int(11) DEFAULT NULL COMMENT '优惠券激活后多少天有效',
  `con_amount` int(11) NOT NULL COMMENT '优惠券满足使用条件金额',
  `goods_filters` varchar(4096) NOT NULL COMMENT '商品过滤设定',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '优惠券类型，1为现金券，2为折扣券',
  `amount` int(11) DEFAULT NULL COMMENT '现金券优惠券金额',
  `discount` int(11) DEFAULT NULL COMMENT '折扣券折扣，百分比%',
  `max_discount_amount` int(11) DEFAULT NULL COMMENT '折扣券最大折扣金额',
  `add_income` tinyint(4) DEFAULT '0' COMMENT '1代表优惠计入收入，0不计入',
  `phone_limited` tinyint(4) DEFAULT '0' COMMENT '1代表优惠券限制只能手机用户使用，0不限制',
  `obtained` tinyint(4) DEFAULT '0' COMMENT '优惠券领取标记，1能领取，0不能领取',
  `obtain_start_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '优惠券领取开始时间',
  `obtain_end_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '优惠券领取结束时间',
  `first_order_limited` tinyint(4) DEFAULT '0' COMMENT '1代表优惠券只能首单用户使用，0不限制',
  PRIMARY KEY (`id`),
  KEY `idx_shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券方案表';

CREATE TABLE `ump_coupon_scheme_his` (
  `id` int(11) NOT NULL COMMENT '优惠券方案id',
  `ver` int(11) NOT NULL COMMENT '版本',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `content` text NOT NULL COMMENT '原数据',
  `ip` varchar(32) DEFAULT NULL,
  `update_account_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`ver`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券方案历史';

CREATE TABLE `ump_coupon_status_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `coupon_order_type` tinyint(4) NOT NULL COMMENT '订单类型，1为生成优惠券的订单，2为使用优惠券的订单',
  `order_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '订单类型，1为电商订单，2为线下订单',
  `order_status` tinyint(4) NOT NULL COMMENT '订单状态',
  `coupon_code` varchar(30) NOT NULL COMMENT '优惠券码',
  `coupon_status` tinyint(4) NOT NULL COMMENT '优惠券状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券状态改变日志表';

CREATE TABLE `ump_coupon_use` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_code` varchar(30) NOT NULL DEFAULT '' COMMENT '优惠券码',
  `order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '使用优惠券的订单id',
  `order_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '订单类型，1为电商订单，2为线下订单',
  `cpns_id` int(11) DEFAULT NULL COMMENT '优惠券方案id',
  `time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '使用时间',
  `order_amount` double DEFAULT NULL COMMENT '订单金额',
  `member_id` bigint(20) DEFAULT NULL COMMENT '会员id',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券使用表';

CREATE TABLE `ump_marketing_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tool_id` int(11) NOT NULL COMMENT '营销工具id',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `update_account_id` int(11) NOT NULL COMMENT '更新活动者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_account_id` int(11) NOT NULL COMMENT '创建活动者',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `enable` tinyint(4) DEFAULT '0' COMMENT '0禁用，1启用',
  `del` tinyint(4) DEFAULT '0' COMMENT '1已删除',
  `ver` int(11) DEFAULT '1' COMMENT '版本',
  `name` varchar(256) NOT NULL COMMENT '活动名',
  `ad` varchar(256) NOT NULL COMMENT '广告语',
  `info` varchar(4096) DEFAULT NULL COMMENT '描述信息',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动结束时间',
  `goods_filters` text DEFAULT NULL COMMENT '商品过滤设定',
  `params` text DEFAULT NULL COMMENT '活动参数设定',
  `applyed` tinyint(4) DEFAULT '0' COMMENT '活动应用标记，1为已应用，0为没有应用',
  PRIMARY KEY (`id`),
  KEY `idx_ump_mkt_act_shop_tool_t0` (`shop_id`,`tool_id`,`start_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营销活动';

CREATE TABLE `ump_marketing_activity_his` (
  `id` int(11) NOT NULL COMMENT '活动id',
  `ver` int(11) NOT NULL COMMENT '版本',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `content` text NOT NULL COMMENT '原数据',
  `ip` varchar(32) DEFAULT NULL,
  `update_account_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`ver`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营销活动历史';

CREATE TABLE `ump_marketing_tool` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL COMMENT '工具code，必须全局唯一',
  `name` varchar(32) NOT NULL COMMENT '营销工具名',
  `level` tinyint(4) NOT NULL COMMENT '1商品，2订单, 3订单簇',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `clazz` varchar(128) NOT NULL COMMENT '营销工具实现类',
  `create_url` varchar(128) NOT NULL COMMENT '创建地址',
  `edit_url` varchar(128) NOT NULL COMMENT '编辑地址',
  `show_url` varchar(128) NOT NULL COMMENT '查看地址',
  `report_url` varchar(128) NOT NULL COMMENT '报表地址',
  `facade_clazz` varchar(128) NOT NULL DEFAULT 'null' COMMENT '营销工具门面服务实现类的完整类名',
  `priority` smallint(4) NOT NULL COMMENT '优先级',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_ump_marketing_tool_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营销工具';

CREATE TABLE `ump_mjs_gift_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gift_id` bigint(20) NOT NULL COMMENT '赠品id或优惠券方案id',
  `gift_type` tinyint(4) DEFAULT NULL COMMENT '赠品类型：1商品, 2优惠卷 ',
  `act_id` int(11) NOT NULL COMMENT '活动id',
  `gift_step_id` int(11) NOT NULL COMMENT '赠品等级id',
  `num` int(11) NOT NULL COMMENT '赠送数量',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `member_id` int(11) NOT NULL COMMENT '会员id',
  `coupon_code` varchar(30) DEFAULT NULL COMMENT '优惠券码',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_member_id` (`member_id`),
  KEY `idx_act_id` (`act_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赠品信息统计';

CREATE TABLE `ump_mlj_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `act_id` int(11) NOT NULL COMMENT '活动Id',
  `order_id` bigint(20) NOT NULL COMMENT '订单Id',
  `member_id` int(11) NOT NULL COMMENT '会员Id',
  `product_id` bigint(20) NOT NULL COMMENT '商品Id',
  `product_num` int(11) NOT NULL COMMENT '销售数量',
  `product_price` int(11) NOT NULL COMMENT '促销价格，单位为分',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_member_id` (`member_id`),
  KEY `idx_act_id` (`act_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='满立减活动统计表';

CREATE TABLE `ump_offline_activity_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(30) NOT NULL COMMENT '优惠券码',
  `cpns_id` int(11) NOT NULL COMMENT '优惠券方案id',
  `act_id` int(11) NOT NULL COMMENT '送券活动id',
  `ver` int(11) NOT NULL COMMENT '送券活动版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下送券活动记录表';

CREATE TABLE `ump_offline_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(30) NOT NULL COMMENT '优惠券码',
  `cpns_id` int(11) NOT NULL COMMENT '优惠券方案id',
  `member_id` varchar(50) DEFAULT NULL COMMENT '会员id',
  `shop_id` int(11) NOT NULL COMMENT '送券的门店id',
  `pos_id` int(11) NOT NULL COMMENT 'pos机编号',
  `order_id` bigint(20) DEFAULT NULL COMMENT '优惠券产生订单号',
  `order_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `batch_id` int(11) DEFAULT NULL COMMENT '优惠券产生批次',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '优惠券产生时间',
  `active_time` timestamp NULL DEFAULT NULL COMMENT '优惠券激活时间',
  `effect_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '有效起始时间',
  `effect_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '有效结束时间',
  `status` tinyint(4) NOT NULL COMMENT '优惠券状态：0未激活，1激活，2已使用，3失效(可单独取消某些已发放出去的优惠券)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_code` (`code`),
  KEY `idx_member_id` (`member_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下优惠券表';

CREATE TABLE `ump_offline_coupon_use` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_code` varchar(30) NOT NULL DEFAULT '' COMMENT '优惠券码',
  `shop_id` int(11) NOT NULL COMMENT '用券的门店id',
  `pos_id` int(11) NOT NULL COMMENT 'pos机编号',
  `order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '使用优惠券的订单id',
  `status` tinyint(4) DEFAULT '1' COMMENT '订单状态：0未付款取消订单; 1创建订单; 2已支付',
  `order_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `cpns_id` int(11) DEFAULT NULL COMMENT '优惠券方案id',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录更新时间',
  `order_amount` double DEFAULT NULL COMMENT '订单金额',
  `member_id` varchar(50) DEFAULT NULL COMMENT '会员id',
  `promotion` varchar(20480) DEFAULT NULL COMMENT '结算时从ump中获取到的json结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下优惠券使用表';

CREATE TABLE `ump_offline_shop_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `act_id` int(11) NOT NULL COMMENT '活动Id',
  `shop_id` int(11) NOT NULL COMMENT '线下门店Id',
  `pos_unicode` varchar(50) NOT NULL COMMENT '线下对于活动定义的唯一码，类似于act_id',
  PRIMARY KEY (`id`),
  KEY `idx_act_id` (`act_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下门店与（送优惠券）活动的关联表';

CREATE TABLE `ump_offline_shop_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpns_id` int(11) NOT NULL COMMENT '优惠券方案Id',
  `shop_id` int(11) NOT NULL COMMENT '线下门店Id',
  `pos_unicode` varchar(50) NOT NULL DEFAULT '线下优惠券定义的唯一码，类似于cpns_id',
  PRIMARY KEY (`id`),
  KEY `idx_cpns_id` (`cpns_id`),
  KEY `idx_shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下门店与优惠券方案定义的关联表';

CREATE TABLE `ump_order_pmt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单时间',
  `member_id` bigint(20) NOT NULL COMMENT '会员id',
  `shop_id` int(11) NOT NULL COMMENT '店铺id:0平台，1自营',
  `promotion` text DEFAULT NULL COMMENT '结算时从ump中获取到的json结果',
  `group_id` varchar(50) DEFAULT NULL COMMENT '订单组号',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单优惠记录';

CREATE TABLE `ump_order_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单状态更新时间',
  `member_id` bigint(20) NOT NULL COMMENT '会员id',
  `shop_id` int(11) NOT NULL COMMENT '店铺id:0平台，1自营',
  `status` tinyint(4) DEFAULT '1' COMMENT '订单状态：0未付款取消订单; 1创建订单; 2已支付; 3未发货,取消支付; 4已发货，配送失败，全额退款; 5已发货，有退货退款',
  `order_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `group_id` varchar(50) DEFAULT NULL COMMENT '订单组号',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`order_time`),
  KEY `idx_order_pmt_group_id` (`group_id`),
  KEY `idx_status` (`status`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单状态记录';

CREATE TABLE `ump_seq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(64) NOT NULL COMMENT 'id类型定义',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='ump序列生成器';

CREATE TABLE `ump_xscx_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `act_id` int(11) NOT NULL COMMENT '活动Id',
  `order_id` bigint(20) NOT NULL COMMENT '订单Id',
  `member_id` int(11) NOT NULL COMMENT '会员Id',
  `product_id` bigint(20) NOT NULL COMMENT '商品Id',
  `product_num` int(11) NOT NULL COMMENT '销售数量',
  `product_price` int(11) NOT NULL COMMENT '促销价格，单位为分',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_act_id` (`act_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='限时促销活动统计表';



-- 清空数据;
truncate table ump_activity_sku;
truncate table ump_config;
truncate table ump_coupon;
truncate table ump_coupon_download;
truncate table ump_coupon_scheme;
truncate table ump_coupon_scheme_his;
truncate table ump_coupon_status_log;
truncate table ump_coupon_use;
truncate table ump_marketing_activity;
truncate table ump_marketing_activity_his;
truncate table ump_marketing_tool;
truncate table ump_mjs_gift_info;
truncate table ump_mlj_info;
truncate table ump_offline_activity_coupon;
truncate table ump_offline_coupon;
truncate table ump_offline_coupon_use;
truncate table ump_offline_shop_activity;
truncate table ump_offline_shop_coupon;
truncate table ump_order_pmt;
truncate table ump_order_status;
truncate table ump_seq;
truncate table ump_xscx_info;

-- 初始化数据;
INSERT INTO `ump_marketing_tool` (`id`, `code`, `name`, `level`, `update_time`, `create_time`, `clazz`, `create_url`, `edit_url`, `show_url`, `report_url`, `facade_clazz`, `priority`) VALUES (1000, 'ump-order-mjz', '满送赠品', 2, '2014-11-24 20:43:02', '2014-6-9 18:12:31', 'com.hitao.ump.center.biz.mjz.tool.OrderMjzMarketingToolBean', '/activity/mjs/create', '/activity/mjs/update', '/activity/mjs/show', '/activity/mjs/report', 'com.hitao.ump.center.facadeservice.impl.MjzActivityFacadeServiceImpl', 6);
INSERT INTO `ump_marketing_tool` (`id`, `code`, `name`, `level`, `update_time`, `create_time`, `clazz`, `create_url`, `edit_url`, `show_url`, `report_url`, `facade_clazz`, `priority`) VALUES (2000, 'ump-goods-xscx', '限时促销', 1, '2014-11-13 18:04:20', '2014-6-19 17:18:34', 'com.hitao.ump.center.biz.xscx.tool.GoodsXscxMarketingToolBean', '/activity/xscx/create', '/activity/xscx/update', '/activity/xscx/show', '/activity/xscx/report', 'com.hitao.ump.center.facadeservice.impl.XscxActivityFacadeServiceImpl', 2);
INSERT INTO `ump_marketing_tool` (`id`, `code`, `name`, `level`, `update_time`, `create_time`, `clazz`, `create_url`, `edit_url`, `show_url`, `report_url`, `facade_clazz`, `priority`) VALUES (3000, 'ump-order-mlj', '满立减', 2, '2014-11-13 18:04:29', '2014-7-8 11:43:46', 'com.hitao.ump.center.biz.mlj.tool.OrderMljMarketingToolBean', '/activity/mlj/create', '/activity/mlj/update', '/activity/mlj/show', '/activity/mlj/report', 'com.hitao.ump.center.facadeservice.impl.MljActivityFacadeServiceImpl', 4);
INSERT INTO `ump_marketing_tool` (`id`, `code`, `name`, `level`, `update_time`, `create_time`, `clazz`, `create_url`, `edit_url`, `show_url`, `report_url`, `facade_clazz`, `priority`) VALUES (4000, 'ump-order-coupon', '送优惠券', 2, '2014-11-24 20:43:05', '2014-7-23 09:50:55', 'com.hitao.ump.center.biz.coupon.tool.OrderCouponMarketingToolBean', '/activity/coupon/create', '/activity/coupon/update', '/activity/coupon/show', '/activity/coupon/report', 'com.hitao.ump.center.facadeservice.impl.CouponActivityFacadeServiceImpl', 7);
INSERT INTO `ump_marketing_tool` (`id`, `code`, `name`, `level`, `update_time`, `create_time`, `clazz`, `create_url`, `edit_url`, `show_url`, `report_url`, `facade_clazz`, `priority`) VALUES (5000, 'ump-goods-xsqg', '限时抢购', 1, '2014-11-13 18:04:12', '2014-10-30 20:50:00', 'com.hitao.ump.center.biz.xsqg.tool.GoodsXsqgMarketingToolBean', '/activity/xsqg/create', '/activity/xsqg/update', '/activity/xsqg/show', '/activity/xsqg/report', 'com.hitao.ump.center.facadeservice.impl.XsqgActivityFacadeServiceImpl', 1);
INSERT INTO `ump_marketing_tool` (`id`, `code`, `name`, `level`, `update_time`, `create_time`, `clazz`, `create_url`, `edit_url`, `show_url`, `report_url`, `facade_clazz`, `priority`) VALUES (6000, 'ump-order-zk', '折扣', 2, '2014-11-13 18:04:27', '2014-11-7 14:02:15', 'com.hitao.ump.center.biz.zk.tool.OrderZkMarketingToolBean', '/activity/zk/create', '/activity/zk/update', '/activity/zk/show', '/activity/zk/report', 'com.hitao.ump.center.facadeservice.impl.ZkActivityFacadeServiceImpl', 3);
INSERT INTO `ump_marketing_tool` (`id`, `code`, `name`, `level`, `update_time`, `create_time`, `clazz`, `create_url`, `edit_url`, `show_url`, `report_url`, `facade_clazz`, `priority`) VALUES (7000, 'ump-order-vip-zk', 'vip折扣', 2, '2014-11-24 20:43:09', '2014-11-17 11:16:23', 'com.hitao.ump.center.biz.zk.tool.OrderZkMarketingToolBean', '/activty/zk/create', '/activty/zk/update', '/activty/zk/show', '/activty/zk/report', 'com.hitao.ump.center.facadeservice.impl.ZkActivityFacadeServiceImpl', 5);

-- 开发数据;
