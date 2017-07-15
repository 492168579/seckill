package org.seckill.dao;

import java.util.List;
import org.seckill.entity.AdminRole;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminRole record);

    AdminRole selectByPrimaryKey(Integer id);

    List<AdminRole> selectAll();

    int updateByPrimaryKey(AdminRole record);


    List<AdminRole>selectByAdminCode(Integer adminCode);
}