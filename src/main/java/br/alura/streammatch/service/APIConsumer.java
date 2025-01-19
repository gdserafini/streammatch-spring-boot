package br.alura.streammatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumer {

    public String getData(String url) 
            throws IOException, InterruptedException{
        
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
            .newBuilder()
            .uri(URI.create(url))
            .build();
        
        return client
            .send(request, HttpResponse.BodyHandlers.ofString())
            .body();
    }
}
