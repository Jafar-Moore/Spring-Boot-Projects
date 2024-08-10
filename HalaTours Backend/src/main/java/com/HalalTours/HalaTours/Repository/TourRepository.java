package com.HalalTours.HalaTours.Repository;

import com.HalalTours.HalaTours.Model.Tours; // Assuming Tour entity class is defined in com.HalalTours.HalaTours.Model package
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tours, Long> {
    // Additional query methods can be defined here if needed
}

