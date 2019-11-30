package ru.spbstu.pipeline;

public interface Consumer extends Fallible, Runnable {

    /**
     * Checks producer status and loads ready data from it if success.
     *
     * @return True if data read, waiting for next portion.
     * False otherwise waiting for additional data portion,
     * producer then should provide more data next time.
     */
    boolean loadDataFrom(Producer producer);
}
