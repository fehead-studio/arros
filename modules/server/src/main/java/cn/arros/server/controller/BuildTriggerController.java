package cn.arros.server.controller;

import cn.arros.server.common.CommonResult;
import cn.arros.server.entity.BuildInfo;
import cn.arros.server.service.IBuildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Verge
 * @Date 2021/10/31 10:11
 * @Version 1.0
 */
@RestController
@RequestMapping("/server/trigger")
public class BuildTriggerController {
    @Autowired
    private IBuildInfoService buildInfoService;

    /**
     * 触发构建
     * @param id 构建信息ID
     * @param token token
     */
    @RequestMapping("/{id}/{token}")
    public CommonResult trigger(@PathVariable String id, @PathVariable String token) throws Exception {
        BuildInfo buildInfo = buildInfoService.getById(id);
        if (buildInfo == null) {
            throw new Exception("构建信息未找到");
        }

        if (!token.equals(buildInfo.getTriggerToken())) {
            throw new Exception("token不匹配");
        }

        // TODO: 开始构建

        return CommonResult.success();
    }
}
