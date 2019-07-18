package com.elfop.sulfur.base.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/15  15:44
 */
@Configuration
public class SimpleCorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    /**
     * websocket 添加响应头
     * (微信小程序等会进行判断,缺少微信不放行)
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest requestToUse = (HttpServletRequest) servletRequest;
        HttpServletResponse responseToUse = (HttpServletResponse) servletResponse;

        String websocketProtocol = ((HttpServletRequest) servletRequest).getHeader("Sec-WebSocket-Protocol");

        if (isNotBlank(websocketProtocol)) {
            responseToUse.addHeader("Sec-WebSocket-Protocol",
                    URLEncoder.encode(websocketProtocol, "UTF-8"));
        }


        filterChain.doFilter(requestToUse, responseToUse);
    }
}
