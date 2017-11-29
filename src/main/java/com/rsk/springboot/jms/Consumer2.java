/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: Consumer
 * Author:   Administrator
 * Date:     2017/11/29 10:47
 * Description: 消费者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rsk.springboot.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈消费者〉
 *
 * @author Administrator
 * @create 2017/11/29
 * @since 1.0.0
 */
@Component
public class Consumer2 {
    @JmsListener(destination = "mytest.queue")
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println("Consumer2收到的报文为:"+text);
        return "return message"+text;
    }
}
