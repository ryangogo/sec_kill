package com.seckill.service.impl;

import com.seckill.Common.SeckillCommon;
import com.seckill.dao.SeckillMapper;
import com.seckill.dao.SuccessKilledMapper;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.pojo.Seckill;
import com.seckill.pojo.SuccessKilled;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/6.
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    private static Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    //md5盐
    private final String slat = "asdadedf23wfgkjdlajoih";

    public List<Seckill> getSeckillList() {
        List<Seckill> seckills = seckillMapper.queryAll(0, 4);
        return seckills;
    }

    public Seckill getById(long seckillId) {
        return seckillMapper.selectById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = getById(seckillId);
        if(seckill == null){
            return new Exposer(false,seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();//当前时间
        long longNowTime = nowTime.getTime();
        long longStartTime = startTime.getTime();
        long longEndTime = endTime.getTime();
        if(longNowTime < longStartTime || longNowTime > longEndTime){
            return new Exposer(false,seckillId,longNowTime,longStartTime,longEndTime);
        }
        String md5 = getMd5(seckillId);
        return new Exposer(md5,true,seckillId);
    }

    private String getMd5(long seckillId){
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    public SeckillExecution executeSeckillId(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException {

        if(md5 == null || md5.equals(getMd5(seckillId))){
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑：减库存 + 记录购买行为
        try{
            int updateCount = seckillMapper.reduceNumber(seckillId,new Date());
            if(updateCount <= 0){
                throw new SeckillCloseException("secKilled is close");
            }else{
                //记录购买行为
                int insertCount = successKilledMapper.insert(seckillId,userPhone);
                if(insertCount <= 0){
                    throw new RepeatKillException("seckill repeated");
                }else{
                    SuccessKilled successKilled = successKilledMapper.selectByIdWithSeckillId(seckillId,userPhone);
                    return new SeckillExecution(seckillId,SeckillCommon.SeckillState.SUCCESS,successKilled);
                }
            }
        }catch(RepeatKillException e1){
            throw e1;
        }catch(SeckillCloseException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
}
