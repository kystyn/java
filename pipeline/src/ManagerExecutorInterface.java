import java.util.logging.Logger;

public interface ManagerExecutorInterface {
    Status setInputFile(String filename);
    Status setOutputFile( String filename );

    Status setProducer( ProducerConsumerInterface producer );
    Status setConsumer( ProducerConsumerInterface consumer );

    Status run();

    Status setLogger( Logger logger );
    Status setConfig( String configName );
}
