// Exercise 24: ArrayList Example

import java.util.ArrayList;

public class Exercise24_ArrayListExample {

    public static void main(String[] args) {

        ArrayList<String> students =
                new ArrayList<>();

        students.add("Palak");
        students.add("Rahul");
        students.add("Ankit");

        for(String name : students) {

            System.out.println(name);

        }
    }
}