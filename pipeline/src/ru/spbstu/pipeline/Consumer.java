package ru.spbstu.pipeline;

import java.util.Collections;
import java.util.Set;

public interface Consumer extends Fallible, Runnable {

    /**
     * Types of input data consumer can work with.
     * Class full name is for example String.class.getCanonicalName().
     * @return Set of full names of accessible input types for consumer.
     */
    default Set<String> acceptableInputTypes() {
        return Collections.singleton(byte[].class.getCanonicalName());
    }

    /**
     * Checks producer status and loads ready data from it if OK.
     */
    void loadDataFrom(Producer producer);
}

