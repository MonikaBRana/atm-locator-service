package com.example.demo.Service;

import com.example.demo.Pojo.AtmLocationDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AtmLocatorServiceTest {

    @Mock
    AtmLocatorClient atmLocatorClient;

    @InjectMocks
    AtmLocatorService atmLocatorService = new AtmLocatorService();


    @Test
    public void getAllAtmDetailsTest(){
        List<AtmLocationDetails> atmLocationDetailsExpected = Arrays.asList(createDataForAtmLocationDetails("Deinum"),createDataForAtmLocationDetails("Tholen"),
                createDataForAtmLocationDetails("Vierlingsbeek"));
        Mockito.when(atmLocatorClient.loadAllAtmDetails()).thenReturn(atmLocationDetailsExpected);
        List<AtmLocationDetails> atmLocationDetailsListActual =atmLocatorService.getAllAtmDetails();
        Assert.assertEquals("size of the expected and actual list should match ",atmLocationDetailsExpected.size(),atmLocationDetailsListActual.size());
    }

    @Test
    public void getAllAtmDetailsByCityTest(){
        String citySearch = "Deinum";
        List<AtmLocationDetails> atmLocationDetailsExpected = Arrays.asList(createDataForAtmLocationDetails("Deinum"),createDataForAtmLocationDetails("Tholen"),
                createDataForAtmLocationDetails("Vierlingsbeek"),createDataForAtmLocationDetails("Deinum"));
        Mockito.when(atmLocatorClient.loadAllAtmDetails()).thenReturn(atmLocationDetailsExpected);
        List<AtmLocationDetails> atmLocationDetailsListActual =atmLocatorService.getAtmDetailsByCity(citySearch);
        Assert.assertEquals("size of the expected and actual list should match ",atmLocationDetailsExpected.size()-2,atmLocationDetailsListActual.size());
        Assert.assertEquals("Expected and actual city should match ",citySearch,atmLocationDetailsListActual.get(0).getAddress().getCity());
    }

    public AtmLocationDetails createDataForAtmLocationDetails(String city){
        PodamFactory factory = new PodamFactoryImpl();
        AtmLocationDetails atmLocationDetails = factory.manufacturePojo(AtmLocationDetails.class);
        atmLocationDetails.getAddress().setCity(city);
        return atmLocationDetails;
    }
}
