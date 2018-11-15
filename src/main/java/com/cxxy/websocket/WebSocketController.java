package com.cxxy.websocket;

import com.cxxy.controller.BaseController;
import com.cxxy.form.BodyForm;
import com.cxxy.form.MessageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author:liuhui
 * Description:
 * Date: 10:08 AM 2018/11/14
 */
@Slf4j
@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/message/send")
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
    public void msg(@Payload MessageForm form){
        log.info("from client message:",form.getBody());
    }
}
