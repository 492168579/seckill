package org.seckill.dao;

import java.util.List;
import org.seckill.entity.RoleConfig;

public interface RoleConfigMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleConfig record);

    RoleConfig selectByPrimaryKey(Integer roleId);

    List<RoleConfig> selectAll();

    int updateByPrimaryKey(RoleConfig record);
}