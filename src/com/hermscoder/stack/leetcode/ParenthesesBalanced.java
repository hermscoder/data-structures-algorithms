package com.hermscoder.stack.leetcode;

public class ParenthesesBalanced {
    public static void main(String[] args) {
        String s1 = "()()()";
        String s2 = "()(()";
        String s3 = "(()())";
        System.out.println(isBalancedParentheses(s1)); // true
        System.out.println(isBalancedParentheses(s2)); // false
        System.out.println(isBalancedParentheses(s3)); // true

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
        */
    }

    public static boolean isBalancedParentheses2(String str) {
        if (str.length() % 2 != 0) {
            return false;
        } else if (str.isEmpty()) {
            return true;
        }

        Stack<Character> openingParentheses = new Stack<>();
        Stack<Character> closingParentheses = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                openingParentheses.push(c);
            } else if (c == ')') {
                closingParentheses.push(c);
            }
        }
        return openingParentheses.size() == closingParentheses.size();
    }

    public static boolean isBalancedParentheses(String str) {
        Stack<Character> charStack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                charStack.push(c);
            } else if (c == ')') {
                if (charStack.isEmpty() || charStack.pop() != '(') {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}
