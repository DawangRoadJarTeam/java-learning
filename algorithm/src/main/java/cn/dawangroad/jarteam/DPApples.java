package cn.dawangroad.jarteam;

import com.sun.xml.internal.ws.util.StreamUtils;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author zhiyingyang
 * @version 2018-10-17 17:56
 */
public class DPApples {
    static int N = 3, M = 4;

    static int[][] apples = {
            {1, 1, 3, 999},
            {2, 4, 5, 2},
            {3, 6, 7, 1}};

    static int[][] maxApples = new int[N][M];

//    @SuppressWarnings("Since15")
    public static void main(String[] args) {
//        System.out.println(apples());
        int[] arr = {1, 2, 3 ,4};


        Arrays.stream(arr).forEach(e ->{
            System.out.println(e);
        });
    }

    static int apples() {
        int n = 0;
        int m = 0;
//        maxApples[n][m] = apples[n][m];

        int mostMax = 0;
        while (n < N) {
            while (m < M) {
//                int cur = m + 1;
                maxApples[n][m] = apples[n][m] + maxSon(n, m);
                if (mostMax < maxApples[n][m]) {
                    mostMax = maxApples[n][m];
                }
                m++;
            }
            m = 0;
            n++;
        }

        return mostMax;
    }

    private static int maxSon(int n, int cur) {
        int maxSon1 = 0, maxSon2 = 0;
        if (n > 0) {
            maxSon1 = maxApples[n - 1][cur];
        }
        if (cur > 0) {
            maxSon2 = maxApples[n][cur - 1];
        }
        return maxSon1 > maxSon2 ? maxSon1 : maxSon2;
    }
}
