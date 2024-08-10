package com.HalalTours.HalaTours.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.HalalTours.HalaTours.Model.Airport;
import com.HalalTours.HalaTours.Repository.AirportRepository;

public class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBookAirportService() {
        // Mock data
        Airport booking = new Airport();
        when(airportRepository.save(booking)).thenReturn(booking);

        // Call service method
        Airport result = airportService.bookAirportService(booking);

        // Verify the result
        assertNotNull(result);
        assertEquals(booking, result);

        // Verify repository method invocation
        verify(airportRepository, times(1)).save(booking);
    }

    @Test
    public void testGetAllBookings() {
        // Mock data
        Airport booking1 = new Airport(
        		"John Doe",
        		2 ,
        		"Today",
               "Tommorow",
                "ABC Airlines - Flight 123",
                "Airport Hotel",
                3);

        Airport booking2 = new Airport("Jane Smith", 1,
        		"Today",
                "Tommorow",
                "XYZ Airlines - Flight 456",
                "City Center Hotel",
                2);
        List<Airport> bookings = Arrays.asList(booking1, booking2);
        when(airportRepository.findAll()).thenReturn(bookings);

        // Call service method
        List<Airport> result = airportService.getAllBookings();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(bookings, result);

        // Verify repository method invocation
        verify(airportRepository, times(1)).findAll();
    }

    @Test
    public void testGetBookingById() {
        // Mock data
        long id = 1L;
        Airport booking = new Airport(/* provide necessary fields */);
        when(airportRepository.findById(id)).thenReturn(Optional.of(booking));

        // Call service method
        Airport result = airportService.getBookingById(id);

        // Verify the result
        assertNotNull(result);
        assertEquals(booking, result);

        // Verify repository method invocation
        verify(airportRepository, times(1)).findById(id);
    }

    @Test
    public void testCancelBooking() {
        // Mock data
        long id = 1L;

        // Call service method
        airportService.cancelBooking(id);

        // Verify repository method invocation
        verify(airportRepository, times(1)).deleteById(id);
    }
}

