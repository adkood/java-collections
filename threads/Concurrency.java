package threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside runnable, no return, does not throw exception");
    }
}

class MyCallable1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello from callable 1";
    }
}

class MyCallable2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello from callable 2";
    }
}

class MyCallable3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello from callable 3";
    }
}

public class Concurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        // service.schedule(() -> {
        //     System.out.println("Hello from scheduler");
        // }, 3000, TimeUnit.MILLISECONDS);


        ScheduledFuture<?> future = service.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("yello form melo");
            } catch (InterruptedException e) {
                System.out.println("Task Inturrupted!");
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        service.schedule(() -> {
            future.cancel(false);
            service.shutdown();
        }, 5000, TimeUnit.MILLISECONDS);

    }

}
