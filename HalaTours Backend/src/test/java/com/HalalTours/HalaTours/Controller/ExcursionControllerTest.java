package com.HalalTours.HalaTours.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.HalalTours.HalaTours.Model.Excursion;
import com.HalalTours.HalaTours.Service.ExcursionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ExcursionController.class)
class ExcursionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ExcursionService excursionService;

    @BeforeEach
    void setUp() {
        // Initialize mocks if needed
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testThatSaveExcursionWorks() throws Exception {
        // Given
        Excursion excursion = new Excursion();
        excursion.setId(1L);
        excursion.setClientName("John Doe");
        excursion.setNumberOfPassengers(1);
        excursion.setNumberOfKids(1);
        excursion.setCruiseShipPier("pier A");
        excursion.setCruiseLine("line 1");
        excursion.setExcursionDateTime("today");

        // Mock the service method
        when(excursionService.createExcursion(excursion)).thenReturn(excursion);

        // When
        String jsonContent = objectMapper.writeValueAsString(excursion);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/bookings/createexcursion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent));

        // Then
        resultActions
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    
    @Test
    void testThatGetExcursionByIdIsWorking() throws Exception {
    	// Given
        Excursion excursion = new Excursion();
        excursion.setId(1L);
        excursion.setClientName("John Doe");
        excursion.setNumberOfPassengers(1);
        excursion.setNumberOfKids(1);
        excursion.setCruiseShipPier("pier A");
        excursion.setCruiseLine("line 1");
        excursion.setExcursionDateTime("today");
        
        //when
        
        when(excursionService.getExcursionById(excursion.getId())).thenReturn(Optional.of(excursion));
        
        mockMvc.perform(
        		MockMvcRequestBuilders.get("/bookings/getexcursion/1")
        		.contentType(MediaType.APPLICATION_JSON)
        		).andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void testThatGetAllExcursionsReturnsHTTP200() throws Exception{
    	
    	Excursion excursion = new Excursion();
        excursion.setId(1L);
        excursion.setClientName("John Doe");
        excursion.setNumberOfPassengers(1);
        excursion.setNumberOfKids(1);
        excursion.setCruiseShipPier("pier A");
        excursion.setCruiseLine("line 1");
        excursion.setExcursionDateTime("today");
        
        Excursion excursion1 = new Excursion();
        excursion1.setId(1L);
        excursion1.setClientName("John Doe");
        excursion1.setNumberOfPassengers(1);
        excursion1.setNumberOfKids(1);
        excursion1.setCruiseShipPier("pier A");
        excursion1.setCruiseLine("line 1");
        excursion1.setExcursionDateTime("today");
        
        Excursion excursion2 = new Excursion();
        excursion2.setId(1L);
        excursion2.setClientName("John Doe");
        excursion2.setNumberOfPassengers(1);
        excursion2.setNumberOfKids(1);
        excursion2.setCruiseShipPier("pier A");
        excursion2.setCruiseLine("line 1");
        excursion2.setExcursionDateTime("today");
        
        List <Excursion> list = new ArrayList<>();
        list.add(excursion);
        list.add(excursion1);
        list.add(excursion2);
        
        
        when(excursionService.getAllExcursions()).thenReturn(list);
        
        mockMvc.perform(
        		MockMvcRequestBuilders.get("/bookings/getallexcursions")
        		.contentType(MediaType.APPLICATION_JSON)
        		).andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    
}
