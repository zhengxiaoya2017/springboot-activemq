package com.example.demoactivemq;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;
import javax.jms.Queue;

/**
 * 描述：
 *
 * @author zhengxiaoya
 * @create 2020-04-21 11:30
 */
@Component
@EnableScheduling
public class QueueProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay=3000)//每3s执行1次
    public void send() {
        try {

            MapMessage mapMessage = new ActiveMQMapMessage();
            mapMessage.setString("info", "你还在睡觉");

            this.jmsMessagingTemplate.convertAndSend("zxy.queue2", mapMessage);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
