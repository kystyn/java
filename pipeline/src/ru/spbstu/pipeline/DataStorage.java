package ru.spbstu.pipeline;

/**
 * Represent immutable data storage class.
 */
public interface DataStorage {

    /**
     * @return Byte array or null.
     */
    byte[] bytes();

    /**
     * @return Char array or null.
     */
    char[] chars();

    /**
     * @return String or null.
     */
    String string();
}
