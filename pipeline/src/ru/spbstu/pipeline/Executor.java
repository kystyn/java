package ru.spbstu.pipeline;

/**
 * Represents executor working on a pipeline.
 * <p>
 * Should have ctor with params:
 * String confPath (path to executor config file)
 * ArrayList<Executor> producers
 * Executor consumer
 * ru.spbstu.pipeline.Logger logger
 * </p>
 */
interface Executor extends Producer, Runnable {
}

interface Producer {

    Status status();

    byte[] result();
}
