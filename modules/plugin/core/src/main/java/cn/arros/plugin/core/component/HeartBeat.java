package cn.arros.plugin.core.component;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import cn.arros.plugin.core.dto.BeatBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Verge
 * @Date 2021/12/4 17:31
 * @Version 1.0
 */
public class HeartBeat{
    private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeat.class);

    public static void beat(BeatBody beatBody, String serverHost) {
        LOGGER.info("发送心跳: " + beatBody);

        String response = HttpRequest
                .post(serverHost + "/beat")
                .body(JSONUtil.toJsonStr(beatBody))
                .execute()
                .body();

        LOGGER.info(response);
    }
}
