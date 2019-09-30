import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Config {
    enum Operation {
        COMPRESS,
        DECOMPRESS;
    }

    Config( String fileName ) {
        this.configName = fileName;
        reloadConfig();
    }

    void reloadConfig() {
        try {
            FileReader f = new FileReader(configName);

            String word = "";
            f.read(word.toCharArray());
            String[] val = word.split(" ");

            if (val[0].equalsIgnoreCase("InputFile"))
                inputFileName = val[1];
            else if (val[0].equalsIgnoreCase("OutputFile"))
                outputFileName = val[1];
            else if (val[0].equalsIgnoreCase("config")) {
                if (val[1].equalsIgnoreCase("compress"))
                    mode = Operation.COMPRESS;
                else if (val[1].equalsIgnoreCase("decompress"))
                    mode = Operation.DECOMPRESS;
                else
                    Logger.get().registerLog(Logger.ErrorType.BAD_OP);
            }
            else if (val[0].equalsIgnoreCase("alphabet"))
                alphabet = val[1];

        } catch (FileNotFoundException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_FILE, e.getMessage());
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_WRITE, e.getMessage());
        }
    }

    String getInputFileName() {
        return inputFileName;
    }

    String getOutputFileName() {
        return outputFileName;
    }

    Operation getMode() {
        return mode;
    }

    String getAlphabet() {
        return alphabet;
    }

    private String configName;
    private String inputFileName, outputFileName;
    private Operation mode;
    private String alphabet; // like abcdef...
}
