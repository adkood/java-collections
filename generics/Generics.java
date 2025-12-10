package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static <T extends Number> double addValue(List<T> list) {
        double sum = 0;
        for(T x: list) {
            sum += x.doubleValue();
        }
        return sum;
    }

    public static void pushValue(List<? super Integer> list, Integer value) {
        list.add(value);
    }

    public static void main(String[] args) {

        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(5.5);
        list.add(10);

        pushValue(list, 20);
        System.out.println(addValue(list));


    }
}
