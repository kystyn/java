package ru.spbstu.pipeline;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class DefaultWriter implements Writer {

    private final OutputStream os;
    private final Logger logger;
    private final List<Executor> producers = new ArrayList<Executor>();

    private Status status;

    public DefaultWriter(OutputStream os, Logger logger) {
        this.os = os;
        this.logger = logger;
    }

    @Override
    public void run() {
        Executor producer = producers.get(0);
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

    @Override
    public void addProducer(Executor producer) {
        producers.add(producer);
    }
}
