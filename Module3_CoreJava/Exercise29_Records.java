// Exercise 29: Records

record Student(
        String name,
        int age
) {}

public class Exercise29_Records {

    public static void main(String[] args) {

        Student s1 =
                new Student(
                        "Palak",
                        20
                );

        System.out.println(s1);

    }
}