package ru.spbstu.pipeline;

import java.util.Optional;

public interface Producer extends Fallible {

    /**
     * @return Data with type from list of consumer's acceptable types
     * or empty if neither type is supported.
     */
    Optional<Object> get();
}
