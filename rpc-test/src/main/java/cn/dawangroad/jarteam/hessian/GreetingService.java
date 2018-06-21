package cn.dawangroad.jarteam.hessian;

import com.caucho.hessian.server.HessianServlet;

import java.io.IOException;

/**
 * service 启动：
 * 1. cd rpc-test
 * 2. mvn jetty:run
 *
 * @author zhiyingyang
 * @version 2018-06-19 20:49
 */
public class GreetingService extends HessianServlet implements IGreetingService {
    private static final long serialVersionUID = -3537274030227675984L;

    @Override
    public String greeting(String name) throws IOException {
        System.out.println("name = [" + name + "]");
        return "Welcome ot the Hassian world, " + name;
    }
}
