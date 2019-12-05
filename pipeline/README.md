[jar для третьей](https://drive.google.com/open?id=1rdsRSw4cQU8vrSoTZ9LZ3BWSKoQcNioE)

## Workflow

- Manager creates pipeline by adding producers to consumers and vice versa.
- Consumer asks types producer can produce. 
Finds acceptable type and asks DataAccessor for this type.
- Manager calls Reader.run().
- Reader reads blocks in loop, it now acts as Producer.
- Producer
   1. Prepare result data
   2. consumer.loadDataFrom(this) &mdash; 
   consumer checks producer's status and saves link to data if OK.
      - If provided data is not enough return 0, producer will provide more data next time.
      - If consumer is able to process some part of provided data, 
      it returns length of such part. In that case producer should cache 
      data from \[loaded, end\] part of data array and provide it with next portion next time. 
   3. consumer.run()
   4. consumer becomes producer.

## Requirements

- java8

## Разное

Вопросы и пожелания, пожалуйста, пишите в [issues](https://github.com/kystyn/java/issues).
