package Hw4.Stack;

import java.util.*;

public class ValidExpression {
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


    public static int evaluateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        expression = insertBlanks(expression);

        String[] tokens = expression.split(" ");


        for (String token: tokens) {
            if (token.length() == 0)
                continue;
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operators.isEmpty() &&
                        (operators.peek() == '+' ||
                                operators.peek() == '-' ||
                                operators.peek() == '*' ||
                                operators.peek() == '/')) {
                    processAnOperator(operands, operators);
                }

                operators.push(token.charAt(0));
            }
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operators.isEmpty() &&
                        (operators.peek() == '*' ||
                                operators.peek() == '/')) {
                    processAnOperator(operands, operators);
                }

                operators.push(token.charAt(0));
            }
            else if (token.trim().charAt(0) == '(') {
                operators.push('(');
            }
            else if (token.trim().charAt(0) == ')') {
                while (operators.peek() != '(') {
                    processAnOperator(operands, operators);
                }
                operators.pop();
            }
            else {
                operands.push(Integer.valueOf(token));
            }
        }
        while (!operators.isEmpty()) {
            processAnOperator(operands, operators);
        }
        return operands.pop();
    }

    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }

    public static String insertBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String expression = sc.nextLine();

        if (isValid(expression)) {
            System.out.println(evaluateExpression(expression));
        } else {
            System.out.println("Invalid expression");
        }

    }
}


