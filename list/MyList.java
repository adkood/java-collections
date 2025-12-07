import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Student {
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }   

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

class Counter {
    private List<Integer> count = new Vector<>();

    public void addElement(int i) {
        count.add(i);
    }

    public int getSize() {
        return count.size();
    }
}

class task1 implements Runnable {

    Counter counter;

    public task1(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            counter.addElement(i);
        }
    }
}

class task2 implements Runnable {

    Counter counter;

    public task2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            counter.addElement(i);
        }
    }
}


public class MyList {
    
    public static void main(String[] args) {
        
        Counter counter = new Counter();

        Thread t1 = new Thread(new task1(counter));
        Thread t2 = new Thread(new task2(counter));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        
        System.out.println(counter.getSize());
    }

}