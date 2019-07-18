package com.elfop.sulfur.websocket.response;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import static com.elfop.sulfur.base.common.Dic.WS_HEARTBEAT_PONG;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/15  11:58
 */
@Data
public class PongResp {

    private String heartbeat = WS_HEARTBEAT_PONG;

    private PongResp() {
    }

    public static String toJsonString() {
        return JSON.toJSONString(getInstance());
    }

    private static PongResp getInstance() {
        return PongRespHolder.PONGRESP_INSTANCE;
    }

    private static class PongRespHolder {
        private static final PongResp PONGRESP_INSTANCE = new PongResp();
    }

}
