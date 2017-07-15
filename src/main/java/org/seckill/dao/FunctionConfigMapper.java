package org.seckill.dao;

import java.util.List;
import org.seckill.entity.FunctionConfig;

public interface FunctionConfigMapper {
    int deleteByPrimaryKey(Long functionId);

    int insert(FunctionConfig record);

    FunctionConfig selectByPrimaryKey(Long functionId);

    List<FunctionConfig> selectAll();

    int updateByPrimaryKey(FunctionConfig record);
}