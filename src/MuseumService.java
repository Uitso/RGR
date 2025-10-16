public class MuseumService {
    private ExhibitRepository repository;

    public MuseumService(ExhibitRepository repository) {
        this.repository = repository;
    }

    public void addPainting(String name, int year, String artist) {
        Exhibit painting = ExhibitFactory.createExhibit("painting", name, year, artist);
        repository.addExhibit(painting);
        System.out.println("Картину успішно додано!\n");
    }

    public void addExhibit(String name, int year) {
        Exhibit exhibit = ExhibitFactory.createExhibit("simple", name, year, "");
        repository.addExhibit(exhibit);
        System.out.println("Експонат успішно додано!\n");
    }

    public void showAll() {
        repository.showAll();
    }
}