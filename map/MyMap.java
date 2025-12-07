package map;

import java.util.HashMap;
import java.util.Map;

public class MyMap {

    public static void main(String[] args) {
        
        // key -> value -> bucket -> hashFunc

        Map<String, Integer> mp = new HashMap<>();

        mp.put(null, null);
        mp.put("banana", 12);

        System.out.println(mp);

    }

}
