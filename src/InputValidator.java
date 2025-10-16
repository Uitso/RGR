public class InputValidator {
    public static int parseYear(String input) throws InvalidYearException {
        try {
            int year = Integer.parseInt(input);
            if (year < 0) throw new InvalidYearException("Рік не може бути від'ємним");
            return year;
        } catch (NumberFormatException e) {
            throw new InvalidYearException("Введено неправильний формат року");
        }
    }
}