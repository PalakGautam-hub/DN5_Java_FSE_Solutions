// Exercise 2: Simple Calculator

import java.util.Scanner;

public class Exercise2_SimpleCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("1.Add");
        System.out.println("2.Subtract");
        System.out.println("3.Multiply");
        System.out.println("4.Divide");

        int choice = sc.nextInt();

        switch(choice){

            case 1:
                System.out.println(a+b);
                break;

            case 2:
                System.out.println(a-b);
                break;

            case 3:
                System.out.println(a*b);
                break;

            case 4:
                System.out.println(a/b);
                break;

            default:
                System.out.println("Invalid Choice");

        }

        sc.close();
    }
}