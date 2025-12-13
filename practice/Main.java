
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread th = new Thread(() -> {
            System.out.println("Inside new thread");
        });

        th.start();
        th.start();

    }

}