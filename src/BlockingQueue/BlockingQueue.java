package BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Integer> q;
    private Integer capacity;
    public BlockingQueue(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    public Boolean addItem(int item) {
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            q.add(item);
            System.out.println("Item added : " + item);
            q.notifyAll();
            return true;
        }
    }

    public Integer remove() {
        synchronized (q) {
            while (q.isEmpty()) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Integer element = q.poll();
            System.out.println("Item popped : " + element);
            q.notifyAll();
            return element;
        }
    }

}
