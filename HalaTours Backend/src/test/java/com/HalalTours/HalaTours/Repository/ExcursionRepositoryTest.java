package com.HalalTours.HalaTours.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.HalalTours.HalaTours.Model.Excursion;

@DataJpaTest
class ExcursionRepositoryTest {
	
	@Autowired
	private TestEntityManager test;	
	
	@Autowired
	private ExcursionRepository undertest;
	
	private Excursion expected;
	
	
	@Test
	void testThatFindByIdWorks() {
		Excursion expected = new Excursion(
				"Jafar Moore",
				4,
				5,
				"Today",
				"pier",
				"line",
				"Name"				
				);
		expected.setId(1L);
		
		test.merge(expected);
		
		Optional<Excursion> actualOptional = undertest.findById(1L);
		
		assertTrue(actualOptional.isPresent(), "Excursion should be present");

        Excursion actual = actualOptional.get();
        assertAll(
        ()-> assertEquals(expected.getId(), actual.getId()),
        ()-> assertEquals(expected.getClientName(), actual.getClientName()),
        ()-> assertEquals(expected.getNumberOfPassengers(), actual.getNumberOfPassengers()),
        ()-> assertEquals(expected.getNumberOfKids(), actual.getNumberOfKids()),
        ()-> assertEquals(expected.getExcursionDateTime(), actual.getExcursionDateTime()),
        ()-> assertEquals(expected.getCruiseShipPier(), actual.getCruiseShipPier()),
        ()-> assertEquals(expected.getCruiseLine(), actual.getCruiseLine()),
        ()-> assertEquals(expected.getExcursionName(), actual.getExcursionName())
        );
	}
	
	@Test
	void TestThatSaveFucntionWorks() {
		Excursion expected = new Excursion(
				"Jafar Moore",
				4,
				5,
				"Today",
				"pier",
				"line",
				"Name"				
				);
		expected.setId(1L);
		
	    undertest.save(expected);
		
		Long databaseid = (Long) test.getId(expected);
		
		
		assertEquals(databaseid,expected.getId());
	}

}
