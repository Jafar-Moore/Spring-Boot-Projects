package com.HalalTours.HalaTours.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.HalalTours.HalaTours.Model.Airport;
import com.HalalTours.HalaTours.Service.AirportService;
import com.HalalTours.HalaTours.Service.ExcursionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AirportController.class)
@ExtendWith(MockitoExtension.class)
class AirportControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private ObjectMapper objectMapper;

	    @MockBean
	    private AirportService aservice;

	    
	@Test
	void testThatSaveAirportBookingWorksAndReturnsA200HTTPSstatus() throws Exception{
		
		//Given
        Airport airport = new Airport();
        airport.setId(1L);
        airport.setClientName("John Doe");
        airport.setNumberOfPassengers(2);
        airport.setArrivalDateTime("2024-08-08T10:00:00");
        airport.setDepartureDateTime("2024-08-15T15:00:00");
        airport.setFlightNameAndNumber("Flight XY123");
        airport.setHotelName("Grand Hotel");
        airport.setNumberOfPiecesOfLuggage(4);
        
        //when
        when(aservice.bookAirportService(airport)).thenReturn(airport);
        
        String jsoncontent = objectMapper.writeValueAsString(airport);
        
        mockMvc.perform(
        		MockMvcRequestBuilders.get("/bookings/createairport")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(jsoncontent)
        		)
        .andExpect(MockMvcResultMatchers.status().isCreated());	
	}

}
