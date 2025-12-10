package threads;


public class Concurrency {

    public static void main(String[] args) {

        Thread th = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("inside thread");
        });

        System.out.println(th.getState());

        th.start();

        System.out.println(th.getState());

        try {

            Thread.sleep(2000);
            System.out.println(th.getState());
            th.join();
        } catch (InterruptedException e) {
            th.interrupt();
        }

        System.out.println(th.getState());

    }

}
