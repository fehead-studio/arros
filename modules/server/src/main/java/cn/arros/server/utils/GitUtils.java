package cn.arros.server.utils;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;

/**
 * @Author Verge
 * @Date 2021/11/1 14:00
 * @Version 1.0
 */
public class GitUtils {
    public static Git clone(String url) throws GitAPIException {
        File file = new File("D://test");
        return Git.cloneRepository()
                .setURI(url)
                .setDirectory(file)
                .call();
    }
}
