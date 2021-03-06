package com.zxd.dubbo.learning.provider;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * @Project DubboLearning
 * @Package com.zxd.dubbo.learning.provider
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 21:03 2018/10/22.
 */
public class MyGenericService implements GenericService{
    /**
     * 泛化调用
     *
     * @param method         方法名，如：findPerson，如果有重载方法，需带上参数列表，如：findPerson(java.lang.String)
     * @param parameterTypes 参数类型
     * @param args           参数列表
     * @return 返回值
     * @throws Throwable 方法抛出的异常
     */

    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if ("sayHello".equals(method)) {
            return "MyGenericService sayHello " + args[0];
        }
        if ("sayGoodbye".equals(method)) {
            return "MyGenericService sayGoodbye " + args[0];
        }
        return null;
    }
}
