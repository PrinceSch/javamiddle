package lesson3;

import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "pie", "apple", "fish", "orange", "pumpkin", "apple", "pie",
                "chips", "pie", "cake", "apple", "orange", "pie", "cucumber", "phone"};

        Map <String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Integer value = map.get(words[i]);
            if (value == null){
                map.put(words[i],1);
            } else {
                map.put(words[i], value + 1);
            }
        }

        System.out.println(map);

        // второе задание

        Phone phone = new Phone();
        phone.add("Doctor",897542332L);
        phone.add("River",89754543543L);
        phone.add("Clara",89754535321L);
        phone.add("Doctor",8975456421L);
        phone.add("Clara",897452452L);
        phone.add("Amy",8754522332L);

        System.out.println("Doctor's phones: "+ phone.get("Doctor"));
        System.out.println("Clara's phones: "+ phone.get("Clara"));
        System.out.println("River's phones: "+ phone.get("River"));
    }
}
