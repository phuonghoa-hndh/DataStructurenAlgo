package DSA.Hw1;

public class SimpleLinkedList<T> {
    public class Node{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        if (bot == null) {
            bot = top;
            bot = top;
        }
        n++;
    }

    public void addBot(T data){
        Node newNode = new Node(data);
        if (bot == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
//            throw new IndexOutOfBoundsException("Index out of bounds: " + i);

        }
        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        }
        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        current.data = data;
    }

    public boolean isContain(T data) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (isEmpty()) {
            return null;
        }
        T removedData = top.data;
        top = top.next;
        if (top == null) {
            bot = null;
        }
        n--;
        return removedData;
    }

    public T removeBot() {
        if (isEmpty()) {
            return null;
        }
        T removedData;
        if (top == bot) {
            removedData = top.data;
            top = null;
            bot = null;
        } else {
            Node current = top;
            while (current.next != bot) {
                current = current.next;
            }
            removedData = bot.data;
            current.next = null;
            bot = current;
        }
        n--;
        return removedData;
    }

    public void remove(T data) {
        if (isEmpty()) {
            return;
        }
        Node prev = null;
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                if (prev == null) {
                    top = current.next;
                } else {
                    prev.next = current.next;
                }
                if (current == bot) {
                    bot = prev;
                }
                n--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
