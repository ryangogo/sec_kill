package com.seckill.Common;

import com.seckill.pojo.Seckill;

/**
 * Created by Administrator on 2018/5/6.
 */
public class SeckillCommon {

    /**
     * 秒杀状态
     */
    public enum SeckillState{
        SUCCESS(1,"成功"),
        END(0,"秒杀结束"),
        REPEAT_KILL(-1,"重复秒杀"),
        INNER_ERROE(-2,"系统异常"),
        DATA_REWRITE(-3,"数据篡改");

        private int state;
        private String stateInfo;

        SeckillState(int state,String stateInfo) {
            this.state = state;
            this.stateInfo = stateInfo;
        }

        public String getStateInfo() {
            return stateInfo;
        }
        public int getState() {
            return state;
        }

        public static SeckillState stateOf(int index){
            for(SeckillState state : values()){
                if(state.getState() == index){
                    return state;
                }
            }
            return null;
        }
    }



}
