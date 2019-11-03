public abstract class ProducerConsumerInterface {
    abstract protected Status put( byte[] ba );
    abstract protected Status get( byte[] ba );
}
