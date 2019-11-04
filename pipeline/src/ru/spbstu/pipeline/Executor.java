package ru.spbstu.pipeline;

/**
 * Represents executor working on a pipeline.
 * <p>
 * Should have ctor with params:
 * String confPath (path to executor config file)
 * Executor consumer
 * ru.spbstu.pipeline.Logger logger
 * </p>
 */
public interface Executor extends Consumer, RunnableWithStatus {
}

interface Consumer {

    void put(byte[] ba);
}

interface RunnableWithStatus extends Runnable {

    Status lastRunStatus();
}
