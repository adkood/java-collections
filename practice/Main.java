import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

interface Storage<K, V> {
    void set(K key, V value);

    V get(K key);

    void remove(K key);

    boolean contains(K key);
}

class InMemoryStorage<K, V> implements Storage<K, V> {

    private Map<K, V> store;

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

    @Override
    public boolean contains(K key) {
        return store.containsKey(key);
    }
}

interface Cache<K, V> {
    void set(K key, V value);

    V get(K key);
}

class Node<K> {

    Node<K> prev;
    Node<K> next;
    K data;

    Node() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    Node(K data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "[ " + this.data + " l : " + prev.data + " r : " + next.data + " ]";
    }
}

class LruCache<K, V> implements Cache<K, V> {

    private Map<K, Node<K>> mp;
    private Node<K> head;
    private Node<K> tail;
    private Storage<K, V> storage;
    private int cap;
    private int size;

    LruCache(int cap) {
        mp = new HashMap<>();
        storage = new InMemoryStorage<>();
        head = new Node<>();
        tail = new Node<>();
        this.cap = cap;
        this.size = 0;

        head.next = tail;
        tail.prev = head;
    }

    @Override
    public synchronized void set(K key, V value) {

        if (mp.containsKey(key)) {

            storage.set(key, value);

            Node<K> nn = mp.get(key);

            if (nn.prev != null)
                nn.prev.next = nn.next;
            if (nn.next != null)
                nn.next.prev = nn.prev;

            if (tail.prev != null)
                tail.prev.next = nn;
            nn.prev = tail.prev;
            nn.next = tail;
            tail.prev = nn;

        } else {

            if (size == cap) {
                storage.remove(head.data);

                Node<K> newhead = head.next;
                head.next = null;
                newhead.prev = null;
                System.out.println(head.data);
                head = newhead;

                size--;
            }

            storage.set(key, value);

            Node<K> nn = new Node<>(key);

            if (head.data == null) {
                head = nn;
                nn.next = tail;
                tail.prev = nn;
            } else {
                if (tail.prev != null)
                    tail.prev.next = nn;
                nn.prev = tail.prev;
                nn.next = tail;
                tail.prev = nn;
            }

            size++;
        }
    }

    @Override
    public synchronized V get(K key) {

        if(!mp.containsKey(key)) {
            return null;
        }

        Node<K> nn = mp.get(key);

        if (nn.prev != null)
            nn.prev.next = nn.next;
        if (nn.next != null)
            nn.next.prev = nn.prev;

        if (tail.prev != null)
            tail.prev.next = nn;
        nn.prev = tail.prev;
        nn.next = tail;
        tail.prev = nn;

        return storage.get(key);
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Cache<String, Integer> cache = new LruCache<>(5);

        cache.set("one", 1);
        cache.set("two", 2);
        cache.set("three", 3);
        cache.set("four", 4);
        cache.set("five", 5);

        // cache.get("one");
        cache.set("six", 6);

        System.out.println(cache.get("one"));

    }

}
