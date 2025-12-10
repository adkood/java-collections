package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside runnable, no return, does not throw exception");
    }
}

class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("Inside callable, returns something, throws exception");
        return "hello from callable";
    }
}

public class Concurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // -- Normal way
        // Thread[] threads = new Thread[10];

        // for (int i = 0; i < 10; i++) {
        // int finalI = i;
        // threads[finalI] = new Thread(() -> {
        // System.out.println(Thread.currentThread().getName() + " : " + finalI);
        // });
        // }

        // for (int i = 0; i < 10; i++) {
        // threads[i].start();
        // }

        // try {
        // for (int i = 0; i < 10; i++) {
        // threads[i].join();
        // }
        // } catch (InterruptedException e) {
        // Thread.currentThread().interrupt();
        // }

        // -- Using Executor
        // Executor service = Executors.newFixedThreadPool(10);

        // for (int i = 0; i < 10; i++) {
        // int finalI = i;
        // service.execute(() -> System.out.println(Thread.currentThread().getName() + "
        // : " + finalI));
        // }

        // -- Using Executors service

        ExecutorService eService =  Executors.newFixedThreadPool(3);

        Future<?> future = eService.submit(() -> {
            try {
                for(int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    int finalI = i;
                    System.out.println("Thread is running : " + finalI);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was inturrupted!");
            }
        });

        try {
            Thread.sleep(2000);
        }catch(Exception e) {

        }

        // future.cancel(true);

        
        future.get();
        
        eService.shutdown();
        
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());


    }

}
