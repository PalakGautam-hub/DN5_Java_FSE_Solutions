// Exercise 22: File Writing

import java.io.FileWriter;
import java.io.IOException;

public class Exercise22_FileWriting {

    public static void main(String[] args) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "output.txt"
                    );

            writer.write(
                    "Hello File Handling"
            );

            writer.close();

            System.out.println(
                    "Data Written Successfully"
            );

        }

        catch(IOException e) {

            e.printStackTrace();

        }
    }
}