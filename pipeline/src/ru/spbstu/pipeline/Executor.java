package ru.spbstu.pipeline;

/**
 * <p>Represents executor working on a pipeline.</p>
 * <p>Should not throw exceptions.</p>
 * <p>
 *     Should have ctor with params:
 *     <ul>
 *         <li>String confPath (path to executor config file, can be empty if no config required)</li>
 *         <li>ru.spbstu.pipeline.logging.Logger logger</li>
 *     </ul>
 * </p>
 */
public interface Executor extends
        Producer, InitializableProducer,
        Consumer, InitializableConsumer {
}
