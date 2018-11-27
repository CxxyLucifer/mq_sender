package com.cxxy.websocket;


import lombok.Builder;
import lombok.Data;

import java.security.Principal;

/**
 * Author:liuhui
 * Description:
 * Date: 6:01 PM 2018/11/26
 */
@Data
@Builder
public class WebSocketPrincipal implements Principal{

    private String name;
}
