package ru.spbstu.pipeline;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExecutor implements Executor {

    private Runnable consumer;
    private Status status;

    protected final List<Executor> producers = new ArrayList<Executor>();
    protected final Logger logger;
    protected byte[] result;

    AbstractExecutor(Logger logger) {
        this.logger = logger;
    }

    /**
     * Runs logic of executor.
     * @return Success or error.
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

    @Override
    public final void addProducer(Executor producer) {
        producers.add(producer);
    }

    @Override
    public final void setConsumer(Runnable consumer) {
        this.consumer = consumer;
    }
}
