import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

interface Retry {
    Boolean retry(Callable<Boolean> task);
}

class RetryWithBackoff implements Retry {

    private int limit;
    private long maxBackOffTime = 60000;

    RetryWithBackoff(int limit) {
        this.limit = limit;
    }

    @Override
    public Boolean retry(Callable<Boolean> task) {

        int limit = this.limit;
        long backoffTime = 1000;
        long maxBackOffTime = this.maxBackOffTime;

        for (int i = 0; i < limit; i++) {

            System.out.println("Attempt : " + i);

            try {
                task.call();
                return true;
            } catch (Exception e) {
                System.out.println("Failed on retry");
            }
            
            long jitter = ThreadLocalRandom.current().nextLong(backoffTime / 2);
            System.out.println("Jitter time : " + jitter);
            long sleepTime = backoffTime + jitter;
            backoffTime = Math.min(backoffTime*2 , maxBackOffTime);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All tries failed");
        return false;
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Callable<Boolean> call1 = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                double rand = (Math.random() * 10);
                // throw new Exception("Something went wrong");
                System.out.println("Rand number : " + rand);
                if((int)rand == 5) {
                return true;
                }
                return false;
            }
        };

        Retry retry = new RetryWithBackoff(3);

        retry.retry(call1);

    }

}
