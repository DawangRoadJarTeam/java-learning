package cn.dawangroad.jarteam.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private static Logger logger = LoggerFactory.getLogger(BoundedBuffer.class);
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[2]; // 阻塞队列
    int putptr, takeptr, count;

    public static void main(String[] args) throws InterruptedException {
        final BoundedBuffer bb = new BoundedBuffer();
        logger.info(Thread.currentThread() + "," + bb);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    logger.info(Thread.currentThread() + "," + bb);
                    bb.put("xx");
                    bb.put("yy");
                    bb.put("zz");
                    bb.put("zz");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info(Thread.currentThread() + "," + bb);
                    bb.take();
                    bb.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void put(Object x) throws InterruptedException {
        logger.info("进入put");
        lock.lock();
        logger.info("put lock 锁住");
        try {
            while (count == items.length) { // 如果队列满了，notFull就一直等待
                logger.info("put notFull 等待");
                notFull.await(); // 调用await的意思取反，及not notFull -> Full
            }
            items[putptr] = x; // 终于可以插入队列
            if (++putptr == items.length)
                putptr = 0; // 如果下标到达数组边界，循环下标置为0
            ++count;
            logger.info("put notEmpty 唤醒");
            notEmpty.signal(); // 唤醒notEmpty
        } finally {
            logger.info("put lock 解锁");
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        logger.info("take lock 锁住");
        try {
            while (count == 0) {
                logger.info("take notEmpty 等待");
                notEmpty.await();
                logger.info("take notEmpty 等待 停止");
            }
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            logger.info("take notFull 唤醒");
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
            logger.info("take lock 解锁");
        }
    }
}
