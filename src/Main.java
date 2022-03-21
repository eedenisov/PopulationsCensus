import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList(
                "Evans", "Young", "Harris", "Wilson", "Davies", "Adamson");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long minors = persons.stream()
                .filter(p -> p.getAge() < 18)
                .count();
        System.out.println("Total number of minors: " + minors);

        List<String> recruit = persons.stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27)
                .filter(p -> p.getSex() == Sex.MAN)
                .map(Person::getSurname)
                .filter(p -> p != null && !p.isEmpty())
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("Surname list of recruit: " + recruit);

        List<String> peopleWithHigher = persons.stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 60 && p.getSex() == Sex.WOMAN ||
                        p.getAge() >= 18 && p.getAge() <= 65 && p.getSex() == Sex.MAN)
                .filter(p -> p.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getSurname))
                .map(Person::getSurname)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("Surname list of people with higher educations: " + peopleWithHigher);
    }
}
