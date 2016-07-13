package org.seckill.enums;

/**
 * 使用枚举表示常量数据字段
 * Created by yezhaoyi on 16/6/14.
 */
public enum  SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_SECKILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_ERROR(-3,"数据篡改异常");

    private  int state ;
    private String stateInfo ;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    SeckillStatEnum(int state, String stateInfo) {

        this.state = state;
        this.stateInfo = stateInfo;
    }
    public static  SeckillStatEnum statOf(int index){
        for(SeckillStatEnum state:values()){
            if(state.getState()==index){
                return  state ;
            }
        }
        return  null ;
    }
}
