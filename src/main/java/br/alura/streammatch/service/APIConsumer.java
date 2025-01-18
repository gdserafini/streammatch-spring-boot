package br.alura.streammatch.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumer {

    public String getData(String url){
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = null;
        
        try{
            response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
