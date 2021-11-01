package cn.arros.server.entity;

import java.time.LocalDateTime;

/**
 * @Author Verge
 * @Date 2021/11/1 15:50
 * @Version 1.0
 */
public class BaseEntity {
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
