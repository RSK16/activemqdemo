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
public class Consumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:" + text);
    }
}
