package com.cxxy.mq;

import com.cxxy.mq.constants.topics;
import com.cxxy.mq.producer.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessagingException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqApplicationTests {

	@Autowired
	private MessageSender messageSender;

	@Test
	public void sendMessage2Topic() throws MessagingException{
		messageSender.sendMessage2Topic(topics.COMMON_TEST_OUT_TOPIC,"{'name':'topic','consumer':2}");
	}

	@Test
	public void sendMessage2Queue() throws MessagingException {
		messageSender.sendMessage2Queue(topics.COMMON_TEST_TOPIC,"{'name':'queue','consumer':1}");
	}

}
