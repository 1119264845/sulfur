package com.elfop.sulfur.base.config;

import com.elfop.sulfur.websocket.WsContextProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Description: 长连结配置
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/15  11:08
 */
@Configuration
@ConditionalOnWebApplication
public class WebSocketConf {

    @Bean
    public WsContextProvider wsContextProvider() {
        return new WsContextProvider();
    }

    /**
     * WebSocket conf.
     * 注入ServerEndpointExporter，这个bean会自动注册使用了
     *
     * @return
     * @ServerEndpoint注解声明的Websocket endpoint。
     * 要注意，如果使用独立的servlet容器(使用tomcat 的war部署)，而不是直接使用springboot的内置容器，
     * 就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理。
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
