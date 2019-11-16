package ru.spbstu.pipeline;

import java.util.List;

public interface Producer extends Fallible {

    /**
     * @return Byte array of even length.
     */
    Object get();
}

interface InitializableProducer {

    void addConsumer(Consumer consumer);
    void addConsumers(List<Consumer> consumers);
}
