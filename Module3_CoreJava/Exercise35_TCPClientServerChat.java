// Exercise 35: TCP Client Server Chat

import java.net.*;
import java.io.*;

public class Exercise35_TCPClientServerChat {

    public static void main(String[] args)
            throws Exception {

        ServerSocket server =
                new ServerSocket(5000);

        System.out.println(
                "Waiting..."
        );

        Socket socket =
                server.accept();

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()
                        )
                );

        System.out.println(
                br.readLine()
        );

        socket.close();
        server.close();
    }
}