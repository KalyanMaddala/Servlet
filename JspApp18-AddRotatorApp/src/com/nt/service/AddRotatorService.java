package com.nt.service;

import java.util.Random;

public class AddRotatorService {
	private String[]  images= {"images/bigbazar.jpg","images/chennai.jpg","images/cmr.jpg","images/klm.jpg","images/max.jpg","images/pantaloons.jpg","images/rsbros.jpg","images/southindia.jpg","images/trends.jpg","images/westside.jpg"};
	private String[]  links= {"https://www.bigbazaar.com/","https://www.thechennaishoppingmall.com/home","https://www.mapsofindia.com/malls/hyderabad/cmr-shopping-mall.html","https://www.klmfashionmall.com/","https://www.maxfashion.in/in/en/","https://www.pantaloons.com/","https://www.rsbrothers.net/","https://www.southindiaeshop.com/","https://www.reliancetrends.com/","https://www.westside.com/"};
	int count=0;
	
	public  void  nextAdvertisement() {
		count=new Random().nextInt(10);
	}
	
	public  String  getImage() {
		return images[count];
	}
	
	public  String  getLink() {
		return links[count];
	}
	
	

}
