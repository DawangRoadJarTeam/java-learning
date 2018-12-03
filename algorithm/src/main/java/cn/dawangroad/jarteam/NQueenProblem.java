package cn.dawangroad.jarteam;

/**
 * @author zhiyingyang
 * @version 2018-12-03 15:02
 */
public class NQueenProblem {
    private static final int N = 2;
    int sum = 0;
    private int[] x = new int[N];

    public static void main(String[] args) {
        NQueenProblem quene = new NQueenProblem();

        quene.backTack(0);

        System.out.println(quene.sum);

    }

    /**
     * 回溯寻找
     *
     * @param n
     */
    void backTack(int n) {


        if (n == N) {
            for (int i = 0; i < x.length; i++) {
                System.out.print("x[" + i + "] = " + x[i] + ",");
            }
            System.out.println();
            sum++;
        } else {
            for (int i = 0; i < N; i++) {
                x[n] = i;
                if (isPlace(n)) {//如果第n行可以放，继续看n + 1行
                    backTack(n + 1);
                }
            }
        }
    }

    /**
     * 在i行可否放置皇后   0 <= i <= n
     *
     * @param i
     * @return
     */
    private boolean isPlace(int i) {

        for (int j = 0; j < i; j++) {
            if (Math.abs(i - j) == Math.abs(x[i] - x[j]) || x[i] == x[j]) {
                return false;
            }
        }
        return true;
    }
}
