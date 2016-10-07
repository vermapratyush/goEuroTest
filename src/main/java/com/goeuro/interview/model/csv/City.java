package com.goeuro.interview.model.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * POJO which is the schema for the file to be written in CSV format
 * Specify the order of the keys and override id to _id
 */
@JsonPropertyOrder({ "id", "name", "type", "latitude", "longitude"})
public class City implements Serializable {
    @JsonProperty("_id")
    private int id;
    private String name;
    private String type;
    private Double latitude;
    private Double longitude;

    public City() {
    }

    public City(int id, String name, String type, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("type", type)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .toString();
    }
}
