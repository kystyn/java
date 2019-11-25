package ru.spbstu.pipeline;

@FunctionalInterface
public interface Fallible {
    Status status();
}
