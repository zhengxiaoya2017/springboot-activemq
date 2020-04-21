package com.example.demoactivemq;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 * 描述：
 *
 * @author zhengxiaoya
 * @create 2020-04-21 11:19
 */
@Configuration
public class ActiveMQConfig {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("zxy.queue");
    }
    @Bean
    public Queue queue2() {
        return new ActiveMQQueue("zxy.queue2");
    }
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("zxy.topic");
    }

}
