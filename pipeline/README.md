## Workflow

- Manager creates pipeline and calls Reader.run().
- Reader reads blocks in loop.
- Executors
   1. Prepare result data
   2. consumer.loadDataFrom(this) &mdash; 
   consumer checks data status ans loads it if OK.
   3. consumer.run()

   
## Questions

- Separate interface to data transfer in pipeline. What does it mean.
(DataStorage is possible implementation)
- How to compress bytes when algorithms work with strings.
