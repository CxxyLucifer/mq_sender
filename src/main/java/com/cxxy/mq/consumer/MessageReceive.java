package com.cxxy.mq.consumer;

import com.cxxy.mq.constants.topics;
import com.cxxy.mq.util.DateUtil;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Author:liuhui
 * Description:
 * Date: 9:57 AM 2018/11/9
 */
//@Component
public class MessageReceive {

    @JmsListener(destination = topics.COMMON_TEST_TOPIC)
    public void receiveQueue(String text) {

        System.out.println(DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss") + ",收到的消息:" + text);
    }
}
