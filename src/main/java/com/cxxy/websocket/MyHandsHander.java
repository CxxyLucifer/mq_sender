package com.cxxy.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.Charset;
import java.security.Principal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author:liuhui
 * Description:
 * Date: 5:03 PM 2018/11/26
 */
public class MyHandsHander extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String query = request.getURI().getQuery();

        // 解析url
        Map<String, NameValuePair> valuePairMap = URLEncodedUtils
                .parse(query, Charset.forName("utf-8"))
                .stream()
                .collect(Collectors.toMap(NameValuePair::getName, Function.identity()));

        String id = valuePairMap.get("id").toString();


        return MyPrincipal.builder().name(id).build();
    }
}
