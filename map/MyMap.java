package map;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

class Car {
    String name;

    Car(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println("vroom vroom");
    }

    @Override
    public String toString() {
        return "{ name : " + name + " }";
    }

 
}

public class MyMap {

    public static void main(String[] args) {

        Map<String, Integer> mp1 = new IdentityHashMap<>();
        // String c1 = new String("alto");
        // String c2 = new String("alto");

        String c1 = "alto";
        String c2 = "alto";

        mp1.put(c1, 1);
        mp1.put(c2, 2);

        Map<String, Integer> mp2 = new HashMap<>();

        mp2.put(c1, 1);
        mp2.put(c2, 2);

        System.out.println(mp1);
        System.out.println(mp2);
    }

}