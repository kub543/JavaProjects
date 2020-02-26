import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class Cwiczenie1714 {
    public static void main(String[] args) {

        List<Integer> integerList = randomToList();
        integerList.stream()
                   .map(integer -> String.valueOf(Character.toChars(integer)))
                   .distinct()
                   .sorted()
                   .forEach(letter -> System.out.printf("%s ", letter));
    }

    public static List<Integer> randomToList() {
        SecureRandom secureLetters = new SecureRandom();
        List<Integer> list = secureLetters.ints(30, 65, 91)
                                          .boxed()
                                          .collect(Collectors.toList());
        return list;
    }
}
