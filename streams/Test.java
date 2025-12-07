import java.util.function.BiPredicate;
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

        BiPredicate<Integer, Integer> biP = (a,b) -> { 
            try {
                return a%b == 0;
            } catch(Exception e) {
                System.out.println("Cannot divide by zero");
            }
            return false;
        };

        System.out.println(biP.test(10, 0));

    }   

}
