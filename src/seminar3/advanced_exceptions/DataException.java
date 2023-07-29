package seminar3.advanced_exceptions;

public class DataException extends Exception{
    public DataException() {
    }

    public void dataException(String data) {
        System.out.println("Exception: DataNotCorrectFormat");
        System.out.printf("It`s not correct format: %s", data);
        System.out.println();
    }
}