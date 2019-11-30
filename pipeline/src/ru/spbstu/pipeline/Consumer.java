package ru.spbstu.pipeline;

import java.util.Collections;
import java.util.Set;

public interface Consumer extends Fallible, Runnable {

    /**
     * Checks producer status and loads ready data from it if OK.
     */
    void loadDataFrom(Producer producer);

    /**
     * Sets accessor for data, produced by producer.
     * @param producer To get data from.
     */
    void setAccessorFor(Producer producer, Accessor accessor);

    /**
     * Types of input data consumer can work with.
     * Class canonical name is for example String.class.getCanonicalName().
     * @return Set of canonical names of accessible input types for consumer.
     */
    default Set<String> acceptableInputTypes() {
        return Collections.singleton(byte[].class.getCanonicalName());
    }
}
