package com.bilaltours.website.Bilal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bilaltours.website.Bilal.model.Booking;
import com.bilaltours.website.Bilal.repository.TourBookingRepository;

@ExtendWith(MockitoExtension.class)
class TourBookingServiceTest {

	@Mock
	TourBookingRepository repo;
	
	@InjectMocks
	TourBookingService undertest;
	
	@Test
	void testThatCreateBookingIsWorking() {
		//Given
		Booking t = new Booking(
				1L,
				"jafar moore",
				"876-230-6327",
				3,
				"santa maria",
				"3:00",
				"jafarmoore@gmail.com",
				"details"
				);
		
		//when
		when(repo.save(t)).thenReturn(t);
		Booking actual = undertest.createBooking(t);
		//then 
		verify(repo , times(1)).save(t);
		assertEquals(t,actual);
		
	}
	
	@Test
	void TestThatGetBookingByIdIsWorkingProperly() {
		
		//Given
		 long BookingId = 5;
		 Booking expected = new Booking(
				 BookingId,
				 "jafar moore",
				 "876-230-6327",
				 3,
				 "santa maria",
				 "3:00",
				 "jafarmoore@gmail.com",
				 "details"
				 );
		 
		 //when
		 when(repo.findById(BookingId)).thenReturn(Optional.of(expected));
		 Booking actual = undertest.getBookingById(BookingId);
		 
		 //Then
		 verify(repo , times(1)).findById(BookingId);
		 assertEquals(expected,actual);
		 
	}
	
	

}
