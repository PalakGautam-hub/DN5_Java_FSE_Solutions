// Exercise 25: HashMap Example

import java.util.HashMap;

public class Exercise25_HashMapExample {

    public static void main(String[] args) {

        HashMap<Integer,String> map =
                new HashMap<>();

        map.put(101,"Palak");
        map.put(102,"Rahul");
        map.put(103,"Ankit");

        System.out.println(
                map.get(102)
        );
    }
}