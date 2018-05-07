package com.seckill.service.impl;

import com.seckill.dto.Exposer;
import com.seckill.pojo.Seckill;
import com.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/5/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void testGetById() throws Exception {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1000);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void testExecuteSeckillId() throws Exception {
        /*seckillService.executeSeckillId(1000l,1233223232L);*/
        //ToDO
    }
}