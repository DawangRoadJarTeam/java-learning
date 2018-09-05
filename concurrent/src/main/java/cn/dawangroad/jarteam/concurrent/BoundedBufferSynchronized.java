package cn.dawangroad.jarteam.concurrent;

/**
 * @author zhiyingyang
 * @version 2018-09-04 18:59
 */
public class BoundedBufferSynchronized {
    int count, putidx, takeidx;
    private Object[] items = new Object[2];
    private Object notEmpty = new Object();
    private Object notFull = new Object();

    public static void main(String[] args) throws InterruptedException {
        final BoundedBufferSynchronized bb = new BoundedBufferSynchronized();
        System.out.println(Thread.currentThread() + "," + bb);

        new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    while (true) {
                        System.out.println(Thread.currentThread() + ",put " + i);
                        bb.put(i++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            int i = 0;
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    while (true) {
//                        System.out.println(Thread.currentThread() + ",take " + i++);
//                        bb.take();
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        bb.take();
        bb.take();
    }

    public void put(Object obj) throws InterruptedException {
        synchronized (notFull) {
            while (count == items.length) {
                notFull.wait();
            }
        }
        items[putidx] = obj;
        if (++putidx == items.length) {
            putidx = 0;
        }
        count++;
        synchronized (notEmpty) {
            notEmpty.notify();
        }
    }

    public Object take() throws InterruptedException {
        synchronized (notEmpty) {
            while (count == 0) { // 啥也没有呢 取啥
                notEmpty.wait();
            }
        }
        Object x = items[takeidx];
        System.out.println("取第" + takeidx + "个元素" + x);
        if (++takeidx == items.length) {
            takeidx = 0;
        }
        count--;
        synchronized (notFull) {
            notFull.notify();
        }
        return x;
    }
}
