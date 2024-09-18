package Hw4.Stack;

import java.util.*;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }

    Node stack = null;

    @Override
    public void push(E element) {
        Node node = new Node();
        node.element = element;
        node.next = stack;
        stack = node;
    }

    public E pop() {
        if (stack == null) {
            System.out.println("Empty Stack");
            return null;
        } else {
            E element = stack.element;
            stack = stack.next;
            return element;
        }
    }

    public boolean isEmpty() {
        return stack == null;
    }

    public E top() {
        if (stack == null) {
            System.out.println("Empty Stack");
            return null;
        } else {
            return stack.element;
        }
    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }
    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}

