package cn.dawangroad.jarteam;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:+PrintGCDetails -XX:MaxDirectMemorySize=500M
 *
 * @author zhiyingyang
 * @version 2018-07-05 15:05
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {


        int count = 0;

        List<ByteBuffer> bufs = new ArrayList<ByteBuffer>();

        while (true) {
            count++;
            System.out.println("count=" + count);
            Thread.sleep(100000);
            System.out.println("allocate direct.");
            ByteBuffer buf = ByteBuffer.allocateDirect(_1MB * 200);

            // 将引用加入集合中防止被GC回收导致直接内存被释放
            bufs.add(buf);
        }
    }

}
