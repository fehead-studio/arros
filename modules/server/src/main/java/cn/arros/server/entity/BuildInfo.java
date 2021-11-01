package cn.arros.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private Integer triggerType;

    @ApiModelProperty("分支")
    private String branch;

    @ApiModelProperty("构建命令")
    private String buildCommand;

    @ApiModelProperty("产物路径")
    private String resultPath;


}
