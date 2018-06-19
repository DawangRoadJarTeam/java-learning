package cn.dawangroad.jarteam;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Unit test for simple App.
 */
class TestContainer {
    public static void main(String[] args) throws InterruptedException {

        Queue queue = new ArrayDeque();

        //todo 初始化
        Producer p = new Producer(queue);
        //todo 初始化
        Consumer c = new Consumer(queue);

        int i = 10;
        while (i != 0) {
            p.add(i++);
        }

        Thread cThread = new Thread(c);
        cThread.start();
        cThread.join();
    }

    static class Producer {

        private Queue queue;

        public Producer(Queue queue) {
            this.queue = queue;
        }

        public void add(Object task) {
            queue.add(task);
        }
    }

    static class Consumer implements Runnable {

        private Queue queue;

        public Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            Object task;
            while (true) {
                task = queue.poll();
                if (task != null) {
                    System.out.println("task" + task + " is running");
                }else{
                    System.out.println("task is empty");
                }
            }
        }
    }
}

