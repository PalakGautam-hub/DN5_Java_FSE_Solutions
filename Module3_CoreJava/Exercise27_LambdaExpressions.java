// Exercise 27: Lambda Expressions

import java.util.Arrays;
import java.util.List;

public class Exercise27_LambdaExpressions {

    public static void main(String[] args) {

        List<String> names =
                Arrays.asList(
                        "Palak",
                        "Rahul",
                        "Ankit"
                );

        names.forEach(
                name ->
                        System.out.println(name)
        );
    }
}