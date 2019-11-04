package ru.spbstu.pipeline;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class DefaultReader implements Reader {

    private static final int DEFAULT_BUFFER_SIZE = 512;

    private final InputStream is;
    private final int bufferSize;
    private final Executor consumer;
    private final Logger logger;

    private Status lastRunStatus = Status.OK;

    public DefaultReader(InputStream is, Executor consumer, Logger logger) {
        this(is, DEFAULT_BUFFER_SIZE, consumer, logger);
    }

    public DefaultReader(InputStream is, int bufferSize, Executor consumer, Logger logger) {
        this.is = is;
        this.bufferSize = bufferSize;
        this.consumer = consumer;
        this.logger = logger;
    }

    @Override
    public Status lastRunStatus() {
        return lastRunStatus;
    }

    @Override
    public void run() {
        lastRunStatus = Status.OK;

        byte[] buff = new byte[bufferSize];
        try {
            while (is.read(buff, 0, bufferSize) != -1) {
                consumer.put(buff);
                consumer.run();
                Status status = consumer.lastRunStatus();
                if (status != Status.OK) {
                    lastRunStatus = Status.CONSUMER_ERROR;
                    return;
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO error", e);
            lastRunStatus = Status.INTERNAL_ERROR;
        }
    }
}
