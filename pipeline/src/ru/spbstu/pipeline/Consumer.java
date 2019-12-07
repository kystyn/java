package ru.spbstu.pipeline;

import org.jetbrains.annotations.NotNull;

public interface Consumer extends Fallible, Runnable {

    /**
     * Saves link to data, provided by producer
     * (via get() in {@link ru.spbstu.pipeline.Producer.DataAccessor}).
     * Does not modify data (make copy if needed).
     *
     * @return 0 if unable to process provided data.
     * length() value from {@link ru.spbstu.pipeline.Producer.DataAccessor} otherwise.
     */
    long loadDataFrom(@NotNull Producer producer);
}
