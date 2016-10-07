package com.goeuro.interview.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Map;

/**
 * Schema of City response from Location Service
 */
public class City implements Serializable {

    @JsonProperty("_id")
    private int id;
    private Object key;
    private String name;
    private String fullName;
    @JsonProperty("iata_airport_code")
    private Object iataAirportCode;
    private String type;
    private String country;
    @JsonProperty("geo_position")
    private GeoPosition geoPosition;
    private int locationId;
    private boolean inEurope;
    private int countryId;
    private String countryCode;
    private boolean coreCountry;
    private Object distance;
    private Map<String, String> names;
    private Object alternativeNames;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Object getIataAirportCode() {
        return iataAirportCode;
    }

    public void setIataAirportCode(Object iataAirportCode) {
        this.iataAirportCode = iataAirportCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public Object getDistance() {
        return distance;
    }

    public void setDistance(Object distance) {
        this.distance = distance;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    public Object getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(Object alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("key", key)
                .append("name", name)
                .append("fullName", fullName)
                .append("iataAirportCode", iataAirportCode)
                .append("type", type)
                .append("country", country)
                .append("geoPosition", geoPosition)
                .append("locationId", locationId)
                .append("inEurope", inEurope)
                .append("countryId", countryId)
                .append("countryCode", countryCode)
                .append("coreCountry", coreCountry)
                .append("distance", distance)
                .append("names", names)
                .append("alternativeNames", alternativeNames)
                .toString();
    }
}
