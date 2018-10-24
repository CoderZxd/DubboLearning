package com.zxd.dubbo.learning.rpc.framework;


/**
 * @Project DubboLearning
 * @Package com.zxd.dubbo.learning.rpc.framework.impl
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 15:51 2018/10/24.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello "+name;
    }
}
