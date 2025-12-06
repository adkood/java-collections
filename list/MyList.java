import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }   

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

class sortByName implements Comparator<Student>  {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class MyList {
    
    public static void main(String[] args) {
        
        
        List<Student> l = new ArrayList<>();
        l.add(new Student("ashu", 25));
        l.add(new Student("rahul", 22));
        l.add(new Student("zoya", 23));

        l.sort(new sortByName());

        System.out.println(l);
    }

}