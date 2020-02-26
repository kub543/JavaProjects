import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String[] strings = {"Czerwony", "pomarańczowy", "Szary", "zielony", "Niebieski", "indygo", "Fioletowy"};

        System.out.printf("Pierwotne teksty: %s%n", Arrays.asList(strings));
        System.out.printf("Teksty dużymi literami: %s%n", Arrays.stream(strings)
                                                                   .map(String::toUpperCase)
                                                                   .collect(Collectors.toList()));
        System.out.printf("Teksty mniejsze od n posortowane rosnąco: %s%n",
                          Arrays.stream(strings)
                                .filter((String s) -> s.compareToIgnoreCase("n") < 0)
                                .sorted(String.CASE_INSENSITIVE_ORDER)
                                .collect(Collectors.toList()));
        System.out.printf("Teksty mniejsze od n posortowane malejąco: %s%n",
                          Arrays.stream(strings)
                                .filter((String s) -> s.compareToIgnoreCase("n") < 0)
                                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                                .collect(Collectors.toList()));
    }
}
