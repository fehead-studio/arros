package cn.arros.server.utils;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.Test;

/**
 * @Author Verge
 * @Date 2021/11/1 14:13
 * @Version 1.0
 */
class GitUtilsTest {

    @Test
    void testClone() throws GitAPIException {
        System.out.println(GitUtils.clone("https://gitee.com/vergeee/static-repo"));
    }
}