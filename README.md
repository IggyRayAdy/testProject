# jarTest

README.md
Добрый день.

Перед запуском приложения необходимо выполнить:

Установить mySQL

      $sudo apt update
      $sudo apt sudo apt install mysql-server

Создать базу данных: 
название базы - 'Application';                        
имя пользователя - 'user';                          
пароль - 'password'.                    

или создать базу с своими параметрами и сменить данные в src/main/resources/hibernate.properties

      hibernate.connection.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/'название базы'
      spring.datasource.username='имя пользователя'
      spring.datasource.password='пароль'

Для запуска проекта необходимо в терминале дериктории проекта прописать

      $mvn spring-boot:run

По следующим адресу будут показаны сущ. категории в формате json.

      http://localhost:8080/categories
      http://localhost:8080/banners

Вы подключили серверную часть, описание далее 
        https://github.com/IggyRayAdy/testProject-front
