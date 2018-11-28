package cn.dawangroad.jarteam.concurrent;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * Description: DemonstrateDeadlock
 *
 * @author ervin
 * @version 2018-11-2323:59
 */
public class DemonstrateDeadlock {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {

        int initialCapacity = 32;
        System.out.println(tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
        System.out.println(tableSizeFor(1));
//        final Random rnd = new Random();
//        final InduceLockOrder.Account[] accounts = new InduceLockOrder.Account[NUM_ACCOUNTS];
//
//        for (int i = 0; i < accounts.length; i++)
//            accounts[i] = new InduceLockOrder.Account();
//
//        class TransferThread extends Thread {
//            public void run() {
//                for (int i = 0; i < NUM_ITERATIONS; i++) {
//                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
//                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
////                    InduceLockOrder.DollarAmount amount = new InduceLockOrder.DollarAmount(rnd.nextInt(1000));
////                    try {
////                        DynamicOrderDeadlock.transferMoney(accounts[fromAcct], accounts[toAcct], amount);
////                    } catch (DynamicOrderDeadlock.InsufficientFundsException ignored) {
////                    }
//                }
//            }
//        }
//        for (int i = 0; i < NUM_THREADS; i++)
//            new TransferThread().start();
    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}

