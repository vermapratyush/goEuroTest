package com.goeuro.interview.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.goeuro.interview.exception.ObjectMapperException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pratyushverma on 10/6/16.
 */
interface IObjectMapper {
    /**
     * Convert InputStream of string to a POJO
     * @param dataString InputStream of the string. This is usually the InputStream from a HTTPRequest
     * @param tClass Class in which the string is to be deserialized.
     * @param <T> Type of the class
     * @return De-serialized object.
     * @throws IOException Exception thrown while reading from inputstream or while de-serializing
     */
    <T> T asPOJO(InputStream dataString, Class<T> tClass) throws IOException;

    /**
     * Convert String of string to a POJO
     * @param dataString String containing the string. This is usually the Response from a HTTPRequest or from a file
     * @param tClass Class in which the string is to be deserialized.
     * @param <T> Type of the class
     * @return De-serialized object.
     * @throws IOException Exception thrown while de-serializing
     */
    <T> T asPOJO(String dataString, Class<T> tClass) throws IOException;

    /**
     * Serializes an object into a string.
     * @param tClass Object containing data to be serialized
     * @param <T> Class of the object
     * @return Serialized form of the object
     * @throws ObjectMapperException Wrapper exception of any error while serialization
     */
    <T> String asString(T tClass) throws ObjectMapperException;
}
