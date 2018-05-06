package com.seckill.dao;

import com.seckill.pojo.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SeckillMapper {


    int insertSelective(Seckill record);

    /**
     * 根据id查询
     * @param seckillId
     * @return
     */
    Seckill selectById(long seckillId);

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 表示更新行数
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offet") int offet,@Param("limit") int limit);

}