package Hw4.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCalls {
    Queue<Integer> queue;
    public RecentCalls() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
