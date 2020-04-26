package com.nt.dto;

import java.io.Serializable;

public class TrainTicketDTO implements Serializable{
    
	private String PassengerName;
	private String PassengeAddress;
	private String Source;
	private String Destination;
	private float Distance;
	private float Fare;
	public String getPassengerName() {
		return PassengerName;
	}
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}
	public String getPassengeAddress() {
		return PassengeAddress;
	}
	public void setPassengeAddress(String passengeAddress) {
		PassengeAddress = passengeAddress;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public float getDistance() {
		return Distance;
	}
	public void setDistance(float distance) {
		Distance = distance;
	}
	public float getFare() {
		return Fare;
	}
	public void setFare(float fare) {
		Fare = fare;
	}
}
