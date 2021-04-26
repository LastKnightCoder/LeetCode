package leetcode58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                } else {
                    break;
                }
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("a "));
    }
}
