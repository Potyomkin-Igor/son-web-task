package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PropertiesConfig.GitHubProperties.class)
public class PropertiesConfig {

    @Getter
    @Setter
    @ConfigurationProperties("github")
    public class GitHubProperties {

        private String clientId;
        private String clientSecret;
    }
}