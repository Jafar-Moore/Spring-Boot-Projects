package com.HalalTours.HalaTours.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HalalTours.HalaTours.Model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	
}
