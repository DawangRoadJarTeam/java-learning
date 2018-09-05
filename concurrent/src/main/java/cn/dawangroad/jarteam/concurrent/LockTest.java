package cn.dawangroad.jarteam.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static Logger logger = LoggerFactory.getLogger(LockTest.class);
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {
        final LockTest bb = new LockTest();
        logger.info(Thread.currentThread() + "," + bb);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    bb.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bb.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void put() throws InterruptedException {
        logger.info("进入put");
        lock.lock();
        logger.info("put lock 锁住");
        condition.signal();
        logger.info("put lock 解锁");
        lock.unlock();
    }

    public void take() throws InterruptedException {
        lock.lock();
        logger.info("take lock 锁住");
        condition.await();
        logger.info("take await 释放");
//        lock.unlock();
//        logger.info("take lock 解锁");
    }
}
