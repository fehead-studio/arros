package cn.arros.server.service;

import cn.arros.server.constant.BuildStatus;
import cn.arros.server.entity.BuildHistory;
import cn.arros.server.entity.BuildInfo;
import cn.arros.server.mapper.BuildHistoryMapper;
import cn.arros.server.utils.GitUtils;
import cn.arros.server.utils.MavenUtils;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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
        List<Supplier<Boolean>> list = new ArrayList<>(4);
        list.add(this::prepare);
        list.add(this::updateSource);
        list.add(this::build);
        list.add(this::deploy);

        for (Supplier<Boolean> booleanSupplier : list) {
            if (!booleanSupplier.get()) {
                break;
            }
        }

    }

    /*
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
        buildHistory.setStartTime(LocalDateTime.now());
        buildHistory.setBuildInfoId(buildInfo.getId());
        buildHistory.setStatus(BuildStatus.PREPARING.getCode());

        return buildHistoryMapper.insert(buildHistory) == 1;
    }

    /**
     * 更新资源
     * @return 成功与否
     */
    private boolean updateSource() {
        buildHistory.setStatus(BuildStatus.BUILDING.getCode());
        buildHistoryMapper.updateById(buildHistory);
        try {
            PullResult pullResult = GitUtils.pull(buildInfo.getRepoId());
            return pullResult.isSuccessful();
        } catch (GitAPIException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 构建项目
     * 目前只支持Maven
     * @return 成功与否
     */
    private boolean build() {
        boolean status = MavenUtils.pack(buildInfo.getRepoId());
        if (status) {
            buildHistory.setStatus(BuildStatus.BUILD_COMPLETED.getCode());
        } else {
            buildHistory.setStatus(BuildStatus.BUILD_FAILED.getCode());
        }
        return status;
    }

    // TODO: 待完成
    private boolean deploy(){
        buildHistory.setStatus(BuildStatus.DEPLOY_COMPLETED.getCode());
        buildHistoryMapper.updateById(buildHistory);

        buildHistory.setEndTime(LocalDateTime.now());
        buildHistoryMapper.updateById(buildHistory);
        return true;
    }

}
