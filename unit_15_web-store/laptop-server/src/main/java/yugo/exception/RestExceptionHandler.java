package yugo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import yugo.data.response.DataContainer;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<DataContainer<String>> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataContainer<>(exception.getMessage()));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<DataContainer<String>> handleEntityNotFoundException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataContainer<>(exception.getMessage()));
    }
}
