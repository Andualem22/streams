import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) {

        System.out.println(malesOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDesc().forEach(System.out::println);
        System.out.println("Distinct genders " + distinctGenders());

        System.out.println("First three people on the list");
        firstThreePeople().forEach(System.out::println);

        System.out.println("List of people on the list skipped first two people ");
        skippedPeople().forEach(System.out::println);

        System.out.println("Person's income is greater than 8000 " + anyPersonWithHighIncome());

        System.out.println("is all people are male? " + isAllPeopleAreMale());

        System.out.println("Is there someone with zero income? " + noneHaveZeroIncome());

        if(personWithHighIncome().isPresent()){
            Person p = personWithHighIncome().get();
            System.out.println("Person with highest income is " + p);
        }
        System.out.println("To find any person " + anyPerson);

        System.out.println("calculating the sum, average, max and min of income " + incomeStats);

        System.out.println("Joining all the names into one string " + allNames);
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
// Map the list of persons to their names.
    static List<String> names(List<Person> people){
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        return names;
    }
//Sort the list of persons by their income in descending order.
    static List<Person> sortedByIncomeDesc(){
        List<Person> sortedList = Person.persons()
                .stream()
                .sorted(Comparator.comparing(Person::getIncome).thenComparing(Person::getName))
                .toList();

        return sortedList;
    }
//Find the distinct genders in the list of persons.
    static List<Person.Gender> distinctGenders(){
        List<Person.Gender> genders = Person.persons()
                .stream()
                .map(Person::getGender)
                .distinct()
                .toList();
        return genders;
    }
//Limit the list of persons to the first 3.
    static List<Person> firstThreePeople(){
        List<Person> top3 = Person.persons()
                .stream()
                .limit(3)
                .toList();
        return top3;
    }

    //Skip the first 2 persons in the list.
    static List<Person> skippedPeople(){
        List<Person> skipped = Person.persons()
                .stream()
                .skip(2)
                .toList();
        return skipped;
    }

    //to use peek() to print the names of all persons on the list

    static void displayNames(){
        Person.persons()
                .stream()
                .peek(person -> System.out.println("Person name" + person.getName()))
                .forEach(System.out::println);
    }

    //to check if any person's income is greater than 8000.0
    static boolean anyPersonWithHighIncome(){
      return     Person.persons()
                .stream()
                .anyMatch(p ->p.getIncome() > 8000 );
    }

    //to check if all people are male
    static boolean isAllPeopleAreMale(){
        return   Person.persons()
                .stream()
                .allMatch(Person::isMale);
    }

    static boolean noneHaveZeroIncome(){
       return    Person.persons()
                .stream()
                .noneMatch(p->p.getIncome() == 0);
    }

    //To count the number of persons
    static long countFemale(){
        return Person.persons()
                .stream()
                .filter(Person::isFemale)
                .count();
    }

    //to find the person with the highest income
    static Optional<Person> personWithHighIncome(){
        return   Person.persons()
                .stream()
                .max(Comparator.comparingDouble(Person::getIncome));
    }
    //to find any person in the list we can use findAny() terminal operation
    static Optional<Person> anyPerson = Person.persons()
            .stream()
            .findAny();

    //calculate the sum, average , max and min of incomes
    static DoubleSummaryStatistics incomeStats = Person.persons()
            .stream()
            .collect(Collectors.summarizingDouble(Person::getIncome));

    //join the names of all persons into a single string
    static String allNames = Person.persons()
            .stream()
            .map(Person::getName)
            .collect(Collectors.joining(", "));
}
