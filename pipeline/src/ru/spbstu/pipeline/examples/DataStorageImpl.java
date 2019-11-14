package ru.spbstu.pipeline.examples;

import ru.spbstu.pipeline.DataStorage;

@Deprecated // Do not use it, write same yourself!
public class DataStorageImpl implements DataStorage {

    private final byte[] bytes;
    private final char[] chars;
    private final String string;

    public DataStorageImpl(byte[] bytes) {
        this.bytes = bytes;
        this.chars = null;
        this.string = null;
    }

    public DataStorageImpl(char[] chars) {
        this.bytes = null;
        this.chars = chars;
        // TODO convert to string
    }

    public DataStorageImpl(String string) {
        this.bytes = null;
        // TODO convert to char array
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
