package br.alura.streammatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IDataConverter {
    <T> T mapData(String json, Class<T> dataClass) 
        throws JsonMappingException, JsonProcessingException;
}
