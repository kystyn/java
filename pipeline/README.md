# Pipeline

### +

- Separate writer and reader entities.
- Lazy pipeline execution, run reader each time as needed.
- Arbitrary parallelizable execution graph.

### -

- Deep stack is needed for long pipelines. 
Better to return Executor result to Pipeline each time, but too complicated implementation.
