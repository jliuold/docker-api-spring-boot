# docker-java-spring-boot  ![Travis CI](https://travis-ci.org/jliu666/docker-java-spring-boot.svg?branch=master)  [![Coverage Status](https://coveralls.io/repos/github/jliu666/docker-java-spring-boot/badge.svg?branch=master)](https://coveralls.io/github/jliu666/docker-java-spring-boot?branch=master)

docker-java-spring-boot makes it easy to use [docker-java](https://github.com/docker-java/docker-java) in your spring boot project. You can learn more about [docker-java](https://github.com/docker-java/docker-java) at here.


# Usage

## Maven dependency
```xml
<dependency>
    <artifactId>docker-java-spring-boot-starter</artifactId>
    <groupId>top.shareall</groupId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

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
Docker-java-spring-boot is Open Source software released under the Apache 2.0 license.