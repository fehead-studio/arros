package cn.arros.server.controller;


import cn.arros.server.common.CommonResult;
import cn.arros.server.entity.BuildInfo;
import cn.arros.server.entity.Repository;
import cn.arros.server.service.IBuildInfoService;
import cn.arros.server.service.IRepositoryService;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Verge
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/server/buildInfo")
public class BuildInfoController {
    @Autowired
    private IBuildInfoService buildInfoService;

    @PostMapping
    public CommonResult addBuildInfo(@RequestBody BuildInfo buildInfo) {
        String uuid = IdUtil.fastSimpleUUID();
        buildInfo.setId(uuid);
        buildInfoService.addBuildInfo(buildInfo);
        return CommonResult.success();
    }
}

