/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: TestBean
 * Author:   Administrator
 * Date:     2017/11/30 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rsk.springboot.jms.mqtest1;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2017/11/30
 * @since 1.0.0
 */

public class TestBean implements Serializable {
    private int age;
    private String name;
    public TestBean() {};
    public TestBean(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
