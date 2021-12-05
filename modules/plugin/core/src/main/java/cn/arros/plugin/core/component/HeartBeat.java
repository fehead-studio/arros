package cn.arros.plugin.core.component;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.arros.plugin.core.dto.HeartBeatBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Verge
 * @Date 2021/12/4 17:31
 * @Version 1.0
 */
public class HeartBeat{
    private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeat.class);

    public static String register(HeartBeatBody heartBeatBody, String serverHost) {
        LOGGER.info("注册: " + heartBeatBody);

        String response = HttpRequest
                .post(serverHost + "/beat/register")
                .body(JSONUtil.toJsonStr(heartBeatBody))
                .execute()
                .body();

        LOGGER.info(response);
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject.getStr("data");
    }

    public static void beat(String id, String serverHost) {
        LOGGER.debug("发送心跳:" + id);

        String response = HttpRequest
                .post(serverHost + "/beat")
                .form("id", id)
                .execute()
                .body();

        LOGGER.info(response);
    }
}
