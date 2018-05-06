package com.seckill.dao;

import com.seckill.dao.SeckillMapper;
import com.seckill.pojo.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillMapperTest {

    //注入dao实现依赖
    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void testInsertSelective() throws Exception{

    }

    @Test
    public void testSelectById() throws Exception{
        long id = 1000;
        Seckill seckill = seckillMapper.selectById(id);
        System.out.println(seckill);
        //Seckill{seckillId=1000, name='1000元秒杀苹果8', number=100, createTime=Sat May 05 12:04:04 CST 2018, startTime=Thu Nov 01 00:00:00 CST 2018, endTime=Mon Nov 02 00:00:00 CST 2015}

    }

    @Test
    public void  testReduceNumber() throws Exception{
        int resultCount = seckillMapper.reduceNumber(1000L,new Date());
        System.out.println(resultCount);
        //Updates: 0 结果是0因为时间跟秒杀开始和结束的时间对不上
    }

    @Test
    public void testQueryAll() throws Exception{
        List<Seckill> seckills = seckillMapper.queryAll(0,100);
        for (Seckill seckill : seckills){
            System.out.println(seckill);
        }
    //Seckill{seckillId=1000, name='1000元秒杀苹果8', number=100, createTime=Sat May 05 12:04:04 CST 2018, startTime=Thu Nov 01 00:00:00 CST 2018, endTime=Mon Nov 02 00:00:00 CST 2015}
     //   Seckill{seckillId=1001, name='500元秒杀苹果7', number=200, createTime=Sat May 05 12:04:04 CST 2018, startTime=Thu Nov 01 00:00:00 CST 2018, endTime=Mon Nov 02 00:00:00 CST 2015}
       // Seckill{seckillId=1002, name='300元秒杀苹果6', number=300, createTime=Sat May 05 12:04:04 CST 2018, startTime=Thu Nov 01 00:00:00 CST 2018, endTime=Mon Nov 02 00:00:00 CST 2015}
      //  Seckill{seckillId=1003, name='200元秒杀苹果5', number=400, createTime=Sat May 05 12:04:04 CST 2018, startTime=Thu Nov 01 00:00:00 CST 2018, endTime=Mon Nov 02 00:00:00 CST 2015}

    }


}
