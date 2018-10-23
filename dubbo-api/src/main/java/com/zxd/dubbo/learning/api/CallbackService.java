package com.zxd.dubbo.learning.api;

/**
 * @Project DubboLearning
 * @Package com.zxd.dubbo.learning.api
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 16:35 2018/10/23.
 */
public interface CallbackService {
    void addListener(String key, CallbackListener listener);
}
