package com.zxd.dubbo.learning.rpc.framework;

/**
 * @Project DubboLearning
 * @Package com.zxd.dubbo.learning.rpc.framework
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 15:55 2018/10/24.
 */
public class RpcConsumer {
    public static void main(String[] args){
        HelloService helloService = RpcFramework.refer(HelloService.class,"127.0.0.1",12345);
        String result = helloService.hello("CoderZZ");
        System.out.println(result);
    }
}
