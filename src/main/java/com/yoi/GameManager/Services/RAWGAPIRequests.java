package com.yoi.GameManager.Services;
import com.yoi.GameManager.Model.Entity.JPA.Game;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RAWGAPIRequests {

    public Game envioReciboDatos(String gameQuery){
        // Instanciamos el cliente HTTP
        OkHttpClient client = new OkHttpClient();
        gameQuery = toSlug(gameQuery);
        // Clave de API y URL de búsqueda
        String apiKey = "TU_API_KEY"; // Reemplaza con tu API Key
        String url = "https://api.rawg.io/api/games?key=" + apiKey + "&search=" + gameQuery;

            // Construimos la solicitud HTTP GET
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println(response.body().string());
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




