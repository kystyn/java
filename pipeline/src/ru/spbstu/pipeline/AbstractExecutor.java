package ru.spbstu.pipeline;

import ru.spbstu.pipeline.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExecutor implements Executor {

    protected final List<Executor> producers = new ArrayList<Executor>();
    protected final List<Runnable> consumers = new ArrayList<Runnable>();
    protected final Logger logger;

    protected Status status;
    protected byte[] result;

    AbstractExecutor(Logger logger) {
        this.logger = logger;
    }

    @Override
    public final Status status() {
        return status;
    }

    @Override
    public final byte[] get() {
        return result;
    }

    @Override
    public final void addProducer(Executor producer) {
        producers.add(producer);
    }

    @Override
    public final void addConsumer(Runnable consumer) {
        consumers.add(consumer);
    }
}
