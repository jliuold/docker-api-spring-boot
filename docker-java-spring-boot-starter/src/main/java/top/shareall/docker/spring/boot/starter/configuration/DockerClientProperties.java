package top.shareall.docker.spring.boot.starter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * The Spring Boot Properties for Docker java
 *
 * @author liujichun
 */
@Configuration
@ConfigurationProperties(prefix = "docker-java")
public class DockerClientProperties {

    private Properties config;
    private String dockerHost;
    private String registryUsername;
    private String registryPassword;
    private String registryEmail;
    private String registryUrl;
    private String dockerConfig;
    private String apiVersion;
    private String dockerCertPath;
    private String dockerTlsVerify;

    public String getDockerCertPath() {
        return dockerCertPath;
    }

    public void setDockerCertPath(String dockerCertPath) {
        this.dockerCertPath = dockerCertPath;
    }

    public String getDockerTlsVerify() {
        return dockerTlsVerify;
    }

    public void setDockerTlsVerify(String dockerTlsVerify) {
        this.dockerTlsVerify = dockerTlsVerify;
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    public String getDockerHost() {
        return dockerHost;
    }

    public void setDockerHost(String dockerHost) {
        this.dockerHost = dockerHost;
    }

    public String getRegistryUsername() {
        return registryUsername;
    }

    public void setRegistryUsername(String registryUsername) {
        this.registryUsername = registryUsername;
    }

    public String getRegistryPassword() {
        return registryPassword;
    }

    public void setRegistryPassword(String registryPassword) {
        this.registryPassword = registryPassword;
    }

    public String getRegistryEmail() {
        return registryEmail;
    }

    public void setRegistryEmail(String registryEmail) {
        this.registryEmail = registryEmail;
    }

    public String getRegistryUrl() {
        return registryUrl;
    }

    public void setRegistryUrl(String registryUrl) {
        this.registryUrl = registryUrl;
    }

    public String getDockerConfig() {
        return dockerConfig;
    }

    public void setDockerConfig(String dockerConfig) {
        this.dockerConfig = dockerConfig;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
