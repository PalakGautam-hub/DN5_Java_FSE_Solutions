// Exercise 41: Executor Service and Callable

import java.util.concurrent.*;

public class Exercise41_ExecutorServiceCallable {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        Callable<Integer> task1 =
                () -> 10 + 20;

        Callable<Integer> task2 =
                () -> 30 + 40;

        Future<Integer> f1 =
                executor.submit(task1);

        Future<Integer> f2 =
                executor.submit(task2);

        System.out.println(
                f1.get()
        );

        System.out.println(
                f2.get()
        );

        executor.shutdown();
    }
}