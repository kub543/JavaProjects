import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args) {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        System.out.print("Wyświetlenie orginalnych wartości: ");
        System.out.println(IntStream.of(values)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));

        System.out.printf("%nElementów: %d%n",IntStream.of(values).count());
        System.out.printf("Minimum: %d%n", IntStream.of(values).min().getAsInt());
        System.out.printf("Maximum: %d%n", IntStream.of(values).max().getAsInt());
        System.out.printf("Suma: %d%n", IntStream.of(values).sum());
        System.out.printf("Średnia: %.2f%n", IntStream.of(values).average().getAsDouble());

        System.out.printf("%nSuma poprzez metodę reduce: %d%n", IntStream.of(values)
                  .reduce(0, (int x, int y) -> x + y));
        System.out.printf("Iloczyn poprzez metodę reduce: %d%n", IntStream.of(values)
                  .reduce((int x, int y) -> x * y).getAsInt());
        System.out.printf("Suma kwadratów poprzez map i sum: %d%n%n", IntStream.of(values)
                  .map((int x) -> x * x).sum());
        System.out.printf("Wartości po posortowaniu: %s%n", IntStream.of(values)
                  .sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        System.out.println(IntStream.of(values).summaryStatistics());
    }
}
