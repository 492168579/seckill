package org.seckill.dao;

import org.seckill.entity.Seckill;
import org.seckill.entity.User;

/**
 * Created by yezhaoyi on 16/8/20.
 */
public interface UserDao {
    public User queryByuserName(String userName) ;
}
