package parallelStreams;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    

    public static void main(String[] args) {

        List<Integer> list = Stream.iterate(1, x -> x+1).limit(10).toList();

        System.out.println(list.stream().collect(Collectors.groupingBy(x -> x%4)));
        
    }

}
