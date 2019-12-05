package ru.spbstu.pipeline;

public interface Consumer extends Runnable {

    /**
     * Checks producer status and saves link to ready data from it if {@link Status}.OK.
     * @return Length of data part from the beginning, that will be processed in run().
     * Rest part should be cached on producer's side.
     */
    long loadDataFrom(Producer producer);
}
