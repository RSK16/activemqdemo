/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: Receive
 * Author:   Administrator
 * Date:     2017/11/30 11:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rsk.springboot.jms.mqtest1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 〈点对点消息模型实例使用queue作为目的之〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2017/11/30
 * @since 1.0.0
 */
public class Receive {
    public static void main(String[] args) {
        // 链接工厂
        ActiveMQConnectionFactory connectionFactory = null;
        // 链接对象
        Connection connection = null;
        // 会话
        Session session = null;
        // 队列（目的地，消费者消费消息的地方）
        Queue queue = null;
        // 消息消费者
        MessageConsumer consumer = null;
        connectionFactory = new ActiveMQConnectionFactory("admin", "admin",
                "tcp://192.168.1.182:61616");
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            // 创建session是的true 和false
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            queue = session.createQueue("test_queue"); // 队列（目的地，消费者消费消息的地方）
            consumer = session.createConsumer(queue); // 消息消费者
            // Message message = consumer.receive(); //同步方式接收
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        String value = textMessage.getText();
                        System.out.println("value: " + value);
                    } catch (JMSException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
