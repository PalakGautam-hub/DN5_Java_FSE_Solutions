// Exercise 33: Transaction Handling

import java.sql.*;

public class Exercise33_TransactionHandlingJDBC {

    public static void main(String[] args) {

        try {

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/bankdb",
                            "root",
                            "root"
                    );

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance-500 WHERE id=1"
                    );

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance+500 WHERE id=2"
                    );

            debit.executeUpdate();
            credit.executeUpdate();

            con.commit();

            System.out.println(
                    "Transfer Successful"
            );

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();

        }
    }
}