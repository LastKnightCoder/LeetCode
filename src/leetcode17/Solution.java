package leetcode17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> lists = new ArrayList<>();

        if (digits.length() == 0) return lists;

        HashMap<String, String[]> maps = new HashMap<>();
        maps.put("1", new String[]{""});
        maps.put("2", new String[]{"a", "b", "c"});
        maps.put("3", new String[]{"d", "e", "f"});
        maps.put("4", new String[]{"g", "h", "i"});
        maps.put("5", new String[]{"j", "k", "l"});
        maps.put("6", new String[]{"m", "n", "o"});
        maps.put("7", new String[]{"q", "p", "r", "s"});
        maps.put("8", new String[]{"t", "u", "v"});
        maps.put("9", new String[]{"w", "x", "y", "z"});

        ArrayList<String> init = new ArrayList<>();
        init.add("");

        lists = Arrays.stream(digits.split(""))
                                        .map(s -> Arrays.asList(maps.get(s)))
                                        .reduce(init ,(pre, cur) -> {
                                            List<String> list = new ArrayList<>();
                                            for (String p: pre) {
                                                for (String c: cur) {
                                                    list.add(p+c);
                                                }
                                            }
                                            return list;
                                        });

        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
