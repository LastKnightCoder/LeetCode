package leetcode10;

public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int indexS, int indexP) {
        if (indexS == s.length() && indexP == p.length()) {
            return true;
        }

        if (indexP == p.length()) {
            return false;
        }

        // s: "" p: "c*c*"
        if (indexS == s.length()) {
            if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
                return isMatch(s, p, indexS, indexP + 2);
            }
            return false;
        }

        if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
            if (p.charAt(indexP) == '.' || s.charAt(indexS) == p.charAt(indexP)) {
                // 不匹配
                if (isMatch(s, p, indexS, indexP + 2)) {
                    return true;
                }
                // 匹配一个
                if (isMatch(s, p, indexS + 1, indexP + 2)) {
                    return true;
                }
                // 匹配多个
                return isMatch(s, p, indexS + 1, indexP);
            } else {
                return isMatch(s, p, indexS, indexP + 2);
            }
        } else if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
            return isMatch(s, p, indexS + 1, indexP + 1);
        }


        return false;
    }
}
