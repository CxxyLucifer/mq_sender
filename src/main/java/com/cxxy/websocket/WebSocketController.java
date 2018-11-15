package com.cxxy.websocket;

import com.cxxy.controller.BaseController;
import com.cxxy.form.MessageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author:liuhui
 * Description:
 * Date: 10:08 AM 2018/11/14
 */
@Slf4j
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/websocket/message/send")
    public Object send(@RequestBody @Valid MessageForm form) {
        try {
            log.info(" ============= body:" + form.getBody());
            simpMessagingTemplate.convertAndSend("/websocket/msg", form.getBody());
            return BaseController.ok();
        } catch (MessagingException e) {
            log.error(form.toString() + " => " + e.getMessage(), e);
            return BaseController.fail();
        }
    }

    @MessageMapping("/msg")
    public void receiveMsg(HashMap contentMap) {
        Iterator<Map.Entry> iterator = contentMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();

            log.info("============ " + entry.getKey() + ":" + entry.getValue());
        }
    }
}
