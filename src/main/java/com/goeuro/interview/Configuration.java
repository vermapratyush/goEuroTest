package com.goeuro.interview;

import com.goeuro.interview.util.HttpUtil;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration management of the Application.
 * Reads configuration from the file config.properties
 *
 * Reloads the file at fixed interval. This although is not very useful in a command-line application.
 * Can be very useful in a web service.
 */
public class Configuration {
    private static Logger LOGGER = Logger.getLogger(Configuration.class.getName());
    private static PropertiesConfiguration config;

    static {
        try {
            config = new PropertiesConfiguration("config.properties");

            //Set reload strategy, so the configuration changes can be made in realtime.
            config.setReloadingStrategy(new FileChangedReloadingStrategy());
        } catch (ConfigurationException e) {
            LOGGER.log(Level.SEVERE, "Configuration file not found");
        }
    }

    public static int getConnectTimeout() {
        return config.getInt("connectTimeout");
    }

    public static int getSocketTimeout() {
        return config.getInt("socketTimeout");
    }

    public static String getClientId() {
        return config.getString("clientId");
    }

    public static String getBaseUrl() {
        return config.getString("baseUrl");
    }

    public static String getCitySuggestionUrl() {
        return config.getString("citySuggestionUrl");
    }

    public static String getOutputFileName() {
        return config.getString("outputFile");
    }


}
