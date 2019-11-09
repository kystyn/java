package ru.spbstu.pipeline;

import ru.spbstu.pipeline.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExecutor implements Executor {

    protected final Logger logger;
    protected Status status;
    protected byte[] result;

    protected AbstractExecutor(Logger logger) {
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
}
