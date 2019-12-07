
[jar для второй](https://drive.google.com/open?id=1enFfHAl7KUx4K1PzqRLcS9pBKdzfvK_6). 
Последний [коммит](https://github.com/kystyn/java/commit/251223acbfc958c7c4babe92bca1b11297c665df) 
до миграции на версию для третьей лабы.
Исходники в [зипе](https://drive.google.com/open?id=1lqTLf8e7UtFzXiJ1Y8C7SndcxpFdaFU8).

[jar для третьей](https://drive.google.com/open?id=141uUtj4LnfpcM8gN7_uGYpYSgb128WdG)

## Workflow

- Manager creates executors using theirs ```String``` canonical names via reflections. Initially executors should have ```status=Status.OK```.
- Manager creates pipeline by adding producers to consumers and vice versa, if adding failed, executors should set ```status=Status.EXECUTOR_ERROR```. 
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
      rest part of data array and provide it with next portion next time.
   3. consumer.run()
   4. consumer becomes producer.

## Requirements

- SDK 1.8
- Входной файл должен быть в кодировке UTF-16BE 
(можно в идее выбрать справа снизу и переконвертировать)
- Тогда конвертация ваглядит так:
    - ```new String(chars).getBytes(UTF-16BE)``` (char\[\] -> byte\[\])c
    - ```new String(bytes, UTF-16BE).toCharArray()``` (byte\[\] -> char\[\])


## Разное

Вопросы и пожелания, пожалуйста, пишите в [issues](https://github.com/kystyn/java/issues).
