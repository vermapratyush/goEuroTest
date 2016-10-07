package com.goeuro.interview.service.locationservice;

import com.goeuro.interview.MockedHttpResponse;
import com.goeuro.interview.client.HTTPClient;
import com.goeuro.interview.model.pojo.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by pratyushverma on 10/7/16.
 */
public class LocationServiceImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetCitySuggestion() throws Exception {
        HTTPClient client = Mockito.mock(HTTPClient.class);

        byte[] content = Files.readAllBytes(Paths.get(getClass().getResource("/berlinResponse.json").getPath()));
        Mockito.when(client.Get(Matchers.anyString(), Matchers.anyMap())).thenReturn(
                MockedHttpResponse.mockedFutureHttpResponseSuccess(new String(content))
        );
        City[] cities = LocationServiceImpl.getInstance().getCitySuggestion("Berlin");
        Assert.assertEquals(cities.length, 8);

    }

}
