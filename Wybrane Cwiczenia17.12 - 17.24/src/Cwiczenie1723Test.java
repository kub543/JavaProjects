import java.util.ArrayList;
import java.util.List;

public class Cwiczenie1723Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("jak", "Bs"));
        list.add(new Person("Kam", "Nowak"));
        list.add(new Person("Ro", "Uijk"));
        list.add(new Person("Gr", "Nowak"));
        list.add(new Person("Fr", "Nowak"));

        System.out.printf("Pierwsza osoba o nazwisku Nowak: %s", list.stream()
                              .filter(person -> person.getLastName().equals("Nowak"))
                              .findFirst()
                              .get());

    }

    private static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Person" + " - " +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'';
        }
    }
}
