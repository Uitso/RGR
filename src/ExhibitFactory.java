public class ExhibitFactory {
    public static Exhibit createExhibit(String type, String name, int year, String extra) {
        if ("painting".equalsIgnoreCase(type)) {
            return new Painting(name, year, extra);
        } else {
            return new Exhibit(name, year);
        }
    }
}