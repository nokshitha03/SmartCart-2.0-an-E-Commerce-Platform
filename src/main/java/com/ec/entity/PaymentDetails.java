package com.ec.entity;

import jakarta.persistence.*;


@Entity

public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String state;
    private String city;
    private String country;

    private String paymentMethod;   // COD / ONLINE
    private String transactionId;   // only for online
    private String mobileNumber;    // only for online
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public PaymentDetails(Long id, String address, String state, String city, String country, String paymentMethod,
			String transactionId, String mobileNumber) {
		
		this.id = id;
		this.address = address;
		this.state = state;
		this.city = city;
		this.country = country;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
		this.mobileNumber = mobileNumber;
	}
	public PaymentDetails() {
		
	}
    
    
    
}
