package cn.arros.server.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.javassist.tools.reflect.Metaobject;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Zero
 * @date 2021/11/12 19:47
 * @description
 * @since 1.8
 **/
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmt_create", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmt_modified", new Date(),metaObject);
    }
}
