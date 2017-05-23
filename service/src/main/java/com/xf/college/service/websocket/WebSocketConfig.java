package com.xf.college.service.websocket;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by xufeng on 2017/5/18.
 */
@Configurable
@Component
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private CollegeWebSocketHandler handler = new CollegeWebSocketHandler();

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/ws").addInterceptors(new HandShake()).setAllowedOrigins("*");
        registry.addHandler(handler, "/ws/sockjs").addInterceptors(new HandShake()).setAllowedOrigins("*").withSockJS();
    }
}
