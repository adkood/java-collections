import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        // predicate 

        // Predicate<Integer> isEven = x -> x%2 == 0;
        // Predicate<Integer> isDivBy10 = x -> x%10 == 0;  
        // System.out.println(isEven.and(isDivBy10).test(100));

        // function

        // Function<Integer, Integer> f = x -> x * 2;
        // Function<Integer, Integer> s = x -> x + 5;

        // System.out.println(f.andThen(s).apply(10)); // 25
        // System.out.println(f.compose(s).apply(10)); // 30

        // Supplier 

        // Supplier<String> sup = () -> "hello";
        // System.out.println(sup.get());

        // Consumer

        // Consumer<Integer> con = x -> System.out.println(x-1);
        // con.accept(10);
    }

}
