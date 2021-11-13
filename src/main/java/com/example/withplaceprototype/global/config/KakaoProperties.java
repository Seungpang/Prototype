package com.example.withplaceprototype.global.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kakao.openapi")
public class KakaoProperties {

    private String pointAddressUrl;
    private String clientSecret;
}
