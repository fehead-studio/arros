package cn.arros.server.service.impl;

import cn.arros.server.entity.BuildInfo;
import cn.arros.server.mapper.BuildInfoMapper;
import cn.arros.server.service.IBuildInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
