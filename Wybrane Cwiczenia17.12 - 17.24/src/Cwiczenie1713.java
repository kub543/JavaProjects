import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cwiczenie1713 {

    public String createAndSaveVerbs () {
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz zdanie, nie używając znaków interpunkcyjnych");
         String zdanie = input.nextLine();
         return zdanie;
    }

    public List<String> splitVerbsAndToList(String zdanie) {
        String[] strings = zdanie.split(" ");
        List<String> list = Arrays.asList(strings);
        return list;
    }

    public void OriginalIgnoreCaseAndPrint(List<String> list) {
        list.stream()
                .distinct()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::print);
    }
}
