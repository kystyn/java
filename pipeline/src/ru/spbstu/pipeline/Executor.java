package ru.spbstu.pipeline;

/**
 * Represents executor working on a pipeline.
 * <p>
 * Should have ctor with params:
 * String confPath (path to executor config file)
 * ru.spbstu.pipeline.Logger logger
 * </p>
 */
interface Executor extends Producer, Consumer, RunnableWithStatus {
}

interface Producer {

    void setConsumer(Runnable consumer);
    byte[] get();
}

interface Consumer {

    void addProducer(Executor producer);
}

interface RunnableWithStatus extends Runnable {

    Status status();
}
