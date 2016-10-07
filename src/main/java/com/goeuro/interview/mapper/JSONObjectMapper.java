package com.goeuro.interview.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.goeuro.interview.exception.ObjectMapperException;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pratyushverma on 10/5/16.
 */
public class JSONObjectMapper extends ObjectMapper implements IObjectMapper {
    private static Logger LOGGER = Logger.getLogger(JSONObjectMapper.class.getName());
    private static JSONObjectMapper ourInstance;

    public static JSONObjectMapper getInstance() {
        return ourInstance;
    }

    static {
        ourInstance = new JSONObjectMapper();
        ourInstance.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        ourInstance.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        ourInstance.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
    }

    private JSONObjectMapper() {
    }

    @Override
    public <T> T asPOJO(InputStream dataString, Class<T> tClass) throws IOException {
        return ourInstance.readValue(dataString, tClass);
    }

    @Override
    public <T> T asPOJO(String dataString, Class<T> tClass) throws IOException {
        return ourInstance.readValue(dataString, tClass);
    }

    @Override
    public <T> String asString(T tClass) throws ObjectMapperException {
        try {
            return ourInstance.writeValueAsString(tClass);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.WARNING, "Exception while serializing Object to JSON", e);
            throw new ObjectMapperException(e);
        }
    }
}
