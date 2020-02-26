import java.util.*;

public class CaseTypeCount {
    //Ćwiczenie nr 16.11.
    public static void main(String[] args) {
        Map<Character, Integer> myMap = new HashMap<>();

        createMap(myMap);
        displayMap(myMap);
    }

    private static void createMap(Map<Character, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz tekst:");
        String input = scanner.nextLine();

        char[] tokens = input.toCharArray();
        for (Character token : tokens) {
            char cases = Character.toLowerCase(token);

            if (map.containsKey(cases)) {
                int count = map.get(cases);
                map.put(cases, count + 1);
            } else {
                map.put(cases, 1);
            }
        }
    }

    private static void displayMap(Map<Character, Integer> map) {
        Set<Character> keys = map.keySet();
        TreeSet<Character> sortedKeys = new TreeSet<>(keys);
        System.out.printf("%nOdwzorowanie zawiera:%nKlucz\t\tWartość%n");
        for (Character key : sortedKeys) {
            System.out.printf("%-11s%10s%n", key, map.get(key));
        }

        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}