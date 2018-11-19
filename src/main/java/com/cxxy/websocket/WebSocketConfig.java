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
 *
 * EnableWebSocketMessageBroker注解 ： 这个配置类不仅配置了 WebSocket，还配置了基于代理的 STOMP 消息
 *
 * registerStompEndpoints()方法：添加一个服务端点，来接收客户端的连接。http://127.0.0.1:8004/testWS，ws://127.0.0.1:8084
 *
 * configureMessageBroker()方法：配置了一个简单的消息代理，通俗一点讲就是设置消息连接请求的各种规范信息
 *
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