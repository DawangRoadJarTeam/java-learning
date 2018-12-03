package cn.dawangroad.jarteam;

import com.google.common.collect.Queues;

import java.util.Queue;

/**
 * @author zhiyingyang
 * @version 2018-12-03 15:35
 */
public class HorsePathSearch {
    // "日"子x坐标
    public int[] fx = {1, 2, 2, 1, -1, -2, -2, -1};
    // "日"子y坐标
    public int[] fy = {2, 1, -1, -2, -2, -1, 1, 2};
    // 棋盘行数
    private int n;
    // 棋盘列数
    private int m;
    // 马的起始x坐标
    private int x;
    // 马的起始y坐标
    private int y;
    // 棋盘坐标
    private int[][] a;
    // 求解总数
    private int count;

    /**
     * 构造方法
     *
     * @param _n
     * @param _m
     * @param _x
     * @param _y
     */
    public HorsePathSearch(int _n, int _m, int _x, int _y) {
        n = _n;
        m = _m;
        x = _x;
        y = _y;
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = 0;
            }
        }
        // 马的起点
        a[x][y] = 1;
        count = 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 注意(0<=x<n && 0<=y<m)
        int n = 5;
        int m = 4;
        int x = 0;
        int y = 0;
        HorsePathSearch rs = new HorsePathSearch(n, m, x, y);
        rs.findShortestFromZero();
//        System.out.println("######################");
//        System.out.println("总解数count=" + rs.getCount());
//        System.out.println("######################");

    }

    public void find(int x, int y, int dep) {
        int i, xx, yy;
        for (i = 0; i < 7; i++) {
            xx = x + fx[i];
            yy = y + fy[i];
            // 判断新坐标是否出界，是否已走过
            if (check(xx, yy) == 1) {
                a[xx][yy] = dep;
                if (dep == n * m) {
                    output();
                } else {
                    // 从新坐标出发，递归下一层
                    find(xx, yy, dep + 1);
                }
                // 回溯，恢复未走标志
                a[xx][yy] = 0;
            }
        }
    }

    public void findShortestFromZero() {

        Queue<Point> queue = Queues.newArrayDeque();
        queue.offer(Point.of(0, 0, 0, null));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int dep = point.dep + 1;


            for (int i = 0; i < 7; i++) {
                int nx = x + fx[i];
                int ny = y + fy[i];
                // 判断新坐标是否出界，是否已走过
                Point nextPoint = Point.of(nx, ny, dep, point);
                if (check(nx, ny) == 1) {
                    a[nx][ny] = 1;
                    if (nx == n - 1 && ny == m - 1) {
                        print(nextPoint);
                        output();
                    } else {
                        queue.offer(nextPoint);
                    }
                }
            }
        }
    }

    private void print(Point point) {
        System.out.println("count=" + point.dep);
        System.out.println("");
        while (point != null) {
            System.out.print(point.x + "," + point.y);
            point = point.pre;
            if (point != null) {
                System.out.print(" <- ");
            }
        }

        System.out.println("");
    }

    /**
     * 判断新坐标是否出界，是否已走过
     *
     * @param xx
     * @param yy
     * @return
     */
    public int check(int xx, int yy) {
        if (xx >= n || yy >= m || xx < 0 || yy < 0 || a[xx][yy] != 0) {
            return 0;
        }
        return 1;
    }

    /**
     * 输出结果
     */
    public void output() {
        count++;
        System.out.println("count=" + count);
        for (int y = 0; y < n; y++) {
            System.out.println("");
            for (int x = 0; x < m; x++) {
                System.out.print(a[y][x] + " ");
            }
        }
        System.out.println("");
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    static class Point {
        private int x;
        private int y;
        private int dep;
        private Point pre;

        public Point(int x, int y, int dep, Point pre) {
            this.x = x;
            this.y = y;
            this.dep = dep;
            this.pre = pre;
        }

        public static Point of(int x, int y, int dep, Point pre) {
            return new Point(x, y, dep, pre);
        }
    }
}
