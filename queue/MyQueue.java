package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
 
    public static void main(String[] args) {
        
        Queue<Integer> q = new LinkedList<>();

        q.offer(120);
        q.add(203);

        q.poll();
        q.poll();

        q.remove();

        // System.out.println(q.peek());
    }
    
}