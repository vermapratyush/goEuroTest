package com.goeuro.interview;

import com.goeuro.interview.model.pojo.City;
import com.goeuro.interview.service.locationservice.ILocationService;
import com.goeuro.interview.service.locationservice.LocationServiceImpl;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Created by pratyushverma on 10/7/16.
 */
public class GoEuroAppTest {

    @Test
    public void testRun() throws Exception {
        LocationServiceImpl mockedLocationService = Mockito.mock(LocationServiceImpl.class);
        GoEuroApp mockedApp = Mockito.mock(GoEuroApp.class);

        City city1 = new City(); city1.setId(1); city1.setName("city1");
        City city2 = new City(); city2.setId(1); city2.setName("city1");
        Mockito.when(mockedLocationService.getCitySuggestion("Berlin")).thenReturn(
                new City[]{city1, city2}
        );

        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                System.out.println(invocationOnMock);
                return null;
            }
        }).when(mockedApp);

        mockedApp.run();

    }
}
