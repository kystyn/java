package ru.spbstu.pipeline;

import java.util.List;

public interface InitializableProducer {
    void addConsumer(Consumer consumer);
    void addConsumers(List<Consumer> consumers);
}
