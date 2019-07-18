package com.elfop.sulfur.websocket;

import com.elfop.sulfur.websocket.response.PongResp;
import com.elfop.sulfur.websocket.service.WsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicLong;

import static com.elfop.sulfur.base.common.Dic.WS_HEARTBEAT_PING;

/**
 * @Description: 长连接控制类 集中处理长连接  单机的websocket的稳定链接数一般在 1200 个长连接左右
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/15  11:22
 */
@Slf4j
@Component
@ServerEndpoint(value = "/ws/{uid}", configurator = WsContextProvider.class)
public class WsServer {

    /**
     * 统计ws在线数
     */
    private static final AtomicLong ONLINE_COUNT = new AtomicLong(0);

    @Resource
    private WsService wsSvc;

    private String uid;

    /**
     * 接受参数建立连接
     * 进入ws的session存放在java map中
     *
     * @param session 　用户session
     * @param uid     用户id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {

        this.uid = uid;

        wsSvc.registerSession(uid, session);

        log.info("New session opened , current connections {} / session id {} / uid {} ",
                ONLINE_COUNT.incrementAndGet(), session.getId(), uid);
    }

    @OnMessage
    public void onMessage(String message, Session session) {

        if (message != null && message.equalsIgnoreCase(WS_HEARTBEAT_PING)) {
            try {
                log.trace(" onMessage Pong: " + ByteBuffer.wrap("health-check".getBytes(StandardCharsets.UTF_8)));
                session.getBasicRemote().sendText(PongResp.toJsonString());
            } catch (IOException e) {
                log.error("onMessage： ERROR ! {}", e.getMessage());
            }
        }

    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        wsSvc.removeSession(this.uid);
        log.info("onClose: One closed, current connections {}", ONLINE_COUNT.decrementAndGet());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("ws : onError: " + throwable.getMessage() + " / " + throwable);
        throwable.printStackTrace();
    }


}
