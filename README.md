# docker-api-spring-boot  ![Travis CI](https://travis-ci.org/jliu666/docker-api-spring-boot.svg?branch=master)  [![Coverage Status](https://coveralls.io/repos/github/jliu666/docker-api-spring-boot/badge.svg?branch=master)](https://coveralls.io/github/jliu666/docker-api-spring-boot?branch=master)

docker-api-spring-boot makes it easy to use [docker-java](https://github.com/docker-java/docker-java) or [docker-client](https://github.com/spotify/docker-client) in your spring boot project. You can learn more about [docker-java](https://github.com/docker-java/docker-java) here, and more about [docker-client](https://github.com/spotify/docker-client) here


# Goal
1. Inject the DockerClient component to spring context in a easy way.
2. Fix the error about dependencies by using snapshot.
3. Integrate the configuration into spring boot configuration. Then users can configure when start the jar or war.


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
    <version>3.1.0-SNAPSHOT</version>
   </dependency>
```
Or you want to use docker-client in your project:
```xml
<dependency>
    <groupId>com.spotify</groupId>
    <artifactId>docker-client</artifactId>
    <version>3.5.12</version>
</dependency>
```

## Warning
*Because the docker-java's last release has a error about dependency. So you must ensure your project can download snapshot version.*   

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