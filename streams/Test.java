import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Car {
    String name;
    Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Car: "+name+" ]";
    }
}

public class Test {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> 42;

        System.out.println(supplier.get());

        Consumer<Integer> consumer = (x) -> System.out.println("x is : " + x);

        consumer.accept(101);
    }   

}
