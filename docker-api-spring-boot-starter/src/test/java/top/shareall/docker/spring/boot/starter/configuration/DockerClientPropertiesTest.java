package top.shareall.docker.spring.boot.starter.configuration;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class DockerClientPropertiesTest {

    DockerClientProperties properties;

    @Before
    public void init() {
        properties = new DockerClientProperties();
    }

    @Test
    public void getDockerCertPath() throws Exception {
        properties.getDockerCertPath();
    }

    @Test
    public void setDockerCertPath() throws Exception {
        properties.setDockerCertPath(".");
    }

    @Test
    public void getDockerTlsVerify() throws Exception {
        properties.getDockerTlsVerify();
    }

    @Test
    public void setDockerTlsVerify() throws Exception {
        properties.setDockerTlsVerify(true);
    }

    @Test
    public void getConfig() throws Exception {
        properties.getConfig();
    }

    @Test
    public void setConfig() throws Exception {
        properties.setConfig(new Properties());
    }

    @Test
    public void getDockerHost() throws Exception {
        properties.getDockerHost();
    }

    @Test
    public void setDockerHost() throws Exception {
        properties.setDockerHost("https://locahost:7963");
    }

    @Test
    public void getRegistryUsername() throws Exception {
        properties.getRegistryUsername();
    }

    @Test
    public void setRegistryUsername() throws Exception {
        properties.setRegistryUsername("test");
    }

    @Test
    public void getRegistryPassword() throws Exception {
        properties.getRegistryPassword();
    }

    @Test
    public void setRegistryPassword() throws Exception {
        properties.setRegistryPassword("test");
    }

    @Test
    public void getRegistryEmail() throws Exception {
        properties.getRegistryEmail();
    }

    @Test
    public void setRegistryEmail() throws Exception {
        properties.setRegistryEmail("test@test.com");
    }

    @Test
    public void getRegistryUrl() throws Exception {
        properties.getRegistryUrl();
    }

    @Test
    public void setRegistryUrl() throws Exception {
        properties.setRegistryUrl("http://localhost");
    }

    @Test
    public void getDockerConfig() throws Exception {
        properties.getDockerConfig();
    }

    @Test
    public void setDockerConfig() throws Exception {
        properties.setDockerConfig("");
    }

    @Test
    public void getApiVersion() throws Exception {
        properties.getApiVersion();
    }

    @Test
    public void setApiVersion() throws Exception {
        properties.setApiVersion("1");
    }

}