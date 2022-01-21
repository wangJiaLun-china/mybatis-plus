package com.wjl.mybatisplus;

import com.wjl.mybatisplus.entity.User;
import com.wjl.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes =com.wjl.mybatisplus.MybatisPlusApplication.class )
class MybatisPlusApplicationTests {

    @Resource //默认按名称装配，找不到与名称匹配的bean，则按照类型装配。是J2EE的注解
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        //selectList()方法的参数：封装了查询条件
        //null：无任何查询条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
