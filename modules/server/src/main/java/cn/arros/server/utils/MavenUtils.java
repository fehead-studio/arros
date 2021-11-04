package cn.arros.server.utils;

import cn.arros.server.properties.ArrosProperties;
import cn.hutool.extra.spring.SpringUtil;
import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/11/4 9:30
 * @Version 1.0
 */
public class MavenUtils {
    private static final Invoker invoker = new DefaultInvoker();
    private static final ArrosProperties arrosProperties = SpringUtil.getBean(ArrosProperties.class);

    static {
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
    }

    public static boolean pack(String repoId) {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setBaseDirectory(new File(arrosProperties.getGit().getPath(), repoId));
        request.setGoals( Arrays.asList("clean","package -Dmaven.test.skip=true"));

        try {
            InvocationResult result = invoker.execute(request);
            if ( result.getExitCode() != 0 ) {
                return false;
            }
        } catch (MavenInvocationException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
