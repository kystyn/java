## Workflow

- Manager creates pipeline and calls Reader.run().
- Reader reads blocks in loop.
- Producer
   1. Prepares result data
   2. consumer.loadDataFrom(this)
   3. consumer.run()
- Consumer
   1. Checks status() of it's producer
   2. [producer](#-producer)

   
## Questions

- Separate interface to data transfer in pipeline. What does it mean.
(DataStorage is possible implementation)
- How to compress bytes when algorithms work with strings.
