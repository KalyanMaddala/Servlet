package com.nt.bo;

public class TrainTicketBO {
	private String PassengerName;
	private String Source;
	private String Destination;
	private  float Distance;
	private  float Fare;
	private  String Result;
	
	public String getPassengerName() {
		return PassengerName;
	}
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
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
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	
}
