package ru.spbstu.pipeline;

import org.jetbrains.annotations.NotNull;

public interface Fallible {

    @NotNull Status status();
}
