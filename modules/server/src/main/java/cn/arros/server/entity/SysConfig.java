package cn.arros.server.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zero
 * @date 2021/11/12 20:25
 * @description
 * @since 1.8
 **/

@ApiModel(value = "SysConfig对象", description = "")
public class SysConfig extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键配置id")
    @TableId(value = "config_id", type = IdType.AUTO)
    private Integer config_id;

    @ApiModelProperty("配置键")
    private String config_key;

    @ApiModelProperty("配置名")
    private String configName;

    @ApiModelProperty("配置值")
    private String configValue;

    @ApiModelProperty("配置类型")
    private String configType;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private Date gmtCreate;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.UPDATE)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private Date gmtModified;

    @ApiModelProperty("备注")
    private String remark;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getConfig_id() {
        return config_id;
    }

    public void setConfig_id(Integer config_id) {
        this.config_id = config_id;
    }

    public String getConfig_key() {
        return config_key;
    }

    public void setConfig_key(String config_key) {
        this.config_key = config_key;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SysConfig{" +
                "config_id=" + config_id +
                ", config_key='" + config_key + '\'' +
                ", configName='" + configName + '\'' +
                ", configValue='" + configValue + '\'' +
                ", configType='" + configType + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", remark='" + remark + '\'' +
                '}';
    }
}
