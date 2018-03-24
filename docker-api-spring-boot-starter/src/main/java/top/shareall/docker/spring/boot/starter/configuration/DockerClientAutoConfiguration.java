package top.shareall.docker.spring.boot.starter.configuration;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerCertificates;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.messages.AuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author jichun
 */
@ConditionalOnClass(DockerClient.class)
@EnableConfigurationProperties(DockerClientProperties.class)
@Configuration
public class DockerClientAutoConfiguration {

    @Autowired
    DockerClientProperties dockerClientProperties;

    @Bean
    @ConditionalOnMissingBean(DockerClient.class)
    public DockerClient dockerClient() {

        DefaultDockerClient.Builder builder = null;
        try {
            builder = DefaultDockerClient.fromEnv();
        } catch (DockerCertificateException e) {
            e.printStackTrace();
        }

        if (builder == null) {
            builder = DefaultDockerClient.builder();
        }

        if (!StringUtils.isEmpty(dockerClientProperties.getApiVersion())) {
            builder.apiVersion(dockerClientProperties.getApiVersion());
        }
        if (!StringUtils.isEmpty(dockerClientProperties.getDockerHost())) {
            builder.uri(dockerClientProperties.getDockerHost());
        }
        if (dockerClientProperties.getDockerTlsVerify() != null) {
            String scheme = builder.uri().getScheme();
            if (dockerClientProperties.getDockerTlsVerify() && "http".equals(scheme.toLowerCase())) {
                builder.uri(builder.uri().toString().replaceFirst("http", "https"));
            }
            if (!dockerClientProperties.getDockerTlsVerify() && "https".equals(scheme.toLowerCase())) {
                builder.uri(builder.uri().toString().replaceFirst("https", "http"));
            }
        }
        DockerCertificates certificates = getCertificates();
        if (null != certificates) {
            builder.dockerCertificates();
        } else {
            builder.dockerCertificates(certificates);
        }
        builder.authConfig(getAuthConfig());
        return builder.build();
    }

    /**
     * Build the DockerCertificates
     */
    private DockerCertificates getCertificates() {
        DockerCertificates certificates = null;
        if (!StringUtils.isEmpty(dockerClientProperties.getDockerCertPath())) {
            try {
                certificates = DockerCertificates.builder().dockerCertPath(Paths.get(dockerClientProperties.getDockerCertPath())).build().get();
            } catch (DockerCertificateException e) {
                e.printStackTrace();
            }
        }
        return certificates;
    }

    /**
     * Get the docker auth config. Default from the .docker/config.json or .dockercfg.
     * It can be override by Spring Boot config.
     */
    private AuthConfig getAuthConfig() {
        AuthConfig.Builder authBuilder = null;
        // 默认的配置文件具有更低的优先级
        try {
            authBuilder = AuthConfig.fromDockerConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (authBuilder == null) {
            authBuilder = AuthConfig.builder();
        }

        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryEmail())) {
            authBuilder.email(dockerClientProperties.getRegistryEmail());
        }
        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryPassword())) {
            authBuilder.password(dockerClientProperties.getRegistryPassword());
        }
        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryUsername())) {
            authBuilder.username(dockerClientProperties.getRegistryUsername());
        }
        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryUrl())) {
            authBuilder.serverAddress(dockerClientProperties.getRegistryUrl());
        }
        return authBuilder.build();
    }
}
