package top.shareall.docker.spring.boot.starter.configuration;


import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 自动探测对应的类并进行注入
 */
@ImportAutoConfiguration({DockerClientAutoConfiguration.class, DockerJavaAutoConfiguration.class})
@Configuration
public class DockerApiAutoConfiguration {
}
