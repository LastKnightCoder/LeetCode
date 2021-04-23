package leetcode38;

public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            str = describe(str);
        }

        return str;
    }

    private String describe(String str) {
        int start = 0;
        int end = 1;
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        while (end < str.length()) {
            if (chars[start] != chars[end]) {
                stringBuilder.append(end - start);
                stringBuilder.append(chars[start]);
                start = end;
            }
            end++;
        }

        stringBuilder.append(end - start);
        stringBuilder.append(chars[start]);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(5));
    }
}
