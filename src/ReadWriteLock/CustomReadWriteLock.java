package ReadWriteLock;

public class CustomReadWriteLock {
    private int readers = 0;       // Number of active readers
    private int writers = 0;       // Number of active writers
    private int writeRequests = 0; // Number of pending write requests

    // Acquire the read lock
    public synchronized void acquireReadLock() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        readers++;
    }

    // Release the read lock
    public synchronized void releaseReadLock() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    // Acquire the write lock
    public synchronized void acquireWriteLock() throws InterruptedException {
        writeRequests++;
        while (readers > 0 || writers > 0) {
            wait();
        }
        writeRequests--;
        writers++;
    }

    // Release the write lock
    public synchronized void releaseWriteLock() {
        writers--;
        notifyAll();
    }
}

