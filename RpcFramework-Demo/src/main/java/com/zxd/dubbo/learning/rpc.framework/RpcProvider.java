package com.zxd.dubbo.learning.rpc.framework;

import java.io.IOException;

/**
 * @Project DubboLearning
 * @Package com.zxd.dubbo.learning.rpc.framework
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 15:54 2018/10/24.
 */
public class RpcProvider {
    public static void main(String[] args) throws IOException {
        HelloService helloService = new HelloServiceImpl();
        RpcFramework.export(helloService,12345);
    }
}
