package org.seckill.exception;

/**
 * 秒杀相关异常
 * Created by yezhaoyi on 16/6/13.
 */
public class SeckillException extends  RuntimeException{
    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillException(String message) {
        super(message);
    }
}
