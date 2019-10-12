import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Config {
    enum Mode {
        COMPRESS("Compress"),
        DECOMPRESS("Decompress");

        Mode( String s ) { oper = s; }

        public String toString() {
            return oper;
        }

        private String oper;
    }

    enum Grammar {
        INPUT_FILE("InputFile"),
        OUTPUT_FILE("OutputFile"),
        MODE("Mode"),
        ALPHABET("Alphabet"),
        VAL_DELIMITER(" {2,}= {2,}"),
        ALPHABET_DELIMITER(", ");

        Grammar( String s ) { lexem = s; }

        public String toString() {
            return lexem;
        }

        private String lexem;
    }

    Config( String fileName ) {
        this.configName = fileName;
        this.alphabet = new ArrayList<String>();
        reloadConfig();
    }

    private void reloadConfig() {
        try {
            BufferedReader f = new BufferedReader(new FileReader(configName));

            String l = null;

            while (true) {
                try {
                    l = f.readLine();
                    if (l == null)
                        break;
                } catch (IOException e) {
                    Logger.get().registerLog(Logger.ErrorType.BAD_READ, e.getMessage());
                }
                String[] val = l.split(Grammar.VAL_DELIMITER.toString());
                if (val.length != 2)
                    Logger.get().registerLog(Logger.ErrorType.BAD_GRAMMAR, "Double assignment");

                if (val[0].equalsIgnoreCase(Grammar.INPUT_FILE.toString()))
                    inputFileName = val[1];
                else if (val[0].equalsIgnoreCase(Grammar.OUTPUT_FILE.toString()))
                    outputFileName = val[1];
                else if (val[0].equalsIgnoreCase(Grammar.MODE.toString())) {
                    if (val[1].equalsIgnoreCase(Mode.COMPRESS.toString()))
                        mode = Mode.COMPRESS;
                    else if (val[1].equalsIgnoreCase(Mode.DECOMPRESS.toString()))
                        mode = Mode.DECOMPRESS;
                    else
                        Logger.get().registerLog(Logger.ErrorType.BAD_OP);
                }
                else if (val[0].equalsIgnoreCase(Grammar.ALPHABET.toString())) {
                    alphabet.addAll(Arrays.asList(val[1].split(Grammar.ALPHABET_DELIMITER.toString())));
                    alphabet.add("\n");
                }
            }

        } catch (FileNotFoundException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_FILE, e.getMessage());
        }
    }

    String getInputFileName() {
        return inputFileName;
    }

    String getOutputFileName() {
        return outputFileName;
    }

    Mode getMode() {
        return mode;
    }

    List<String> getAlphabet() {
        return alphabet;
    }

    private String configName;
    private String inputFileName, outputFileName;
    private Mode mode;
    private List<String> alphabet; // like abcdef...
}
