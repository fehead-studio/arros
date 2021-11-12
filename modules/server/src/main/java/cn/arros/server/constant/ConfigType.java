package cn.arros.server.constant;

/**
 * @author Zero
 * @date 2021/11/12 21:16
 * @description
 * @since 1.8
 **/
public enum ConfigType {
    GIT_CONFIG(1,"GIT"),
    AES_CONFIG(2,"AES"),
    BUILD_CONFIG(3,"BUILD");

    private final int type;
    private final String name;

    ConfigType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
