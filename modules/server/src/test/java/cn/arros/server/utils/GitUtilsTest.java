package cn.arros.server.utils;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Verge
 * @Date 2021/11/1 14:13
 * @Version 1.0
 */
@SpringBootTest
class GitUtilsTest {
    @Autowired
    GitUtils gitUtils;

    @Test
    void testClone() throws GitAPIException {
        //System.out.println(gitUtils.clone("https://gitee.com/vergeee/static-repo"));
    }
}