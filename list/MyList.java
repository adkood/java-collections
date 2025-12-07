import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

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

public class MyList {
    
    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for(Integer i : list) {
            if(i%2 == 0) {
                list.remove(i);
            }
        }

        System.out.println(list);
    }

}