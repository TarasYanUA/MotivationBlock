Модуль "Блок мотивации" v2.13.0 + тема Юни2(UltRu) v4.18.1b. Можно установить весь пакет темы Юни2.
Запустить тесты можно:
1) Через файл testNG.xml
2) Через Surefire отчёт: перейти в "Терминал" и ввести "mvn clean test". После этого в папке "target -> surefire reports"
   открыть файл "index.html" с помощью браузера (правая кнопка мыши -> Open in -> Browser).

**Важно** следить за версией драйверов (chromedriver и geckodriver), которые расположены в папке test -> resources. Версия этого файла должна совпадать с версией браузера Хром на ПК.
Если при запуске testNG.xml тесты падают на этапе открытия браузера, то значит версия драйвера устарела.

Сайт для chromedriver: https://getwebdriver.com/

Сайт для geckodriver: https://github.com/mozilla/geckodriver/releases
