package org.seckill.dao;

import java.util.List;
import org.seckill.entity.RoleAcvicity;

public interface RoleAcvicityMapper {
    int deleteByPrimaryKey(Integer roleAcvicityId);

    int insert(RoleAcvicity record);

    RoleAcvicity selectByPrimaryKey(Integer roleAcvicityId);

    List<RoleAcvicity> selectAll();

    int updateByPrimaryKey(RoleAcvicity record);

    List<RoleAcvicity>selectbyRoleId(Integer roleId);
}