package ru.spbstu.pipeline;

import java.util.List;

public interface Consumer extends Fallible, Runnable {

    void addProducer(Producer producer);
    void addProducers(List<Producer> producers);

    /**
     * Loads ready data from producer.
     */
    void loadDataFrom(Producer producer);
}
