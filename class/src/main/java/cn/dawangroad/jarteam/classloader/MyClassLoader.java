package cn.dawangroad.jarteam.classloader;

import sun.rmi.rmic.iiop.ClassPathLoader;
import sun.tools.java.ClassPath;

/**
 * @author zhiyingyang
 * @version 2018-12-12 18:17
 */
public class MyClassLoader extends ClassPathLoader {

    public MyClassLoader(ClassPath classPath) {
        super(classPath);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if(name.startsWith("java")){
                c = super.loadClass(name, resolve);

            }

            if (c == null) {
                long t0 = System.nanoTime();

                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                c = findClass(name);

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader(new ClassPath("/Users/ervin/Study/practice-code/java-learning/class-init-order/target/classes"));
        System.out.println(myClassLoader.loadClass("jdk.net.Sockets").newInstance().toString());
    }
}
