import java.util.function.Function;
import java.util.function.Predicate;

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

        // predicate

        Predicate<Integer> predicate = x -> x%2 == 0;

        Predicate<Integer> predicate2 = x -> x%4 == 0;

        System.out.println(predicate.negate().test(1));

        // function

        Function<Integer, Integer> function = (x) -> x += 2;

        Function<Integer, Integer> function2 = (x) -> x /= 2;



        System.out.println( Function.identity().apply(100));

    }   

}
