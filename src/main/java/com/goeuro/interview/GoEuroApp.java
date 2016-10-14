package com.goeuro.interview;

import com.goeuro.interview.mapper.CSVObjectMapper;
import com.goeuro.interview.model.csv.CityBuilder;
import com.goeuro.interview.model.pojo.City;
import com.goeuro.interview.service.locationservice.ILocationService;
import com.goeuro.interview.service.locationservice.LocationServiceImpl;
import com.mashape.unirest.http.Unirest;

import java.io.*;

/**
 * Core of the application.
 * Calls Location service and writes relevant data into a CSV file.
 */
class GoEuroApp {
    private String city;
    private ILocationService locationService;

    GoEuroApp(String city) {
        this.city = city;
        locationService = LocationServiceImpl.getInstance();
    }

    public void run() {
        try {
            City[] cities = locationService.getCitySuggestion(city);

            com.goeuro.interview.model.csv.City[] cityList = new com.goeuro.interview.model.csv.City[cities.length];
            for (int i = 0; i < cities.length; i++) {
                CityBuilder cityBuilder = new CityBuilder()
                        .setId(cities[i].getId())
                        .setName(cities[i].getName())
                        .setType(cities[i].getType());
                if (cities[i].getGeoPosition() != null) {
                    cityBuilder.setLatitude(cities[i].getGeoPosition().getLatitude());
                    cityBuilder.setLongitude(cities[i].getGeoPosition().getLongitude());
                }
                cityList[i] = cityBuilder.createCity();
            }

            writeToFile(cityList);
        } catch (Exception | Error e) {
            System.err.println(e.getCause());
            System.exit(1);
        } finally {
            try {
                Unirest.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeToFile(com.goeuro.interview.model.csv.City[] cityList) throws IOException {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(Configuration.getOutputFileName()), "utf-8"))) {
            String outputString = CSVObjectMapper.getInstance().asString(cityList);
            writer.write(outputString);

            System.out.println("Output written to file: " + Configuration.getOutputFileName());
            System.out.println(outputString);
        }
    }
}
