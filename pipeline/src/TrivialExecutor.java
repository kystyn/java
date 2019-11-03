import java.util.logging.Logger;

public class TrivialExecutor extends ExecutorInterface {
    public Status setInputFile( String filename ) {
        return Status.OK;
    }
    public Status setOutputFile( String filename ) {
        return Status.OK;
    }

    public Status setProducer( ProducerConsumerInterface producer ) {
        return Status.OK;
    }

    public Status setConsumer( ProducerConsumerInterface consumer ) {
        return Status.OK;
    }

    public Status run() {
        return Status.OK;
    }

    public Status setLogger( Logger logger ) {
        return Status.OK;
    }

    protected Status put( byte[] ba ) {
        return Status.OK;
    }

    protected Status get( byte[] ba ) {
        return Status.OK;
    }
}
