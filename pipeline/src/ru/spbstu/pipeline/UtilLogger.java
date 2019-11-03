package ru.spbstu.pipeline;

import java.util.logging.Level;

/**
 * Decorates java.util.logging.ru.spbstu.pipeline.Logger for unified interface.
 */
public final class UtilLogger implements Logger {

    private java.util.logging.Logger logger;

    public static UtilLogger of(java.util.logging.Logger logger) {
        return new UtilLogger(logger);
    }

    private UtilLogger(java.util.logging.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(Level level, String msg) {
        logger.log(level, msg);
    }

    @Override
    public void log(Level level, String msg, Throwable thrown) {
        logger.log(level, msg, thrown);
    }
}
