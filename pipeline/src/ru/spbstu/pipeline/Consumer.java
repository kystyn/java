package ru.spbstu.pipeline;

import java.util.List;

public interface Consumer extends Fallible, Runnable {

    /**
     * Checks producer status and loads ready data from it if OK.
     */
    void loadDataFrom(Producer producer);
}

interface InitializableConsumer {

    void addProducer(Producer producer);
    void addProducers(List<Producer> producers);
}
