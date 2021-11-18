package cn.arros.server.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zero
 * @date 2021/11/16 20:53
 * @description
 * @since 1.8
 **/

@ServerEndpoint("/web/{uid}")
public class WebSocket {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     * 标识当前连接客户端的用户id
     */
    private String userId;

    /**
     * 连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     *  用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String,WebSocket> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 打开连接
     * @param sessions
     * @param userId
     */
    @OnOpen
    public void onOpen(Session sessions, @PathParam(value = "uid") String userId) {
        this.session = sessions;
        this.userId = userId;
        webSocketSet.put(sessions.getId(), this);
        addOnlineCount();
    }

    /**
     * 连接发生错误
     * @param throwable
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void OnClose() {
        webSocketSet.remove(this.userId);
        subOnlineCount();
        logger.info("[WebSocket] 退出成功，当前连接数为：={},是{}",webSocketSet.size(),webSocketSet.keySet());
    }

    /**
     * 接收消息
     * @param message
     * TODO: 客户端暂时没有和服务端交互的需求
     */

    @OnMessage
    public void OnMessage(String message){

    }

    /**
     * 点对点发送
     * @param
     * @param
     */
    public void AppointSending() {


//        try {
//            System.out.println(webSocketSet.keySet());
//            System.out.println("包含"+ messageVO.getToo());
//            System.out.println(webSocketSet.containsKey(messageVO.getToo()));
//            if(webSocketSet.containsKey(messageVO.getToo())) {
//                webSocketSet.get(messageVO.getToo()).session.getBasicRemote().sendText(JSON.toJSONString(messageVO));
//            } else {
//                //离线则保存这个消息
//                messageVO.setStatus(true);
//                //更改消息为离线消息
//                messageService.update(messageVO,new UpdateWrapper<MessageVO>().eq("id", messageVO.getId()));
//                //第三方消息推送服务推送消息
//                //通道设置为用户id，这样每个用户只需订阅自己唯一id的通道就能获得所有的通
//                notifyUtil.publish(JSON.toJSONString(messageVO),messageVO.getToo().toString(),messageVO.getId());
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 群发
     * @param message
     */
    public void GroupSending(String message){
        for (String userId : webSocketSet.keySet()){
            try {
                webSocketSet.get(userId).session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取当前在线用户数
     */
    public static int getOnlineCount() {
        return onlineCount.get();
    }

    /**
     * 增加连接数
     */
    public static void addOnlineCount() {
        onlineCount.incrementAndGet();
    }

    /**
     * 减少在线人数
     */
    public static void subOnlineCount() {
        onlineCount.decrementAndGet();
    }

}
