package ua.com.alevel.exception;

public class UserExistException extends RuntimeException {

    public UserExistException(String msg) {
        super(msg);
    }
}
