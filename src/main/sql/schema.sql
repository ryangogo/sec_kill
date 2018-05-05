--数据库初始化脚本
create datebase seckill;
--使用数据库
use seckill;
--创建秒杀库存表
CREATE table seckill(

  `seckill_id` bigint not null AUTO_INCREMENT COMMENT '商品库存id',
  `name` VARCHAR(120) NOT NULL COMMENT '商品名称',
  `number` INT NOT null COMMENT '库存数量',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'

--初始化数据
INSERT INTO seckill(name,number,start_time,end_time)
values
('1000元秒杀苹果8',100,'2018-11-01 00:00:00','2015-11-02 00:00:00'),
('500元秒杀苹果7',200,'2018-11-01 00:00:00','2015-11-02 00:00:00'),
('300元秒杀苹果6',300,'2018-11-01 00:00:00','2015-11-02 00:00:00'),
('200元秒杀苹果5',400,'2018-11-01 00:00:00','2015-11-02 00:00:00');

--秒杀成功明细表
--用户登录认证相关信息
CREATE table success_killed(

  `seckill_id` bigint NOT NULL COMMENT '秒杀商品id',
  `user_phone` bigint not NULL COMMENT '用户手机号',
  `state` tinyint  NOT NULL DEFAULT -1 COMMENT '状态表示：-1：无效 0：成功 1：已付款 2：已发货',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
KEY idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表'

--连接控制台
mysql -uroot -p