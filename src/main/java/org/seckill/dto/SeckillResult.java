package org.seckill.dto;

/**
 * Created by yezhaoyi on 16/6/16.
 * 所有ajax请求的返回类型,封装json结果
 */

public class SeckillResult<T> {
    private  boolean succcess ;
    private  T       data ;
    private String   error ;


    public SeckillResult(boolean succcess, String error) {
        this.succcess = succcess;
        this.error = error;
    }

    public SeckillResult(boolean succcess ,T data) {
        this.data = data;
        this.succcess = succcess;
    }

    @Override
    public String toString() {
        return "SeckillResult{" +
                "succcess=" + succcess +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }

    public boolean isSucccess() {
        return succcess;
    }

    public void setSucccess(boolean succcess) {
        this.succcess = succcess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
