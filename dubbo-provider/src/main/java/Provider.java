import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: DubboLearning
 * @Package PACKAGE_NAME
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-10-11 23:14
 **/
public class Provider {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
        System.out.println(classPathXmlApplicationContext.getApplicationName()+":"+classPathXmlApplicationContext.getDisplayName());
        classPathXmlApplicationContext.start();
        //dubbo://172.20.10.4:20880/com.zxd.dubbo.learning.api.DemoService?
        // anyhost=true&application=dubbo-demo-provider&dubbo=2.5.3&
        // interface=com.zxd.dubbo.learning.api.DemoService&methods=sayHello,sayGoodbye&
        // owner=CoderZZ&pid=6444&side=provider&timestamp=1539276144617
        System.out.println("Dubbo provider started!");
        // 阻塞当前进程，否则程序会直接停止
        System.in.read();
    }
}
