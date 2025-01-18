package br.alura.streammatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {
    
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T mapData(String json, Class<T> dataClass) 
            throws JsonMappingException, JsonProcessingException {
        return mapper.readValue(json, dataClass);
    }
}
