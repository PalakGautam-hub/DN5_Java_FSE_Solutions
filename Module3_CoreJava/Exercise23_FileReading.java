// Exercise 23: File Reading

import java.io.File;
import java.util.Scanner;

public class Exercise23_FileReading {

    public static void main(String[] args) {

        try {

            File file =
                    new File(
                            "output.txt"
                    );

            Scanner sc =
                    new Scanner(file);

            while(sc.hasNextLine()) {

                System.out.println(
                        sc.nextLine()
                );

            }

            sc.close();

        }

        catch(Exception e) {

            e.printStackTrace();

        }
    }
}