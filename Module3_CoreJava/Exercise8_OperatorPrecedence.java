// Exercise 8: Operator Precedence

public class Exercise8_OperatorPrecedence {

    public static void main(String[] args) {

        int result1 =
                10 + 5 * 2;

        int result2 =
                (10 + 5) * 2;

        System.out.println(
                "Result1 = " + result1
        );

        System.out.println(
                "Result2 = " + result2
        );

    }
}