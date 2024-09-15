package BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQ {
    private Queue<Integer> queue;
    private Integer capacity;

    public BlockingQ(Integer capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public Boolean add(Integer item) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queue.add(item);
            queue.notifyAll();
            return true;
        }

    }

    public Integer remove() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Integer element = queue.poll();
            queue.notifyAll();
            return element;
        }
    }


}
