package com.wjl.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjl.mybatisplus.entity.User;
import com.wjl.mybatisplus.mapper.UserMapper;
import com.wjl.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> listAllByName(String name) {
        // baseMapper对象指向当前业务的mapper对象
        return baseMapper.selectAllByName(name);
    }
}