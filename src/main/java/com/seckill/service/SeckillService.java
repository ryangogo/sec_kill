package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.pojo.Seckill;

import java.util.List;

/**
 * Created by Administrator on 2018/5/6.
 */
public interface SeckillService {

    /**
     * 查询秒杀商品列表
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);


    /**
     * 输出秒杀接口的地址，
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl (long seckillId);

    /**
     * 执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillId(long seckillId, long userPhone, String md5)
        throws SeckillException,SeckillCloseException,RepeatKillException;


}
