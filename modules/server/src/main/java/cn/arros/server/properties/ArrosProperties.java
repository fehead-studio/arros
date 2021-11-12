package cn.arros.server.properties;

import cn.arros.server.constant.ConfigType;
import cn.arros.server.entity.SysConfig;
import cn.arros.server.service.ISysConfigService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zero
 * @date 2021/11/12 20:25
 * @description
 * @since 1.8
 **/
@Configuration
public class ArrosProperties {

    @Autowired
    private ISysConfigService sysConfigService;

    /**
     * 根据配置类型数据库拿取配置
     * @param type
     * @return
     */
    public SysConfig getConfig(ConfigType type) {
        return sysConfigService.getOne(new QueryWrapper<SysConfig>().eq(isContainType(type), "config_name", type.getName()));
    }

    /**
     * 根据配置名从数据库获取配置
     * @param type
     * @return
     */
    public SysConfig getConfig(String type) {
        return sysConfigService.getOne(new QueryWrapper<SysConfig>().eq(isContainType(type), "config_name", type));
    }

    /**
     * 判断是否包含支持配置类型
     * @param type
     * @return
     */
    private boolean isContainType(Object type) {
        for(ConfigType element :ConfigType.values()) {
            if(type instanceof String) {
                return element.getName().equalsIgnoreCase((String) type);
            } else if(type instanceof ConfigType) {
                return element.equals(type);
            } else {
                return type.equals(element.getType());
            }
        }
        return false;
    }


}
