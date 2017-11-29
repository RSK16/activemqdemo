/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: Producer
 * Author:   Administrator
 * Date:     2017/11/29 10:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rsk.springboot.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 〈生产者〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2017/11/29
 * @since 1.0.0
 */
@Service("producer")
public class Producer {
    @Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsMessagingTemplate jmsTemplate;
    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
