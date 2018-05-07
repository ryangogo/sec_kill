package com.seckill.dto;

import com.seckill.Common.SeckillCommon;
import com.seckill.pojo.SuccessKilled;

/**
 * 封装秒杀执行后的结果
 */
public class SeckillExecution {

    private long seckillid;

    //秒杀执行结果状态
    private int state;

    //状态的标识
    private String stateInfo;

    //秒杀成功对象
    private SuccessKilled successKilled;

    public SeckillExecution() {

    }

    public SeckillExecution(long seckillid, SeckillCommon.SeckillState seckillState) {
        this.seckillid = seckillid;
        this.state = seckillState.getState();
        this.stateInfo = seckillState.getStateInfo();
    }


    public SeckillExecution(long seckillid, SeckillCommon.SeckillState seckillState, SuccessKilled successKilled) {
        this.seckillid = seckillid;
        this.state = seckillState.getState();
        this.stateInfo = seckillState.getStateInfo();
        this.successKilled = successKilled;
    }

    public long getSeckillid() {
        return seckillid;
    }

    public void setSeckillid(long seckillid) {
        this.seckillid = seckillid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
