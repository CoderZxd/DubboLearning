package com.zxd.dubbo.learning.rpc.framework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project DubboLearning
 * @Package com.zxd.dubbo.learning.rpc.framework
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 14:32 2018/10/24.
 */
public class RpcFramework {

    /**
     * @FileName RpcFramework.java
     * @ClassName RpcFramework
     * @MethodName export
     * @Desc 暴露服务
     * @author zouxiaodong
     * @date 2018/10/24 15:06
     * @Params [service 服务实现, port 服务端口]
     * @return void
     */
    public static void export(final Object service,int port) throws IOException {
        if(service == null){
            throw new IllegalArgumentException("service instance == null");
        }
        if(port < 0 || port > 65535){
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println("Export service :" + service.getClass().getName() + " on port " + port);
        ServerSocket serverSocket = new ServerSocket(port);
        while (true){
            try {
                Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ObjectInputStream input = null;
                        ObjectOutputStream output = null;
                        try {
                            input = new ObjectInputStream(socket.getInputStream());
                            String methodName = input.readUTF();
                            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                            Object[] arguments = (Object[]) input.readObject();
                            output = new ObjectOutputStream(socket.getOutputStream());
                            Method method = service.getClass().getMethod(methodName,parameterTypes);
                            Object result = method.invoke(service,arguments);
                            output.writeObject(result);
                        } catch (Exception e) {
                            System.err.println("1."+e.getMessage());
                        }finally {
                            try {
                                if(output != null){
                                    output.close();
                                }
                                if(input != null){
                                    input.close();
                                }
                                if(socket != null){
                                    socket.close();
                                }
                            } catch (IOException e) {
                                System.err.println("2."+e.getMessage());
                            }
                        }
                    }
                }).start();
            }catch (Exception e){

            }
        }
    }

    /**
     * @FileName RpcFramework.java
     * @ClassName RpcFramework
     * @MethodName refer
     * @Desc 引用服务
     * @author zouxiaodong
     * @date 2018/10/24 15:32
     * @Params [interfaceClass 接口类型, host 服务器主机名, port 服务器端口]
     * @return T 远程服务
     */
    public static <T> T refer(final Class<T> interfaceClass,final String host,final int port){
        if(interfaceClass == null){
            throw new IllegalArgumentException("Interface class == null");
        }
        if(!interfaceClass.isInterface()){
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        }
        if (host == null || host.length() == 0) {
            throw new IllegalArgumentException("Host == null!");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host,port);
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(args);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                try {
                    Object result = input.readObject();
                    if(result instanceof Throwable){
                        throw  (Throwable)result;
                    }
                    return result;
                }finally {
                    input.close();
                    output.close();
                    socket.close();
                }
            }
        });
    }
}
