package cn.arros.server.utils;

import cn.arros.server.properties.ArrosProperties;
import com.google.j2objc.annotations.AutoreleasePool;
import org.checkerframework.checker.units.qual.A;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @Author Verge
 * @Date 2021/11/1 14:00
 * @Version 1.0
 */
@Component
public class GitUtils {
    @Autowired
    private ArrosProperties arrosProperties;

    // 克隆仓库
    public Git clone(String url, String filename) throws GitAPIException {
        System.out.println(arrosProperties);
        File file = new File(arrosProperties.getGit().getPath() + "/" +filename);
        return Git.cloneRepository()
                .setURI(url)
                .setDirectory(file)
                .call();
    }

}
