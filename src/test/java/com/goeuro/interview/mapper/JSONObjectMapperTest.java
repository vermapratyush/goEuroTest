package com.goeuro.interview.mapper;

import com.goeuro.interview.model.pojo.City;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pratyushverma on 10/7/16.
 */
public class JSONObjectMapperTest {
    @Test
    public void testAsString() throws Exception {
        City city = new City();
        city.setName("cityName");
        String json = JSONObjectMapper.getInstance().asString(city);
        Assert.assertEquals("{\"name\":\"cityName\"}", json);
    }

    @Test
    public void testAsPOJO() throws Exception {
        String json = "{\"name\":\"cityName\"}";
        City city = JSONObjectMapper.getInstance().asPOJO(json, City.class);
        Assert.assertEquals(city.getName(), "cityName");

    }
}
