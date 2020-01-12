package com.company;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String num = "/../";
        System.out.print(simplifyPath(num));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String m : path.split("/")) {
            if ("..".equals(m)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(m) && !m.isEmpty()) {
                stack.push(m);
            }
        }
        return "/" + String.join("/", stack);
    }
}
