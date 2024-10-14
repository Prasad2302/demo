package com.hexaware.carrental.entity;

public class Customer {
   private int customerId;
   private String firstName;
   private String lastName;
   private String email;
   private long phoneNumber;
public Customer() {
	super();
}
public Customer(int customerId, String firstName, String lastName, String email, long phoneNumber) {
	super();
	this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phoneNumber = phoneNumber;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
			+ email + ", phoneNumber=" + phoneNumber + "]";
}
   
}
