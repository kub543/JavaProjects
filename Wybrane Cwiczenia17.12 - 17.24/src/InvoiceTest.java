import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class InvoiceTest {
    public static void main(String[] args) {

        Invoice[] zamowienia = {new Invoice("83", "Szlifierka Oscylacyjna", 7, 89.98),
                new Invoice("24", "Piła ogrodowa", 18, 69.99),
                new Invoice("7", "Młot dwuręczny", 11, 99.50),
                new Invoice("77", "Młotek", 76, 21.99),
                new Invoice("39", "Kosiarka do trawy", 3, 299.50),
                new Invoice("68", "Śrubokręt", 106, 8.99),
                new Invoice("56", "Piłą do metalu", 21, 18.99),
                new Invoice("3", "Klucz francuski", 34, 17.50)
        };

        List<Invoice> invoiceList = Arrays.asList(zamowienia);

        System.out.println("Obiekty posortowane alfabetycznie po partDescription:");
        invoiceList.stream()
                   .sorted(Comparator.comparing(Invoice::getPartDescription))
                   .forEach(System.out::println);

        System.out.println("----------------------------");

        System.out.println("Obiekty posortowane alfabetycznie po pricePerItem:");
        invoiceList.stream()
                   .sorted(Comparator.comparing(Invoice::getPricePerItem))
                   .forEach(System.out::println);

        System.out.println("----------------------------");

        System.out.println("Obiekty posortowane po Quantity");
       invoiceList.stream()
                   .sorted(Comparator.comparing(Invoice::getQuantity))
                   .map(Invoice::getQuantityAndDescription)
                   .forEach(System.out::println);

        System.out.println("----------------------------");

        System.out.println("Obiekty posortowane po InvoiceAmount");
       invoiceList.stream()
                  .sorted(Comparator.comparing(Invoice::getInvoiceAmount))
                  .map(Invoice::getInvoiceAmountAndGetPartDescription)
                  .forEach(System.out::println);

        System.out.println("----------------------------");

        System.out.println("Obiekty posortowane po InvoiceAmount w przedziale cenowej od 1000 do 5000");
       Predicate<Invoice> invoicePredicate = invoice -> (invoice.getInvoiceAmount() >= 1000 &&
                                                         invoice.getInvoiceAmount() <=5000);
       invoiceList.stream()
                  .filter(invoicePredicate)
                  .sorted(Comparator.comparing(Invoice::getInvoiceAmount))
                  .map(Invoice::getInvoiceAmountAndGetPartDescription)
                  .forEach(System.out::println);
    }
}

