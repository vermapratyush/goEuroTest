package com.goeuro.interview.mapper;

import com.goeuro.interview.model.csv.City;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pratyushverma on 10/7/16.
 */
public class CSVObjectMapperTest {
    @Test
    public void testAsString() throws Exception {
        City city = new City(1, "cityName", "location", 1.0, 1.0);
        String csv = CSVObjectMapper.getInstance().asString(city);
        Assert.assertEquals("1,cityName,location,1.0,1.0\n", csv);
    }

    @Test
    public void testAsPOJO() throws Exception {
        String csv = "1,cityName,location,1.0,-1.0";
        City city = CSVObjectMapper.getInstance().asPOJO(csv, City.class);
        Assert.assertEquals(1, city.getId());
        Assert.assertEquals("cityName", city.getName());
        Assert.assertEquals("location", city.getType());
        Assert.assertEquals(1.0, city.getLatitude(), 0);
        Assert.assertEquals(-1.0, city.getLongitude(), 0);
    }
}
