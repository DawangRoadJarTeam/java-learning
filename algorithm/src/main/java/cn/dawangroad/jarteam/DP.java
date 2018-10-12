package cn.dawangroad.jarteam;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiyingyang
 * @version 2018-10-11 17:08
 */
public class DP {
    private static final int[] coins = {3, 3, 5};

    public static int minCoinNums(int x) {
        if (x < coins[0]) {
            return 0;
        }

        for (int coin : coins) {
            if (coin == x) {
                return 1;
            }
        }

        int cur = 0;
        for (int coin : coins) {
            int preMin = minCoinNums(x - coin);
            if (preMin == 0) {
                continue;
            }
            if (cur == 0 || preMin + 1 < cur) {
                cur = preMin + 1;
            }
        }

        return cur;
    }

    public static List<Integer> minCoinNumsNoneRecursive(int x) {
        if (x < coins[0]) {
            return new ArrayList<>();
        }

        List<Integer>[] coinNumNeeded = new ArrayList[x + 1];

        for (int i = 0; i <= x; i++) {
            List<Integer> cur = Lists.newArrayList();

            for (int coin : coins) {
                if (i - coin == 0) {
                    cur = Lists.newArrayList(coin);
                    continue;
                }

                if (i - coin < 0 || coinNumNeeded[i - coin].size() == 0) {
                    continue;
                }

                if (cur.size() == 0 || coinNumNeeded[i - coin].size() + 1 < cur.size()) {
                    cur = new ArrayList<Integer>();
                    cur.addAll(coinNumNeeded[i - coin]);
                    cur.add(coin);
                }
            }

            coinNumNeeded[i] = cur;
        }

        return coinNumNeeded[x];
    }

    public static void main(String[] args) {
        print(0);
        print(1);
        print(2);
        print(3);
        print(4);
        print(5);
        print(6);
        print(7);
        print(8);
        print(9);
        print(10);
        print(11);
        print(12);
        print(102);
    }

    public static void print(int x) {
        List<Integer> coins = minCoinNumsNoneRecursive(x);
        System.out.print(String.format("sum:%d, min coins: %d, coins:", x, coins.size()));
        for (Integer coin : coins) {
            System.out.print(coin + " ");
        }
        System.out.println();
//        System.out.println(String.format("sum:%d, min coins:%d %d", x, minCoinNums(x), minCoinNumsNoneRecursive(x)));
    }
}
