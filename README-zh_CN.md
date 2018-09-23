# docker-api-spring-boot  ![Travis CI](https://travis-ci.org/jliu666/docker-api-spring-boot.svg?branch=master)  [![Coverage Status](https://coveralls.io/repos/github/jliu666/docker-api-spring-boot/badge.svg?branch=master)](https://coveralls.io/github/jliu666/docker-api-spring-boot?branch=master) [![codecov](https://codecov.io/gh/jliu666/docker-api-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/jliu666/docker-api-spring-boot)  [![中文](https://img.shields.io/badge/language-English-green.svg)](./README.md)


随着Spring Boot和Docker越来越流行，所以这个项目诞生了。Docker-api-spring-boot-starter可以让我们以一种更简单的方式使用Docker API。

0. Docker API 是一种restful风格的API，它允许我们通过网络对Docker进行操作。
1. [Docker-java](https://github.com/docker-java/docker-java) 是Docker API的一种封装。
2. [Docker-client](https://github.com/spotify/docker-client) 是Docker API的另一种封装.

这个Starter统一封装了docker-java和docker-client的配置，因此仅仅通过改变项目的依赖，就可以使用两种不同的API封装。  

# 使用

## Maven
将下面的依赖添加到项目的pom中:
```xml
<dependency>
    <artifactId>docker-api-spring-boot-starter</artifactId>
    <groupId>top.shareall</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
docker-java:
```xml
<dependency>
    <groupId>com.github.docker-java</groupId>
    <artifactId>docker-java</artifactId>
    <version>3.1.0-SNAPSHOT</version>
</dependency>
```
docker-client:
```xml
<dependency>
    <groupId>com.spotify</groupId>
    <artifactId>docker-client</artifactId>
    <version>3.5.12</version>
</dependency>
```

## Warning
*由于目前docker-java的3.0.14版本存在依赖问题，所以此处采用了snapshot版本。所以你的maven配置必须启用快照版本*   


### 如何使用snapshot版本
如果你使用了一个没有snapshot的maven镜像，你可以像下面的方式配置你的maven

以华为镜像为例:
将下面的设置添加到maven配置文件的servers节点中。
```xml
<server>
    <id>huaweicloud</id>
    <username>anonymous</username>
    <password>devcloud</password>
</server>
```
将下面的设置添加到maven配置文件中的mirrors节点中。
```xml
<mirror>
    <id>huaweicloud</id>
    <mirrorOf>*,!snapshots</mirrorOf>
    <url>https://repo.huaweicloud.com/repository/maven/</url>
</mirror>
```

## 配置
项目将docker-java和docker-client的配置统一到Spring Boot中，你可以通过下面的方式来配置docker-java
```yml
...
docker-java:
  dockerHost: unix://localhost
...
```

# License
Docker-java-spring-boot is Open Source software released under the [Apache 2.0 license](http://www.apache.org/licenses/).