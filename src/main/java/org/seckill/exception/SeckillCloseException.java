package org.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by yezhaoyi on 16/6/12.
 */
public class SeckillCloseException  extends RuntimeException{

    public SeckillCloseException() {
    }

    public SeckillCloseException(String message) {
        super(message);
    }
}
