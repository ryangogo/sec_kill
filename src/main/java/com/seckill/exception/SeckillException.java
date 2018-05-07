package com.seckill.exception;

/**
 * Created by Administrator on 2018/5/6.
 */
public class SeckillException extends Exception{

    public SeckillException(String message){
        super(message);
    }

    public SeckillException(String message,Throwable cause){
        super(message,cause);
    }
}
