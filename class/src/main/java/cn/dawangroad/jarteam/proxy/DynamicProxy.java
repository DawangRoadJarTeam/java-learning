package cn.dawangroad.jarteam.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhiyingyang
 * @version 2019-01-04 17:19
 */
public class DynamicProxy {
    public static void main(String[] args) {
        // 2. 然后在需要使用HelloConcrete的时候，通过CGLIB动态代理获取代理对象。
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete hello = (HelloConcrete) enhancer.create();
        System.out.println(hello.sayHello("I love you!"));

    }

    public static class HelloConcrete {

        /**
         * static方法不可以被代理
         */
        public static String sayHello(String str) {
            return "HelloConcrete: " + str;
        }
    }

    public static class MyMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("You said: " + Arrays.toString(args));
            return proxy.invokeSuper(obj, args);
        }
    }

}
