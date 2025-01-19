package br.alura.streammatch.service;

import java.io.IOException;

public class DataProcessor {
    APIConsumer consumer = new APIConsumer();
    DataConverter converter = new DataConverter();

    public <T> T process(String url, Class<T> toClass) 
            throws IOException, InterruptedException{
        var json = this.consumer.getData(url);
		var data = this.converter.mapData(json, toClass);
		return data;
    }
}
