# spring-angular-api

[![Build Status](https://travis-ci.org/jjxp/spring-angular-api.svg?branch=master)](https://travis-ci.org/jjxp/spring-angular-api)

spring-angular-api is a part of the Sprouts Framework project and aims to use AngularJS as a front-end technology using Spring Boot as a back-end server.

### Technologies

The most important technologies that are being used in this project are, among others:

* [AngularJS] - as a front-end framework
* [Spring Boot] - as a back-end framework
* [Spring JDBC] - as a technology that permits access to relational databases
* [Twitter Bootstrap] - a famous CSS framework for styling the front-end resources
* [MySQL] - as a database engine
* [Maven] - as a build manager

### Installation

In order to install spring-angular-api, there are a few obvious dependencies, such as:

* [Java 8] - needed for running the project itself
* [Maven] - needed in case no IDE will be used
* [Git] - needed for cloning the repository
* [MySQL] - for database access needs

Please, note that this installation procedure is a quick-start installation and thus will not explain how to set up the project in an IDE.

For downloading and running this project, the following commands has to be run:

```sh
$ git clone https://github.com/jjxp/spring-angular-api.git
$ cd spring-angular-api
$ mysql -uroot < initialize.sql
$ mvn clean install spring-boot:run
```
After the former is performed, the project should be running at http://localhost:8080/

Licenses
----
spring-angular-api is constrained to the following licenses:
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
