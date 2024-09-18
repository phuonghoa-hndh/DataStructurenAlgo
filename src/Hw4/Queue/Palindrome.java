package Hw4.Queue;
import Hw4.Stack.StackInterface;
import Hw4.Stack.ArrayStack;

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        StackInterface<Character> stack = new ArrayStack<Character>(s.length());
        QueueInterface<Character> queue = new ArrayQueue<Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            queue.enqueue(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
}
