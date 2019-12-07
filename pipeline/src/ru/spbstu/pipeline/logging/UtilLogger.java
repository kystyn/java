package ru.spbstu.pipeline.logging;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * Decorates java.util.logging.ru.spbstu.pipeline.logging.Logger for unified interface.
 */
public final class UtilLogger implements Logger {

    @NotNull
    private java.util.logging.Logger logger;

    public static UtilLogger of(@NotNull java.util.logging.Logger logger) {
        return new UtilLogger(logger);
    }

    private UtilLogger(@NotNull java.util.logging.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(@NotNull String msg) {
        log(DEFAULT_LEVEL, msg);
    }

    @Override
    public void log(@NotNull String msg, @NotNull Throwable thrown) {
        log(DEFAULT_LEVEL, msg, thrown);
    }

    @Override
    public void log(@NotNull Level level, @NotNull String msg) {
        logger.log(level, msg);
    }

    @Override
    public void log(@NotNull Level level, @NotNull String msg, @NotNull Throwable thrown) {
        logger.log(level, msg, thrown);
    }
}
