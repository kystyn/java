import java.io.BufferedReader;
import java.io.IOException;

class BitReader {
    BitReader( BufferedReader reader ) {
        inFile = reader;
        setCodeSize(9);
        pointer = codeSize * 8;
    }

    void setCodeSize( int codeSize ) {

        this.codeSize = codeSize;
        this.buffer = new byte[codeSize];
    }

    void close() {
        try {
            inFile.close();
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_READ, e.getMessage());
        }
    }

    boolean readCode( Integer code ) {
        if (pointer == codeSize * 8) {
            boolean finish = false;
            for (int i = 0; i < buffer.length && !finish; i++)
                try {
                    buffer[i] = (byte) (inFile.read());
                    finish = (buffer[i] == -1);
                } catch (IOException e) {
                    Logger.get().registerLog(Logger.ErrorType.BAD_READ, e.getMessage());
                }

            if (finish)
                return false;
            pointer = 0;
        }

        for (int i = 0; i < codeSize; i++) {
            int bit = buffer[pointer / 8] & (1 << (pointer % 8));
            code |= (bit << i);
            pointer++;
        }

        return true;
    }

    private BufferedReader inFile;
    private int pointer;
    private int codeSize;
    private byte[] buffer;
}
