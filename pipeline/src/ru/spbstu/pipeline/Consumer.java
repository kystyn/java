package ru.spbstu.pipeline;

public interface Consumer extends Fallible, Runnable {

    /**
     * Checks producer status and loads ready data from it if success.
     */
    void loadDataFrom(Producer producer);
}
