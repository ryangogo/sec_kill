package com.seckill.dao;

import com.seckill.pojo.SuccessKilled;
import com.sun.net.httpserver.Authenticator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/5/6.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledMapperTest {

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Test
    public void testInsert() throws Exception {
        int insert = successKilledMapper.insert(1000L, 13528372836L);
        System.out.println(insert);
    }

    @Test
    public void testSelectByIdWithSeckillId() throws Exception {
        SuccessKilled successKilled = successKilledMapper.selectByIdWithSeckillId(1000L);
        System.out.println(successKilled);
        //SuccessKilled{seckillId=1000, userPhone=13528372837, state=-1, createTime=Sun May 06 10:25:20 CST 2018, seckill=Seckill{seckillId=1000, name='1000元秒杀苹果8', number=100, createTime=Sat May 05 12:04:04 CST 2018, startTime=Thu Nov 01 00:00:00 CST 2018, endTime=Mon Nov 02 00:00:00 CST 2015}}


    }
}