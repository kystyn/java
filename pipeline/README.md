## Workflow

- Manager creates pipeline and calls Reader.run().
- Reader reads blocks in loop.
- Producer
   1. Prepare result data
   2. consumer.loadDataFrom(this) &mdash; 
   consumer checks producer's status and loads data if OK.
   `Status is OK if and only if get() output contains value`.
   Producer should return some type from consumer's acceptable type list
   or ```empty``` if it cant's.
   3. consumer.run()
   4. Consumer becomes producer.

## Requirements

- java8