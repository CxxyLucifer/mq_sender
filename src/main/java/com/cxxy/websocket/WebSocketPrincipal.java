package com.cxxy.websocket;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;

/**
 * Author:liuhui
 * Description:
 * Date: 6:01 PM 2018/11/26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketPrincipal implements Principal{

    private String userId;

    @Override
    public String getName() {
        return this.userId;
    }
}
