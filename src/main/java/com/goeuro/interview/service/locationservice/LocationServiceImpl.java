package com.goeuro.interview.service.locationservice;

import com.goeuro.interview.Configuration;
import com.goeuro.interview.client.HTTPClient;
import com.goeuro.interview.exception.NetworkException;
import com.goeuro.interview.mapper.JSONObjectMapper;
import com.goeuro.interview.model.pojo.City;
import com.goeuro.interview.service.Service;
import com.goeuro.interview.util.HttpUtil;
import com.mashape.unirest.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of LocationService version 1.0
 */
public class LocationServiceImpl extends Service implements ILocationService {
    private static LocationServiceImpl ourInstance = new LocationServiceImpl();

    public static LocationServiceImpl getInstance() {
        return ourInstance;
    }

    private static Logger LOGGER = Logger.getLogger(LocationServiceImpl.class.getName());
    private String baseUrl = Configuration.getBaseUrl();
    private String citySuggestionUrl = baseUrl + Configuration.getCitySuggestionUrl();

    @Override
    public City[] getCitySuggestion(String city) throws NetworkException, IOException {
        try {
            HttpResponse<InputStream> response =
                    HTTPClient.getInstance()
                            .Get(citySuggestionUrl + HttpUtil.urlEncode(city), baseHeaders)
                    .get();

            return JSONObjectMapper.getInstance().asPOJO(response.getBody(), City[].class);
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.WARNING, "HttpConnection interrupted", e);
            throw new NetworkException();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Response deserialization failed", e);
            throw e;
        }
    }

    @Override
    public String getName() {
        return "LocationService";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
