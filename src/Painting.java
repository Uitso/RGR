public class Painting extends Exhibit {
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