package com.HalalTours.HalaTours.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HalalTours.HalaTours.Model.Airport;
import com.HalalTours.HalaTours.Repository.AirportRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService{
	
	@Autowired
    private  AirportRepository airportRepository;



 
    public Airport bookAirportService(Airport booking) {
        // Add business logic if needed (e.g., validation)
        return airportRepository.save(booking);
    }

 
    public List<Airport> getAllBookings() {
        return airportRepository.findAll();
    }

    public Airport getBookingById(long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public void cancelBooking(long id) {
        airportRepository.deleteById(id);
    }
}

