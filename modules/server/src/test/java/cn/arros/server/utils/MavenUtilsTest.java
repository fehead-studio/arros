package cn.arros.server.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Verge
 * @Date 2021/11/4 9:43
 * @Version 1.0
 */
@SpringBootTest
class MavenUtilsTest {

    @Test
    void pack() {
        MavenUtils.pack("bdd0b150d06c4b148735caf431aad4f4");
    }
}