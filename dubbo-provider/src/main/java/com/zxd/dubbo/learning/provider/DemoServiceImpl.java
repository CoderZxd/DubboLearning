package com.zxd.dubbo.learning.provider;

import com.alibaba.dubbo.rpc.RpcContext;
import com.zxd.dubbo.learning.api.DemoService;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: DubboLearning
 * @Package com.zxd.dubbo.learning.provider
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-10-11 23:10
 **/
public class DemoServiceImpl implements DemoService{
    /**
     * class_name: sayHello
     * param: [param]
     * describe: say hello
     * creat_user: CoderZZ
     * creat_date: 2018-10-11
     * creat_time: 23:06
     *
     * @param param
     */
    public String sayHello(String param) {
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("isProviderSide:"+isProviderSide);
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        System.out.println("clientIP:"+clientIP);
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        System.out.println("application:"+application);
        String address = RpcContext.getContext().getUrl().getAddress();
        System.out.println("address:"+address);
        String index = RpcContext.getContext().getAttachment("index");
        System.out.println("getAttachment index:"+index);
        return "Hello "+param;
    }

    /**
     * class_name: sayGoodbye
     * param: [param]
     * describe: TODO
     * creat_user: CoderZZ
     * creat_date: 2018-10-12
     * creat_time: 0:27
     *
     * @param param
     */
    public String sayGoodbye(String param) {
        return "Goodbey "+param;
    }
}
