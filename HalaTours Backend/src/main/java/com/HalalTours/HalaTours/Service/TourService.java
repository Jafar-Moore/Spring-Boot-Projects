package com.HalalTours.HalaTours.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HalalTours.HalaTours.Model.Tours;
import com.HalalTours.HalaTours.Repository.TourRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
		@Autowired
	    private  TourRepository tourRepository;

	    
	    public Tours bookTour(Tours booking) {
	        // Add business logic if needed (e.g., validation)
	        return tourRepository.save(booking);
	    }

	    public List<Tours> getAllBookings() {
	        return tourRepository.findAll();
	    }

	 
	    public Tours getBookingById(long id) {
	        return tourRepository.findById(id).orElse(null);
	    }

	
	    public void cancelBooking(long id) {
	        tourRepository.deleteById(id);
	    }
}
