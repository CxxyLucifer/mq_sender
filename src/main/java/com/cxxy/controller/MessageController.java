package com.cxxy.controller;

import com.cxxy.form.MessageForm;
import com.cxxy.mq.constants.topics;
import com.cxxy.mq.producer.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author:liuhui
 * Description:
 * Date: 5:03 PM 2018/11/13
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping("/send")
    public Object send(@RequestBody @Valid MessageForm form) {
        try {
            messageSender.sendMessage2Topic(topics.COMMON_TEST_OUT_TOPIC, form.getBody());
            return BaseController.ok();
        } catch (MessagingException e) {
            log.error(form.toString() + " => " + e.getMessage(), e);
            return BaseController.fail();
        }
    }
}
