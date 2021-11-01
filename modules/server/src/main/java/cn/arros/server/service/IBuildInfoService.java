package cn.arros.server.service;

import cn.arros.server.entity.BuildInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Verge
 * @since 2021-11-01
 */
public interface IBuildInfoService extends IService<BuildInfo> {
    int addBuildInfo(BuildInfo buildInfo);
}
