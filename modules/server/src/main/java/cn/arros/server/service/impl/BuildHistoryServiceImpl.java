package cn.arros.server.service.impl;

import cn.arros.server.entity.BuildHistory;
import cn.arros.server.mapper.BuildHistoryMapper;
import cn.arros.server.service.IBuildHistoryService;
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
public class BuildHistoryServiceImpl extends ServiceImpl<BuildHistoryMapper, BuildHistory> implements IBuildHistoryService {

}
