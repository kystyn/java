package ru.spbstu.pipeline.logging;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public interface Logger {

    @NotNull Level DEFAULT_LEVEL = Level.INFO;

    void log(@NotNull String msg);

    void log(@NotNull String msg, @NotNull Throwable thrown);

    void log(@NotNull Level level, @NotNull String msg);

    void log(@NotNull Level level, @NotNull String msg, @NotNull Throwable thrown);
}