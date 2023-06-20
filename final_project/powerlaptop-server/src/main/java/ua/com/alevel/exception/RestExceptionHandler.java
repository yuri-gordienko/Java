package ua.com.alevel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ua.com.alevel.data.response.DataContainer;

@RestControllerAdvice   // позволяет инкапсулировать в этом классе отлов всех эксепшенов которые мы кидаем в системе
// или система сама кидает
public class RestExceptionHandler { // спец класс для отлова исключений

    @ExceptionHandler(value = EntityNotFoundException.class) // чтоб эксепшн заработал (обрабатывает конкретный тип эксепшена)
    public ResponseEntity<DataContainer<String>> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataContainer<>(exception.getMessage()));
    // DataContainer создавали, чтоб все ответы были универсальными для фронта
        // принимаем наш эксепшн handleEntityNotFoundException(EntityNotFoundException exception)
    // возвращаем статус(неправильный запрос 400), в бади сообщение выводим, можно показывать
    }

    @ExceptionHandler(value = UserExistException.class)
    public ResponseEntity<DataContainer<String>> handleUserExistException(UserExistException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataContainer<>(exception.getMessage()));
    }

    @ExceptionHandler(value = RuntimeException.class)   // отлавливает эксепшены глобально (любой, который может вылетить,
    // если мы даже пропустили где-то выкинуть)
    public ResponseEntity<DataContainer<String>> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataContainer<>(exception.getMessage()));
    }
}
