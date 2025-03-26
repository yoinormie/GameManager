package com.yoi.GameManager.Model.DTO.RequestDTOs.GameRequest.RAWGDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDTORequest {
    @JsonProperty("name_original")
    private String nameOriginal;

    private Integer metacritic;
    private String released;

    @JsonProperty("platforms")
    private List<PlatformWrapper> platforms;

    @JsonProperty("developers")
    private List<Developer> developers;

    @JsonProperty("publishers")
    private List<Publisher> publishers;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlatformWrapper {
        @JsonProperty("platform")
        private Platform platform;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Platform {
        private String name;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Developer {
        private String name;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Publisher {
        private String name;
    }
}