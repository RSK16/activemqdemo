/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: Tes
 * Author:   Administrator
 * Date:     2017/12/1 14:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rsk.springboot.jms.mqtest1;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2017/12/1
 * @since 1.0.0
 */
public class Tes {
    public static void main(String[] args) {
        TestBean testBean = null;
        List<TestBean> list = new ArrayList<>();
        list.add(new TestBean(13,"zk"));
        list.add(new TestBean(23,"ls"));
        for (TestBean testBean1 : list) {
            if (testBean1.getName().contains("ls"))
                testBean = new TestBean(testBean1.getAge(),testBean1.getName());

        }
        if (testBean == null) {
            System.out.printf("null");
        } else {
            System.out.printf(""+testBean.getName());
        }
    }
}
