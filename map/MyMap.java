package map;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

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

        Map<Integer, String> mp = new ConcurrentSkipListMap<>();

        mp.put(12,"apple");
        mp.put(79, "banana");
        mp.put(898,"kiwi");
        mp.put(27,"lichi");
        mp.put(15,"tomato");

        System.out.println(mp);

        Map<Integer, String> mp2 = Map.copyOf(mp);
        
        // mp2.put(22,"hiji");
        System.out.println(mp2);
    }

}