import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);

        // Corrected Test for Scenario 2
        Future<?> future = service.submit(() -> {
            System.out.println("Task has started.");
            Thread.sleep(3000);
            System.out.println("running...");
            return 42;
        });

        Thread.sleep(2900); // <-- ADDED: Ensure the task has time to start
        future.cancel(false); // This should now find the task running

        System.out.println("Future isCancelled: " + future.isCancelled()); // Should print false
        // ...

        service.shutdown();
    }

}
