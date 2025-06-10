package com.yoi.GameManager.Components;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class SteamUserAgentInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("User-Agent", "SteamMicroserviceClient/1.0");
    }
}

