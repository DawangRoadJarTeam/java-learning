package cn.dawangroad.jarteam.hessian;

import com.caucho.hessian.client.HessianProxyFactory;

import java.io.IOException;

/**
 * hession 客户端
 *
 * @author zhiyingyang
 * @version 2018-06-20 12:04
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //RPC访问地址
        String url = "http://localhost:8080/hessian";

        //接口的动态代理工厂
        HessianProxyFactory factory = new HessianProxyFactory();
        IGreetingService greetingService = (IGreetingService) factory.create(IGreetingService.class, url);

        //远程方法调用
        System.out.println("hello(), " + greetingService.greeting("tom"));
    }
}
