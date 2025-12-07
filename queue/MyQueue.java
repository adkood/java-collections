package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
 
    public static void main(String[] args) {
        
        Deque<Integer> q = new ArrayDeque<>();

        q.add(13);
        q.addLast(79);

        q.add(100);

        System.out.println(q);
    }
    
}