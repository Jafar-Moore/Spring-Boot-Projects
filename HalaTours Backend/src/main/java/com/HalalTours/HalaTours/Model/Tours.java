package com.HalalTours.HalaTours.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tours {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
	    private String clientName;
	    private int numberOfPassengers;
	    private int numberOfChildrenAge4to12;
	    private String dateOfTour;
	    private String pickupTime;
	    private String hotelName;
	    private String tourName;
		public String getClientName() {
			return clientName;
		}
		public Tours(){
		}
		
		public Tours(String clientName, int numberOfPassengers, int numberOfChildrenAge4to12, String dateOfTour,
				String pickupTime, String hotelName, String tourName) {
			super();
			this.clientName = clientName;
			this.numberOfPassengers = numberOfPassengers;
			this.numberOfChildrenAge4to12 = numberOfChildrenAge4to12;
			this.dateOfTour = dateOfTour;
			this.pickupTime = pickupTime;
			this.hotelName = hotelName;
			this.tourName = tourName;
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
		public int getNumberOfChildrenAge4to12() {
			return numberOfChildrenAge4to12;
		}
		public void setNumberOfChildrenAge4to12(int numberOfChildrenAge4to12) {
			this.numberOfChildrenAge4to12 = numberOfChildrenAge4to12;
		}
		public String getDateOfTour() {
			return dateOfTour;
		}
		public void setDateOfTour(String dateOfTour) {
			this.dateOfTour = dateOfTour;
		}
		public String getPickupTime() {
			return pickupTime;
		}
		public void setPickupTime(String pickupTime) {
			this.pickupTime = pickupTime;
		}
		public String getHotelName() {
			return hotelName;
		}
		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
		public String getTourName() {
			return tourName;
		}
		public void setTourName(String tourName) {
			this.tourName = tourName;
		}
	    
		public long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

}
