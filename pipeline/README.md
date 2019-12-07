
[jar для второй](https://drive.google.com/open?id=1enFfHAl7KUx4K1PzqRLcS9pBKdzfvK_6). 
Последний [коммит](https://github.com/kystyn/java/commit/251223acbfc958c7c4babe92bca1b11297c665df) 
до миграции на версию для третьей лабы.
Исходники в [зипе](https://drive.google.com/open?id=1lqTLf8e7UtFzXiJ1Y8C7SndcxpFdaFU8).

[jar для третьей](https://drive.google.com/open?id=1sYT5ZSvtTemLk1aUKl89PxvsbyJ8ovta)


## Lab 3+

### Знакомство

Manager читает конфиг и выстраивает экзекуторов на конвейер. 
Делает он это в порядке, описанном в конфиге. 
Конвейер получается знакомством соседних экзекуторов.

Считаем что у нас на руках два экзекутора, P и С. Будем их знакомить.

1. ```P.addConsumer(C);```
    - тут P просто сохраняет ссылку на C.
2. ```C.addProducer(P);```
    1. C вызывает ```P.outputDataTypes()```
    2. ```P.outputDataTypes()``` возвращает множество строк - имена типов, 
    в виде которых P может отдавать данные.
    3. С из множества имен типов выбирает один - тот, 
    в каком C хочет получать данные (напр, ```byte[]```).
    4. С вызывает ```P.getAccessor(byte[].class.getCanonicalName)``` 
    (подставляем имя того типа, который выбрали).
    5. ```P.getAccessor``` возвращает экземпляр класса, 
    который у продьюсера вложенный и унаследован от ```Producer.DataAccessor```.
    C сохраняет у себя этот экземпляр.
    
На этом знакомство закончилось!

##### DataAccessor

Посмотрим что это такое. Вот пример куска кода продьюсера:
```

private Object output;

public final class DataAccessor implements Producer.DataAccessor {

    @NotNull
    @Override
    public Object get() {
        Objects.requireNonNull(output);
        return output;  // некоторое поле в P
    }

    @Override
    public long size() {
        Objects.requireNonNull(output);
        
        // тут мы знаем, что output это массив, 
        // если строка, вернули бы ((String) output).length()
        return ((byte[]) output).length;  
    }
}

@NotNull
@Override
public DataAccessor getAccessor(@NotNull final String typeName) {
    Objects.requireNonNull(dataAccessor);
    // сохраняем себе имя типа, в который будем конвертировать перед отдачей.
    this.outputTypeName = typeName; 
    return new DataAccessor();
}
```

Таким образом, ```DataAccessor``` позволяет C ходить в P и забирать данные.

Также, ```DataAccessor``` может в ```get()``` содержать логику конвертации в выбранный С тип данных,
зависит от реализации.


### Рабочий процесс конвейера

Итак, мы познакомили всех экзекуторов, тем самым сделали конвейер.

##### Запуск!

1. Manager (M) вызывает у первого на конвейере, ридера (R), метод ```R.run()```.
2. В ```run()``` ридер в цикле читает файл по блокам и отправляет на конвейер, работает как продьюсер.

##### Взаимодействие P и C

Допустим, продьюсер обработал данные 
(если продьюсер здесь это ридер, то просто прочитал данные из файла),
сконвертировал в нужный C тип и сложил в переменную output. 

Т.е. мы находимся в методе ```run()``` у P.

Дальше:
1. P вызывает у C ```C.loadDataFrom(this);```
    1. Там С забирает ссылку на данные у продьюсера через сохраненный аксессор:
    ```input = dataAccessor.get()```
    2. Если размер у данных (```dataAccessor.size()```) не равен ожидаемому, ```return 0```
    3. Иначе ```return dataAccessor.size();```
2. P смотрит что вернул ```C.loadDataFrom(this);```
    1. Если вернулся ноль, ставим ```status = Status.EXECUTOR_ERROR;``` и делаем ```return```
    2. Если не ноль, вызываем ```C.run()```
3. После того как ```C.run()``` отработал, ставим ```this.status = C.status()```
    - таким образом статус ошибки, если появится, дойдет до R и тот завершит цикл.

   
## Типы
- поддерживаем
    - byte[]
    - char[]
    - String
- Входной файл должен быть в кодировке UTF-16BE
(можно в idea выбрать справа снизу и переконвертировать)
- Тогда конвертация в коде ваглядит так:
    - ```new String(chars).getBytes("UTF-16BE")``` (char\[\] -> byte\[\])c
    - ```new String(bytes, "UTF-16BE").toCharArray()``` (byte\[\] -> char\[\])
    - к тому же можно полагаться что размер ```byte[]``` в этой кодировке
    будет вдвое длиннее соттветствующего ```char[]```


## Требования

- SDK 1.8

## Разное

Вопросы и пожелания, пожалуйста, пишите в [issues](https://github.com/kystyn/java/issues).
