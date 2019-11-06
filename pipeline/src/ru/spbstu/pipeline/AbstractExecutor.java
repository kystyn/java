package ru.spbstu.pipeline;

import java.util.List;

public abstract class AbstractExecutor implements Executor {

    private final Runnable consumer;
    private Status status;

    protected final List<Executor> producers;
    protected final Logger logger;
    protected byte[] result;

    AbstractExecutor(List<Executor> producers, Runnable consumer, Logger logger) {
        this.producers = producers;
        this.consumer = consumer;
        this.logger = logger;
    }

    /**
     * Runs logic of executor.
     * @return Success of error.
     */
    abstract Status execute();

    @Override
    public final void run() {
        status = execute();
        consumer.run();
    }

    @Override
    public final Status status() {
        return status;
    }

    @Override
    public final byte[] get() {
        return result;
    }
}
