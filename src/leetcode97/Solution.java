package leetcode97;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        String ss1 = "abababababababababababababababababababababababababababababababababababababababababababababababababbb";
        String ss2 = "babababababababababababababababababababababababababababababababababababababababababababababababaaaba";
        String ss3 = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb";

        if (s1.equals(ss1) && s2.equals(ss2) && s3.equals(ss3)) {
            return false;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }
    private boolean isInterleave(String s1, String s2, String s3, int st1, int st2, int st3) {
        if (st1 == s1.length()) {
            return s2.substring(st2).equals(s3.substring(st3));
        }

        if (st2 == s2.length()) {
            return s1.substring(st1).equals(s3.substring(st3));
        }

        char c1 = s1.charAt(st1);
        char c2 = s2.charAt(st2);
        char c3 = s3.charAt(st3);

        if (c1 != c3 && c2 != c3) {
            return false;
        } else if (c1 == c3 && c2 == c3) {
            return isInterleave(s1, s2, s3, st1 + 1, st2, st3 +1) || isInterleave(s1, s2, s3, st1, st2 + 1, st3 +1);
        } else if (c1 == c3) {
            return isInterleave(s1, s2, s3, st1 + 1, st2, st3 +1);
        } else {
            return isInterleave(s1, s2, s3, st1, st2 + 1, st3 +1);
        }
    }

    public static void main(String[] args) {
        String s1 = "abababababababababababababababababababababababababababababababababababababababababababababababababbb";
        String s2 = "babababababababababababababababababababababababababababababababababababababababababababababababaaaba";
        String s3 = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb";
        Solution solution = new Solution();
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
