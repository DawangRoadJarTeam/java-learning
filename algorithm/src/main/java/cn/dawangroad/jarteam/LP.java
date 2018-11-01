package cn.dawangroad.jarteam;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiyingyang
 * @version 2018-10-11 18:08
 */
public class LP {
    public static int longestPalindrome(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        int maxLen = 0;
        for (int i = 0; i < n; i++) {  // i作为终点
            int j = i;    //j作为起点
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    maxLen = Math.max(maxLen, i - j + 1);
                }
                j--;
            }
        }
        return maxLen;
    }

    public static void allPalindrome(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
//        int maxLen = 0;
        for (int i = 0; i < n; i++) {  // i作为终点
            int j = i;    //j作为起点
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
//                    maxLen = Math.max(maxLen, i - j + 1);
                }
                j--;
            }
        }

        Set<String> sets = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 0) {
                if (pal[j][i]) {
                    sets.add(s.substring(j, i + 1));
                }
                j--;
            }
        }

        for (String str : sets) {
            System.out.println(str);

        }

//        return maxLen;
    }

    public static void main(String[] args) {
        String str = "fddfdsfsd23232e432sfds";
        System.out.println("str = " + str);
        System.out.println("longestPalindrome = [" + longestPalindrome(str) + "]");
        allPalindrome(str);
    }
}
