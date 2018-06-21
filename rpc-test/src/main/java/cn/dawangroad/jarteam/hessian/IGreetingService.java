package cn.dawangroad.jarteam.hessian;

import java.io.IOException;

/**
 * @author zhiyingyang
 * @version 2018-06-19 20:49
 */
public interface IGreetingService {
    String greeting(String name) throws IOException;
}
