package ru.spbstu.pipeline;

import java.util.List;

public interface Consumer extends Fallible, Runnable {

    /**
     * Loads ready data from producer.
     */
    void loadDataFrom(Producer producer);
}

interface InitializableConsumer {

    void addProducer(Producer producer);
    void addProducers(List<Producer> producers);
}
