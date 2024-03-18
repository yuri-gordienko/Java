package ua.com.alevel.service.logger.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.com.alevel.service.logger.LoggerLevel;
import ua.com.alevel.service.logger.LoggerService;

@Service("loggerService")
public class LoggerServiceImpl implements LoggerService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger(LoggerLevel.INFO.getLevel());
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger(LoggerLevel.WARN.getLevel());
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(LoggerLevel.ERROR.getLevel());

    @Override
    public void log(LoggerLevel level, String message) {
        switch (level) {
            case INFO -> LOGGER_INFO.info(message);
            case WARN -> LOGGER_WARN.warn(message);
            case ERROR -> LOGGER_ERROR.error(message);
        }
    }
}
