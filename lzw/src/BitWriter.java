import java.io.Writer;
import java.io.IOException;

class BitWriter {

    BitWriter( Writer writer ) {
        this.outFile = writer;

        pointer = 0;

        // in bits
        int startCodeSize = 9;
        codeSize = startCodeSize;
        buffer = new byte[startCodeSize];

        for (byte c : buffer)
            c = -128;
    }

    void setCodeSize( int size ) {
        flushBuffer();
        // no '-128' code. '-128' is border of dictionaries with different size
    }

    // suppose big-endian: 1_10=10000000_2, not 00000001_2
    void writeCode( int code ) {
        for (int i = 0; i < codeSize; i++) {
            int bit = code & (1 << i);
            buffer[pointer / 8] |= (bit << (pointer % 8));
        }

        if (pointer == codeSize * 8)
            flushBuffer();
    }

    private void flushBuffer() {
        try {
            pointer = 0;
            for (byte b : buffer)
                outFile.write(b);
        } catch (IOException e) {
            logger.registerLog(Logger.ErrorType.BAD_WRITE, e.getMessage());
        }
    }

    private int pointer; // bit where we are now
    private int codeSize;
    private byte[] buffer;
    private Writer outFile;
    private Logger logger;
}