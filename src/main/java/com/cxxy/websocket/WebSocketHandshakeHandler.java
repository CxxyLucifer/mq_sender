package com.cxxy.websocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
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
@Slf4j
@Component
public class WebSocketHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {

        String query = request.getURI().getQuery();

        if (StringUtils.isNotBlank(query)) {
            // 解析url
            Map<String, NameValuePair> valuePairMap = URLEncodedUtils
                    .parse(query, Charset.forName("utf-8")).stream()
                    .collect(Collectors.toMap(NameValuePair::getName, Function.identity()));

            NameValuePair id = valuePairMap.get("id");

            log.info("=========== id:" + id.getValue());

            return WebSocketPrincipal
                    .builder()
                    .name(id.getValue())
                    .build();
        } else {
            return null;
        }

    }
}
