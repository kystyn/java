package ru.spbstu.pipeline;

import java.util.List;

public interface Producer extends Fallible {

    void addConsumer(Consumer consumer);
    void addConsumers(List<Consumer> consumers);

    DataStorage get();
}
