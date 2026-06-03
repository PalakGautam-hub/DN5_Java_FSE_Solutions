// Exercise 40: Virtual Threads
// Java 21 Required

public class Exercise40_VirtualThreads {

    public static void main(String[] args)
            throws Exception {

        for(int i=1;i<=1000;i++) {

            int num = i;

            Thread.startVirtualThread(
                    () -> System.out.println(
                            "Virtual Thread "
                                    + num
                    )
            );
        }

        Thread.sleep(2000);
    }
}