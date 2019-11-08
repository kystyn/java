package ru.spbstu.pipeline;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;

public class DefaultWriter implements Writer {

    private final OutputStream os;
    private final Executor producer;
    private final Logger logger;

    private Status status;

    public DefaultWriter(OutputStream os, Executor producer, Logger logger) {
        this.os = os;
        this.producer = producer;
        this.logger = logger;
    }

    @Override
    public void run() {
        if (producer.status() != Status.OK) {
            status = producer.status();
            return;
        }

        status = Status.OK;
        try {
            os.write(producer.get());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Writing error", e);
            status = Status.ERROR;
        }
    }

    @Override
    public Status status() {
        return status;
    }
}
