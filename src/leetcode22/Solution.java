package leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> results = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n - 1, 1, "(");

        return results;
    }

    private void generateParenthesis(int left, int neededClose, String s) {
        if (left == 0 && neededClose == 0) {
            results.add(s);
            return;
        }

        if (left == 0) {
            StringBuilder sBuilder = new StringBuilder(s);
            for (int i = 0; i < neededClose; i++) {
                sBuilder.append(")");
            }
            s = sBuilder.toString();
            results.add(s);
            return;
        }

        generateParenthesis(left - 1, neededClose + 1, s+"(");
        if (neededClose != 0) {
            generateParenthesis(left, neededClose - 1, s + ")");
        }
    }
}
