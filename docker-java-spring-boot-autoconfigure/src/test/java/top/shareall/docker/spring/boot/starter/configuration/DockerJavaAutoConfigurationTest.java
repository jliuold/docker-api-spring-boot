package top.shareall.docker.spring.boot.starter.configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
public class DockerJavaAutoConfigurationTest {

    @Autowired
    DockerClient dockerClient;

    @Autowired
    DockerClientBuilder dockerClientBuilder;

    @Test
    public void dockerClient() throws Exception {
        Assert.notNull(dockerClient, "docker client注入失败");
    }

    @Test
    public void dockerClientBuilder() {
        Assert.notNull(dockerClientBuilder, "dockerClientBuilder注入失败");
    }

}