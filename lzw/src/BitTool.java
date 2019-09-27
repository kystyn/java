import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BitTool {
    private static int startCodeSize = 8; // in bits

    public BitTool( String outFileName, Logger logger ) {
        this.logger = logger;
        try {
            outFile = new FileWriter(outFileName);
        } catch (IOException e) {
            logger.registerLog(Logger.ErrorType.BAD_FILE, e.getMessage());
        }

        pointer = 0;
        codeSize = startCodeSize;
        buffer = new byte[startCodeSize];

        for (byte c : buffer)
            c = -128;
    }

    public void setCodeSize( int size ) {
        flushBuffer();
        // no '-128' code. '-128' is border of dictionaries with different size
    }


    // suppose big-endian: 1_10=10000000_2, not 00000001_2
    public void writeCode( int code ) {
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
    private FileWriter outFile;
    private Logger logger;
}