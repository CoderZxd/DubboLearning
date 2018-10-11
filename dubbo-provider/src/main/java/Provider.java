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
        System.out.println("Dubbo provider started!");
        // 阻塞当前进程，否则程序会直接停止
        System.in.read();
    }
}
