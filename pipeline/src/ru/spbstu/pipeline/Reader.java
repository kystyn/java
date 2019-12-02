package ru.spbstu.pipeline;

/**
 * <ul>
 *     <li>Reads data in loop.</li>
 *     <li>Places status INPUT_STREAM_END at the end, and calls consumers last time.</li>
 * </ul>
 */
public interface Reader extends Producer, InitializableProducer, Runnable {
}
