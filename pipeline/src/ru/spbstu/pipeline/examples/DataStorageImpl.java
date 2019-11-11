package ru.spbstu.pipeline.examples;

import ru.spbstu.pipeline.DataStorage;

public class DataStorageImpl implements DataStorage {

    private byte[] bytes;
    private char[] chars;
    private String string;

    public DataStorageImpl(byte[] bytes) {
        this.bytes = bytes;
        // TODO
        // TODO
    }

    public DataStorageImpl(char[] chars) {
        // TODO convert to bytes
        this.chars = chars;
        // TODO convert to string
    }

    public DataStorageImpl(String string) {
        // TODO
        // TODO
        this.string = string;
    }

    @Override
    public byte[] bytes() {
        return bytes;
    }

    @Override
    public char[] chars() {
        return chars;
    }

    @Override
    public String string() {
        return string;
    }
}
