package com.elfop.sulfur.base.common;

/**
 * @Description: 状态码等, 字典类
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/9  14:00
 */
public class Dic {

    /**
     * 正常返回
     */
    public static final int RESULT_CODE_SUCCESS = 200;

    /**
     * 服务器错误
     */
    public static final int RESULT_CODE_FAIL = 500;

    /**
     * 客户端错误
     */
    public static final int RESULT_CODE_CLIENT_FAIL = 400;

    /**
     * zabbix api 请求id参数
     */
    public static final String DEFAULT_ZABBIX_API_REQUEST_PARAM_ID = "1";

    /**
     * zabbix api 请求jsonrpc参数
     */
    public static final String DEFAULT_ZABBIX_API_REQUEST_PARAM_JSONRPC = "2.0";

    /**
     * websocket 心跳响应
     */
    public static final String WS_HEARTBEAT_PONG = "pong";

    /**
     * webscoket 心跳发出
     */
    public static final String WS_HEARTBEAT_PING = "ping";

    /**
     * token 时效 (day)
     */
    public static final Long TOKEN_EFFECTIVE_TIME = 1000L * 60L * 60L * 24L;

}
