package com.goeuro.interview.service;

import com.goeuro.interview.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all Services within geoEuro.
 * This should contain the "company" level practices common headers, authorization.
 *
 */
public abstract class Service implements IIdentifiable {

    // Common headers that needs to be passed along with every request.
    // In a microservice environment, it becomes extremely difficult to debug if there are many different clients.
    // API_KEY and other common headers can be added here.
    public static final Map<String, String> baseHeaders = new HashMap<String, String>() {{
        put("Client-Id", Configuration.getClientId());
    }};

    @Override
    public String getId() {
        return getName() + "_" + getVersion();
    }
}
