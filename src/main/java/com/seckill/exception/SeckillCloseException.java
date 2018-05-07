package com.seckill.exception;

/**
 * Created by Administrator on 2018/5/6.
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message){
        super(message);
    }

    public SeckillCloseException(String message,Throwable cause){
        super(message,cause);
    }

}
