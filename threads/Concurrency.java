package threads;

import java.util.List;
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

        ExecutorService eService = Executors.newFixedThreadPool(3);

        String val = eService
                .invokeAny(List.of(new MyCallable1(), new MyCallable2(), new MyCallable3()));

        // System.out.println(future.stream().map(n -> {
        //     try {
        //         return n.get();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     } catch (ExecutionException e) {
        //         e.printStackTrace();
        //     }
        //     return null;
        // }).toList());

        System.out.println(val);

        eService.shutdown();
    }

}
