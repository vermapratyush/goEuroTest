package com.goeuro.interview.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.goeuro.interview.Configuration;
import com.goeuro.interview.mapper.JSONObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Implementation of IHTTPClient.
 * Here we are using Unirest, however it can be changed to any other vendor provided it implements IHTTPClient.
 *
 * Since we are writing a Commandline program, connection pooling is not really necessary.
 * However in case of a web server, connection pooling is be a must.
 * Connection pooling can be implemented here.
 */
public class HTTPClient implements IHTTPClient {
    private static HTTPClient ourInstance = new HTTPClient();

    public static HTTPClient getInstance() {
        return ourInstance;
    }

    private HTTPClient() {
        Unirest.setObjectMapper(new ObjectMapper() {
            @Override
            public <T> T readValue(String s, Class<T> aClass) {
                try {
                    return JSONObjectMapper.getInstance().asPOJO(s, aClass);
                } catch (IOException e) {
                    throw new Error();
                }
            }

            @Override
            public String writeValue(Object o) {
                try {
                    return JSONObjectMapper.getInstance().asString(o);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        Unirest.setTimeouts(Configuration.getConnectTimeout(), Configuration.getSocketTimeout());
    }

    @Override
    public Future<HttpResponse<InputStream>> Get(String url, Map<String, String> headers) {
        return Unirest
                .get(url)
                .headers(headers)
                .asBinaryAsync();
    }

    @Override
    public Future<HttpResponse<InputStream>> Post(String url, Map<String, String> headers, Object body) {
        throw new UnsupportedOperationException("Post not yet implemented");
    }

    @Override
    public Future<HttpResponse<InputStream>> Put(String url, Map<String, String> headers, Object body) {
        throw new UnsupportedOperationException("Put not yet implemented");
    }
}
