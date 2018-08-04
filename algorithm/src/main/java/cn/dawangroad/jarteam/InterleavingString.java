package cn.dawangroad.jarteam;

/**
 * @author zhiyingyang
 * @version 2018-08-04 17:40
 */
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null) {
            return (s1 == null) && (s2 == null);
        }

        if (s1 == null || s1.isEmpty()) {
            return s3.equals(s2);
        }

        if (s2 == null || s2.isEmpty()) {
            return s3.equals(s1);
        }

        int s1n = s1.length();
        int s2n = s2.length();
        int s3n = s3.length();

        if (s3n != (s1n + s2n)) {
            return false;
        }

        return  isInterleave(s1, 0, s2, 0, s3, 0);
    }

    private static boolean isInterleave(String s1, int s1Start, String s2, int s2Start, String s3, int s3Start) {
        if (s1Start >= s1.length()) {
            return s3.substring(s3Start).equals(s2.substring(s2Start));
        }

        if (s2Start >= s2.length()) {
            return s3.substring(s3Start).equals(s1.substring(s1Start));
        }

        if (s1.charAt(s1Start) != s3.charAt(s3Start) && s2.charAt(s2Start) != s3.charAt(s3Start)) {
            return false;
        }

        if (s1.charAt(s1Start) == s3.charAt(s3Start) && s2.charAt(s2Start) == s3.charAt(s3Start)) {
            return isInterleave(s1, s1Start + 1, s2, s2Start, s3, s3Start + 1) || isInterleave(s1, s1Start, s2, s2Start + 1, s3, s3Start + 1);
        } else if (s1.charAt(s1Start) == s3.charAt(s3Start)) {
            return isInterleave(s1, s1Start + 1, s2, s2Start, s3, s3Start + 1);
        } else if (s2.charAt(s2Start) == s3.charAt(s3Start)) {
            return isInterleave(s1, s1Start, s2, s2Start + 1, s3, s3Start + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";

//        String s1 ="aabcc";
//        String s2 ="dbbca";
//        String s3 ="aadbbcbcac";

        System.out.println("args = [" + InterleavingString.isInterleave(s1, s2, s3) + "]");
    }
}
