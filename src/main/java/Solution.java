import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) {

        System.out.println(malesOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDesc().forEach(System.out::println);

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

    static List<String> names(List<Person> people){
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        return names;
    }

    static List<Person> sortedByIncomeDesc(){
        List<Person> sortedList = Person.persons()
                .stream()
                .sorted(Comparator.comparing(Person::getIncome).thenComparing(Person::getName))
                .toList();

        return sortedList;
    }
}
