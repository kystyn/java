
import java.util.logging.Level;

public class Logger implements LoggerInterface {
    private static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());
    Logger(){
        
    }
    @Override
    public void log(String msg) {
        LOGGER.log(Level.SEVERE, msg);
    }
}
