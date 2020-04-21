package com.example.demoactivemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;
import javax.jms.Message;

/**
 * 描述：
 *
 * @author zhengxiaoya
 * @create 2020-04-21 11:32
 */
@Component
public class QueueConsumer {
    //使用JmsListener配置消费者监听的队列，其中Message是接收到的消息
    @JmsListener(destination = "zxy.queue")
    public void receiveQueue(Message message) {
        try {
            MapMessage mapMessage = (MapMessage) message;
            String info = mapMessage.getString("info");
            System.out.println(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @JmsListener(destination = "zxy.queue2")
    @SendTo("zxy.queue2")
    public void receiveQueue2(Message message) {
        try {
            MapMessage mapMessage = (MapMessage) message;
            String info = mapMessage.getString("info");
            System.out.println(info+"quene2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
