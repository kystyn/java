import java.io.FileWriter;
import java.io.IOException;

class Logger {
    enum ErrorType {
        BAD_FILE("Bad file name"),
        BAD_READ("Error while FileReader.read"),
        BAD_WRITE("Error while FileWriter.write"),
        BAD_GRAMMAR( "Bad lexem sequence"),
        BAD_OP("Bad operation mentioned");

        ErrorType( String errorMsg ) {
            this.errorMsg = errorMsg;
        }

        private String get() {
            return errorMsg;
        }

        private String errorMsg;
    }

    static {
        logger = new Logger("troubles.log");
    }

    private Logger( String logName ) {
        try {
            logFile = new FileWriter(logName);
        } catch (IOException e) {
            System.out.println("Bad log name" + logName);
        }
    }

    void registerLog( ErrorType error, String msg ) {
        try {
            logFile.write(error.get());
        } catch (IOException e) {
            System.out.println("Error: "  + e.getMessage() + msg);
        }
        finally {
            System.exit(0);
        }
    }

    void registerLog( ErrorType error ) {
        registerLog(error, "");
    }

    static Logger get() {
        return logger;
    }

    private FileWriter logFile;
    private static Logger logger;
}
