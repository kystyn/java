[Свежий jar](https://drive.google.com/open?id=1gsrM5xF2WU7lLzAkjcxTmrO4OG-2-BQF).

## Workflow

- Manager creates pipeline by adding producers to consumers and vice versa.
- Producer asks Consumer's acceptable types, 
if it cannot provide data in one of specified types, it sets error status.
- Manager calls Reader.run().
- Reader reads blocks in loop, it now acts as Producer.
- Producer
   1. Prepare result data
   2. consumer.loadDataFrom(this) &mdash; 
   consumer checks producer's status and loads data if OK.
   3. consumer.run()
   4. consumer becomes producer.

## Requirements

- java8

## Разное

Вопросы и пожелания, пожалуйста, пишите в [issues](https://github.com/kystyn/java/issues).
