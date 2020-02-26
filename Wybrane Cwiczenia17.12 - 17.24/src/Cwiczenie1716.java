import java.security.SecureRandom;

public class Cwiczenie1716 {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.ints(50, 1, 1000)
                    .filter(number -> number % 2 != 0)
                    .sorted()
                    .forEach(number -> System.out.printf("%s ", number));
    }
}
