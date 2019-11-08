package ru.spbstu.pipeline;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public final class DefaultReader implements Reader {

    private static final int DEFAULT_BUFFER_SIZE = 512;

    private final InputStream is;
    private final byte[] result;
    private Runnable consumer;
    private final Logger logger;
    private Status status = Status.EMPTY;

    public DefaultReader(InputStream is, Logger logger) {
        this(is, DEFAULT_BUFFER_SIZE, logger);
    }

    public DefaultReader(InputStream is, int bufferSize, Logger logger) {
        this.is = is;
        this.result = new byte[bufferSize];
        this.logger = logger;
    }

    @Override
    public void run() {
        status = Status.OK;

        try {
            int res = is.read(result, 0, result.length);
            if (res == -1) {
                logger.log(Level.INFO, "End of source file");
                status = Status.EMPTY;
            }
            consumer.run();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Reading error", e);
            status = Status.ERROR;
        }
    }

    @Override
    public Status status() {
        return status;
    }

    @Override
    public byte[] get() {
        return result;
    }

    @Override
    public void setConsumer(Runnable consumer) {
        this.consumer = consumer;
    }
}
