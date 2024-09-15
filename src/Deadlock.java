public class Deadlock {
    String lock1;
    String lock2;
    public Deadlock() {
        lock1 = "Akshat";
        lock2 = "Mehra";
    }

    public void methodA() {
        synchronized (lock1) {
            System.out.println("lock1 acquired by current thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                System.out.println("lock2 acquired by current thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void methodB() {
        synchronized (lock2) {
            System.out.println("lock2 acquired by current thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock1) {
                System.out.println("lock1 acquired by current thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
