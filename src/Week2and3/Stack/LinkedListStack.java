package Week2and3.Stack;
//import java.util.Iterator;
public class LinkedListStack<E> implements Stack<E> {
    private class Node {
        E data;
        Node next;

        public Node(E element){
            this.data = element;
            this.next = null;
        }
    }

    private Node head = null;
    public void push(E data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public E pop(){
        E e = head.data;
        head = head.next;
        return e;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        Node p = head;
        int count = 0;
        while (p != null){
            p = p.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<>();
        //java.util.Stack<Integer> javaStack = new Stack<>();
        Stack<Character> charStack = new LinkedListStack<>();
        for (char i = 'A'; i < 'Z'; i++)
            charStack.push(i);

        for (int i=0; i<10; i++){
            stack.push(i);
        }

        System.out.println("Size of stack = " + stack.size());
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        System.out.println("Size of stack = " + stack.size());
    }
}