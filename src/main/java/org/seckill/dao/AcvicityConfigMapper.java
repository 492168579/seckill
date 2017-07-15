package org.seckill.dao;

import java.util.List;
import org.seckill.entity.AcvicityConfig;

public interface AcvicityConfigMapper {
    int deleteByPrimaryKey(Integer acvicityId);

    int insert(AcvicityConfig record);

    AcvicityConfig selectByPrimaryKey(Integer acvicityId);

    List<AcvicityConfig> selectAll();

    int updateByPrimaryKey(AcvicityConfig record);
}