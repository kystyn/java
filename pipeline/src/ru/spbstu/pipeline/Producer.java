package ru.spbstu.pipeline;

public interface Producer extends Fallible {

    /**
     * @return Byte array of even length.
     */
    Object get();
}
