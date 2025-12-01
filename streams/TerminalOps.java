import java.util.List;
import java.util.stream.Collectors;

public class TerminalOps {
    
    public static void main(String[] args) {
        

        List<Integer> list = List.of(1,2,3,45,14,3,1,10);
        System.out.println(list.stream().collect(Collectors.toList()));

    }

}
