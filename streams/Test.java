import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        Stream<Integer> it = Stream.iterate(1, x -> x+1);

        System.out.println(it.map(x -> x * 10).limit(10).toList());

    }

}
