import java.util.stream.IntStream;

public class StreamReduce {
    public static void main(String[] args) {
        System.out.printf("Suma liczb z zakresu od 1 do 10 wynosi: %d%n", IntStream.rangeClosed(1, 10).sum());
    }
}
