package com.cxxy.websocket;

import com.cxxy.controller.BaseController;
import com.cxxy.form.BodyForm;
import com.cxxy.form.MessageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author:liuhui
 * Description:
 * Date: 10:08 AM 2018/11/14
 *
 * @MessageMapping 标识客户端发来消息的请求地址
 */
@Slf4j
@RestController
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/websocket/message/sendToUser")
    public Object sendToUser(@RequestBody @Valid MessageForm form) {
        try {
            simpMessagingTemplate.convertAndSendToUser(form.getId(), WebSocketMsg.destination, form.getBody());
            return BaseController.ok();
        } catch (MessagingException e) {
            log.error(form.toString() + " => " + e.getMessage(), e);
            return BaseController.fail();
        }
    }


    @RequestMapping("/websocket/message/send")
    public Object send(@RequestBody @Valid BodyForm form) {
        try {
            simpMessagingTemplate.convertAndSend(WebSocketMsg.destination, form.getBody());
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

            log.info("============ 收到客户端消息: " + entry.getKey() + ":" + entry.getValue());
        }

    }
}
