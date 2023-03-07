# <img width="4%" title="Allure TestOPS" src="images/logo/hh_logo.svg"> Проект по автоматизации тестирования сайта hh.ru

##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Реализованыe проверки](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)


## :technologist: Технологии и инструменты



<code><img width="5%" title="IntelliJ IDEA" src="images/icons/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/icons/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="images/icons/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="images/icons/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/icons/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/icons/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/icons/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/icons/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/icons/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/icons/Jenkins_logo.svg"></code>
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

## :computer: Запуск тестов из терминала

### Локальный запуск тестов

```bash
gradle clean test -Denv=local
```

### Удаленный запуск тестов

```bash
gradle clean test -Denv=remote
```