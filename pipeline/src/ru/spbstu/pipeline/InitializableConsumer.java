package ru.spbstu.pipeline;

import java.util.List;

public interface InitializableConsumer {
    void addProducer(Producer producer);
    void addProducers(List<Producer> producers);
}
