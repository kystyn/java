package ru.spbstu.pipeline.logging;

import java.util.logging.Level;

public interface Logger {

    Level DEFAULT_LEVEL = Level.INFO;

    void log(String msg);
    void log(String msg, Throwable thrown);

    void log(Level level, String msg);
    void log(Level level, String msg, Throwable thrown);
}