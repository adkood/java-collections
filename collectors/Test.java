package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    
    public static void main(String[] args) {
        
        // collect to a list
        // Stream<Integer> s = Stream.iterate(1, x -> x+1);
        
        // List<Integer> list = s.limit(10).toList();
                                                                                                                                                                                                                                                                    
        

        // String str = list.stream().map(Object::toString).collect(Collectors.joining(", "));

        // System.out.println(str);

        // System.out.println( list.stream().collect(Collectors.summarizingInt(x -> x)));

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // System.out.println(list.stream().collect(Collectors.groupingBy(x -> x.length())));

        // System.out.println(  list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        // System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x%2 == 0)));

        // Map<String, Integer> mp = new HashMap<>();
        // mp.put("apple", 100);
        // mp.put("banana", 200);
        // mp.put("kiwi", 22);

        // System.out.println(mp.values().stream().reduce((x,y) -> x+y).get());

        List<String> list = List.of("apple", "banana", "kiwi", "plum");

        Map<String, Integer> mp = list.stream().collect(Collectors.toCollection(() -> new HashMap<>()));
    }
 
}
