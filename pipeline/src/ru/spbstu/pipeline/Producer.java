package ru.spbstu.pipeline;

public interface Producer extends Fallible {

    /**
     * @return Processed data.
     */
    Object get();
}
