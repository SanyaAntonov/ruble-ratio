**REST / Spring Boot / Spring Cloud Openfeign / Gradle / Lombok / JUnit**
##
**TEST TASK**
##

**Description**
>Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
если ниже - отсюда https://giphy.com/search/broke
Ссылки
REST API курсов валют - https://docs.openexchangerates.org/
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide
Must Have
Сервис на Spring Boot 2 + Java / Kotlin
Запросы приходят на HTTP endpoint, туда передается код валюты
Для взаимодействия с внешними сервисами используется Feign
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
Для сборки должен использоваться Gradle
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску
Nice to Have
Сборка и запуск Docker контейнера с этим сервисом

**Technology stack:**
- Spring Boot
- REST
- Spring Cloud Openfeign
- Gradle
- JUnit
- Lombok

##
**How to use this program**

**1. Clone a repository:**

```sh
 git clone https://github.com/SanyaAntonov/ruble-ratio
```

**2. Open the project using the IDE**

**3. Change properties to yours :**
```sh
giphy.api_key=YOUR_API_KEY
oer.app_id=YOUR_APP_ID
oer.base=RUB
```

**4 Run this app in your IDE or create Docker container**

**(Optional) Create Docker container**
```sh
Build image for Dockerfile
docker build --build-arg JAR_FILE=build/libs/*.jar -t antonov/ruble-ratio .
docker run --name ruble-ratio -dp 8080:8080 antonov/ruble-ratio
```

**5. Start ruble-ratio service :**
```sh
  GET http://localhost:8080/compare/{CurrencyCode}  CurrencyCode - USD,RUB,UAH и тд.
```
##

