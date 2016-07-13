--连接mySql 控制台 mysql -u root -p
--秒杀执行存储过程
DELIMITER $$ ----consoel ; 转化为$$
--定义存储过程
--参数: in 输入参数 ;out 输出参数
--rows_count:返回
CREATE  PROCEDURE  execute_seckill
(in v_seckill_id bigint ,in v_phone bigint ,in v_kill_time timestamp ,out r_result int )
 BEGIN
  DECLARE  insert_count int DEFAULT  0 ;
  START TRANSACTION ;
  insert ignore into success_killed
  (seckill_id,user_phone,create_time)
  values (v_seckill_id,v_phone,v_kill_time);
  select row_count() into insert_count ;
  IF (insert_count = 0)THEN ROLLBACK ;
    set r_result = -1 ;
  ELSEIF(insert_count < 0) THEN  ROLLBACK ;
    SET r_result = -2 ;
  ELSE
     update seckill
     set number  =  number - 1
     where  seckill_id = v_seckill_id
     and end_time > v_kill_time
     and start_time < v_kill_time
     and number > 0 ;
     select row_count() INTO insert_count ;
     IF(insert_count=0) THEN
     ROLLBACK ;
     SET r_result = 0 ;
     ELSEIF(insert_count < 0)THEN
     ROLLBACK ;
     SET r_result = -2 ;
     ELSE
     COMMIT ;
      SET r_result = 1 ;
     END IF ;
  END IF ;
END ;
$$
--查看存储过程
show create procedure seckill.execute_seckill\G ;
---存储过程定义结束
DELIMITER ;
set @r_result = -3 ;
---执行存储过程
call execute_seckill(1000,18851808758,now(),@r_result);
--获取结果
select @r_result ;
--删除存储过程
drop procedure seckill.execute_seckill；
---存储过程
--1.存储过程:事务行级锁持有时间
--2:不要过分依赖存储过程
--3:简单的逻辑可以应用存储过程
--4:







