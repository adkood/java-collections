import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

        List<Integer> mp = new ArrayList<>();
        mp.add(1);
        mp.add(2);
        mp.add(6);
        mp.add(7);
        mp.add(10);

        System.out.println(mp.stream().filter(x -> x%2 == 0).findAny().get());


    }

}
