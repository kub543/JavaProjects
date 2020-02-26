import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {
    public static void main(String[] args) {
        Employee[] employees = {new Employee("Jan", "Kowalski", 5000, "IT"),
                                new Employee("Anna", "Kusar", 7600, "IT"),
                                new Employee("Marcin", "Nowak", 3587.5, "Sprzedaż"),
                                new Employee("Jerzy", "Nowak", 4700.77, "Marketing"),
                                new Employee("Lech", "Nowak", 6200, "IT"),
                                new Employee("Jan", "Zielony", 3200, "Sprzedaż"),
                                new Employee("Wanda", "Kapusta", 4236.4, "Marketing")};

        List<Employee> list = Arrays.asList(employees);

        System.out.println("Kompletna lista pracowników:");
        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand = (Employee e) -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        System.out.printf("%nPracownicy zarabiający od 4000 do 6000 zł miesięcznie, posortowani według " +
                "wysokości wynagrodzenia:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
        System.out.printf("%nPierwszy pracownik zarabiający od 4000 do 6000 zł:%n%s%n", list.stream()
                                                                                               .filter(fourToSixThousand)
                                                                                               .findFirst()
                                                                                               .get());

        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

        System.out.printf("%npracownicy posortowani rosnąco po nazwisku i imieniu:%n");
        list.stream()
            .sorted(lastThenFirst)
            .forEach(System.out::println);
        System.out.printf("%nPracownicy posortowani malejąco po nazwisku i imieniu%n");
        list.stream()
            .sorted(lastThenFirst.reversed())
            .forEach(System.out::println);


        System.out.printf("%nUnikatowe nazwiska pracowników:%n");
        list.stream()
            .map(Employee::getLastName)
            .distinct()
            .sorted()
            .forEach(System.out::println);
        System.out.printf("%nPracownicy posortowani alfabetycznie po nazwisku i imieniu:%n");
        list.stream()
            .sorted(lastThenFirst)
            .map(Employee::getName)
            .forEach(System.out::println);


        System.out.printf("%nPracownicy pogrupowani według działów:%n");
        Map<String, List<Employee>> groupedByDepartment = list.stream()
                                                              .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach(
            (department, employeesInDepartment) -> {
                System.out.printf("%n%s%n", department);
                employeesInDepartment.forEach(
                    (Employee employee) -> System.out.printf("     %s%n", employee)
                );
            }
        );

        System.out.printf("%nLiczba pracowników w każdym dziale:%n");
        Map<String, Long> employeeCountByDepartment = list.stream()
                                                          .collect(Collectors.groupingBy(Employee::getDepartment,
                                                                  Collectors.counting()));
        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf("%s ma %d pracowników%n", department, count)
        );

        System.out.printf("%nSuma zarobków pracowników (za pomocą metody sum): %.2f%n",
                          list.stream()
                              .mapToDouble(Employee::getSalary)
                              .sum());
        System.out.printf("Suma zarobków pracowników (za pomocą metody reduce): %.2f%n",
                          list.stream()
                              .mapToDouble(Employee::getSalary)
                              .reduce(0, (value1, value2) -> value1 + value2));
        System.out.printf("Średnia zarobków pracowników: %.2f%n",
                          list.stream()
                              .mapToDouble(Employee::getSalary)
                              .average()
                              .getAsDouble());

    }
}
