package ru.spbstu.pipeline;

/**
 * Represents executor working on a pipeline.
 * <p>
 * Should not throw exceptions.
 * <p>
 * Should have ctor with params:
 * String confPath (path to executor config file, can be empty if no config required)
 * ru.spbstu.pipeline.logging.Logger logger
 */
public interface Executor extends
        Producer, InitializableProducer,
        Consumer, InitializableConsumer {
}
