import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Logger {
    enum MsgType {
        BAD_FILE("Bad file name: "),
        BAD_READ("Error while FileReader.read: "),
        BAD_WRITE("Error while FileWriter.write: "),
        BAD_GRAMMAR( "Bad lexem sequence: "),
        BAD_OP("Bad operation mentioned: "),
        INFO("Info message: ");

        MsgType( String errorMsg ) {
            this.errorMsg = errorMsg;
        }

        private String get() {
            return errorMsg;
        }

        private String errorMsg;
    }

    static {
        logger = new Logger("logger.log");
    }

    private Logger( String logName ) {
        try {
            logFile = new BufferedWriter(new FileWriter(logName));
        } catch (IOException e) {
            System.out.println("Bad log name " + logName);
        }
    }

    void registerLog( MsgType error, String msg ) {
        try {
            logFile.write(error.get() + " " + msg + "\n");
        } catch (IOException e) {
            System.out.println("Error: "  + e.getMessage());
        }
    }

    void registerFatalLog( MsgType error, String msg ) {
        registerLog(error, msg);
        close();
    }

    void registerLog( MsgType error ) {
        registerLog(error, "");
    }

    void close() {
        try {
            logFile.close();
        } catch (IOException e) {
            System.out.println("Error: "  + e.getMessage());
        }
    }

    static Logger get() {
        return logger;
    }

    private BufferedWriter logFile;
    private static Logger logger;
}
