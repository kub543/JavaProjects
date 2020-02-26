import java.util.stream.IntStream;

public class Predykat {
    public static void main(String[] args) {
       int v = IntStream.rangeClosed(1, 10).filter((int x) -> {
           System.out.printf("%nFilter: %d%n", x);
           return x % 2 == 0;
       }).map((int y) -> {
           System.out.printf("map: %d%n", y);
           return y * 3;
       }).sum();
        System.out.printf("Parzyste liczby od 2 do 10 pomnożone przez 3 i zsumowame: %d%n", v);
    }
}
