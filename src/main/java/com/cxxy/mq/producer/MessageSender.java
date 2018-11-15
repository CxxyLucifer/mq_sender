package com.cxxy.mq.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    public void sendMessage2Topic(String name, String msg) throws MessagingException {
        jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(name), msg);
    }

    /**
     * mq发送消息
     *
     * @param name 目的地名称
     * @param msg  消息体
     */
    public void sendMessage2Queue(String name, String msg) throws MessagingException{
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(name), msg);
    }
}
