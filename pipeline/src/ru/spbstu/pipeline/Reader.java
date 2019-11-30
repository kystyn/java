package ru.spbstu.pipeline;

/**
 * Reads data in loop.
 * Places status INPUT_STREAM_END at the end, and calls consumers last time.
 */
public interface Reader extends Producer, InitializableProducer, Runnable {
}
