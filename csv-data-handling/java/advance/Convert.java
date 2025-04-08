package advance;

import java.io.*;
import java.util.*;

class Student {
    String id, name;
    int age, marks;

    public Student(String id, String name, int age, int marks) {
        this.id = id; this.name = name;
        this.age = age; this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Age: " + age + ", Marks: " + marks + ")";
    }
}

public class Convert {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                students.add(new Student(d[0], d[1], Integer.parseInt(d[2]), Integer.parseInt(d[3])));
            }
        }
        students.forEach(System.out::println);
    }
}
