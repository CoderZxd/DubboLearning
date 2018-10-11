package com.zxd.dubbo.learning.provider;

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
        return "Hello "+param;
    }
}
