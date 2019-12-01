package ru.spbstu.pipeline;

public interface Consumer extends Fallible, Runnable {

    /**
     * Checks producer status and loads ready data from it if success.
     *
     * @return Length of loaded data part from the beginning of provided buffer.
     */
    long loadDataFrom(Producer producer);
}
