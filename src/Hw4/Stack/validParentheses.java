package Hw4.Stack;

import java.util.Stack;

public class validParentheses {
        public static boolean isValid(String expression) {
            Stack<Character> stack = new Stack<>();

            for (char ch : expression.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']' || ch == '}') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char top = stack.pop();
                        if ((ch == ')' && top != '(') ||
                                (ch == ']' && top != '[') ||
                                (ch == '}' && top != '{')) {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
}
