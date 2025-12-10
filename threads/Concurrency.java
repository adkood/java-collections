package threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside runnable, no return, does not throw exception");
    }
}

class MyCallable1 implements Callable<String> {

    private CyclicBarrier barrier;

    MyCallable1(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        // try {
        Thread.sleep(1000);
        barrier.await();
        return "hello from callable 1";

        // } finally {

        // }
    }
}

class MyCallable2 implements Callable<String> {

    private CyclicBarrier barrier;

    MyCallable2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(2000);
            barrier.await();
            return "hello from callable 2";
        } finally {
            // latch.countDown();
        }
    }
}

class MyCallable3 implements Callable<String> {

    private CyclicBarrier barrier;

    MyCallable3(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(3000);
            barrier.await();

            return "hello from callable 3";
        } finally {
            // latch.countDown();
        }
    }
}

public class Concurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService eService = Executors.newFixedThreadPool(3);

        int parties = 3;
        CyclicBarrier barrier = new CyclicBarrier(parties,
                () -> {
                    System.out.println("All parties arrived at the barrier. Now start!");
                    eService.shutdown();
                });

        eService.submit(new MyCallable1(barrier));
        eService.submit(new MyCallable2(barrier));
        eService.submit(new MyCallable3(barrier));

    }

}
