public class ThreadTester {

    public static void main(String[] args) {
        /*
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1);
                for (int i=10; i>0; i--);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        thread.start();

        while (true) {
            Thread.State state = thread.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED) break;
        }

//        thread.start();
*/


        System.out.println("Main is starting");
        System.out.println("Priority of main thread is : " + Thread.currentThread().getPriority());
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "Our Thread");

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Priority of child thread is : " + thread.getPriority());
        System.out.println("Main is exiting");
    }
}
