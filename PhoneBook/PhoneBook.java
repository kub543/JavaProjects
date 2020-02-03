import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

class PhoneBook {
    ValidateInput validateInput = new ValidateInput();
    Scanner input = new Scanner(System.in);
    List<Contact> myPhoneBook = new ArrayList<>();

    public void showPhoneBook() {
        for (int i =0; i < myPhoneBook.size(); i++) {
            System.out.printf("%d.%n %s%n %s%n %s%n",
                                i + 1,
                                myPhoneBook.get(i).getName(),
                                myPhoneBook.get(i).getPhoneNumber(),
                                myPhoneBook.get(i).getEmail()
            );
        }
    }

    public Contact searchContact() {
        Contact contact;
        System.out.print("Wpisz nazwe: ");
        String searchContact = input.nextLine();
        for (int i = 0; i < myPhoneBook.size(); i++) {
            if (searchContact.equals(myPhoneBook.get(i).getName())) {
                contact = myPhoneBook.get(i);
                return contact;
            }
        }
        System.out.println("Nie znaleziono takiego kontaktu!");
        System.out.println("Chcesz dodać kontakt?");
        return null;
    }

    public String putName() {
            System.out.print("Wprowadź nazwę: ");
            String in = input.nextLine();
            if (validateInput.validateName(in)) {
                return in;
            } else {
                System.out.println("Niepoprawne imię");
                return putName();
            }
    }

    public String putPhoneNumber() {
        System.out.print("Wprowadź numer telefonu: ");
        String in = input.nextLine();
        if (validateInput.validatePhone(in)) {
            return in;
        } else {
            System.out.println("Nieprawidłowy numer telefonu (wzór: 111-111-111)");
            return putPhoneNumber();
        }
    }

    public String putEmail() {
        System.out.print("Wprowadź email: ");
        String in = input.nextLine();
        if (validateInput.validateEmail(in)) {
            return in;
        } else {
            System.out.println("Nieprawidłowy email");
            return putEmail();
        }
    }

    public void addContact() {
        Contact contact = new Contact(putName(), putPhoneNumber(), putEmail());
        if (myPhoneBook.contains(contact)) {
            System.out.println("taki kontakt już istnieje!");
        } else {
            myPhoneBook.add(contact);
            Collections.sort(myPhoneBook);
        }
    }

    public void editContact(Contact contact) {
        while (true) {
            System.out.print("Wpisz 1 aby edytować nazwe, wpisz 2 aby edytować numer telefonu, " +
                    "wpisz 3 aby edytować email, lub 0 aby powrócić do menu.");
            int chaise = input.nextInt();
            if (chaise == 1) {
                input.nextLine();
                String newName = putName();
                contact.setName(newName);
            } else if (chaise == 2) {
                input.nextLine();
                String newPhoneNumber = putPhoneNumber();
                contact.setPhoneNumber(newPhoneNumber);
            } else if (chaise == 3) {
                input.nextLine();
                String newEmail = putEmail();
                contact.setEmail(newEmail);
            } else {
                break;
            }
        }
    }

    public void deleteContact(Contact contact) {
        myPhoneBook.remove(contact);
        System.out.println("Usunięto kontakt");
    }

    public void saveConactsToFile() {
        System.out.println("Wpisz gdzie chcesz zapisać plik");
        String filePath = input.nextLine();
        if (validateInput.validateInputWay(filePath)) {
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                for (int i = 0; i < myPhoneBook.size(); i++) {
                    fileWriter.write(String.format("%d. %s%n", i + 1, myPhoneBook.get(i)));
                }
            } catch (IOException e) {
                System.out.println("Zapisywanie do pliku nie powiodło się!");
            }
            System.out.println("Zapisywanie powiodło się");
        } else {
            System.out.println("Nieprawidłowa ścieżka zapisu");
            saveConactsToFile();
        }

    }

    @Override
    public String toString() {
        return "Moje kontakty: " + myPhoneBook;
    }
}