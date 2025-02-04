package com.yoi.GameManager.Components;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.yoi.GameManager.Exceptions.Appuser.UserNotDeserialized;
import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import com.yoi.GameManager.Repositories.JPA.AppuserRepositoryJPA;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@NoArgsConstructor(force = true)
public class AppuserDeserialzer extends JsonDeserializer<Appuser> {

    private final AppuserRepositoryJPA appuserRepositoryJPA;

    @Autowired
    public AppuserDeserialzer(AppuserRepositoryJPA appuserRepositoryJPA) {
        this.appuserRepositoryJPA = appuserRepositoryJPA;
    }

    @Override
    public Appuser deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String userId = jsonParser.getText();
        return appuserRepositoryJPA.findById(UUID.fromString(userId))
                .orElseThrow(() -> new UserNotDeserialized());
    }
}

