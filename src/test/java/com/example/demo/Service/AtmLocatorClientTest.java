package com.example.demo.Service;

import com.example.demo.Pojo.AtmLocationDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtmLocatorClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AtmLocatorClient atmLocatorClient = new AtmLocatorClient();

    @Test
    public void loadAllAtmDetailsTest(){
        String atmDetailsProviderUrl = "https://www.ing.nl/api/locator/atms/";
        String response = ")])\n[{\"address\":{\"street\":\"Ginnekenweg\",\"housenumber\":\"46\",\"postalcode\":\"4818 JG\",\"city\":\"Breda\",\"geoLocation\":{\"lat\":\"51.577302\",\"lng\":\"4.78034\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"09:00\",\"hourTo\":\"20:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"}]";
        when(restTemplate.getForObject(atmDetailsProviderUrl,String.class)).thenReturn(response);
        List<AtmLocationDetails> atmLocationDetailsList = atmLocatorClient.loadAllAtmDetails();
        assertNotNull("list cannot be empty",atmLocationDetailsList);
        assertEquals("list size should be 1",1,atmLocationDetailsList.size());
    }
}
