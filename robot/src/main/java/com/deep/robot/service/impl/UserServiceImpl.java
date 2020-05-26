package com.deep.robot.service.impl;
import com.javen.dao.UserMapper;
import com.javen.model.User;
import com.javen.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userDao;

    public User getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId);
    }

}