package seminar3.advanced_exceptions;

public class SexException extends Exception {
    public SexException() {
    }

    public void sexException(String s) {
        System.out.println("Exception: SexNotCorrectData");
        System.out.printf("It`s not correct data: %s", s);
        System.out.println();
    }
}
