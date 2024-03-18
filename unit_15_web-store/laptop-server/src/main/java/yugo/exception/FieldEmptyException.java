package yugo.exception;

public class FieldEmptyException extends RuntimeException { // класс для тестов на проверку заполненности полей

    public FieldEmptyException(String msg) {
        super(msg);
    }
}
