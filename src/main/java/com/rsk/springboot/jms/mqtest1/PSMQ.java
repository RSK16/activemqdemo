/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: PSMQ
 * Author:   Administrator
 * Date:     2017/11/30 14:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rsk.springboot.jms.mqtest1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 〈发布/订阅消息模型实例〉<br>
 * 〈消息发布端〉
 *
 * @author Administrator
 * @create 2017/11/30
 * @since 1.0.0
 */
public class PSMQ {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","tcp://192.168.1.182:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建话题
        Topic topic = session.createTopic("myTopic.messages");
        //为话题创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        while(true) {
            TextMessage message = session.createTextMessage();
            message.setText("message_" + System.currentTimeMillis());
            producer.send(message);
            System.out.println("Sent message: " + message.getText());
        }
    }
}
