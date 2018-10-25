package com.zxd.dubbo.learning.provider;

import com.alibaba.dubbo.common.status.Status;
import com.alibaba.dubbo.common.status.StatusChecker;

/**
 * @Project DubboLearning
 * @Package PACKAGE_NAME
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 17:25 2018/10/25.
 */
public class TestStatusChecker implements StatusChecker{
    /**
     * check status
     *
     * @return status
     */
    public Status check() {
        return new Status(Status.Level.OK,"Test status checker is OK","This is a test status checker");
    }
}
