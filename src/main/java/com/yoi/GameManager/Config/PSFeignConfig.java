package com.yoi.GameManager.Config;

import com.yoi.GameManager.Components.PSUserAgentInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PSFeignConfig {
    @Bean
    public RequestInterceptor psUserAgentInterceptor() {
        return new PSUserAgentInterceptor();
    }
}
