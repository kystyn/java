import java.util.logging.Logger;

public class TrivialExecutor implements ExecutorInterface {
    public Status setInputFile( String filename ) {
        return Status.OK;
    }
    public Status setOutputFile( String filename ) {
        return Status.OK;
    }

    public Status setProducer( ExecutorInterface producer ) {
        return Status.OK;
    }

    public Status setConsumer( ExecutorInterface consumer ) {
        return Status.OK;
    }

    public Status setConfig( String configName ){return Status.OK;}

    public Status run() {
        return Status.OK;
    }

    public Status setLogger( Logger logger ) {
        return Status.OK;
    }

    public Status put( byte[] ba ) {
        return Status.OK;
    }

    public Status get( byte[] ba ) {
        return Status.OK;
    }
}
