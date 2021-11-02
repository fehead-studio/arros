package cn.arros.server.service;

import cn.arros.server.constant.BuildStatus;
import cn.arros.server.entity.BuildHistory;
import cn.arros.server.entity.BuildInfo;
import cn.arros.server.mapper.BuildHistoryMapper;
import cn.arros.server.utils.GitUtils;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @Author Verge
 * @Date 2021/11/2 10:20
 * @Version 1.0
 */
public class BuildService implements Runnable{

    private final BuildInfo buildInfo;

    BuildHistory buildHistory = new BuildHistory();

    BuildHistoryMapper buildHistoryMapper = SpringUtil.getBean(BuildHistoryMapper.class);

    public BuildService(BuildInfo buildInfo) {
        this.buildInfo = buildInfo;
    }

    @Override
    public void run() {

    }

    /**
     * 构建流程
     * 准备：向表build_history插入基本信息
     * 拉取资源：执行git pull获取最新源码
     * 执行命令：执行打包命令
     * 部署：部署至服务器
     */

    /**
     * 准备阶段
     * @return 成功与否
     */
    private boolean prepare() {
        buildHistory.setId(IdUtil.fastSimpleUUID());
        buildHistory.setBuildInfoId(buildInfo.getId());
        buildHistory.setStatus(BuildStatus.PREPARING.getCode());
        buildHistory.setStartTime(LocalDateTime.now());

        return buildHistoryMapper.insert(buildHistory) == 1;
    }

    /**
     * 更新资源
     * @return 成功与否
     */
    private boolean updateSource() throws GitAPIException, IOException {
        buildHistory.setStatus(BuildStatus.BUILDING.getCode());
        buildHistoryMapper.updateById(buildHistory);

        PullResult pullResult = GitUtils.pull(buildInfo.getRepoId());
        return pullResult.isSuccessful();
    }

    private boolean build() {
        System.out.println(RuntimeUtil.execForStr("mvn -v"));
        return true;
    }




}
