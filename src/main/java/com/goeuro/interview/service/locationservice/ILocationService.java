package com.goeuro.interview.service.locationservice;

import com.goeuro.interview.exception.NetworkException;
import com.goeuro.interview.model.pojo.City;

import java.io.IOException;

/**
 * Interface for LocationService.
 * Newer version of the server should implement this interface.
 * All the APIs exposed in LocationService should have an entry here.
 */
public interface ILocationService {
    City[] getCitySuggestion(String city) throws NetworkException, IOException;
}
