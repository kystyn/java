package ru.spbstu.pipeline;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface InitializableConsumer {

    void addProducer(@NotNull Producer producer);

    void addProducers(@NotNull List<Producer> producers);
}
