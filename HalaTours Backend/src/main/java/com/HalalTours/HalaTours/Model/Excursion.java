package com.HalalTours.HalaTours.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Excursion {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
	    private String clientName;
	    private int numberOfPassengers;
	    private int numberOfKids;
	    private String excursionDateTime;
	    private String cruiseShipPier;
	    private String cruiseLine;
	    private String excursionName;
	    
		public Excursion() {
		}
	    
		public Excursion(String clientName, int numberOfPassengers, int numberOfKids, String excursionDateTime,
				String cruiseShipPier, String cruiseLine, String excursionName) {
			super();
			this.clientName = clientName;
			this.numberOfPassengers = numberOfPassengers;
			this.numberOfKids = numberOfKids;
			this.excursionDateTime = excursionDateTime;
			this.cruiseShipPier = cruiseShipPier;
			this.cruiseLine = cruiseLine;
			this.excursionName = excursionName;
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
		public int getNumberOfKids() {
			return numberOfKids;
		}
		public void setNumberOfKids(int numberOfKids) {
			this.numberOfKids = numberOfKids;
		}
		public String getExcursionDateTime() {
			return excursionDateTime;
		}
		public void setExcursionDateTime(String excursionDateTime) {
			this.excursionDateTime = excursionDateTime;
		}
		public String getCruiseShipPier() {
			return cruiseShipPier;
		}
		public void setCruiseShipPier(String cruiseShipPier) {
			this.cruiseShipPier = cruiseShipPier;
		}
		public String getCruiseLine() {
			return cruiseLine;
		}
		public void setCruiseLine(String cruiseLine) {
			this.cruiseLine = cruiseLine;
		}
		public String getExcursionName() {
			return excursionName;
		}
		public void setExcursionName(String excursionName) {
			this.excursionName = excursionName;
		}
		
		public long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

	

}
