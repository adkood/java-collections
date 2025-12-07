package map;

import java.lang.ref.WeakReference;
import java.util.HashMap;
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
        
       Map<Car, Integer> mp = new HashMap<>();

       Car c1 = new Car("swift");
       mp.put(c1, 23);
       
       c1 = null;
        System.gc();
       System.out.println(mp);

    }

}
