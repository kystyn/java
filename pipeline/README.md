[Свежий jar](https://drive.google.com/open?id=1ZcOctIMLc2fdtHtJN_2ruftZM07ah9Q2).

## Workflow

- Manager creates pipeline by adding producers to consumers and vice versa.
- Consumer asks types producer can produce. 
Finds acceptable type and asks accessor for this type.
- Manager calls Reader.run().
- Reader reads blocks in loop, it now acts as Producer.
- Producer
   1. Prepare result data
   2. consumer.loadDataFrom(this) &mdash; 
   consumer checks producer's status and loads data if OK.
   3. consumer.run()
   4. consumer becomes producer.
- Consumer can wait additional another portion of data, if size is not enough.

## Requirements

- java8

## Разное

Вопросы и пожелания, пожалуйста, пишите в [issues](https://github.com/kystyn/java/issues).
