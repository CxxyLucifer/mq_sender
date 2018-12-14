package com.cxxy.websocket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:liuhui
 * Description:
 * Date: 10:36 AM 2018/12/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketMsg {
    public static final String destination = "/websocket/msg";
}
