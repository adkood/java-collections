import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        
        int[] arr = { 1, 2, 3, 14 };

        IntStream st = Arrays.stream(arr);

        // Optional<Integer> value = st.boxed().collect(Collectors.maxBy((a,b) -> Integer.compare(a, b)));
        // System.out.println(value.get());

        // OptionalInt value = st.max();

        // System.out.println(value.getAsInt());

        String str = "hello bois";

        System.out.println(str.chars().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting())));

    }

}