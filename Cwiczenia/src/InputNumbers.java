import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputNumbers {
    //Zadanie nr 16.14
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();
        int[] intStream = randomNumbers.ints(25, 0, 101).toArray();

        String string = IntStream.of(intStream)
                                 .sorted()
                                 .mapToObj(String::valueOf)
                                 .collect(Collectors.joining(" "));

        int intStream2 = IntStream.of(intStream)
                                  .sum();

        double asDouble = IntStream.of(intStream)
                                  .average()
                                  .getAsDouble();

        List<Object> list = new LinkedList<>();

        list.add(string);
        list.add(intStream2);
        list.add(asDouble);
        System.out.printf("%nLista zawiera:%n posortowane liczby, sumę liczb i średnią liczb: %s", list);
    }
}
