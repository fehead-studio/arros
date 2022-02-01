package cn.arros.common.dto;

/**
 * @Author Verge
 * @Date 2021/12/26 12:36
 * @Version 1.0
 */
public class RepositoryDto {
    private String name;

    private String gitUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }
}
