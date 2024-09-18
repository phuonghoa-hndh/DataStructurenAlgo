package Hw4.Stack;

import java.util.*;

public class ArrayStack <E> implements StackInterface<E> {
    private E[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = (E[]) new Object[capacity];
        top = -1;
    }

    public void push(E element) {
        if (top == capacity - 1 ) {
            System.out.println("Full Stack");
        }
        else {
            stack[++top] = element;
        }
    }

    public E pop() {
        if (top == -1) {
            System.out.println("Empty Stack");
        return null;
        }
        else {
            return stack[top--];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public E top(){
        if (top == -1) {
            System.out.println("Empty Stack");
            return null;
        }
        else {
            return stack[top];
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i <= top; i++) {
            s += stack[i] + " ";
        }
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = top;

            @Override
            public boolean hasNext() {
                return i > -1;
            }

            @Override
            public E next() {
                return stack[i--];
            }
        };
    }

}
