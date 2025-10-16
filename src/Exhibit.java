public class Exhibit {
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