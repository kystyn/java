import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.Collectors;

class Compressor {

    Compressor( String configName ) {
        config = new Config(configName);

        openFiles(config.getInputFileName(), config.getOutputFileName());
        if (config.getMode() == Config.Mode.COMPRESS)
            Compress();
        else
            Decompress();
    }

    void Compress() {
        try {
            // add atomics in dictionary
            dictionary.addAll(Arrays.asList(config.getAlphabet()));

            String syms;
            String cur = "";
            while ((syms = inputFile.readLine()) != null) {
                cur = new String(new char[]{syms.charAt(0)});
                for (int i = 1; i < syms.length(); i++) {
                    char c = syms.charAt(i);

                    if (!config.getAlphabet().toString().contains(new String(new char[]{c})))
                        Logger.get().registerLog(Logger.ErrorType.BAD_GRAMMAR, "Element not in alphabet");

                    String expanded = cur + c;

                    if (dictionary.contains(expanded)){
                        cur = expanded;
                    }
                    else {
                        writer.writeCode(dictionary.indexOf(cur));
                        dictionary.add(expanded);
                        cur = new String(new char[]{c});
                    }
                }
            }
            writer.writeCode(dictionary.indexOf(cur));
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_READ, e.getMessage());
        }
    }

    void Decompress() {

        // add atomics in dictionary
        dictionary.addAll(Arrays.asList(config.getAlphabet()));

        Integer codeOld = 0, codeCur = 0;
        if (!reader.readCode(codeOld))
            Logger.get().registerLog(Logger.ErrorType.BAD_FILE, "Empty file");
        try {
            outputFile.write(dictionary.get(codeOld));
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_WRITE, e.getMessage());
        }
        while (reader.readCode(codeCur)) {
            String cur = dictionary.get(codeCur);
            try {
                outputFile.write(cur);
            } catch (IOException e) {
                Logger.get().registerLog(Logger.ErrorType.BAD_WRITE, e.getMessage());
            }

            dictionary.add(dictionary.get(codeOld) + cur.charAt(0));
            codeOld = codeCur;
        }
    }

    private void openFiles( String in, String out) {
        try {
            if (config.getMode() == Config.Mode.COMPRESS) {
                inputFile = new BufferedReader(new FileReader(in));
                writer = new BitWriter(new BufferedWriter(new FileWriter(out)));
            }
            else {
                outputFile = new BufferedWriter(new FileWriter(out));
                reader = new BitReader(new BufferedReader(new FileReader(in)));
            }
        } catch (IOException e) {
            Logger.get().registerLog(Logger.ErrorType.BAD_FILE, e.getMessage());
        }
    }

    private BufferedReader inputFile;
    private BufferedWriter outputFile;
    private BitWriter writer;
    private BitReader reader;
    private Config config;
    private List<String> dictionary;
}
