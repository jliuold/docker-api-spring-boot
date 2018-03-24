package top.shareall.docker.spring.boot.starter.configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Docker Java 自动配置类
 *
 * @author liujichun
 */
@ConditionalOnClass(DockerClient.class)
@EnableConfigurationProperties(DockerClientProperties.class)
@Configuration
public class DockerJavaAutoConfiguration {

    @Autowired
    DockerClientProperties dockerClientProperties;

    @Bean
    @ConditionalOnMissingBean(DockerClientConfig.class)
    public DockerClientConfig dockerClientConfig() {
        DefaultDockerClientConfig.Builder builder = DefaultDockerClientConfig.createDefaultConfigBuilder();
        if (!StringUtils.isEmpty(dockerClientProperties.getApiVersion()))
            builder.withApiVersion(dockerClientProperties.getApiVersion());
        if (!StringUtils.isEmpty(dockerClientProperties.getDockerConfig()))
            builder.withDockerConfig(dockerClientProperties.getDockerConfig());
        if (!StringUtils.isEmpty(dockerClientProperties.getDockerHost()))
            builder.withDockerHost(dockerClientProperties.getDockerHost());
        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryUrl()))
            builder.withRegistryUrl(dockerClientProperties.getRegistryUrl());
        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryEmail()))
            builder.withRegistryEmail(dockerClientProperties.getRegistryEmail());
        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryPassword()))
            builder.withRegistryPassword(dockerClientProperties.getRegistryPassword());
        if (!StringUtils.isEmpty(dockerClientProperties.getRegistryUsername()))
            builder.withRegistryUsername(dockerClientProperties.getRegistryUsername());
        if (!StringUtils.isEmpty(dockerClientProperties.getDockerCertPath()))
            builder.withDockerCertPath(dockerClientProperties.getDockerCertPath());
        if (!StringUtils.isEmpty(dockerClientProperties.getApiVersion()))
            builder.withApiVersion(dockerClientProperties.getApiVersion());
        if (dockerClientProperties.getDockerTlsVerify() != null)
            builder.withDockerTlsVerify(dockerClientProperties.getDockerTlsVerify());
        if (!CollectionUtils.isEmpty(dockerClientProperties.getConfig()))
            builder.withProperties(dockerClientProperties.getConfig());
        return builder.build();
    }

    @Bean
    @ConditionalOnMissingBean(DockerClientBuilder.class)
    public DockerClientBuilder dockerClientBuilder() {
        return DockerClientBuilder.getInstance(dockerClientConfig());
    }

    @Bean
    @ConditionalOnMissingBean(DockerClient.class)
    public DockerClient dockerJavaClient() {
        return dockerClientBuilder().build();
    }

}
