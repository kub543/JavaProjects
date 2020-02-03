import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    final static Scanner input = new Scanner(System.in);
    Converter converter;
    static String choise;
    static double temp;
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
        choise = input.next();
            while(!choise.equals("q")) {
                if ((choise.equals("c")) || (choise.equals("f"))) {
                    Converter wybor = main.choiceConverter(choise);
                    System.out.println("wprowadź liczbę: ");
                    try {
                        temp = input.nextDouble();
                        System.out.println("Wynik: " + wybor.calculate(temp));
                        System.out.println();
                        main.showMenu();
                        choise = input.next();
                    } catch (InputMismatchException e) {
                            System.out.println("Błąd. Musisz wprowadzić liczbę!");
                            System.out.println();
                            input.next();
                    }
                } else {
                    System.out.println("Wybierz odpowiednią literę");
                    System.out.println();
                    main.showMenu();
                    choise = input.next();
                }
            }
    }
    public Converter choiceConverter(String choise) {
        if (choise.equals("c")) {
            converter = new FahrenheitConverter();
        } else if (choise.equals("f")) {
            converter = new CelsiuseConverter();
        }
        return converter;
    }
    public void showMenu() {
        System.out.println("Aby można byłoby policzyć dokonaj wyboru: ");
        System.out.println("----------c---------- zamień celsius na fahrengeit");
        System.out.println("----------f---------- zamień fahrenheit na calsius");
        System.out.println("----------q---------- wyjdż z programu");
    }
}