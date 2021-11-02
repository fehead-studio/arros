package cn.arros.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Verge
 * @since 2021-11-01
 */
@TableName("build_info")
@ApiModel(value = "BuildInfo对象", description = "")
public class BuildInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("uuid")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("repo id")
    private String repoId;

    @ApiModelProperty("触发类型")
    private String triggerToken;

    @ApiModelProperty("分支")
    private String branch;

    @ApiModelProperty("构建命令")
    private String buildCommand;

    @ApiModelProperty("产物路径")
    private String resultPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    public String getTriggerToken() {
        return triggerToken;
    }

    public void setTriggerToken(String triggerToken) {
        this.triggerToken = triggerToken;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBuildCommand() {
        return buildCommand;
    }

    public void setBuildCommand(String buildCommand) {
        this.buildCommand = buildCommand;
    }

    public String getResultPath() {
        return resultPath;
    }

    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    @Override
    public String toString() {
        return "BuildInfo{" +
                "id='" + id + '\'' +
                ", repoId='" + repoId + '\'' +
                ", triggerToken='" + triggerToken + '\'' +
                ", branch='" + branch + '\'' +
                ", buildCommand='" + buildCommand + '\'' +
                ", resultPath='" + resultPath + '\'' +
                '}';
    }
}
