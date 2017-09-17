package ua.chumakov.xxx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vesa-pk on 07.09.2017.
 */
public class XXX {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Vitalii", 32),
                new Person("Natasha", 36),
                new Person("Dima", 4),
                new Person("Ludmila", 33),
                new Person("Natasha", 41)
        );
        List<Person> fitred = personList.stream().filter(x-> x.name.startsWith("N")).collect(Collectors.toList());

        System.out.println(fitred);

    }
}
