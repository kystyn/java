package ru.spbstu.pipeline;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Consumer extends Fallible, Runnable {

    void loadDataFrom(@NotNull Producer producer);
}

interface InitializableConsumer {

    void addProducer(@NotNull Producer producer);
    void addProducers(@NotNull List<Producer> producers);
}
