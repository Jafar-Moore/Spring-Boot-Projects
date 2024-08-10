package com.HalalTours.HalaTours.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airport {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    private String clientName;
    private int numberOfPassengers;
    private String arrivalDateTime;
    private String departureDateTime;
    private String flightNameAndNumber;
    private String hotelName;
    private int numberOfPiecesOfLuggage;
    
	public Airport() {
	}
    
	public Airport(String clientName, int numberOfPassengers, String arrivalDateTime,
			String departureDateTime, String flightNameAndNumber, String hotelName,
			int numberOfPiecesOfLuggage) {
		super();
		this.clientName = clientName;
		this.numberOfPassengers = numberOfPassengers;
		this.arrivalDateTime = arrivalDateTime;
		this.departureDateTime = departureDateTime;
		this.flightNameAndNumber = flightNameAndNumber;
		this.hotelName = hotelName;
		this.numberOfPiecesOfLuggage = numberOfPiecesOfLuggage;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public String getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public String getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public String getFlightNameAndNumber() {
		return flightNameAndNumber;
	}
	public void setFlightNameAndNumber(String flightNameAndNumber) {
		this.flightNameAndNumber = flightNameAndNumber;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getNumberOfPiecesOfLuggage() {
		return numberOfPiecesOfLuggage;
	}
	public void setNumberOfPiecesOfLuggage(int numberOfPiecesOfLuggage) {
		this.numberOfPiecesOfLuggage = numberOfPiecesOfLuggage;
	}

    
}

