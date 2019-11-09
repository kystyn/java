## Workflow

- Manager creates pipeline and calls Reader.run().
- Reader reads blocks in loop and calls run() of it's consumer.
- Consumer
   1. checks status() of it's producer
   2. gets data from producer
   3. processes data
   4. calls consumer's run()
   
## Questions

Separate interface to data transfer in pipeline. What does it mean.