package threads;

class MyDeamon extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Deamon : " + i);
        }

    }

}

public class Concurrency {

    public static void main(String[] args) {

        Thread th = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("thread 1");
        });

        Thread th2 = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("thread 2");
        });

        Thread th3 = new MyDeamon();
        th3.setDaemon(true);

        th.start();
        th2.start();
        th3.start();

        try {
            th.join();
            th2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
