# docker-api-spring-boot  [![Travis CI](https://travis-ci.org/jliu666/docker-api-spring-boot.svg?branch=master)](https://travis-ci.org/jliu666/docker-api-spring-boot)  [![codecov](https://codecov.io/gh/jliu666/docker-api-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/jliu666/docker-api-spring-boot)  [![中文](https://img.shields.io/badge/language-%E4%B8%AD%E6%96%87-green.svg)](./README-zh_CN.md)


Both Docker and Spring Boot become more and more popular. So the docker-api-spring-boot-starter comes. 
It makes easy to start a Spring Boot project with Docker API.

0. Docker API is a restful api to operate docker on network.
1. [Docker-java](https://github.com/docker-java/docker-java) is one wrapper of the Docker API.
2. [Docker-client](https://github.com/spotify/docker-client) is another wrapper of the Docker API.

The starter wrappers the configuration of docker-java and docker-client. So just add the maven dependency of docker-java or docker-client to your project and code happily.  

# Usage

## Maven dependency
Add it to your project's pom:
```xml
<dependency>
    <artifactId>docker-api-spring-boot-starter</artifactId>
    <groupId>top.shareall</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
If you want to use docker-java in your project, add this to your project pom:
```xml
<dependency>
    <groupId>com.github.docker-java</groupId>
    <artifactId>docker-java</artifactId>
</dependency>
```
Or you want to use docker-client in your project:
```xml
<dependency>
    <groupId>com.spotify</groupId>
    <artifactId>docker-client</artifactId>
</dependency>
```

## Warning
*Because the docker-java's last release has a error about dependency. So you must ensure your project can download snapshot version.*   

### How to enable snapshot version
If you want to enable snapshot version with a maven repo mirror without snapshot. You can configure maven like below.

Use Huawei maven repo:
Add below to maven setting file's servers node.
```xml
<server>
    <id>huaweicloud</id>
    <username>anonymous</username>
    <password>devcloud</password>
</server>
```
Add below to maven setting file's mirrors node.
```xml
<mirror>
    <id>huaweicloud</id>
    <mirrorOf>*,!snapshots</mirrorOf>
    <url>https://repo.huaweicloud.com/repository/maven/</url>
</mirror>
```

The snapshots repository is defined in the pom.xml of the starter.


## Configuration
You can config docker-java in your spring-boot configuration. If you use deafault, of course you needn't to config it.
A spring-boot configuration like this;
```yml
...
docker-java:
  dockerHost: unix://localhost
...
```

# License
Docker-java-spring-boot is Open Source software released under the [Apache 2.0 license](http://www.apache.org/licenses/).
