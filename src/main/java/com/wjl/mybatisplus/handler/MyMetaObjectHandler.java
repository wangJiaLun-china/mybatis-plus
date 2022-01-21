package com.wjl.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        //判断是否具备author属性
        boolean hasAuthor = metaObject.hasSetter("author");
        if(hasAuthor){
            log.info("start insert fill author....");
            this.strictInsertFill(metaObject, "author", String.class, "Helen");
        }

        //判断age是否赋值
        Object age = this.getFieldValByName("age", metaObject);
        if(age == null){
            log.info("start insert fill age....");
            this.strictInsertFill(metaObject, "age", String.class, "18");
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}