package com.zxd.dubbo.learning.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.zxd.dubbo.learning.api.CallbackListener;
import com.zxd.dubbo.learning.api.CallbackService;
import com.zxd.dubbo.learning.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
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
        String returnvalue = demoService.sayHello("CoderZZ");
        System.out.println(returnvalue);
        Future<String> stringFuture = RpcContext.getContext().getFuture();
        returnvalue = stringFuture.get();
        System.out.println("returnvalue form Future:"+returnvalue);
        String goodbye = demoService.sayGoodbye("CoderZZ");
        System.out.println(goodbye);
        Future<String> goodbyeFuture = RpcContext.getContext().getFuture();
        goodbye = goodbyeFuture.get();
        System.out.println("goodbye form Future:"+goodbye);
        /**
         * 回声测试
         */
        EchoService echoService = (EchoService)demoService;
        System.out.println("EchoService:"+echoService.$echo("OK"));
        Future<Object> objectFuture = RpcContext.getContext().getFuture();
        Object object = objectFuture.get();
        System.out.println("EchoService form Future:"+object.toString());
        /**
         *使用泛化调用
         * 在 Spring 配置申明 generic="true"
         */
        GenericService genericService = (GenericService)classPathXmlApplicationContext.getBean("demoService2");
        RpcContext.getContext().setAttachment("index","2");
        Object result = genericService.$invoke("sayHello", new String[] { "java.lang.String" }, new Object[] { "World" });
        System.out.println("GenericService======="+result.toString());

        // 本端是否为消费端，这里会返回true
        boolean isConsumer = RpcContext.getContext().isConsumerSide();
        System.out.println("isConsumer:"+isConsumer);
        //获取最后一次调用的提供方IP地址
        String serverIP = RpcContext.getContext().getRemoteHost();
        System.out.println("serverIP:"+serverIP);
        String address = RpcContext.getContext().getUrl().getAddress();
        System.out.println("address:"+address);
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        System.out.println("application:"+application);



        CallbackService callbackService = (CallbackService) classPathXmlApplicationContext.getBean("callbackService");

        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener(){
            @Override
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
//        System.in.read();
    }
}
