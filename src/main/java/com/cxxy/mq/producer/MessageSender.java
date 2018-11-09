package com.cxxy.mq.producer;

import com.cxxy.mq.constants.topics;
import com.cxxy.mq.util.DateUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsMessagingTemplate;


/**
 * Author:liuhui
 * Description:
 * Date: 6:09 PM 2018/11/6
 */
@Service
public class MessageSender {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * mq发送消息
     *
     * @param name 目的地名称
     * @param msg  消息体
     */
    public void sendMessage(String name, String msg) throws Exception{
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(name), msg);
    }

    @JmsListener(destination = topics.COMMON_TEST_OUT_TOPIC)
    public void consumerMessage(String text) {
        System.out.println(DateUtil.getCurrentDateString("") + " ,从out_topic中收到消息:" + text);
    }
}
