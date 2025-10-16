import java.util.ArrayList;
import java.util.List;

public class ExhibitRepository {
    private final List<Exhibit> exhibits = new ArrayList<>();

    public void addExhibit(Exhibit e) {
        exhibits.add(e);
    }

    public void showAll() {
        if (exhibits.isEmpty()) {
            System.out.println("Музей порожній.");
            return;
        }
        for (Exhibit e : exhibits) {
            System.out.println(e.getInfo());
        }
    }
}