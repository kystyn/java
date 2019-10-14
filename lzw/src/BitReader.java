import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

class BitReader {
    BitReader( BufferedReader reader ) {
        inFile = reader;
        setCodeSize(9);
        pointer = codeSize * 8;
    }

    void setCodeSize( int codeSize ) {

        this.codeSize = codeSize;
        buffer = new char[codeSize];
        Arrays.fill(buffer, (char)0);
    }

    void close() {
        try {
            inFile.close();
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_READ, e.getMessage());
        }
    }

    boolean readCode( int[] code ) {
        if (pointer == codeSize * 8) {
            boolean finish = false;
            try {
                int res = inFile.read(buffer, 0, codeSize);
                if (res == -1)
                    return false;
            }
            catch (IOException e) {
                Logger.get().registerLog(Logger.ErrorType.BAD_READ, e.getMessage());
            }

            pointer = 0;
        }

        //int codeVal = 0;

        code[0] = 0;
        for (int i = 0; i < codeSize; i++) {
            int bit = (buffer[pointer / 8] & (1 << (pointer % 8))) >> (pointer % 8);
            code[0] |= (bit << (codeSize - 1 - i));
            pointer++;
         }

        //code = codeVal;

        return code[0] != (1 << codeSize) - 1;
    }

    int getCodeSize() {
        return codeSize;
    }

    private BufferedReader inFile;
    private int pointer;
    private int codeSize;
    private char[] buffer;
}
