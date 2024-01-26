package yugo.exception;

public class ProductNotFoundException extends RuntimeException {

    ProductNotFoundException(String msg) {
        super(msg); ;
    }
}
