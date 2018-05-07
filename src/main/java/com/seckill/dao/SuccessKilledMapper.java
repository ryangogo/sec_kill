package com.seckill.dao;

import com.seckill.pojo.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledMapper {

    /**
     * 插入购买明细，使用联合主键，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 表示更新的行数（更新了多少条数据）
     */
    int insert(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);

    /**
     * 根据id查询成功秒杀的信息，并携带秒杀产品对象信息
     * @param seckillId
     * @return
     */
    SuccessKilled selectByIdWithSeckillId(@Param("seckillId")long seckillId,@Param("userPhone") long userPhone);



}