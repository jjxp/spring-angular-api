# sprouts-core

[![Build Status](https://travis-ci.org/jjxp/sprouts-core.svg?branch=master)](https://travis-ci.org/jjxp/sprouts-core)

sprouts-core is a part of the Sprouts Project that aims to use AngularJS as a front-end technology using Spring Boot as a back-end server in order to ease use case implementation.

### Technologies

The most important technologies that are being used in this project are, among others:

* [AngularJS] - as a front-end framework
* [Spring Boot] - as a back-end framework
* [Spring JDBC] - as a technology that permits access to relational databases
* [Twitter Bootstrap] - a famous CSS framework for styling the front-end resources
* [MySQL] - as a database engine
* [Maven] - as a build manager
* [Swagger] - as a tool for automatically generating API documentation
* [angular-translate] - as a package for i18n support
* [Netflix Eureka] - as a service for microservice architecture purposes
* [zuul] - as a gateway service between frontend and backend for routing purposes

### Installation

In order to install spring-angular-api, there are a few obvious dependencies, such as:

* [Java 8] - needed for running the project itself
* [Maven] - needed in case no IDE will be used
* [Git] - needed for cloning the repository
* [MySQL] - for database access needs

Please, note that this installation procedure is a quick-start installation and thus will not explain how to set up the project in an IDE.

For downloading and running this project, the following commands has to be run:

```sh
$ git clone https://github.com/jjxp/sprouts-core.git
$ cd sprouts-core
$ mysql -uroot < initialize.sql
$ mvn clean install spring-boot:run
```
For each microservice, the last command shall be ran in a different command prompt. The order is as follows:
* eureka-server
* backend-server
* frontend-server

After the former is performed, the project should be running at http://localhost:8080/

Licenses
----
sprouts-core is constrained to the following licenses:
* [TDG]
* [ASLv2]
* [CC BY-ND 3.0]

   [TDG]: <http://www.tdg-seville.info/License.html>
   [ASLv2]: <https://www.apache.org/licenses/LICENSE-2.0>
   [CC BY-ND 3.0]: <https://creativecommons.org/licenses/by-nd/3.0/>
   [Spring Boot]: <https://projects.spring.io/spring-boot/>
   [Spring JDBC]: <https://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html>
   [MySQL]: <https://www.mysql.com/>
   [Maven]: <https://maven.apache.org/>
   [Java 8]: <https://www.java.com/>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [Git]: <https://git-scm.com/>
   [AngularJS]: <http://angularjs.org>
   [Swagger]: <http://swagger.io/>
   [angular-translate]: <https://angular-translate.github.io/>
   [Netflix Eureka]: <https://github.com/Netflix/eureka>
   [zuul]: <https://github.com/Netflix/zuul>
