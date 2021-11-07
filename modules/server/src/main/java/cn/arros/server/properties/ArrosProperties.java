package cn.arros.server.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Verge
 * @Date 2021/11/1 16:53
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "arros")
public class ArrosProperties {
    public static class Git {
        private String path = "/arros/repo";

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    public static class Build {
        private String path = "/arros/build";

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    public static class AES {
        private String key = "1234567890";

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    private Git git = new Git();

    private Build build = new Build();

    private AES aes = new AES();

    public Git getGit() {
        return git;
    }

    public void setGit(Git git) {
        this.git = git;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public AES getAes() {
        return aes;
    }

    public void setAes(AES aes) {
        this.aes = aes;
    }
}
