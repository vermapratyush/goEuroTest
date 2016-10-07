package com.goeuro.interview.model.csv;

public class CityBuilder {
    private int id;
    private String name;
    private String type;
    private double latitude;
    private double longitude;

    public CityBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public CityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CityBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public CityBuilder setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public CityBuilder setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public City createCity() {
        return new City(id, name, type, latitude, longitude);
    }
}