// Exercise 15: String Reversal

import java.util.Scanner;

public class Exercise15_StringReversal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");

        String str = sc.nextLine();

        String reversed = "";

        for(int i = str.length()-1;
            i >= 0;
            i--) {

            reversed += str.charAt(i);

        }

        System.out.println(
                "Reversed = " + reversed
        );

        sc.close();
    }
}