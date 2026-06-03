// Exercise 10: Number Guessing Game

import java.util.Random;
import java.util.Scanner;

public class Exercise10_NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        int target =
                random.nextInt(100) + 1;

        int guess;

        do{

            System.out.print(
                    "Enter Guess: "
            );

            guess =
                    sc.nextInt();

            if(guess > target){

                System.out.println(
                        "Too High"
                );

            }else if(
                    guess < target){

                System.out.println(
                        "Too Low"
                );

            }else{

                System.out.println(
                        "Correct Guess!"
                );

            }

        }while(
                guess != target
        );

        sc.close();
    }
}