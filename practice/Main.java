
class Test {

    public synchronized void funcA() {
        System.out.println("func a");
    };

    public synchronized void funcB() {
       System.out.println("func b");
       funcA(); 
    };
}


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.funcB();
    }

}