# passport_service

+ [О проекте](#О-проекте)
+ [Технологии](#Технологии)
+ [Использование](#Использование)
+ [Контакты](#Контакты)

## О проекте

Сервис использует Spring Boot и архитектуру REST. Для хранения используется PostgreSQL. Для сообщений kafka. Сервис занимается управлением
паспортами и рассылкой для оповещения у кого пасспорт просрочен.

## Технологии

+ **Java 11**, **Spring Boot**, **kafka**;
+ **PostgreSQL**;
+ Сборщик проектов **Maven**;

## Использование
Создано три сервиса. Первый сервис заниматься управлением паспортами.
Второй сервис вызывает методы первого сервиса используя RestTemplate.
Третий сервис рассылает сообщения с не валидными паспортами.
### Паспорта

`POST /passport` - сохранить данные паспорта

`PUT /passport` - обновить данные паспорта

`DELETE /passport/{id}` - удалить данные паспорта

`GET /passport` - загрузить все паспорта

`GET /passports/getBySeries/{series}` - загрузить паспорт с определенной серией

`GET /passports/notValid` - загрузить паспорта чей срок вышел

`GET /passports/soonValid` - загрузить паспорта, которые нужно заменить в ближайшие 3 месяца

## Контакты

Шураков Илья

Email: qq.ferveks@gmail.com
