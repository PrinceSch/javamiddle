package lesson3;

import java.util.*;

public class Phone {

    private HashMap<String, Set<Long>> phoneBook = new HashMap<>();

    public void add(String name, Long phone){
        Set<Long> number = phoneBook.getOrDefault(name, new HashSet<>());
        number.add(phone);
        phoneBook.put(name, number);
    }

    public void add (String name, Long ... phones){
        Set<Long> number = phoneBook.getOrDefault(name, new HashSet<>());
        number.addAll(Arrays.asList(phones));
        phoneBook.put(name, number);
    }

    public Set<Long> get(String name) {
        return Collections.unmodifiableSet(phoneBook.get(name));
    }

}
