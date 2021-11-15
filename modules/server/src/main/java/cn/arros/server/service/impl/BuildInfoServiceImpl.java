package cn.arros.server.service.impl;

import cn.arros.server.constant.ConfigType;
import cn.arros.server.entity.BuildInfo;
import cn.arros.server.mapper.BuildInfoMapper;
import cn.arros.server.properties.ArrosProperties;
import cn.arros.server.service.IBuildInfoService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Verge
 * @since 2021-11-01
 */
@Service
public class BuildInfoServiceImpl extends ServiceImpl<BuildInfoMapper, BuildInfo> implements IBuildInfoService {
    @Autowired
    private ArrosProperties arrosProperties;
    @Autowired
    private BuildInfoMapper buildInfoMapper;

    // TODO: 不应直接将地址都设置为这个
    @Override
    public int addBuildInfo(BuildInfo buildInfo) {
        buildInfo.setResultPath(arrosProperties.getConfig(ConfigType.BUILD).getConfigValue() + "/" + buildInfo.getId());
        return buildInfoMapper.insert(buildInfo);
    }
}
