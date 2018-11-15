package com.cxxy.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


/**
 * Author:liuhui
 * Description:
 * Date: 9:48 AM 2018/11/14
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //简单来说就是设置一个节点，路径名字
        //前端js初始化    new SockJS('/项目名称/testWS');
        registry.addEndpoint("/testWS")
                .setAllowedOrigins("*")
                .withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        ThreadPoolTaskScheduler te = new ThreadPoolTaskScheduler();
//        te.setPoolSize(1);
//        te.setThreadNamePrefix("wss-heartbeat-thread-");
//        te.initialize();

        registry.enableSimpleBroker("/websocket");
    }
}