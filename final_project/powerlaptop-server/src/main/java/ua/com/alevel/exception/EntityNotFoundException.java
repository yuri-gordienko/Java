package ua.com.alevel.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String msg) {    // принимает меседж
        super(msg); // и кидает паренту
        // грубая ошибка (может возникнуть когда по указанному id товара в базе нет, когда БД забита)
        // в этом случае нужно исправлять ситуацию через RestExceptionHandler
    }
}