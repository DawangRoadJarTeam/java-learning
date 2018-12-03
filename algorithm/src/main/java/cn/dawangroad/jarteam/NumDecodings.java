package cn.dawangroad.jarteam;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * @author zhiyingyang
 * @version 2018-11-23 11:46
 */
public class NumDecodings {


    private static Set<String> codes = Sets.newHashSet("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "20", "21", "22", "23", "24", "25", "26");

    public static int numDecodings(String s) {
        if (s == null || s.isEmpty() || !s.matches("\\d+")) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = isCorrectCode(s.substring(0, 1)) ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            dp[i] = (isCorrectCode(s.substring(i - 1, i)) ? dp[i - 1] : 0)
                    +
                    (isCorrectCode(s.substring(i - 2, i)) ? dp[i - 2] : 0);

        }
        return dp[dp.length - 1];

    }

    private static boolean isCorrectCode(String code) {
        return codes.contains(code);
    }

    public static void main(String[] args) {
        System.out.println(new S().getV());
//        System.out.println(numDecodings("dsf2"));
//        System.out.println(numDecodings("1000"));
//        System.out.println(numDecodings("12"));
//        System.out.println(numDecodings("102"));
//        System.out.println(numDecodings("27"));
//        System.out.println(numDecodings("77126"));
//        System.out.println(numDecodings("000026"));
//        System.out.println(numDecodings("01"));
    }

    static class P {
        int v = 10;

        public P() {
            System.out.println(v);
            System.out.println(this.getV());
        }

        public int getV() {
            return v;
        }
    }

    static class S extends P {
        int v;

        public S() {
            super();
            System.out.println(v);
            v = 11;
        }

        public int getV() {
            return v;
        }
    }
}
