import java.io.FileReader;
import java.io.IOException;

public class Compressor {
    public Compressor( String configName, String logName ) {
        logger = new Logger(logName);
    }

    public void reloadConfig() {
        try {
            FileReader f = new FileReader(configName);
        } catch (IOException e) {
            logger.registerLog(Logger.ErrorType.BAD_FILE, e.getMessage());
        }
    }

    private String configName, logName;
    private Logger logger;
}
