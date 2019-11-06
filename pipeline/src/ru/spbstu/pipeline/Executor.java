package ru.spbstu.pipeline;

/**
 * Represents executor working on a pipeline.
 * <p>
 * Should have ctor with params:
 * String confPath (path to executor config file)
 * List<Executor> producers
 * Runnable consumer
 * ru.spbstu.pipeline.Logger logger
 * </p>
 */
interface Executor extends Producer, RunnableWithStatus {
}

interface Producer {

    byte[] get();
}

interface RunnableWithStatus extends Runnable {

    Status status();
}
