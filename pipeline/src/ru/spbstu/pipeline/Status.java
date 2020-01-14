package ru.spbstu.pipeline;

public enum Status {
    // Success statuses.
    OK,
    INPUT_STREAM_END, // Do not use it!!!

    // Failure statuses.
    ERROR,
    READER_ERROR,
    EXECUTOR_ERROR,
    WRITER_ERROR
}
