package com.yoi.GameManager.Components;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;


public class PSUserAgentInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("PSMicroserviceClient/1.0");
    }
}
