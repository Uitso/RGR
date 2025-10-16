import java.util.Scanner;

public class Main {
    private static final String MENU = "\n=== МУЗЕЙ ===\n" +
            "1) Додати картину\n" +
            "2) Додати експонат\n" +
            "3) Показати експонати\n" +
            "4) Вихід\n" +
            "Ваш вибір: ";

    public static void main(String[] args) {
        ExhibitRepository repository = new ExhibitRepository();
        MuseumService service = new MuseumService(repository);
        Scanner scanner = new Scanner(System.in);

        boolean work = true;
        while (work) {
            System.out.print(MENU);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Назва картини: ");
                    String pName = scanner.nextLine();
                    System.out.print("Рік: ");
                    int pYear = readYear(scanner);
                    System.out.print("Художник: ");
                    String artist = scanner.nextLine();
                    service.addPainting(pName, pYear, artist);
                    break;

                case "2":
                    System.out.print("Назва експоната: ");
                    String eName = scanner.nextLine();
                    System.out.print("Рік: ");
                    int eYear = readYear(scanner);
                    service.addExhibit(eName, eYear);
                    break;

                case "3":
                    service.showAll();
                    break;

                case "4":
                    work = false;
                    System.out.println("Дякуємо за користування музеєм!");
                    break;

                default:
                    System.out.println("Невірний вибір, спробуйте ще раз!\n");
            }
        }
    }

    private static int readYear(Scanner scanner) {
        try {
            return InputValidator.parseYear(scanner.nextLine());
        } catch (InvalidYearException e) {
            System.out.println("Помилка: " + e.getMessage());
            return 0;
        }
    }
}