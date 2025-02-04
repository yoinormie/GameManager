package com.yoi.GameManager.Config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.yoi.GameManager.Components.AppuserDeserialzer;
import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import com.yoi.GameManager.Repositories.JPA.AppuserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Autowired
    private AppuserRepositoryJPA appuserRepositoryJPA;

    @Bean
    public SimpleModule customModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Appuser.class, new AppuserDeserialzer(appuserRepositoryJPA));
        return module;
    }
}
