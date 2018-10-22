package com.zxd.dubbo.learning.consumer;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.zxd.dubbo.learning.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

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
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        classPathXmlApplicationContext.start();
        //consumer://172.20.10.4/com.zxd.dubbo.learning.api.DemoService?
        // application=dubbo-demo-consumer&category=consumers&check=false&
        // dubbo=2.5.3&interface=com.zxd.dubbo.learning.api.DemoService&
        // methods=sayHello,sayGoodbye&pid=2300&side=consumer&timestamp=1539276809522
        System.out.println("Consumer started!");
        DemoService demoService = classPathXmlApplicationContext.getBean("demoService",DemoService.class);
        String returnvalue = demoService.sayHello("CoderZZ");
        System.out.println(returnvalue);
        System.out.println(demoService.sayGoodbye("CoderZZ"));


        GenericService genericService = (GenericService)classPathXmlApplicationContext.getBean("demoService");
        Object result = genericService.$invoke("sayHello", new String[] { "java.lang.String" }, new Object[] { "World" });

        System.in.read();
    }
}
