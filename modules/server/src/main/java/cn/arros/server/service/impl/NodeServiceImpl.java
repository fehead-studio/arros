package cn.arros.server.service.impl;

import cn.arros.server.entity.Node;
import cn.arros.server.mapper.NodeMapper;
import cn.arros.server.service.INodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Verge
 * @since 2021-11-06
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements INodeService {

}
