package seminar3.advanced_exceptions;

public class DateException extends Exception {
    public DateException() {
    }

    public void dataException(String date) {
        System.out.println("Exception: DateNotCorrectFormat");
        System.out.printf("It`s not correct date format: %s", date);
        System.out.println();
    }
}