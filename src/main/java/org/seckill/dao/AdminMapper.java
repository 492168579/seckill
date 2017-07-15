package org.seckill.dao;

import java.util.List;
import org.seckill.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminCode);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer adminCode);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}