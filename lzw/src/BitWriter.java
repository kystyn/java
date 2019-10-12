import java.io.BufferedWriter;
import java.io.Writer;
import java.io.IOException;

class BitWriter {

    BitWriter( BufferedWriter writer ) {
        this.outFile = writer;
        pointer = 0;
        codeSize = -1;
        buffer = null;
        // in bits
        setCodeSize(9);
    }

    void setCodeSize( int size ) {
        if (size == codeSize)
            return;

        codeSize = size;
        flushBuffer();
        buffer = new char[codeSize];
    }

    void close() {
        try {
            flushBuffer();
            outFile.close();
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_WRITE, e.getMessage());
        }
    }

    // suppose big-endian: 1_10=10000000_2, not 00000001_2
    void writeCode( int code ) {
        for (int i = 0; i < codeSize; i++) {
            int bit = (code & (1 << (codeSize - 1 - i))) >> (codeSize - 1 - i);
            buffer[pointer / 8] |= (bit << (pointer % 8));
            pointer++;
        }

        if (pointer == codeSize * 8)
            flushBuffer();
    }

    private void flushBuffer() {
        try {
            pointer = 0;
            if (buffer == null)
                return;
            outFile.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_WRITE, e.getMessage());
        }
    }

    private int pointer; // bit where we are now
    private int codeSize;
    private char[] buffer;
    private BufferedWriter outFile;
}