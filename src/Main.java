import BlockingQueue.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BlockingQueue blockingQueue = new BlockingQueue(5);

        Thread thread1 = new Thread(() ->
                blockingQueue.addItem(5));

        Thread thread2 = new Thread(() ->
                blockingQueue.addItem(6));

        Thread thread3 = new Thread(() ->
                blockingQueue.addItem(8));

        Thread thread4 = new Thread(() ->
                blockingQueue.remove());

        Thread thread5 = new Thread(() ->
                blockingQueue.remove());

        thread5.start();
        thread4.start();
        thread2.start();
        thread3.start();
        thread1.start();
    }
}