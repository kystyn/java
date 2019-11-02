import java.util.logging.Logger;

public interface ManagerExecutorInterface {
    Status setInputFile(String filename);
    Status setOutputFile( String filename );

    Status setProducer( ExecutorInterface producer );
    Status setConsumer( ExecutorInterface consumer );

    Status run();

    Status setLogger( Logger logger );
}
