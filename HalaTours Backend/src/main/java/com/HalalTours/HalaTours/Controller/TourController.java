package com.HalalTours.HalaTours.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.HalalTours.HalaTours.Model.Tours;
import com.HalalTours.HalaTours.Service.TourService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("http://127.0.0.1:5502")
public class TourController {
	
		@Autowired
	    private  TourService tourService;

	    @PostMapping("/createtour")
	    public Tours bookTour(@RequestBody Tours booking) {
	        return tourService.bookTour(booking);
	    }

	    @GetMapping("/getalltours")
	    public List<Tours> getAllBookings() {
	        return tourService.getAllBookings();
	    }

	    @GetMapping("/getonetour/{id}")
	    public Tours getBookingById(@PathVariable("id") long id) {
	        return tourService.getBookingById(id);
	    }

	    @DeleteMapping("/canceltour/{id}")
	    public void cancelBooking(@PathVariable("id") long id) {
	        tourService.cancelBooking(id);
	    }

}
