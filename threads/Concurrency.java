package threads;


class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("inside runnable");
    }
}

public class Concurrency {

    public static void main(String[] args) {
        Thread th = new Thread(new MyRunnable());
        th.start();

    }

}
