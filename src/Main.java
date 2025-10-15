import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ExhibitRepository {
    private final List<Exhibit> exhibits = new ArrayList<>();

    public void addExhibit(Exhibit e) {
        exhibits.add(e);
    }


    public void showAll() {
        for (Exhibit e : exhibits) {
            System.out.println(e.getInfo());
        }
    }
}

class Exhibit {
    private String name;
    private int year;

    public Exhibit(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getInfo() {
        return "Експонат: " + name + ", Рік: " + year;
    }
}


class Painting extends Exhibit {
    private String artist;

    public Painting(String name, int year, String artist) {
        super(name, year);
        this.artist = artist;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Художник: " + artist;
    }
}


class ExhibitFactory {
    public static Exhibit createExhibit(String type, String name, int year, String extra) {
        if ("painting".equalsIgnoreCase(type)) {
            return new Painting(name, year, extra);
        } else {
            return new Exhibit(name, year);
        }
    }
}


class MuseumService {
    private final ExhibitRepository repository;

    public MuseumService(ExhibitRepository repository) {
        this.repository = repository;
    }

    public void addPainting(String name, int year, String artist) {
        Exhibit painting = ExhibitFactory.createExhibit("painting", name, year, artist);
        repository.addExhibit(painting);
        System.out.println("Картину додано!\n");
    }

    public void addSimpleExhibit(String name, int year) {
        Exhibit simple = ExhibitFactory.createExhibit("simple", name, year, "");
        repository.addExhibit(simple);
        System.out.println("Експонат додано!\n");
    }

    public void showAll() {
        repository.showAll();
    }
}


public class Main {
    private static final String MENU = "\n--- МЕНЮ МУЗЕЮ ---\n" +
            "1) Додати картину \n" +
            "2) Додати простий експонат\n" +
            "3) Показати всі експонати\n" +
            "4) Вихід\n" +
            "Виберіть пункт: ";

    public static void main(String[] args) {
        ExhibitRepository repository = new ExhibitRepository();
        MuseumService museum = new MuseumService(repository);


        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print(MENU);
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введіть назву картини: ");
                    String pName = sc.nextLine();
                    System.out.print("Введіть рік: ");
                    int pYear = parseIntSafe(sc.nextLine());
                    System.out.print("Введіть ім'я художника: ");
                    String artist = sc.nextLine();
                    museum.addPainting(pName, pYear, artist);
                    break;

                case "2":
                    System.out.print("Введіть назву експоната: ");
                    String eName = sc.nextLine();
                    System.out.print("Введіть рік: ");
                    int eYear = parseIntSafe(sc.nextLine());
                    museum.addSimpleExhibit(eName, eYear);
                    break;

                case "3":
                    museum.showAll();
                    break;

                case "4":
                    running = false;
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.\n");
            }
        }

        System.out.println("Дякуємо за використання системи музею!");
    }


    private static int parseIntSafe(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

