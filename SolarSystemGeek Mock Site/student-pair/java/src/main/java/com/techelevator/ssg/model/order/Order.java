package com.techelevator.ssg.model.order;


public class Order{
	
 private long orderId;
 private String customerName ="";
 private String streetAddress1 ="";
 private String streetAddress2 = "";
 private String city = "";
 private String state ="";
 private String zipcode ="";

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getStreetAddress1() {
	return streetAddress1;
}

public void setStreetAddress1(String streetAddress1) {
	this.streetAddress1 = streetAddress1;
}

public String getStreetAddress2() {
	return streetAddress2;
}

public void setStreetAddress2(String streetAddress2) {
	this.streetAddress2 = streetAddress2;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public long getOrderId() {
	return orderId;
}

public void setOrderId(long orderId) {
	this.orderId = orderId;
}

 
 
 

 
}
