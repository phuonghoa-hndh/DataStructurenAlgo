package Week2and3.Stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {

    private E[] stack;
    private int top = 0;
    private int capacity = 100;

    public ArrayStack(){
        stack = (E[]) new Object[capacity];
    }

    public ArrayStack(int capacity){

    }

    @Override
    public void push(E element) {
        if (size() >= stack.length)
            stack = Arrays.copyOf(stack, stack.length*3/2);
        stack[top++] = element;
        //stack[top] = element; top++
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            E data = stack[top - 1];
            top--;
            return data;
        }
        else
            return null;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public int size() {
        return top;
    }
    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < data.length; i++)
            stack.push(data[i]);
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());

    }
}
