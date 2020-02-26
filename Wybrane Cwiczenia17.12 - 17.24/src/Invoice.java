import java.util.List;
import java.util.stream.Stream;

    // Invoice.java
    public class Invoice {
        private final String partNumber;
        private final String partDescription;
        private int quantity;
        private double pricePerItem;


        // Konstruktor.
        public Invoice(String partNumber, String partDescription, int quantity,
                       double pricePerItem) {
            if (quantity < 0) { // Walidacja liczby sztuk.
                throw new IllegalArgumentException("Liczba sztuk musi być >= 0");
            }

            if (pricePerItem < 0.0) { // Walidacja ceny za sztukę.
                throw new IllegalArgumentException("Cena za sztukę musi być >= 0");
            }

            this.quantity = quantity;
            this.partNumber = partNumber;
            this.partDescription = partDescription;
            this.pricePerItem = pricePerItem;
        }

        // Pobierz numer części.
        public String getPartNumber() {return partNumber;}

        // Pobierz opis.
        public String getPartDescription() {return partDescription;}

        public String getQuantityAndDescription() {
            return String.format("%s %s", getPartDescription(), getQuantity());
        }

        // UStaw liczbę sztuk.
        public void setQuantity(int quantity) {
            if (quantity < 0) { // Walidacja liczby sztuk.
                throw new IllegalArgumentException("Liczba sztuk musi być >= 0");
            }

            this.quantity = quantity;
        }

        // Pobierz liczbę sztuk.
        public int getQuantity() {return quantity;}

        // Ustaw cenę za sztukę.
        public void setPricePerItem(double pricePerItem) {
            if (pricePerItem < 0.0) {// Walidacja ceny za sztukę.
                throw new IllegalArgumentException("Cena za sztukę musi być >= 0");
            }

            this.pricePerItem = pricePerItem;
        }

        // Pobierz cenę za sztukę.
        public double getPricePerItem() {return pricePerItem;}

        // Zwraca tekstową reprezentację obiektu Invoice.
        @Override
        public String toString() {
            return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                    "Faktura", "Numer części", getPartNumber(), getPartDescription(),
                    "sztuk", getQuantity(), "cena za sztukę", getPricePerItem());
        }

        // Zwróć kwotę na fakturze.
        public double getInvoiceAmount() {
            return getQuantity() * getPricePerItem(); // Oblicz łączny koszt.
        }

        public String getInvoiceAmountAndGetPartDescription() {
            return String.format("%s %s", getInvoiceAmount(), getPartDescription());
        }
    }
