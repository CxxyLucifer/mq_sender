package com.cxxy.mq;

import com.cxxy.mq.constants.topics;
import com.cxxy.mq.producer.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqApplicationTests {

	@Autowired
	private MessageSender messageSender;

	@Test
	public void contextLoads() throws Exception{
		messageSender.sendMessage(topics.common_test_topic,"{'name':'jack','age':28}");
	}

}
