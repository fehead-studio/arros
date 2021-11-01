package cn.arros.server.constant;

/**
 * @Author Verge
 * @Date 2021/10/31 16:43
 * @Version 1.0
 */
public enum RepoType {
    GITHUB(1),GITEE(2);

    int type;

    RepoType(int type) {
        this.type = type;
    }

    public int val() {
        return type;
    }
}
