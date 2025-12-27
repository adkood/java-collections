import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

interface Storage<K,V> {
    void set(K key, V value);
    V get(K key);
    void remove(K key);
}

class InMemoryStorage<K,V> implements Storage<K,V> {

    private Map<K,V> store;
 
    InMemoryStorage() {
        store = new ConcurrentHashMap<>();
    }

    @Override
    public void set(K key, V value) {
        store.put(key, value);
    }

    @Override
    public V get(K key) {
        return store.get(key);
    }

    @Override
    public void remove(K key) {
        store.remove(key);
    }
}

interface cache {

}

public class Main {
    public static void main(String[] args) throws InterruptedException {



    }

}
