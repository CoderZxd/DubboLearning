package com.zxd.dubbo.learning.consumer;

import com.zxd.dubbo.learning.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: DubboLearning
 * @Package com.zxd.dubbo.learning.consumer
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-10-11 23:28
 **/
public class Consumer {
    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        classPathXmlApplicationContext.start();
        DemoService demoService = classPathXmlApplicationContext.getBean("demoService",DemoService.class);
        String returnvalue = demoService.sayHello("CoderZZ");
        System.out.println(returnvalue);
    }
}
