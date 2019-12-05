package ru.spbstu.pipeline;

public interface Consumer extends Runnable {

    /**
     * Checks producer status and loads ready data from it if success.
     * Does not modify provided data inplace (make copy if needed).
     * @return Length of loaded data part from the beginning of provided buffer.
     */
    long loadDataFrom(Producer producer);
}
