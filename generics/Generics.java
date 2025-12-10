package generics;

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

public class Generics {

    public static <T extends Exception> void testException(T ex) throws T {
        throw ex;
    } 

    public static void main(String[] args) {

        try {
            testException(new MyException("Hello from custom excep"));
        } catch (MyException e) {
            System.out.println("custom : " + e);
        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
