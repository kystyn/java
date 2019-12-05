package ru.spbstu.pipeline;

/**
 * <p>Represents executor working on a pipeline.</p>
 * <p>Should not throw exceptions.</p>
 * <p>
 * Should have ctor with params:
 *     <ol>
 *         <li>String confPath (path to executor config file, can be empty if no config required)</li>
 *         <li>ru.spbstu.pipeline.logging.Logger logger</li>
 *     </ol>
 * </p>
 */
public interface Executor extends
        Producer, InitializableProducer,
        Consumer, InitializableConsumer {
}
