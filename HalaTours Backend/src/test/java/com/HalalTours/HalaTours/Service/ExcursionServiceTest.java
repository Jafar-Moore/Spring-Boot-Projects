package com.HalalTours.HalaTours.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.HalalTours.HalaTours.Model.Excursion;
import com.HalalTours.HalaTours.Repository.ExcursionRepository;

@ExtendWith(MockitoExtension.class)
class ExcursionServiceTest {
	
	@Mock
	ExcursionRepository repo;

	@InjectMocks
	ExcursionService undertest;
	
	@Test
	@DisplayName("Create Booking Test")
	void TestThatCreateBookingIsWorkingProperly() {
		
		//Given(Mock Data)
		Excursion ex = new Excursion(	
				"Jafar Moore",
				4,
				5,
				"Today",
				"pier",
				"line",
				"Name"
				);
		
		//When
		when(repo.save(ex)).thenReturn(ex);
		
		Excursion actual = undertest.createExcursion(ex);
		
		//Then
		verify(repo , times(1)).save(ex);
		assertEquals(actual,ex);	
	}
	
	@Test
	@DisplayName("Testing Get All Bookings")
	void TestThatGetAllBookingsIsWorking(){
		//Given(Mock Data)
		Excursion ex = new Excursion(	
				"Jafar Moore",
				4,
				5,
				"Today",
				"pier",
				"line",
				"Name"
				);
		Excursion ex1 = new Excursion(	
				"Jafar Moore",
				4,
				5,
				"Today",
				"pier",
				"line",
				"Name"
				);
		Excursion ex2 = new Excursion(	
				"Jafar Moore",
				4,
				5,
				"Today",
				"pier",
				"line",
				"Name"
				);
		
		 List<Excursion> expected = new ArrayList<Excursion>();		 
		 expected.add(ex);
		 expected.add(ex1);
		 expected.add(ex2);
		 		
		//When
		when(repo.findAll()).thenReturn(expected);
		List<Excursion> actual = undertest.getAllExcursions();
		
		//Then
		verify(repo , times (1)).findAll();
		assertEquals(expected,actual);
		
	}

}
