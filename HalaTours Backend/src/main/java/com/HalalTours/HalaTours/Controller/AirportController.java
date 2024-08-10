package com.HalalTours.HalaTours.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.HalalTours.HalaTours.Model.Airport;
import com.HalalTours.HalaTours.Service.AirportService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("http://127.0.0.1:5502")
public class AirportController {
	
	@Autowired
    private AirportService airportService;

    @PostMapping("/createairport")
    public Airport AirportService(@RequestBody Airport booking) {
        return airportService.bookAirportService(booking);
    }

    @GetMapping("/getallairport")
    public List<Airport> getAllBookings() {
        return airportService.getAllBookings();
    }

    @GetMapping("/getoneairport/{id}")
    public Airport getBookingById(@PathVariable("id") long id) {
        return airportService.getBookingById(id);
    }

    @DeleteMapping("/cancelairport/{id}")
    public void cancelBooking(@PathVariable("id") long id) {
        airportService.cancelBooking(id);
    }
}

