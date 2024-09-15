import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadpoolTester {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores in the system = " + cores);
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        // to check how fast the os can context switch, give the below line a try
        // ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new HeavyTask());
        }
    }
}

class HeavyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Heavy task started by Thread : " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Heavy task ended");

    }
}
