package com.elfop.sulfur.websocket;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContextAware;

import javax.websocket.server.ServerEndpointConfig;

/**
 * @Description: 为websocket提供ioc注入支持
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2018/12/26  15:30
 */
public class WsContextProvider extends ServerEndpointConfig.Configurator implements ApplicationContextAware {
    private static volatile BeanFactory context;

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    private static void setContext(BeanFactory context) {
        WsContextProvider.context = context;
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
        return context.getBean(clazz);
    }
}