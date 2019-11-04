package ru.spbstu.pipeline;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;

public class DefaultWriter implements Writer {

    private final OutputStream os;
    private final Logger logger;

    private Status lastRunStatus = Status.OK;
    private byte[] bytes;

    public DefaultWriter(OutputStream os, Logger logger) {
        this.os = os;
        this.logger = logger;
    }

    @Override
    public void run() {
        lastRunStatus = Status.OK;

        try {
            os.write(bytes);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Write error", e);
            lastRunStatus = Status.INTERNAL_ERROR;
        }
    }

    @Override
    public void put(byte[] ba) {
        bytes = ba;
    }

    @Override
    public Status lastRunStatus() {
        return lastRunStatus;
    }
}
