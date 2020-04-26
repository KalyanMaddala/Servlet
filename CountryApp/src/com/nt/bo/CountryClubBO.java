package com.nt.bo;

public class CountryClubBO {
	private String Name;
	private String Address;
	private String Package;
	private float PackageAmount;
	private float DiscountAmount;
	private float NetAmount;
	
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
	public float getPackageAmount() {
		return PackageAmount;
	}
	public void setPackageAmount(float packageAmount) {
		PackageAmount = packageAmount;
	}
	public float getDiscountAmount() {
		return DiscountAmount;
	}
	public void setDiscountAmount(float discountAmount) {
		DiscountAmount = discountAmount;
	}
	public float getNetAmount() {
		return NetAmount;
	}
	public void setNetAmount(float netAmount) {
		NetAmount = netAmount;
	}
	
	
	
}
