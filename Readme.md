# Clevertek test task

## Используемый стек:
- java 17
- junit 5.8.1
- gradle 7.5

## Инструкция по запуску:

    перейти в корень приложения
```sh
gradle assemble
```
     переходим в папку build/libs
     Пример запуска приложения: java -jar Check-0.0.1.jar 3-1 2-5 1-8 card-1 cardfilename-"../../cards.csv" productfilename-"../../products.csv"
Принимаемые параметры:
-   3-1  товар с id=3 в количестве 1шт. (обязательный параметр, можно указать несколько раз)
-   card-1  карта с id=1 (необязательный параметр)
-   cardfilename-"../../cards.csv"  путь к файлу с картами
-   productfilename-"../../products.csv"  путь к файлу с продуктами
 