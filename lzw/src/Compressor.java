import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.List;

class Compressor {

    Compressor( String configName ) {
        config = new Config(configName);

        openFiles(config.getInputFileName(), config.getOutputFileName());
        if (config.getMode() == Config.Operation.COMPRESS)
            Compress();
        else
            Decompress();
    }

    void Compress() {
        try {
            // add atomics in dictionary
            for (char c : config.getAlphabet().toCharArray())
                dictionary.add(new String(new char[]{c}));

            String syms;
            String cur = "";
            while ((syms = inputFile.readLine()) != null) {
                cur = new String(new char[]{syms.charAt(0)});
                for (char c : syms.substring(1).toCharArray()) {
                    String expanded = cur.concat(new String(new char[]{c}));
                    int
                            codeBase = 0,
                            codeExpanded = 0;
                    for (String seq : dictionary) {
                        if (seq.equals(expanded)) {
                            cur = expanded;
                            writer.writeCode(codeExpanded);
                            break;
                        }
                        if (seq.equals(cur))
                            codeBase = codeExpanded; // current code
                        codeExpanded++;
                    }

                    if (codeExpanded == dictionary.size()) {
                        writer.writeCode(codeBase);
                        dictionary.add(expanded);
                    }
                }
            }

            // output last code
            int code = 0;
            if (!cur.isEmpty())
                for (String seq : dictionary) {
                    if (seq.equals(cur))
                        writer.writeCode(code);
                    code++;
                }
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_READ, e.getMessage());
        }
    }

    void Decompress() {

    }

    private void openFiles( String in, String out) {
        try {
            inputFile = new BufferedReader(new FileReader(in));
            writer = new BitWriter(new BufferedWriter(new FileWriter(out)));
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_FILE, e.getMessage());
        }
    }

    private BufferedReader inputFile;
    private BitWriter writer;
    private Config config;
    private List<String> dictionary;
}
