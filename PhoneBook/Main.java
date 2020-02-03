import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            Main.showMainMenu();
            int option = input.nextInt();
            switch (option) {
                case 1:
                    phoneBook.showPhoneBook();
                    break;
                case 2:
                    Contact contact = phoneBook.searchContact();
                    if (contact == null) {
                        System.out.println("Nie znaleziono kontaktu. Czy chcesz dodać kontakt?");
                        System.out.println("Wpisz 1 aby dodać kontakt, lub 0 aby wrócić do głównego menu.");
                        int chose = input.nextInt();
                        if (chose == 1) {
                            phoneBook.addContact();
                        } else {
                            break;
                        }
                    } else {
                        System.out.println(contact);
                        System.out.println("Wpisz 1 aby edytować kontakt, 2 aby usunąć kontakt, lub 0 aby otworzyć menu.");
                        int chose = input.nextInt();
                        if (chose == 1) {
                            phoneBook.editContact(contact);
                        } else if (chose == 2) {
                            phoneBook.deleteContact(contact);
                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
                    phoneBook.addContact();
                    break;
                case 4:
                    phoneBook.saveConactsToFile();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
        }
            public static void showMainMenu(){
                System.out.println();
                System.out.println("------------------------------");
                System.out.println("wpisz --1-- aby wyświetlić kontakty");
                System.out.println("wpisz --2-- aby wyszukać kontakt");
                System.out.println("wpisz --3-- aby dodać kontakt");
                System.out.println("wpisz --4-- aby zapisać kontakty do pliku");
                System.out.println("wpisz --0-- aby wyjść z programu");
                System.out.println("------------------------------");
                System.out.println();
            }



}