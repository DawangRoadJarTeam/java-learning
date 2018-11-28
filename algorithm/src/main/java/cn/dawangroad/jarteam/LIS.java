package cn.dawangroad.jarteam;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhiyingyang
 * @version 2018-10-11 18:08
 */
public class LIS {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int[] arr = {5, 3, 4, 8, 6, 6, 6, 6, 6, 6, 7};
        System.out.println("lis:" + lis(arr, arr.length));
        System.out.println("fastNonDownLis:" + fastNonDownLis(arr, arr.length));
        System.out.println("fastIncreaseLis:" + fastIncreaseLis(arr, arr.length));
    }

    static int lis(int arr[], int n) {
        int[] d = new int[n];
        int len = 1;
        for (int i = 0; i < n; ++i) {
            d[i] = 1;
            for (int j = 0; j < i; ++j)
                if (arr[j] <= arr[i] && d[j] + 1 > d[i])
                    d[i] = d[j] + 1;
            if (d[i] > len) len = d[i];
        }
        return len;
    }


    static int fastNonDownLis(int d[], int n) {
        int i = 0, len = 1;
        int[] end = new int[n + 1];
        end[1] = d[0]; //初始化：长度为1的LIS末尾为d[0]
        for (i = 1; i < n; i++) {
            int pos = upperBound(end, 1, len, d[i]); //找到插入位置
            end[pos] = d[i];
            if (len < pos) //按需要更新LIS长度
                len = pos;
        }
        return len;
    }

    static int fastIncreaseLis(int d[], int n) {
        int i = 0, len = 1;
        int[] end = new int[n + 1];
        end[1] = d[0]; //初始化：长度为1的LIS末尾为d[0]
        for (i = 1; i < n; i++) {
            int pos = lowerBound(end, 1, len, d[i]); //找到插入位置
            end[pos] = d[i];
            if (len < pos) //按需要更新LIS长度
                len = pos;
        }
        return len;
    }

    //在非递减序列 arr[s..e]（闭区间）上二分查找第一个大于等于key的位置，如果都小于key，就返回e+1
    static int upperBound(int arr[], int s, int e, int key) {
        int mid;
        if (arr[e] < key)
            return e + 1;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (arr[mid] <= key) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }

    //在递增序列 arr[s..e]（闭区间）上二分查找第一个大于等于key的位置，如果都小于key，就返回e+1
    static int lowerBound(int arr[], int s, int e, int key) {
        int mid;
        if (arr[e] < key)
            return e + 1;
        while (s < e) {
            mid = s + (e - s) / 2;
            if (arr[mid] < key) {
                s = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }
}
