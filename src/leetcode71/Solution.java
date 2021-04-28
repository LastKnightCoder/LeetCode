package leetcode71;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        // 这一步经典，处理起来方便，佩服我自己
        path = path + "/";
        List<String> paths = new ArrayList<>();
        while (!path.equals("")) {
            if (path.startsWith("../")) {
                // 这是从 Vue 源码学到的，解析完的部分就干掉
                path = path.substring(3);
                if (!paths.isEmpty()) {
                    paths.remove(paths.size() - 1);
                }
            } else if (path.startsWith("./")) {
                path = path.substring(2);
            } else if (path.startsWith("/")) {
                int count = 1;
                for (int i = 1; i < path.length(); i++) {
                    if (path.charAt(i) == '/') {
                        count++;
                    } else {
                        break;
                    }
                }
                path = path.substring(count);
            } else if (path.startsWith(" ")) {
                int count = 1;
                for (int i = 1; i < path.length(); i++) {
                    if (path.charAt(i) == ' ') {
                        count++;
                    }else {
                        break;
                    }
                }
                path = path.substring(count);
            } else {
                int index = path.indexOf("/");
                paths.add(path.substring(0, index));
                path = path.substring(index + 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (paths.size() == 0) {
            stringBuilder.append("/");
            return stringBuilder.toString();
        }

        for (String s : paths) {
            stringBuilder.append("/").append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = ".././a/b/../s/e///////a/a/a/a/ ../   ../hello/yes";
        path = new Solution().simplifyPath(path);
        System.out.println(path);
    }
}
