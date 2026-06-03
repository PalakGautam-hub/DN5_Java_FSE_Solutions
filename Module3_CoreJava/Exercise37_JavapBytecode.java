// Exercise 37: Using javap

public class Exercise37_JavapBytecode {

    public void display() {

        System.out.println(
                "Hello Bytecode"
        );

    }

    public static void main(String[] args) {

        new Exercise37_JavapBytecode()
                .display();

    }
}

/*
Compile:

javac Exercise37_JavapBytecode.java

Inspect:

javap -c Exercise37_JavapBytecode
*/