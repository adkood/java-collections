import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {

    public static void main(String[] args) {

        // Ways to create streams

        // 1.
        // List<Integer> list = List.of(1,3,4,612,32);
        // System.out.println(list.stream().filter(x -> x%2 == 0).toList());

        // 2.
        // int[] arr = {1,2,10,7};
        // int[] newArr = Arrays.stream(arr).filter(x -> x%2 == 0).toArray();
        
        // for(int x: newArr) {
        //     System.out.print(x + " ");
        // }

        // 3.
        // System.out.println(Stream.of(14,424,535,65,88,21).filter(x -> x%2 != 0).toList());
        
        // 4.
        // using generate
        // System.out.println(Stream.generate(() -> 1).limit(100).toList());
        
        // using iterate
        // System.out.println(Stream.iterate(1, x -> x+1).limit(100).toList());



    }
    
}
