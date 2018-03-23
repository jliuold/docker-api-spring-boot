# docker-java-spring-boot  ![Travis CI](https://travis-ci.org/jliu666/docker-java-spring-boot.svg?branch=master)  [![Coverage Status](https://coveralls.io/repos/github/jliu666/docker-java-spring-boot/badge.svg?branch=master)](https://coveralls.io/github/jliu666/docker-java-spring-boot?branch=master)

docker-java-spring-boot makes it easy to use [docker-java](https://github.com/docker-java/docker-java) in your spring boot project. You can learn more about [docker-java](https://github.com/docker-java/docker-java) at here.

# Why not named docker-client-spring-boot?
[docker-java](https://github.com/docker-java/docker-java) is a project about docker api. But [docker-client](https://github.com/spotify/docker-client) is another project. In order not to confuse the two items, So the project is named docker-java-spring-boot.

# Goal
1. Inject the DockerClient compent to spring context in a easy way.
2. Fix the error about dependencies by using snapshot.
3. Integrate the configuration into spring boot configuration. Then users can configure when start the jar or war.


# Usage

## Maven dependency
Add it to your project's pom:
```xml
<dependency>
    <artifactId>docker-java-spring-boot-starter</artifactId>
    <groupId>top.shareall</groupId>
    <version>1.0-SNAPSHOT</version>
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