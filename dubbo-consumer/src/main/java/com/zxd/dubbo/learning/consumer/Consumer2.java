package com.zxd.dubbo.learning.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.zxd.dubbo.learning.api.DemoService;
import com.zxd.dubbo.learning.api.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: DubboLearning
 * @Package com.zxd.dubbo.learning.consumer
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-10-11 23:28
 **/
public class Consumer2 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:dubbo-consumer2.xml");
        classPathXmlApplicationContext.start();
        //consumer://172.20.10.4/com.zxd.dubbo.learning.api.DemoService?
        // application=dubbo-demo-consumer&category=consumers&check=false&
        // dubbo=2.5.3&interface=com.zxd.dubbo.learning.api.DemoService&
        // methods=sayHello,sayGoodbye&pid=2300&side=consumer&timestamp=1539276809522
        System.out.println("Consumer started!");

        DemoService demoService = classPathXmlApplicationContext.getBean("demoService",DemoService.class);
        //隐式参数
        //注意：path, group, version, dubbo, token, timeout 几个 key 是保留字段，请使用其它值
        RpcContext.getContext().setAttachment("index","1");
        Person person = demoService.getPerson("CoderZZ");
        System.out.println("person.getName():"+person.getName());
        RpcContext.getContext().setAttachment("index","2");
        String rt = demoService.sayHello("world");
        System.out.println(rt);
//        System.in.read();
    }
}
