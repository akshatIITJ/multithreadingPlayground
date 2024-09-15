public class DeadlockTester {
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        Thread thread1 = new Thread(() -> {
            deadlock.methodA();
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            deadlock.methodB();
        }, "thread2");

        thread1.start();
        thread2.start();

        while (true) {
            System.out.println("Thread 1 State = " + thread1.getState() + " || " + "Thread 2 State = " + thread2.getState());
            if (thread1.getState()==Thread.State.TERMINATED && thread2.getState()==Thread.State.TERMINATED) break;
        }
    }
}
