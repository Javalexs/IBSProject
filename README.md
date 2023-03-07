# <img width="4%" title="Allure TestOPS" src="images/logo/hh_logo.svg"> Проект по автоматизации тестирования сайта hh.ru

##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Реализованыe проверки](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов](#computer-запуск-тестов)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)


## :technologist: Технологии и инструменты

<code><img width="5%" title="IntelliJ IDEA" src="images/icons/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/icons/Java.svg"></code>
<code><img src="images/icons/Selenoid.svg" title="Selenoid" width="5%"/></code>
<code><img width="5%" title="Selenide" src="images/icons/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/icons/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/icons/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/icons/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/icons/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/icons/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/icons/Jenkins.svg"/></code>
<code><img width="5%" title="Jira" src="images/icons/Jira.svg"></code>

## :bookmark_tabs: Реализованные проверки:

- Проверка на наличие заголовка вакансии
- Проверка содержания заголовка вакансии
- Проверка названия вакансии на странице
- Поиск подзаголовка в тексте вакансии
- Проверка присутствия названия статьи, в результате ввода запроса в поиск
- Проверка отображения списка подкатегорий в выбранной категории 
- Поиск элемента в навигации страницы
- Проверка отсутсвия фавикона

## :computer: Запуск тестов

### Локальный запуск тестов производится из терминала среды разработки IntelliJ IDEA командой:
```bash
gradle clean test -Denv=local
```
#### Параметры сборки по умолчанию:

 <code>baseUrl</code> =https://ibs.ru - адрес сайта на котором запускаются тесты

 <code>browserName=chrome</code> - имя браузера

 <code>browserVersion=100</code> - версия браузера

 <code>browserSize=1920x1080</code> - размер экрана

 <code>isRemote=false</code> - проверка запуска теста локально


### Удаленный запуск тестов производится через программу [Jenkins](https://jenkins.autotests.cloud/job/QA-Project_UI/) через удаленный сервер 
### для запуска тестов в программе нужно нажать "Собрать с параметрами" убедиться, что в графе LAUNCH_PARAMETR стоит параметр <code>remote</code>
и далее подтверить нажав на кнопку "Собрать"

#### Параметры сборки по умолчанию:

 <code>baseUrl=https://ibs.ru</code> - адрес сайта на котором запускаются тесты

 <code>browserName=chrome</code> - имя браузера

 <code>browserVersion=100</code> - версия браузера

 <code>browserSize=1920x1080</code> - размер экрана

 <code>isRemote=true</code> - проверка запуска теста удаленно

 <code>remoteUrl=https://user:@selenoid.autotests.cloud/wd/hub</code> - адрес удаленного сервера (url изменен в целях безопасности)

<p align="center">
  <img src="images/screen/jenkins1.jpg" alt="Jenkins" width="800">
</p>

<p align="center">
  <img src="images/screen/jenkins2.jpg" alt="Jenkins" width="800">
</p>

