package com.HalalTours.HalaTours.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HalalTours.HalaTours.Model.Excursion;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
	
	
}

