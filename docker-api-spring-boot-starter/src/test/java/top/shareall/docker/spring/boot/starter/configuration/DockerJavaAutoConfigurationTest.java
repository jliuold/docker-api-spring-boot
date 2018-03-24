package top.shareall.docker.spring.boot.starter.configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = {DockerJavaAutoConfigurationTest.class, DockerJavaAutoConfiguration.class})
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class DockerJavaAutoConfigurationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerJavaAutoConfigurationTest.class);

    @Autowired
    DockerClient dockerClient;

    @Autowired
    DockerClientBuilder dockerClientBuilder;

    @Autowired
    DockerClientConfig dockerClientConfig;

    @Test
    public void dockerClientConfig() {
        Assert.assertNotNull(dockerClientConfig);
    }

    @Test
    public void dockerClient() throws Exception {
        Assert.assertNotNull(dockerClient);
    }

    @Test
    public void dockerClientBuilder() {
        Assert.assertNotNull(dockerClientBuilder);
    }

}