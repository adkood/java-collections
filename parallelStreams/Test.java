package parallelStreams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Test {
    
    public static long factorial(int n) {
        long l = 1;
        for(int i = 1; i <= n; i++) {
            l *= i;
        }
        return l;
    }

    public static void main(String[] args) {

        List<Integer> list = Stream.iterate(1, (x) -> x+1).limit(10).toList();

        // long start = System.currentTimeMillis();
        // List<Long> factos = list.stream().map(Test::factorial).toList();
        // long end = System.currentTimeMillis();

        // long time = end-start;
        // System.out.println("Total time taken : " + time + " ms");

        // start = System.currentTimeMillis();
        // factos = list.parallelStream().map(Test::factorial).toList();
        // end = System.currentTimeMillis();

        // time = end-start;
        // System.out.println("Total time taken using parallel streams : " + time + " ms");


        // AtomicLong sum = new AtomicLong(0);

        // System.out.println(list.stream().map(x -> {
        //     long i = sum.getAndAdd(x);
        //     return i;
        // }).toList());

    }

}
