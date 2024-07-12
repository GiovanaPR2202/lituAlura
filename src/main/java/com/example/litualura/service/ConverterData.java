package com.example.litualura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;


public class ConverterData implements  IConverterData {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T getData(String json, Class<T> Tclass){
        try {
            return mapper.readValue(json, Tclass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getJson(String json, String object){
        try {
            JsonNode completeJson = mapper.readTree(json);
            JsonNode jsonBook = completeJson.path("results");
            return jsonBook.toString();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public <T> List<T> getList(String json, Class<T> Tclass ){
        CollectionType list = mapper.getTypeFactory()
                .constructCollectionType(List.class, Tclass);
        try {
            return mapper.readValue(json, list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
