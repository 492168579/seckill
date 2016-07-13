package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * Created by yezhaoyi on 16/6/13.
 */
public class SeckillExcuption {
        private  long  seckillId ;
        //秒杀执行结果状态
        private  int   state     ;
        //状态表示
        private  String stateInfo ;
        //
        private SuccessKilled successKilled ;


        public SeckillExcuption(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
            this.seckillId = seckillId;
            this.state = statEnum.getState();
            this.stateInfo = statEnum.getStateInfo();
            this.successKilled = successKilled;
        }

        public SeckillExcuption(long seckillId, SeckillStatEnum statEnum) {
            this.seckillId = seckillId;
            this.state = statEnum.getState();
            this.stateInfo = statEnum.getStateInfo();
        }

        public SeckillExcuption(Long seckillId, SeckillStatEnum seckillStatEnum) {
            this.seckillId = seckillId;
            this.state = seckillStatEnum.getState();
            this.stateInfo = seckillStatEnum.getStateInfo();

        }
        public long getSeckillId() {
            return seckillId;
        }

        public void setSeckillId(long seckillId) {
            this.seckillId = seckillId;
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
