// Exercise 39: Reflection

import java.lang.reflect.*;

class Demo {

    public void show() {

        System.out.println(
                "Reflection Demo"
        );

    }
}

public class Exercise39_Reflection {

    public static void main(String[] args)
            throws Exception {

        Class<?> cls =
                Class.forName("Demo");

        Object obj =
                cls.getDeclaredConstructor()
                        .newInstance();

        Method method =
                cls.getDeclaredMethod(
                        "show"
                );

        method.invoke(obj);
    }
}