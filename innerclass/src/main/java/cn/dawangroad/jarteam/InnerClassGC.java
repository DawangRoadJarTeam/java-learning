package cn.dawangroad.jarteam;

import java.util.function.Function;

/**
 * 命令：
 * cd innerclass/src/main/java/
 * javac cn/dawangroad/jarteam/InnerClassGC.java
 * java -Xmn2m -Xms10m -Xmx10m -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly -XX:+HeapDumpOnOutOfMemoryError
 */
@SuppressWarnings("unchecked")
public class InnerClassGC {
//    private int j;

    public static void main(String[] args) {
        while (true) {
            InnerClassGC innerClassGC = new InnerClassGC();
            FunctionImpl function = new FunctionImpl();
        }

    }

    static class FunctionImpl implements Function<Object, Object> {

        private static final int _1M = 1024 * 1024;
        private static final byte[] o1 = new byte[1 * _1M];

        @Override
        public Object apply(Object o) {
            return null;
        }
    }
}
