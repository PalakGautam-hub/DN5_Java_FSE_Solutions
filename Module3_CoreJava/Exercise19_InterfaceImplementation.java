// Exercise 19: Interface Implementation

interface Shape {

    double area();

}

class Circle implements Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {

        return Math.PI *
                radius *
                radius;

    }
}

public class Exercise19_InterfaceImplementation {

    public static void main(String[] args) {

        Circle c =
                new Circle(5);

        System.out.println(
                c.area()
        );

    }
}