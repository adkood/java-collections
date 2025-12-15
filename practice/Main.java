import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        service.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wazzzzzzzzap");
        }, 3000, 1000,TimeUnit.MILLISECONDS);

        service.schedule(() -> {
            service.shutdown();
        }, 8000, TimeUnit.MILLISECONDS);

    }

}
