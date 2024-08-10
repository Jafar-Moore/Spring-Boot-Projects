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

import com.HalalTours.HalaTours.Model.Tours;
import com.HalalTours.HalaTours.Repository.TourRepository;

public class TourServiceTest {

    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourService tourService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBookTour() {
        // Mock data
        Tours booking = new Tours(/* provide necessary fields */);
        when(tourRepository.save(booking)).thenReturn(booking);

        // Call service method
        Tours result = tourService.bookTour(booking);

        // Verify the result
        assertNotNull(result);
        assertEquals(booking, result);

        // Verify repository method invocation
        verify(tourRepository, times(1)).save(booking);
    }

    @Test
    public void testGetAllBookings() {
        // Mock data
        Tours booking1 = new Tours(/* provide necessary fields */);
        Tours booking2 = new Tours(/* provide necessary fields */);
        List<Tours> bookings = Arrays.asList(booking1, booking2);
        when(tourRepository.findAll()).thenReturn(bookings);

        // Call service method
        List<Tours> result = tourService.getAllBookings();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(bookings, result);

        // Verify repository method invocation
        verify(tourRepository, times(1)).findAll();
    }

    @Test
    public void testGetBookingById() {
        // Mock data
        long id = 1L;
        Tours booking = new Tours(/* provide necessary fields */);
        when(tourRepository.findById(id)).thenReturn(Optional.of(booking));

        // Call service method
        Tours result = tourService.getBookingById(id);

        // Verify the result
        assertNotNull(result);
        assertEquals(booking, result);

        // Verify repository method invocation
        verify(tourRepository, times(1)).findById(id);
    }

    @Test
    public void testCancelBooking() {
        // Mock data
        long id = 1L;

        // Call service method
        tourService.cancelBooking(id);

        // Verify repository method invocation
        verify(tourRepository, times(1)).deleteById(id);
    }
}
