// Exercise 17: Class and Object

class Student {

    String name;
    int age;

    void display() {

        System.out.println(
                name + " " + age
        );

    }
}

public class Exercise17_ClassAndObject {

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = "Palak";
        s1.age = 20;

        s1.display();

    }
}