package ReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) {
        CustomReadWriteLock lock = new CustomReadWriteLock();

        Runnable reader = () -> {
            try {
                lock.acquireReadLock();
                System.out.println(Thread.currentThread().getName() + " is reading");
                Thread.sleep(1000);
                lock.releaseReadLock();
                System.out.println(Thread.currentThread().getName() + " finished reading");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writer = () -> {
            try {
                lock.acquireWriteLock();
                System.out.println(Thread.currentThread().getName() + " is writing");
                Thread.sleep(1000);
                lock.releaseWriteLock();
                System.out.println(Thread.currentThread().getName() + " finished writing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Create and start reader and writer threads
        Thread t1 = new Thread(reader);
        Thread t2 = new Thread(writer);
        Thread t3 = new Thread(reader);

        t1.start();
        t2.start();
        t3.start();
    }
}

