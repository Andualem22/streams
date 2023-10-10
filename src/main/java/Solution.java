import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) {

        System.out.println(malesOnly(Person.persons()));


    }

    // Filter the list of persons to include only males.
    static List<String> malesOnly(List<Person> people){
        //people = Person.persons();
        List<String> males = people.stream()
                .filter(Person::isMale)
                .map(Person::getName)
                .toList();
        return males;
    }

}
