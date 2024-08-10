package com.bilaltours.website.Bilal.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bilaltours.website.Bilal.model.AirportBooking;
import com.bilaltours.website.Bilal.repository.BookingRepository;

@ExtendWith(MockitoExtension.class)

class BookingServiceTest {
	
	@Mock
	private BookingRepository repo;
	
	@InjectMocks
	private BookingService undertest;
	
	@Test
	void testThatServiceBookingIsCreated_WithValidObject() {
		//given 
		AirportBooking expected = new AirportBooking(
			    1L,                         // bookingId (assuming it's auto-generated)
			    "John Doe",                 // customerName
			    "john.doe@example.com",     // email
			    "123-456-7890",             // phoneNumber
			    "Yes",                      // roundTrip
			    "2024-08-01",               // ArrivalDate
			    "2024-08-10",               // DepartureDate
			    "10:00 AM",                 // ArrivalTime
			    "12:00 PM",                 // DepartureTime
			    2,                          // numberOfTravelers
			    1500.0,                     // totalCost
			    "No special requests",      // specialRequests
			    "JFK",                      // landingAirport
			    "Four Seasons",             // accommodation
			    "New York"                  // HotelLocation
			);
		
		//when
        when(repo.save(expected)).thenReturn(expected);

        // Call the method under test
        AirportBooking result = undertest.createBooking(expected);

        // Verify that save method of bookingRepository is called exactly once with the booking object
        verify(repo, times(1)).save(expected);

        // Assert that the result returned by createBooking is the same as the booking object passed in
        assertEquals(expected, result);
		
	}
	
	@Test
	void testThatServiceBookingIsCreated_WithInValidObject() {
		//given
		AirportBooking a = new AirportBooking();
		
		//when
		when(repo.save(a)).thenThrow(new RuntimeException());
		
		//call mmethod undertest
		  assertThrows(RuntimeException.class, () -> {
		        undertest.createBooking(a);
		    });
		
		
	}
	
	@Test
	void TestThatGetBookingByIdWorksProperlyWithValidId() {
		//given
		long bookingid =3;
		AirportBooking expected = new AirportBooking(
			    bookingid,                         // bookingId (assuming it's auto-generated)
			    "John Doe",                 // customerName
			    "john.doe@example.com",     // email
			    "123-456-7890",             // phoneNumber
			    "Yes",                      // roundTrip
			    "2024-08-01",               // ArrivalDate
			    "2024-08-10",               // DepartureDate
			    "10:00 AM",                 // ArrivalTime
			    "12:00 PM",                 // DepartureTime
			    2,                          // numberOfTravelers
			    1500.0,                     // totalCost
			    "No special requests",      // specialRequests
			    "JFK",                      // landingAirport
			    "Four Seasons",             // accommodation
			    "New York"                  // HotelLocation
			);
		
		//when
		when(repo.findById(bookingid)).thenReturn(Optional.of(expected));
		
		//then
		Optional<AirportBooking> actual = undertest.getBookingById(bookingid);
		
		assertEquals(Optional.of(expected),actual);
		 verify(repo, times(1)).findById(bookingid);
		
		
	}
	
	@Test
	void TestThatAllBookingsAreRetreivedProperly() {
		
		//given
		AirportBooking book1 = new AirportBooking();
		AirportBooking book2 = new AirportBooking();
		AirportBooking book3 = new AirportBooking();
		AirportBooking book4 = new AirportBooking();
		AirportBooking book5 = new AirportBooking();
		AirportBooking book6 = new AirportBooking();
		
		List<AirportBooking> bookings = Arrays.asList(book1,book2,book3,book4,book5,book6);
		
		//when
		when(repo.findAll()).thenReturn(bookings);
		
		//then 
		List<AirportBooking> bookingsgot = undertest.getAllBookings();
		
		verify(repo , times(1)).findAll();
		
		assertEquals(bookingsgot,bookings);
		
	}

}
