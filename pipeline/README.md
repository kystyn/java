## Workflow

- Manager creates pipeline and calls Reader.run().
- Reader reads blocks in loop.
- Executors
   1. Prepare result data
   2. consumer.loadDataFrom(this) &mdash; 
   consumer checks data status ans loads it if OK.
   3. consumer.run()
