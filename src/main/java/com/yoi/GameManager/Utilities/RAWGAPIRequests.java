package com.yoi.GameManager.Utilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoi.GameManager.Model.DTO.RequestDTOs.GameRequest.RAWGDTOs.GameDTORequest;
import com.yoi.GameManager.Model.Entity.JPA.Game;
import com.yoi.GameManager.Repositories.JPA.GameRepositoryJPA;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RAWGAPIRequests {

        public Game envioReciboDatos(String gameQuery, GameRepositoryJPA gameRepositoryJPA){
            OkHttpClient client = new OkHttpClient();
            gameQuery = toSlug(gameQuery);
            String apiKey = "f7753954ce2b4182b24f25507bf7c0bf";
            String url = "https://api.rawg.io/api/games/" + gameQuery + "?key=" + apiKey;
            GameDTORequest gameDTO;
            //if(gameRepositoryJPA.)
            Request request = new Request.Builder().url(url).get().build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    gameDTO = objectMapper.readValue(response.body().string(), GameDTORequest.class);
                    if(!gameDTO.getDetail().isBlank()){
                        
                    }
                } else {
                    System.out.println("Error en la solicitud: " + response.code());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        private static String toSlug(String title){
            return title.toLowerCase()
                    .replaceAll("[^a-z0-9 ]", "")
                    .replaceAll("\\s+", "-");
        }
}




