public interface ProducerConsumerInterface {
    Status put( byte[] ba );
    Status get( byte[] ba );
}
