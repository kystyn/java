package ru.spbstu.pipeline;

import java.util.List;

public interface Producer extends Fallible {

    DataStorage get();
}

interface InitializableProducer {

    void addConsumer(Consumer consumer);
    void addConsumers(List<Consumer> consumers);
}
