package com.goeuro.interview.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.goeuro.interview.Configuration;
import com.goeuro.interview.exception.ObjectMapperException;
import com.goeuro.interview.model.csv.City;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pratyushverma on 10/5/16.
 */
public class CSVObjectMapper extends CsvMapper implements IObjectMapper {
    private static Logger LOGGER = Logger.getLogger(CSVObjectMapper.class.getName());
    private static CSVObjectMapper ourInstance;

    public static CSVObjectMapper getInstance() {
        return ourInstance;
    }

    static {
        ourInstance = new CSVObjectMapper();
    }

    private CSVObjectMapper() {
    }

    @Override
    public <T> T asPOJO(InputStream dataString, Class<T> tClass) throws IOException {
        return ourInstance.readerFor(tClass)
                .with(ourInstance.schemaFor(tClass))
                .readValue(dataString);
    }

    @Override
    public <T> T asPOJO(String dataString, Class<T> tClass) throws IOException {
        return ourInstance.readerFor(tClass)
                .with(ourInstance.schemaFor(tClass))
                .readValue(dataString);
    }

    /**
     * Converts an Object[] to CSV a complete CSV file
     * The function also converts Object to a row of CSV file
     * @param tClass object to be serialized
     * @param <T> Type of the class being passed.
     * @return Object and Object[] in string format
     * @throws ObjectMapperException Exception Wrapper for ObjectMappers.
     */
    @Override
    public <T> String asString(T tClass) throws ObjectMapperException {
        if (tClass instanceof Object[]) {
            StringWriter stringWriter = new StringWriter();
            CsvSchema schema = ourInstance.schemaFor(((Object[]) tClass)[0].getClass()).withHeader();
            try (SequenceWriter csvWriter = ourInstance
                    .writer(schema)
                    .withDefaultPrettyPrinter()
                    .forType(((Object[]) tClass)[0].getClass())
                    .writeValues(stringWriter)) {
                for(Object nextRow : (Object[]) tClass) {
                    csvWriter.write(nextRow);
                }
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Exception while serializing Object[] to CSV", e);
                throw new ObjectMapperException(e);
            }

            return stringWriter.toString();
        } else {
            try {
                return ourInstance.writerFor(tClass.getClass())
                        .withDefaultPrettyPrinter()
                        .with(ourInstance.schemaFor(tClass.getClass()))
                        .writeValueAsString(tClass);
            } catch (JsonProcessingException e) {
                LOGGER.log(Level.WARNING, "Exception while serializing Object to CSV", e);
                throw new ObjectMapperException(e);
            }
        }
    }
}
