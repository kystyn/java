import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public enum ErrorType {
        BAD_FILE("Bad file name"),
        BAD_WRITE("Error while FileWriter::write");

        ErrorType( String errorMsg ) {
            this.errorMsg = errorMsg;
        }

        public String get() {
            return errorMsg;
        }

        private String errorMsg;
    }

    public Logger( String logName ) {
        try {
            logFile = new FileWriter(logName);
        } catch (IOException e) {
            System.out.println("Bad log name" + logName);
        }
    }

    public void registerLog( ErrorType error, String msg ) {
        try {
            logFile.write(error.get());
        } catch (IOException e) {
            System.out.println("Error: "  + e.getMessage() + msg);
        }
    }

    public void registerLog( ErrorType error ) {
        registerLog(error, "");
    }

    private FileWriter logFile;
}
