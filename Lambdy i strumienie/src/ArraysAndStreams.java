import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
    public static void main(String[] args) {
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        System.out.printf("Orginalne wartości: %s%n", Arrays.asList(values));
        System.out.printf("Posortowane wartości: %s%n", Arrays.stream(values)
                                                                 .sorted()
                                                                 .collect(Collectors.toList()));
        List<Integer> greaterThan4 = Arrays.stream(values)
                                           .filter((Integer value) -> value > 4)
                                           .collect(Collectors.toList());
        System.out.printf("Wartości większe od 4: %s%n", greaterThan4);
        System.out.printf("Posortowane wartości większe od 4: %s%n", Arrays.stream(values)
                                                                              .filter((Integer value) -> value > 4)
                                                                              .sorted()
                                                                              .collect(Collectors.toList()));
        System.out.printf("Wartości większe od 4 (rosnąco w strumieniu): %s%n", greaterThan4.stream()
                                                                                                .sorted()
                                                                                                .collect(Collectors.toList()));
    }
}
