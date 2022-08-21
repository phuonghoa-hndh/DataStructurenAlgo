package Week2and3.Queue;
public class LinkedListQueue<E> implements Queue<E> {
    class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;
    @Override
    public void enqueue(E value) {
        if (top == null || bot == null) {
            Node node = new Node(value);
            top = bot = node;
            n = 1;
        }
        else {
            Node node = new Node(value);
            bot.next = node;
            bot = node;
            n++;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty())
        return null;

        E data = top.data;
        top = top.next;
        n--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return n;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<Integer>();

        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < data.length; i++) {
            queue.enqueue(data[i]);

            System.out.println("Size: " + queue.size());
            System.out.println(queue.dequeue() + " " + queue.dequeue());
            System.out.println("Size: " + queue.size());

            while (queue.isEmpty())
                System.out.println(queue.dequeue() + " ");
        }
    }
}