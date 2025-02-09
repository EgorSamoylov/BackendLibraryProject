# BackendLibraryProject

Этот документ описывает шаги для запуска приложения Book Library на новом компьютере. Приложение состоит из двух частей:

*   **Frontend:** Vue.js клиентское приложение.
*   **Backend:** Spring Boot REST API.

## Предварительные требования

Убедитесь, что на вашем компьютере установлены следующие инструменты:

*   **Frontend:**
    *   [Node.js](https://nodejs.org/) (версия >= 14.x рекомендуется)
    *   [npm](https://www.npmjs.com/) (поставляется вместе с Node.js) или [Yarn](https://yarnpkg.com/)
    *   [Vue CLI](https://cli.vuejs.org/) (рекомендуется): `npm install -g @vue/cli`
*   **Backend:**
    *   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (версия 8 или выше)
    *   [Maven](https://maven.apache.org/download.cgi) или [Gradle](https://gradle.org/install/) (в зависимости от системы сборки проекта)
    *   [Интегрированная среда разработки (IDE)](https://www.jetbrains.com/idea/) (рекомендуется, но не обязательна)

## Шаги запуска

### Подготовка базы данных
**1. Установка и запуск базы данных:**

*   Если у вас еще не установлена база данных [Название базы данных], скачайте и установите ее с официального сайта: [Ссылка на сайт базы данных].
*   Запустите сервер базы данных.  Убедитесь, что он доступен на порту [Номер порта по умолчанию 5432 для PostgreSQL].

**2. Создание базы данных:**

*   Создайте новую базу данных с именем book_db

**3. Настройка параметров подключения:**

*   Приложение использует следующие параметры для подключения к базе данных:
    *   **URL:**  `[URL базы данных, например, jdbc:postgresql://localhost:5432/book_library, jdbc:mysql://localhost:3306/book_library]`
    *   **Username:** `[Имя пользователя базы данных, например, postgres, root]`
    *   **Password:** `[Пароль пользователя базы данных]`

*   Эти параметры необходимо указать в файле `src/main/resources/application.properties` (или `application.yml`) в вашем Spring Boot проекте.

    *   **В данном проекте по умолчанию** 

        ```properties
        spring.application.name=live
        spring.datasource.url=jdbc:postgresql://localhost:5432/book_db
        spring.datasource.username=postgres
        spring.datasource.password=123
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

### 1. Клонирование репозитория

Склонируйте репозиторий с кодом приложения

### 2. Запуск Backend (Spring Boot)
1. Перейдите в директорию backend:

cd backend  # Или название вашей папки с бэкендом

2. Сборка проекта:

**Maven:**
*  mvn clean install

**Gradle:**
gradle clean build

3. Запустите проект

### 3. Запуск Frontend (Vue.js)
1. Перейдите в директорию frontend:

cd frontend  
Или название вашей папки с фронтендом

2. Установите зависимости:

npm install axios
или
yarn install axios

3. Запустите приложение:

npm run serve
# или
yarn serve
