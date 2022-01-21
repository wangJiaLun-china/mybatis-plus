package com.wjl.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wjl.mybatisplus.entity.User;
import com.wjl.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class WrapperTests {
    
    @Resource
    private UserMapper userMapper;

    @Test
    public void test1() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name","n")
                .between("age", 10, 20)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test2() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderByDesc("age")
                .orderByAsc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test3() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper); //条件构造器也可以构建删除语句的条件
        System.out.println("delete return count = " + result);
    }

    @Test
    public void test4() {

        //修改条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "n")
                .and(i -> i.lt("age", 18).or().isNull("email")); //lambda表达式内的逻辑优先运算

        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println(result);
    }
}