package threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
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

    private CountDownLatch latch;

    MyCallable1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000);
            return "hello from callable 1"; 

        } finally {
            latch.countDown();
        }
    }
}

class MyCallable2 implements Callable<String> {

    private CountDownLatch latch;

    MyCallable2(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
                        Thread.sleep(2000);
            return "hello from callable 2"; 
        } finally {
            latch.countDown();
        }    
    }
}

class MyCallable3 implements Callable<String> {

    private CountDownLatch latch;

    MyCallable3(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
                        Thread.sleep(3000);

            return "hello from callable 3"; 
        } finally {
            latch.countDown();
        }    
    }
}

public class Concurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService eService = Executors.newFixedThreadPool(3);
        int countDown = 3;
        CountDownLatch latch = new CountDownLatch(3);

        eService.submit(new MyCallable1(latch));
        eService.submit(new MyCallable2(latch));
        eService.submit(new MyCallable3(latch));

        latch.await(4000, TimeUnit.MILLISECONDS);

        System.out.println("Dependencies are up. Main started");
        eService.shutdown();

    }

}
