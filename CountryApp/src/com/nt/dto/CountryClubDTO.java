package com.nt.dto;

import java.io.Serializable;

public class CountryClubDTO implements Serializable{
    
	private int MemberShipId;
	private String Name;
	private String Address;
	private String Package;
	private float Amount;
	private String Country;
	public int getMemberShipId() {
		return MemberShipId;
	}
	public void setMemberShipId(int memberShipId) {
		MemberShipId = memberShipId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPackage() {
		return Package;
	}
	public void setPackage(String package1) {
		Package = package1;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
}
