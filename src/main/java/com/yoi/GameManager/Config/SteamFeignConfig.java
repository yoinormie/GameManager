package com.yoi.GameManager.Config;

import com.yoi.GameManager.Components.SteamUserAgentInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SteamFeignConfig {
    @Bean
    public RequestInterceptor steamUserAgentInterceptor() {
        return new SteamUserAgentInterceptor();
    }
}