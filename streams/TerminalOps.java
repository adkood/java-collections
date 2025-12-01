import java.util.ArrayList;
import java.util.List;

public class TerminalOps {
    
    public static void main(String[] args) {
        

        // System.out.println(list.stream().collect(Collectors.toList()));

        // list.stream().toList();

        // list.stream().forEach(x -> System.out.println(x*10));

        // System.out.println(list.stream().reduce(Integer::sum).get());

        // List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        // System.out.println( names.stream().filter(x -> x.length() > 3).toList());

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = List.of(1,2,3);
        List<Integer> l2 = List.of(11,12,13);
        list.add(l1);
        list.add(l2);

        // System.out.println( list.stream().reduce((x,y) -> x+y).get());

        // System.out.println( list.stream().map(x -> x*x).sorted().collect(Collectors.toList()));

        // String sentence = "Hello world";

        // System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // System.out.println(list.stream().count());

        System.out.println( list.stream().flatMap(x -> x.stream()).anyMatch(x -> x == 14));
    }

}
